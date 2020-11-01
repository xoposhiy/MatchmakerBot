package com.company.bot;

import com.company.*;
import com.company.bot.inlineKeyboard.BotInlineKeyboardButton;
import com.company.bot.inlineKeyboard.InlineKeyboardData;

import java.util.ArrayList;

public class Bot {
    private UserRepository users;
    private DialogLogic logic;

    public Bot(UserRepository userRep, DialogLogic logic) {
        users = userRep;
        this.logic = logic;
    }

    public void createUser(long id) {
        User client = new User(id);
        users.addUser(client);
    }

    public Message replyToUser(long userId, String userName, Message messageFromUser) {
        if (users.getUser(userId) == null)
            createUser(userId);
        var user = users.getUser(userId);
        user.setUserName(userName);
        var generatedMessage = generateMessage(user, messageFromUser);

        if (user.getCurrentState() == DialogState.FIND &&
                messageFromUser.getTextMessage().equals("/find"))
            setInlineKeyboardForFind(generatedMessage);
        return generatedMessage;
    }

    public Message generateMessage(User user, Message messageFromUser) {
        return logic.getResponse(user, messageFromUser, users);

    }

    private void setInlineKeyboardForFind(Message generatedMessage) {
        generatedMessage.setInlineKeyboardData(new InlineKeyboardData());
        var inlinedKeyboardData = generatedMessage.getInlineKeyboardData();
        var rows = inlinedKeyboardData.getRows();
        rows.add(new ArrayList<>());
        rows.get(0).add(new BotInlineKeyboardButton("find\uD83D\uDC94", "/find"));
        rows.get(0).add(new BotInlineKeyboardButton("like❤", "/like"));
    }
}
package com.company.bot;

public class AnswersStorage {
    public static String helpMessage = """
            Напишите /reg, чтобы зарегистрировать себя в базе.
            Можно изменить анкету написав /reg после регистрации.
            Напишите /help, чтобы вывести это сообщение ещё раз.
            Напишите /showbio, чтобы посмотреть свою анкету.
            Напишите /find, чтобы посмотреть другие анкеты.
            Напишите /like, чтобы лайкнуть понравившуюся анкету.
            Напишите /matches, чтобы посмотреть все совпадения.
            """;
    // "THIS IS HELP AND THIS IS WORK";


    public static String defaultMessage = "Не понимаю вашего запроса." +
            " Вызовите /help для справки.";
    private final static String botName = "MatchmakerBot - Вячесlove";
    public static String registerNameMessage = "Регистрация: Напишите своё имя.";
    public static String regAgeMessage = "Напишите свой возраст арабскими цифрами, в пределах от 0 до 150 лет.";
    public static String wrongAgeMessage = "Я же попросил написать возраст арабскими цифрами, в пределах от 0 до 150 лет.!\n" +
            "Перепишите пожалуйста.";
    public static String regCityMessage = "Напишите город в котором вы находитесь.";
    public static String regInfoMessage = "Расскажите о себе одним сообщением.\nМожете добавить свое фото.";
    public static String startMessage = String.format("Приветствую странник. Меня зовут %s!\n", botName);
    public static String forcedRegMessage = "Сейчас начнётся процесс регистрации. \n\n";
    public static String showbioErrorMessage = "Вы ещё не зарегистрировались. \n" +
            "Я не могу показать вам вашу анкету.\n" + forcedRegMessage;
    public static String matchErrorMessage = "Вы ещё не зарегистрировались. \n" +
            "Я не могу показать вам другие анкеты.\n" + forcedRegMessage;
    public static String regErrorMessage = "Вы уже зарегистрированы.";
    public static String noUsernameError = "Для работы бота вам необходимо задать username в настройках Telegram";
    public static String showMatchesMessage = "Вот ваши совпадения: \n \n";
    public static String likeMessage = "Ждите ответа от вашей второй половинки.\n " +
            "Чтобы посмотреть свои совпадения напишите /matches. \n" +
            "Чтобы продолжить искать половинку напишите /find.";
    public static String stopMessage = "Хватит пока искать свою половинку.";
    public static String nobodyElseMessage = "Не могу найти вам подходящего человека :(" +
            "Подождите пока кто-нибудь ещё зарегистрируется";
    public static String forwardMessage = "\n Поставить лайк: /like \n Скипнуть: /find \n";
    public static String startFindingMessage = "\nНачать поиск половинки: /find";

    public static String getUserInfo(User user) {
        return String.format("Имя: %s\nВозраст: %d\nГород: %s\n++++Описание++++\n%s",
                user.getName(), user.getAge(), user.getCity(), user.getInfo());
    }

}
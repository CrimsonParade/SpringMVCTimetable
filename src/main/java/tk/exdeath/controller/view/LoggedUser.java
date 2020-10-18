package tk.exdeath.controller.view;

import tk.exdeath.model.User;
import tk.exdeath.model.service.UserService;

public abstract class LoggedUser {

    private static final UserService userService = new UserService();
    private static String language = "RU";
    private static String login;
    private static User user;

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        LoggedUser.language = language;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        LoggedUser.login = login;
        LoggedUser.user = userService.readUserByLogin(login);
    }

    public static UserService getUserService() {
        return userService;
    }

    public static User getUser() {
        return user;
    }
}

package tk.exdeath.controller.view.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.view.LoggedUser;
import tk.exdeath.model.User;
import tk.exdeath.model.service.UserService;

@Controller
public class AuthController {

    String language;
    String path;
    User user;
    UserService userService;

    @GetMapping("/auth")
    public String auth(
            @RequestParam(defaultValue = "RU") String language) {

        this.language = language;
        path = language + "/menu/auth" + language;
        userService = LoggedUser.getUserService();

        return path;
    }

    @PostMapping("/auth")
    public String passCheck(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam(defaultValue = "SignIn") String move) {

        user = userService.readUserByLogin(login);

        if (move.equals("Create")) {
            return createUser(login, password);
        }
        return signIn(login, password);
    }


    private String createUser(String login, String password) {
        if (user.getLogin().equals("null")) {
            userService.create(new User(login, password));
            authUser(login);
            return "redirect:/accountSettings";
        }
        return path;
    }

    private String signIn(String login, String password) {
        if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
            authUser(login);
            return "redirect:/accountSettings";
        }
        return path;
    }

    private void authUser(String login) {
        LoggedUser.setLogin(login);
        LoggedUser.setLanguage(language);
    }
}

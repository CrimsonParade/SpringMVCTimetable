package tk.exdeath.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.model.User;
import tk.exdeath.model.service.UserService;

@Controller
public class AuthController {

    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }

    @PostMapping("/auth")
    public String passCheck(@RequestParam String login, @RequestParam String password, @RequestParam(defaultValue = "Login") String move) {

        if (move.equals("Create")) {
            return createUser(login, password);
        }

        UserService service = new UserService();
        User testingUser = service.readByLogin(login);

        if (testingUser.getLogin().equals(login) && testingUser.getPassword().equals(password)) {
            return "redirect:/main?userLogin=" + testingUser.getLogin();
        }
        return "auth";
    }

    public String createUser(String login, String password) {
        UserService service = new UserService();
        User testingUser = service.readByLogin(login);
        if (testingUser.getLogin().equals("null")) {
            service.create(new User(login, password));
            return "redirect:/main?userLogin=" + login;
        }
        return "auth";
    }
}

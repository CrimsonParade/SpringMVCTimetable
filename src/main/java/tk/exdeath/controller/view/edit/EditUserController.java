package tk.exdeath.controller.view.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.model.User;
import tk.exdeath.model.service.UserService;

@Controller
public class EditUserController {

    String login;
    String language;

    @GetMapping("/editUser")
    public String editUser(
            @RequestParam(defaultValue = "RU") String language,
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        this.language = language;
        login = userLogin;
        model.addAttribute("login", userLogin);
        return language + "/edit/editUser" + language;
    }

    @PostMapping("/editUser")
    public String editPassword(
            @RequestParam String value,
            @RequestParam String password) {

        UserService service = new UserService();
        User updatableUser = service.readUserByLogin(login);

        if (updatableUser.getPassword().equals(password)) {
            updatableUser.setPassword(value);
            service.update(updatableUser);
        }

        return "redirect:/main?userLogin=" + login + "&language=" + language;
    }
}

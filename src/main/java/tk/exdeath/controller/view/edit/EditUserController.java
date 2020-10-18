package tk.exdeath.controller.view.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.view.LoggedUser;
import tk.exdeath.model.User;
import tk.exdeath.model.service.UserService;

@Controller
public class EditUserController {

    String login;
    String language;
    String path;

    @GetMapping("/editUser")
    public String editUser(Model model) {

        login = LoggedUser.getLogin();
        language = LoggedUser.getLanguage();
        path = language + "/edit/editUser" + language;

        model.addAttribute("login", login);
        return path;
    }

    @PostMapping("/editUser")
    public String editPassword(
            @RequestParam String value,
            @RequestParam String password) {

        UserService service = LoggedUser.getUserService();
        User updatableUser = LoggedUser.getUser();

        if (updatableUser.getPassword().equals(password)) {
            updatableUser.setPassword(value);
            service.update(updatableUser);
            return "redirect:/main?userLogin=" + login + "&language=" + language;
        }
        return path;
    }
}

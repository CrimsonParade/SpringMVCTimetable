package tk.exdeath.controller.view.menu;

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

    @GetMapping("/editUser")
    public String editUser(
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        login = userLogin;
        model.addAttribute("login", userLogin);
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editPassword(
            @RequestParam String value,
            @RequestParam String password) {

        UserService service = new UserService();
        User updatableUser = service.readByLogin(login);

        if (updatableUser.getPassword().equals(password)) {
            updatableUser.setPassword(value);
            service.update(updatableUser);
        }

        return "redirect:/main?userLogin=" + login;
    }
}

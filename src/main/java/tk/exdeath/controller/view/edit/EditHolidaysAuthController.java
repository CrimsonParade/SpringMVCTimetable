package tk.exdeath.controller.view.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.model.User;
import tk.exdeath.model.service.UserService;

@Controller
public class EditHolidaysAuthController {

    String login;

    @GetMapping("/editHolidaysAuth")
    public String auth(
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        login = userLogin;
        model.addAttribute("login", userLogin);
        return "editHolidaysAuth";
    }

    @PostMapping("/editHolidaysAuth")
    public String passwordCheck(
            @RequestParam(defaultValue = "") String password, Model model) {

        UserService service = new UserService();
        User updatableUser = service.readUserByLogin(login);

        if (updatableUser.getPassword().equals(password)) {
            return "redirect:/editHolidays?userLogin=" + login;
        }

        return "editHolidaysAuth";
    }

}
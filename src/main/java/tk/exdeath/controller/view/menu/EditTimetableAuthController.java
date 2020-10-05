package tk.exdeath.controller.view.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.model.User;
import tk.exdeath.model.service.UserService;

@Controller
public class EditTimetableAuthController {

    String login;

    @GetMapping("/editTimetableAuth")
    public String editTimetable(
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        login = userLogin;
        model.addAttribute("login", userLogin);
        return "editTimetableAuth";
    }

    @PostMapping("/editTimetableAuth")
    public String editPassword(
            @RequestParam(defaultValue = "") String password, Model model) {

        UserService service = new UserService();
        User updatableUser = service.readByLogin(login);

        if (updatableUser.getPassword().equals(password)) {
            return "redirect:/editTimetable?userLogin=" + login;
        }

        return "editTimetableAuth";
    }

}

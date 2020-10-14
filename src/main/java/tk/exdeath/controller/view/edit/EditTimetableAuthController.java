package tk.exdeath.controller.view.edit;

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
    String language;

    @GetMapping("/editTimetableAuth")
    public String auth(
            @RequestParam(defaultValue = "RU") String language,
            @RequestParam(defaultValue = "null") String userLogin, Model model) {


        this.language = language;
        login = userLogin;

        model.addAttribute("login", userLogin);
        return language + "/edit/editTimetableAuth" + language;
    }

    @PostMapping("/editTimetableAuth")
    public String passwordCheck(
            @RequestParam(defaultValue = "") String password, Model model) {

        UserService service = new UserService();
        User userToCheck = service.readUserByLogin(login);

        if (userToCheck.getPassword().equals(password)) {
            return "redirect:/editTimetable?userLogin=" + login + "&language=" + language;
        }

        return language + "/edit/editTimetableAuth" + language;
    }

}

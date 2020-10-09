package tk.exdeath.controller.view.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountSettingsController {

    @GetMapping("/accountSettings")
    public String main(
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        model.addAttribute("login", userLogin);
        return "menu/accountSettings";
    }

}
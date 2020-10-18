package tk.exdeath.controller.view.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tk.exdeath.controller.view.LoggedUser;

@Controller
public class AccountSettingsController {

    @GetMapping("/accountSettings")
    public String main(Model model) {
        model.addAttribute("login", LoggedUser.getLogin());
        return LoggedUser.getLanguage() + "/menu/accountSettings" + LoggedUser.getLanguage();
    }
}

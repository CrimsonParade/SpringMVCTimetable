package tk.exdeath.controller.view.RU.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {

    @GetMapping("/")
    public String startPage() {
        return "RU/menu/startPage";
    }
}

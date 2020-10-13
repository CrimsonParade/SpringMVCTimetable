package tk.exdeath.controller.view.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StartPageController {

    @GetMapping("/")
    public String startPage(@RequestParam(defaultValue = "RU") String language ) {
        return language + "/menu/startPage";
    }
}

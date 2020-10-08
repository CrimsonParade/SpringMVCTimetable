package tk.exdeath.controller.view.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChooseTimetableController {

    @GetMapping("/chooseTimetable")
    public String chooseTimetable() {
        return "menu/chooseTimetable";
    }
}

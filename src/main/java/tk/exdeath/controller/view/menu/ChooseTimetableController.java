package tk.exdeath.controller.view.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChooseTimetableController {

    @GetMapping("/chooseTimetable")
    public String chooseTimetable(
            @RequestParam(defaultValue = "RU") String language) {
        return language + "/menu/chooseTimetable" + language;
    }
}

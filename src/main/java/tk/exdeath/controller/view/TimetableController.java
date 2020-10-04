package tk.exdeath.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimetableController {

    @GetMapping("/timetable")
    public String timetable(@RequestParam(defaultValue = "null") String userLogin, Model model) {
        model.addAttribute("login", userLogin);
        return "timetable";
    }
}

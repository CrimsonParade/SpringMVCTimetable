package tk.exdeath.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.collector.TimetableByDayOfWeek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class IndexController {

    private final String TODAY_DAY_OF_WEEK = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE"));
    private final String TOMORROW_DAY_OF_WEEK = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("EEEE"));

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/days")
    public String days(
            @RequestParam(name = "dayOfWeek", required = false, defaultValue = "today") String dayOfWeek, Model model) {

        if (dayOfWeek.equals("today")) {
            model.addAttribute("timetable", TimetableByDayOfWeek.getTimetable(TODAY_DAY_OF_WEEK));
            return "days";
        }
        if (dayOfWeek.equals("tomorrow")) {
            model.addAttribute("timetable", TimetableByDayOfWeek.getTimetable(TOMORROW_DAY_OF_WEEK));
            return "days";
        }

        model.addAttribute("timetable", TimetableByDayOfWeek.getTimetable(dayOfWeek));
        return "days";
    }

}

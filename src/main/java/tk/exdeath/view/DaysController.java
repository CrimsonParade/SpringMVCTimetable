package tk.exdeath.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.informant.TimetableByDayOfWeek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class DaysController {

    private final String TODAY_DAY_OF_WEEK = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE"));
    private final String TOMORROW_DAY_OF_WEEK = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("EEEE"));

    @GetMapping("/days")
    public String days(
            @RequestParam(name = "dayOfWeek", required = false, defaultValue = "today") String dayOfWeek, Model model) {

        if (dayOfWeek.equals("today")) {
            dayOfWeek = TODAY_DAY_OF_WEEK;
        }
        if (dayOfWeek.equals("tomorrow")) {
            dayOfWeek = TOMORROW_DAY_OF_WEEK;
        }

        model.addAttribute("dayOfWeek", dayOfWeek);
        model.addAttribute("timetable", TimetableByDayOfWeek.getTimetable(dayOfWeek));
        return "days";
    }
}

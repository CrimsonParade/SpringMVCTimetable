package tk.exdeath.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.processor.days.TimetableByDayOfWeekProcessor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class TimetableByDayOfWeekController {

    private final String TODAY_DAY_OF_WEEK = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE"));
    private final String TOMORROW_DAY_OF_WEEK = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("EEEE"));

    @GetMapping("/days")
    public String timetableByDayOfWeek(
            @RequestParam(defaultValue = "today") String dayOfWeek,
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        if (dayOfWeek.equals("today")) {
            dayOfWeek = TODAY_DAY_OF_WEEK;
        }
        if (dayOfWeek.equals("tomorrow")) {
            dayOfWeek = TOMORROW_DAY_OF_WEEK;
        }

        model.addAttribute("dayOfWeek", dayOfWeek);
        model.addAttribute("timetable", TimetableByDayOfWeekProcessor.getTimetable(dayOfWeek, userLogin));
        return "timetableByDayOfWeek";
    }
}

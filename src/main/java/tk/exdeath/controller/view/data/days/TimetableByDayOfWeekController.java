package tk.exdeath.controller.view.data.days;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.processor.days.TimetableProcessorCreator;

@Controller
public class TimetableByDayOfWeekController {

    @GetMapping("/days")
    public String timetableByDayOfWeek(
            @RequestParam(defaultValue = "RU") String language,
            @RequestParam(defaultValue = "today") String dayOfWeek,
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        TimetableProcessor processor = TimetableProcessorCreator.getInstance(language);

        if (dayOfWeek.equals("today")) {
            dayOfWeek = processor.getTodayDayOfWeek();
        }
        if (dayOfWeek.equals("tomorrow")) {
            dayOfWeek = processor.getTomorrowDayOfWeek();
        }

        model.addAttribute("dayOfWeek", dayOfWeek);
        model.addAttribute("timetable", processor.getTimetable(dayOfWeek, userLogin));
        return language + "/timetableByDayOfWeek" + language;
    }
}

package tk.exdeath.controller.view.data.lessons;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.processor.lessons.holidays.Holidays;
import tk.exdeath.controller.processor.lessons.holidays.HolidaysCreator;

import java.util.ArrayList;

@Controller
public class LessonsController {

    @GetMapping("/lessons")
    public String lessonsCounting(
            @RequestParam(defaultValue = "RU") String language,
            @RequestParam(defaultValue = "") String lessonName,
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        ArrayList<String> lessons = new ArrayList<>();
        Holidays holidays;

        holidays = HolidaysCreator.getInstance("nearest", language);
        lessons.add(holidays.getLessonInformation(lessonName, userLogin));

        holidays = HolidaysCreator.getInstance("summer", language);
        lessons.add(holidays.getLessonInformation(lessonName, userLogin));

        model.addAttribute("timetable", lessons);
        return language + "/lessonsCounting" + language;
    }
}

package tk.exdeath.controller.view.data.lessons;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.processor.lessons.LessonProcessorCreator;
import tk.exdeath.controller.processor.lessons.holidays.NearestHolidays;
import tk.exdeath.controller.processor.lessons.holidays.SummerHolidays;

import java.util.ArrayList;

@Controller
public class LessonsCountingController {

    @GetMapping("/lessons")
    public String lessonsCounting(
            @RequestParam(defaultValue = "RU") String language,
            @RequestParam(defaultValue = "") String lessonName,
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        ArrayList<String> lessons = new ArrayList<>();
        LessonsBeforeHolidays holidays;

        holidays = new NearestHolidays(LessonProcessorCreator.getInstance(language));
        lessons.add(holidays.getLessonInformation(lessonName, userLogin));

        holidays = new SummerHolidays(LessonProcessorCreator.getInstance(language));
        lessons.add(holidays.getLessonInformation(lessonName, userLogin));

        model.addAttribute("timetable", lessons);
        return language + "/lessonsCounting" + language;
    }
}

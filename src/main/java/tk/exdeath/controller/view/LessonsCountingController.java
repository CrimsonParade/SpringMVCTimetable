package tk.exdeath.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.processor.lessons.LessonCountingProcessor;
import tk.exdeath.controller.processor.lessons.NearestHolidays;
import tk.exdeath.controller.processor.lessons.SummerHolidays;

import java.util.ArrayList;

@Controller
public class LessonsCountingController {

    @GetMapping("/lessons")
    public String lessonsCounting(
            @RequestParam(defaultValue = "") String lessonName,
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        ArrayList<String> lessons = new ArrayList<>();
        LessonCountingProcessor processor;

        processor = new NearestHolidays();
        lessons.add(processor.getLessonInformation(lessonName, userLogin));

        processor = new SummerHolidays();
        lessons.add(processor.getLessonInformation(lessonName, userLogin));

        model.addAttribute("timetable", lessons);
        return "lessonsCounting";
    }
}

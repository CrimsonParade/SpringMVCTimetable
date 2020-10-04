package tk.exdeath.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.processor.lessons.NearestHolidays;
import tk.exdeath.controller.processor.lessons.SummerHolidays;
import tk.exdeath.controller.processor.lessons.LessonsCountProcessor;

import java.util.ArrayList;

@Controller
public class LessonsController {

    @GetMapping("/lessons")
    public String lessons(
            @RequestParam(defaultValue = "") String lessonName,
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        ArrayList<String> lessons = new ArrayList<>();
        LessonsCountProcessor processor;

        processor = new NearestHolidays();
        lessons.add(processor.getLessonInformation(lessonName, userLogin));

        processor = new SummerHolidays();
        lessons.add(processor.getLessonInformation(lessonName, userLogin));

        model.addAttribute("timetable", lessons);
        return "lessons";
    }
}

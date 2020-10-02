package tk.exdeath.controller.web.lessons;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.view.lessons.NearestHolidays;
import tk.exdeath.view.lessons.SummerHolidays;
import tk.exdeath.view.lessons.LessonsProcessor;
import tk.exdeath.model.service.LessonService;

import java.util.ArrayList;

@Controller
public class EveryController {

    @GetMapping("/every")
    public String every(
            @RequestParam(name = "before", required = false, defaultValue = "nearest") String before, Model model) {

        LessonService reader = new LessonService();
        LessonsProcessor processor = new NearestHolidays();
        ArrayList<String> lessons = new ArrayList<>();

        if (before.equals("nearest")) {
            processor = new NearestHolidays();
        }
        if (before.equals("summer")) {
            processor = new SummerHolidays();
        }

        for (String lessonName : reader.readAllLessons()) {
             lessons.add(processor.getLessonInformation(lessonName));
        }

        model.addAttribute("timetable", lessons);
        return "every";
    }
}
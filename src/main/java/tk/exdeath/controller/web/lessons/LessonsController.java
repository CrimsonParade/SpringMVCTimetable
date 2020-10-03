package tk.exdeath.controller.web.lessons;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.view.lessons.NearestHolidays;
import tk.exdeath.view.lessons.SummerHolidays;
import tk.exdeath.view.lessons.LessonsProcessor;

import java.util.ArrayList;

@Controller
public class LessonsController {

    @GetMapping("/lessons")
    public String lessons(
            @RequestParam(defaultValue = "") String lessonName,
            @RequestParam(defaultValue = "root") String userLogin, Model model) {

        ArrayList<String> lessons = new ArrayList<>();
        LessonsProcessor processor;

        processor = new NearestHolidays();
        lessons.add(processor.getLessonInformation(lessonName, userLogin));

        processor = new SummerHolidays();
        lessons.add(processor.getLessonInformation(lessonName, userLogin));

        model.addAttribute("timetable", lessons);
        return "lessons";
    }
}

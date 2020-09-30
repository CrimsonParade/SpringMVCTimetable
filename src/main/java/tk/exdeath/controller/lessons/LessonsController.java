package tk.exdeath.controller.lessons;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.view.lessons.BeforeNearestHolidays;
import tk.exdeath.view.lessons.BeforeSummerHolidays;
import tk.exdeath.view.lessons.NumberOfLessonsProcessor;

import java.util.ArrayList;

@Controller
public class LessonsController {

    @GetMapping("/lessons")
    public String lessons(
            @RequestParam(name = "lessonName", required = false, defaultValue = "") String lessonName, Model model) {

        ArrayList<String> lessons = new ArrayList<>();
        NumberOfLessonsProcessor processor;

        processor = new BeforeNearestHolidays();
        lessons.add(processor.getNumberOfLessons(lessonName));

        processor = new BeforeSummerHolidays();
        lessons.add(processor.getNumberOfLessons(lessonName));

        model.addAttribute("timetable", lessons);
        return "lessons";
    }
}

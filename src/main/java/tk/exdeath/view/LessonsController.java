package tk.exdeath.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.collector.BeforeNearestHolidays;
import tk.exdeath.controller.collector.BeforeSummerHolidays;
import tk.exdeath.controller.collector.NumberOfLessons;

import java.util.ArrayList;

@Controller
public class LessonsController {

    @GetMapping("/lessons")
    public String lessons(
            @RequestParam(name = "lessonName", required = false, defaultValue = "") String lessonName, Model model) {

        ArrayList<String> lessons = new ArrayList<>();
        NumberOfLessons writer;

        writer = new BeforeNearestHolidays();
        lessons.add(writer.getNumberOfLessons(lessonName));

        writer = new BeforeSummerHolidays();
        lessons.add(writer.getNumberOfLessons(lessonName));

        model.addAttribute("timetable", lessons);
        return "lessons";
    }
}

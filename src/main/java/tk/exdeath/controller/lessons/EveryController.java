package tk.exdeath.controller.lessons;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.view.lessons.BeforeNearestHolidays;
import tk.exdeath.view.lessons.BeforeSummerHolidays;
import tk.exdeath.view.lessons.NumberOfLessonsProcessor;
import tk.exdeath.model.reader.DataBaseReader;

import java.util.ArrayList;

@Controller
public class EveryController {

    @GetMapping("/every")
    public String every(
            @RequestParam(name = "before", required = false, defaultValue = "nearest") String before, Model model) {

        DataBaseReader reader = new DataBaseReader();
        NumberOfLessonsProcessor processor = new BeforeNearestHolidays();
        ArrayList<String> lessons = new ArrayList<>();

        if (before.equals("nearest")) {
            processor = new BeforeNearestHolidays();
        }
        if (before.equals("summer")) {
            processor = new BeforeSummerHolidays();
        }

        for (String lessonName : reader.readAllLessons()) {
             lessons.add(processor.getNumberOfLessons(lessonName));
        }

        model.addAttribute("timetable",lessons);
        return "every";
    }
}

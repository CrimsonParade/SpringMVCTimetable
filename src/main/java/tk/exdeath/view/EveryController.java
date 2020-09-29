package tk.exdeath.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.collector.BeforeNearestHolidays;
import tk.exdeath.controller.collector.BeforeSummerHolidays;
import tk.exdeath.controller.collector.NumberOfLessons;
import tk.exdeath.model.DataBaseReader;

import java.util.ArrayList;

@Controller
public class EveryController {

    @GetMapping("/every")
    public String every(
            @RequestParam(name = "before", required = false, defaultValue = "nearest") String before, Model model) {

        DataBaseReader reader = new DataBaseReader();
        NumberOfLessons writer = new BeforeNearestHolidays();
        ArrayList<String> lessons = new ArrayList<>();

        if (before.equals("nearest")) {
            writer = new BeforeNearestHolidays();
        }
        if (before.equals("summer")) {
            writer = new BeforeSummerHolidays();
        }

        for (String lessonName : reader.readAllLessons()) {
             lessons.add(writer.getNumberOfLessons(lessonName));
        }

        model.addAttribute("timetable",lessons);
        return "every";
    }
}

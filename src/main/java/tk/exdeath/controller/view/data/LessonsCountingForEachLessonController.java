package tk.exdeath.controller.view.data;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.processor.lessons.LessonCountingProcessor;
import tk.exdeath.controller.processor.lessons.NearestHolidays;
import tk.exdeath.controller.processor.lessons.SummerHolidays;
import tk.exdeath.model.service.UserService;

import java.util.ArrayList;

@Controller
public class LessonsCountingForEachLessonController {

    @GetMapping("/allLessons")
    public String lessonsCountingForEachLesson(
            @RequestParam(defaultValue = "RU") String language,
            @RequestParam(defaultValue = "nearest") String before,
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        UserService reader = new UserService();
        LessonCountingProcessor processor = whatHolidays(before);
        ArrayList<String> lessons = new ArrayList<>();

        for (String lessonName : reader.readAllLessonNames(userLogin)) {
            lessons.add(processor.getLessonInformation(lessonName, userLogin));
        }

        model.addAttribute("timetable", lessons);
        return language + "/lessonsCountingForEachLesson" + language;
    }

    LessonCountingProcessor whatHolidays(String holidaysName) {

        if (holidaysName.equals("summer")) {
            return new SummerHolidays();
        }

        return new NearestHolidays();
    }
}

package tk.exdeath.controller.view.data.lessons;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.processor.lessons.holidays.Holidays;
import tk.exdeath.controller.processor.lessons.holidays.HolidaysCreator;
import tk.exdeath.model.service.UserService;

import java.util.ArrayList;

@Controller
public class LessonsForEachLessonController {

    @GetMapping("/allLessons")
    public String lessonsCountingForEachLesson(
            @RequestParam(defaultValue = "RU") String language,
            @RequestParam(defaultValue = "nearest") String before,
            @RequestParam(defaultValue = "null") String userLogin, Model model) {

        UserService reader = new UserService();

        Holidays holidays = HolidaysCreator.getInstance(before, language);
        ArrayList<String> lessons = new ArrayList<>();

        for (String lessonName : reader.readAllLessonNames(userLogin)) {
            lessons.add(holidays.getLessonInformation(lessonName, userLogin));
        }

        model.addAttribute("timetable", lessons);
        return language + "/lessonsCountingForEachLesson" + language;
    }
}

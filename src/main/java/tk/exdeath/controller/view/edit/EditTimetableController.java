package tk.exdeath.controller.view.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.model.Lesson;
import tk.exdeath.model.User;
import tk.exdeath.model.service.UserService;

import java.util.Comparator;
import java.util.List;

@Controller
public class EditTimetableController {

    String language;
    String userLogin;
    User user;
    UserService userService = new UserService();


    @GetMapping("/editTimetable")
    public String edit(
            @RequestParam(defaultValue = "RU") String language,
            @RequestParam String userLogin, Model model) {

        this.language = language;
        this.userLogin = userLogin;
        this.user = userService.readUserByLogin(userLogin);

        model.addAttribute("userLogin", userLogin);
        model.addAttribute("timetable", getSortedTimetable());
        return language + "/edit/editTimetable" + language;
    }


    @PostMapping("/editTimetable")
    public String editTimetable(
            @RequestParam String dayOfWeek,
            @RequestParam int lessonNumber,
            @RequestParam String lessonName,
            @RequestParam String roomNumber,
            @RequestParam String teacherName, Model model) {

        Lesson lesson = new Lesson(lessonNumber, dayOfWeek, lessonName, roomNumber, teacherName, user);
        user.addLesson(lesson);
        userService.update(user);

        model.addAttribute("userLogin", userLogin);
        model.addAttribute("timetable", getSortedTimetable());
        return language + "/edit/editTimetable" + language;
    }


    private List<Lesson> getSortedTimetable() {

        List<Lesson> lessons = user.getLessons();
        lessons.sort(Comparator.comparing(Lesson::getDayOfWeek));
        return lessons;
    }
}

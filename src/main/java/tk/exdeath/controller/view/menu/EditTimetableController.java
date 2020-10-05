package tk.exdeath.controller.view.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.model.Lesson;
import tk.exdeath.model.User;
import tk.exdeath.model.service.UserService;

import java.util.List;

@Controller
public class EditTimetableController {

    String userLogin;
    User user;
    UserService userService = new UserService();


    @GetMapping("/editTimetable")
    public String edit(
            @RequestParam String userLogin, Model model) {

        this.userLogin = userLogin;
        this.user = userService.readByLogin(userLogin);

        List<Lesson> lessons = user.getLessons();

        model.addAttribute("userLogin", userLogin);
        model.addAttribute("timetable", lessons);
        return "editTimetable";
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

        List<Lesson> lessons = user.getLessons();

        model.addAttribute("userLogin", userLogin);
        model.addAttribute("timetable", lessons);
        return "editTimetable";
    }
}

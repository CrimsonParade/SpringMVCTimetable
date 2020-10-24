package tk.exdeath.controller.view.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.exdeath.controller.view.LoggedUser;
import tk.exdeath.model.Lesson;
import tk.exdeath.model.User;

import java.util.Comparator;
import java.util.List;

@Controller
public class EditTimetableController {

    String path;
    String login;
    User user;

    @GetMapping("/editTimetable")
    public String edit(Model model) {

        path = LoggedUser.getLanguage() + "/edit/editTimetable" + LoggedUser.getLanguage();
        login = LoggedUser.getLogin();
        user = LoggedUser.getUser();

        model.addAttribute("userLogin", login);
        model.addAttribute("timetable", getSortedTimetable());
        return path;
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
        LoggedUser.getUserService().update(user);

        model.addAttribute("userLogin", login);
        model.addAttribute("timetable", getSortedTimetable());
        return path;
    }


    private List<Lesson> getSortedTimetable() {
        List<Lesson> lessons = user.getLessons();
        if (!lessons.isEmpty()) {
            lessons.sort(Comparator.comparing(Lesson::getDayOfWeek));
        }
        return lessons;
    }
}

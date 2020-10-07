package tk.exdeath.controller.processor.days;

import tk.exdeath.model.Lesson;
import tk.exdeath.model.service.UserService;

import java.util.ArrayList;
import java.util.List;


public abstract class TimetablesProcessor {

    private static final UserService READER = new UserService();

    public static List<String> getTimetable(String dayOfWeek, String userLogin) {

        List<String> timetable = new ArrayList<>();

        if (isHoliday(dayOfWeek, userLogin)) {
            timetable.add("Выходной!");
        } else {
            for (Lesson lesson : READER.readLessonsByDayOfWeek(dayOfWeek, userLogin)) {
                timetable.add(lesson.toRoomAndLesson());
            }
        }
        return timetable;
    }

    private static boolean isHoliday(String dayOfWeek, String userLogin) {
        return READER.readLessonsByDayOfWeek(dayOfWeek, userLogin).isEmpty();
    }
}

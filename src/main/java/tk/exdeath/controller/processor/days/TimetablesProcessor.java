package tk.exdeath.controller.processor.days;

import tk.exdeath.model.service.LessonService;
import tk.exdeath.model.Lesson;

import java.util.ArrayList;
import java.util.List;


public abstract class TimetablesProcessor {

    private static final LessonService READER = new LessonService();

    public static List<String> getTimetable(String dayOfWeek, String userLogin) {

        List<String> timetable = new ArrayList<>();

        if (isHoliday(dayOfWeek, userLogin)) {
            timetable.add("Выходной!");
        }
        else {
            for (Lesson lesson : READER.readByDayOfWeek(dayOfWeek, userLogin)) {
                timetable.add(lesson.toRoomAndLesson());
            }
        }
        return timetable;
    }

    private static boolean isHoliday(String dayOfWeek, String userLogin) {
        return READER.readByDayOfWeek(dayOfWeek, userLogin).isEmpty();
    }
}

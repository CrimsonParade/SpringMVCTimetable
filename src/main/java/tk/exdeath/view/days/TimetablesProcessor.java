package tk.exdeath.view.days;

import tk.exdeath.model.reader.DataBaseReader;
import tk.exdeath.model.database.Lesson;

import java.util.ArrayList;
import java.util.List;


public abstract class TimetablesProcessor {

    private static final DataBaseReader READER = new DataBaseReader();

    public static List<String> getTimetable(String dayOfWeek) {

        List<String> timetable = new ArrayList<>();

        if (isHoliday(dayOfWeek)) {
            timetable.add("Выходной!");
        }
        else {
            for (Lesson lesson : READER.readByDayOfWeek(dayOfWeek)) {
                timetable.add(lesson.toRoomAndLesson());
            }
        }
        return timetable;
    }

    private static boolean isHoliday(String dayOfWeek) {
        return READER.readByDayOfWeek(dayOfWeek).isEmpty();
    }
}

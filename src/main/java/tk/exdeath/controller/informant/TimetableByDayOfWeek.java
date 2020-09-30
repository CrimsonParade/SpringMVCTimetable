package tk.exdeath.controller.informant;

import tk.exdeath.model.DataBaseReader;
import tk.exdeath.model.database.Timetable;

import java.util.ArrayList;
import java.util.List;


public abstract class TimetableByDayOfWeek {

    private static final DataBaseReader READER = new DataBaseReader();

    public static List<String> getTimetable(String dayOfWeek) {
        List<String> lessons = new ArrayList<>();
        if (isHoliday(dayOfWeek)) {
            lessons.add("Выходной!");
        } else {
            for (Timetable timeTable : READER.readByDayOfWeek(dayOfWeek)) {
                lessons.add(timeTable.toTimetable());
            }
        }
        return lessons;
    }

    private static boolean isHoliday(String dayOfWeek) {
        return READER.readByDayOfWeek(dayOfWeek).isEmpty();
    }
}

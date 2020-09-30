package tk.exdeath.model.reader;

import tk.exdeath.model.database.Timetable;

import java.util.List;
import java.util.Set;

public interface InterfaceDAO {
    List<Timetable> readByDayOfWeek(String dayOfWeek);

    Set<String> readAllLessons();
}

package tk.exdeath.model.reader;

import tk.exdeath.model.database.Lesson;

import java.util.List;
import java.util.Set;

public interface InterfaceDAO {
    List<Lesson> readByDayOfWeek(String dayOfWeek);

    Set<String> readAllLessons();
}

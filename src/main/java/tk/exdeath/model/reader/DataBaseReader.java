package tk.exdeath.model.reader;

import tk.exdeath.model.database.LessonDAO;
import tk.exdeath.model.database.Lesson;

import java.util.List;
import java.util.Set;

public class DataBaseReader {

    private final InterfaceDAO DAO = new LessonDAO();

    public DataBaseReader() {
    }

    public List<Lesson> readByDayOfWeek(String dayOfWeek) {
        return DAO.readByDayOfWeek(dayOfWeek);
    }

    public Set<String> readAllLessons() {
        return DAO.readAllLessons();
    }

}

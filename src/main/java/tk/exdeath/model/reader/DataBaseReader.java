package tk.exdeath.model.reader;

import tk.exdeath.model.database.TimetableDAO;
import tk.exdeath.model.database.Timetable;

import java.util.List;
import java.util.Set;

public class DataBaseReader {

    private final InterfaceDAO DAO = new TimetableDAO();

    public DataBaseReader() {
    }

    public List<Timetable> readByDayOfWeek(String dayOfWeek) {
        return DAO.readByDayOfWeek(dayOfWeek);
    }

    public Set<String> readAllLessons() {
        return DAO.readAllLessons();
    }

}

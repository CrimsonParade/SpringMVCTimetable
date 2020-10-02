package tk.exdeath.model.service;

import tk.exdeath.model.hibernate.LessonDAO;
import tk.exdeath.model.Lesson;

import java.util.List;
import java.util.Set;

public class LessonService {

    private final LessonDAO DAO = new LessonDAO();

    public LessonService() {
    }

    public void create(Lesson lesson) {
        DAO.create(lesson);
    }

    public void update(Lesson lesson) {
        DAO.update(lesson);
    }

    public void delete(Lesson lesson) {
        DAO.delete(lesson);
    }

    public List<Lesson> readByDayOfWeek(String dayOfWeek) {
        return DAO.readByDayOfWeek(dayOfWeek);
    }

    public Set<String> readAllLessons() {
        return DAO.readAllLessons();
    }

}

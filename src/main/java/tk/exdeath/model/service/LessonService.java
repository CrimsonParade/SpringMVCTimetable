package tk.exdeath.model.service;

import tk.exdeath.model.hibernate.LessonDAO;
import tk.exdeath.model.Lesson;

import java.util.ArrayList;
import java.util.HashSet;
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

    public List<Lesson> readByDayOfWeek(String dayOfWeek, String userLogin) {
        List<Lesson> lessons = new ArrayList<>();

        for (Lesson lesson : DAO.readByDayOfWeek(dayOfWeek)) {
            if (lesson.getUserLogin().equals(userLogin)) {
                lessons.add(lesson);
            }
        }

        return lessons;
    }

    public Set<String> readAllLessons(String userLogin) {
        Set<String> lessons = new HashSet<>();

        for (Lesson lesson : DAO.readAllLessons()) {
            if (lesson.getUserLogin().equals(userLogin)) {
                lessons.add(lesson.getLessonName());
            }
        }

        return lessons;
    }

}

package tk.exdeath.model.service;

import tk.exdeath.model.Lesson;
import tk.exdeath.model.hibernate.LessonDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LessonService {

    private final LessonDAO DAO = new LessonDAO();

    public LessonService() {
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

    public Set<String> readAllLessonNames(String userLogin) {
        Set<String> lessonNames = new HashSet<>();

        for (Lesson lesson : DAO.readAllLessons()) {
            if (lesson.getUserLogin().equals(userLogin)) {
                lessonNames.add(lesson.getLessonName());
            }
        }

        return lessonNames;
    }

}

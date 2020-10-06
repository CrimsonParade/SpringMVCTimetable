package tk.exdeath.model.service;

import tk.exdeath.model.Lesson;
import tk.exdeath.model.User;
import tk.exdeath.model.hibernate.UserDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserService {

    private final UserDAO DAO = new UserDAO();

    public UserService() {
    }

    public void create(User user) {
        DAO.create(user);
    }

    public void update(User user) {
        DAO.update(user);
    }

    public User readUserByLogin(String login) {
        if (DAO.readByLogin(login) == null) {
            return new User("null", "null");
        }
        return DAO.readByLogin(login);
    }

    public Set<String> readAllLessonNames(String userLogin) {
        Set<String> lessonNames = new HashSet<>();

        for (Lesson lesson : DAO.readByLogin(userLogin).getLessons()) {
            lessonNames.add(lesson.getLessonName());
        }

        return lessonNames;
    }

    public List<Lesson> readLessonsByDayOfWeek(String dayOfWeek, String userLogin) {
        List<Lesson> lessons = new ArrayList<>();

        for (Lesson lesson : DAO.readByLogin(userLogin).getLessons()) {
            if (lesson.getDayOfWeek().equals(dayOfWeek)) {
                lessons.add(lesson);
            }
        }

        return lessons;
    }

}

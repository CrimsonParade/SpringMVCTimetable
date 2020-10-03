package tk.exdeath.model.service;

import tk.exdeath.model.User;
import tk.exdeath.model.hibernate.UserDAO;

import java.util.List;

public class UserService {

    private final UserDAO DAO = new UserDAO();

    public void create(User user) {
        DAO.create(user);
    }

    public void update(User user) {
        DAO.update(user);
    }

    public void delete(User user) {
        DAO.delete(user);
    }

    public User readByLogin(String login) {
        if (DAO.readByLogin(login) == null) {
            return new User("null", "null");
        }
        return DAO.readByLogin(login);
    }

    public List<User> readAllUsers() {
        return DAO.readAllUsers();
    }
}

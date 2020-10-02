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

    public User readByID(int id) {
        return DAO.readByID(id);
    }

    public List<User> readAllUsers() {
        return DAO.readAllUsers();
    }
}

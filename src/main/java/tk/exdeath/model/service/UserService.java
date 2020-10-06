package tk.exdeath.model.service;

import tk.exdeath.model.User;
import tk.exdeath.model.hibernate.UserDAO;

public class UserService {

    private final UserDAO DAO = new UserDAO();

    public void create(User user) {
        DAO.create(user);
    }

    public void update(User user) {
        DAO.update(user);
    }

    public User readByLogin(String login) {
        if (DAO.readByLogin(login) == null) {
            return new User("null", "null");
        }
        return DAO.readByLogin(login);
    }
}

package tk.exdeath.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "exdeath.users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userID;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons;

    @Override
    public String toString() {
        return "Login: " + login +
                " Password: " + password +
                " ID: " + userID;
    }

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

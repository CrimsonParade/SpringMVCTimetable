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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Holiday> holidays;

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
    

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }
}

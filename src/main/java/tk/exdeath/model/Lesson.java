package tk.exdeath.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exdeath.timetable")
public class Lesson implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "lesson_number")
    private int lessonNumber;
    @Column(name = "day_of_week")
    private String dayOfWeek;
    @Column(name = "lesson_name")
    private String lessonName;
    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "teacher_name")
    private String teacherName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Lesson() {
    }

    @Override
    public String toString() {
        return "\nДень недели: " + dayOfWeek +
                " | Урок номер: " + lessonNumber +
                " | Кабинет: " + roomNumber +
                " | Урок: " + lessonName +
                " | Учитель: " + teacherName;
    }

    public String toRoomAndLesson() {
        return  "№: " + lessonNumber +
                " | Кабинет: " + roomNumber +
                " | Урок: " + lessonName;
    }
    public String toRoomAndDayOfWeek(){
        return  "№: " + lessonNumber +
                " | Кабинет: " + roomNumber +
                " | День недели: " + dayOfWeek;
    }

    public String getLessonName() {
        return lessonName;
    }

    public String getUserLogin() {
        return user.getLogin();
    }
}

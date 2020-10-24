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

    public Lesson(int lessonNumber, String dayOfWeek, String lessonName, String roomNumber, String teacherName, User user) {
        this.lessonNumber = lessonNumber;
        this.dayOfWeek = dayOfWeek;
        this.lessonName = lessonName;
        this.roomNumber = roomNumber;
        this.teacherName = teacherName;
        this.user = user;
    }


    public String getLessonName() {
        return lessonName;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    @Override
    public String toString() {
        return "№: " + lessonNumber +
                ", День недели: " + dayOfWeek +
                ", Название: " + lessonName +
                ", Кабинет: " + roomNumber +
                ", Учитель: " + teacherName;
    }

    public String toRoomAndLessonRU() {
        return "№: " + lessonNumber +
                " | Кабинет: " + roomNumber +
                " | Урок: " + lessonName;
    }

    public String toRoomAndLessonENG() {
        return "№: " + lessonNumber +
                " | Room: " + roomNumber +
                " | Lesson: " + lessonName;
    }

    public String toRoomAndDayOfWeekRU() {
        return "№: " + lessonNumber +
                " | Кабинет: " + roomNumber +
                " | День недели: " + dayOfWeek;
    }

    public String toRoomAndDayOfWeekENG() {
        return "№: " + lessonNumber +
                " | Room: " + roomNumber +
                " | Day Of Week: " + dayOfWeek;
    }
}

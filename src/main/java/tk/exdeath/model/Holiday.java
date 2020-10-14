package tk.exdeath.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exdeath.holidays")
public class Holiday implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "length")
    private int length;
    @Column(name = "year")
    private int year;
    @Column(name = "month")
    private int month;
    @Column(name = "day")
    private int day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Holiday() {
    }

    public Holiday(int length, int year, int month, int day, User user) {
        this.length = length;
        this.year = year;
        this.month = month;
        this.day = day;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Holiday length: " + length +
                ", Year: " + year +
                ", Month: " + month +
                ", Day: " + day;
    }

    @Override
    public int hashCode() {
        return ((year % 100) * 10000) + (month * 100) + day;
    }

    public int getLength() {
        return length;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}

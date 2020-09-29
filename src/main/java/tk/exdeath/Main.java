package tk.exdeath;

import tk.exdeath.controller.collector.BeforeNearestHolidays;
import tk.exdeath.controller.collector.NumberOfLessons;
import tk.exdeath.controller.collector.TimetableByDayOfWeek;
import tk.exdeath.model.DataBaseReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DataBaseReader reader = new DataBaseReader();
        NumberOfLessons writer = new BeforeNearestHolidays();
        System.out.println(TimetableByDayOfWeek.getTimetable(LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("EEEE"))));

        //for (String lessonName : reader.readAllLessons()) { System.out.println(writer.getNumberOfLessons(lessonName)); }
    }
}

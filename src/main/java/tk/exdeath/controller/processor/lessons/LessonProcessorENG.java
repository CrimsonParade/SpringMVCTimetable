package tk.exdeath.controller.processor.lessons;

import tk.exdeath.controller.counter.LessonCounter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LessonProcessorENG implements LessonProcessor {

    private final LocalDate NULL_DATE = LocalDate.MIN;
    private LessonCounter counter;

    @Override
    public String getLessonInformation(String lessonName, String userLogin, LessonCounter counter) {

        this.counter = counter;
        this.counter.setLocale(Locale.ENGLISH);
        String lessonInformation = "Lesson: " + lessonName + "\nLessons before " + holidaysName() + " holidays: " + lessonsBeforeHolidays(lessonName, userLogin);

        if (lastLessonIsNotNull()) {
            lessonInformation += "\nLast lesson date: " + lastLessonDate() + "\nLast lesson: " + lastLesson();
        }
        return lessonInformation;
    }


    private boolean lastLessonIsNotNull() {
        return !counter.getLastLessonDate().equals(NULL_DATE);
    }

    private int lessonsBeforeHolidays(String lessonName, String userLogin) {
        return counter.lessonsBeforeHolidays(lessonName, userLogin);
    }

    private String lastLessonDate() {
        DateTimeFormatter dayMonthYear = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
        return counter.getLastLessonDate().format(dayMonthYear);
    }

    private String lastLesson() {
        return counter.getLastLesson().toRoomAndDayOfWeekENG();
    }

    private String holidaysName() {
        return counter.getHolidaysNameENG();
    }
}

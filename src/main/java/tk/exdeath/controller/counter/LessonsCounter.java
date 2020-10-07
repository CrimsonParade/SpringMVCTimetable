package tk.exdeath.controller.counter;

import tk.exdeath.model.Lesson;
import tk.exdeath.model.service.UserService;

import java.time.LocalDate;

public abstract class LessonsCounter {

    private final LocalDate NULL_DATE = LocalDate.MIN;

    private Lesson lastLesson;
    private LocalDate lastLessonDate = NULL_DATE;
    private final UserService reader = new UserService();


    public int lessonsBeforeHolidays(String lessonName, String userLogin) {

        LocalDate lessonDate = dateWithoutHolidays();
        int i = counterWithoutHolidays(lessonDate);
        long daysBeforeHolidays = daysBeforeHolidays();

        int numberOfLessons = 0;

        while (i <= daysBeforeHolidays) {

            for (Lesson lesson : reader.readLessonsByDayOfWeek(lessonDate.format(ConstantPull.DAY_OF_WEEK), userLogin)) {

                if (lesson.getLessonName().equals(lessonName)) {
                    lastLesson = lesson;
                    lastLessonDate = lessonDate;
                    numberOfLessons++;
                }
            }

            i = addCounterValue(lessonDate, i);
            lessonDate = addDays(lessonDate);
        }

        return numberOfLessons;
    }


    private int addCounterValue(LocalDate lessonDate, int counterValue) {

        if (lessonDate.equals(ConstantPull.OCTOBER_HOLIDAYS) || lessonDate.equals(ConstantPull.APRIL_HOLIDAYS)) {
            counterValue += ConstantPull.SHORT_HOLIDAYS_LENGTH;
        }
        if (lessonDate.equals(ConstantPull.NOVEMBER_HOLIDAYS) || lessonDate.equals(ConstantPull.FEBRUARY_HOLIDAYS)) {
            counterValue += ConstantPull.LONG_HOLIDAYS_LENGTH;
        }
        if (lessonDate.equals(ConstantPull.NEW_YEAR_HOLIDAYS)) {
            counterValue += ConstantPull.NEW_YEAR_HOLIDAYS_LENGTH;
        }

        counterValue++;

        return counterValue;
    }

    private LocalDate addDays(LocalDate lessonDate) {

        if (lessonDate.equals(ConstantPull.OCTOBER_HOLIDAYS) || lessonDate.equals(ConstantPull.APRIL_HOLIDAYS)) {
            lessonDate = lessonDate.plusDays(ConstantPull.SHORT_HOLIDAYS_LENGTH);
        }
        if (lessonDate.equals(ConstantPull.NOVEMBER_HOLIDAYS) || lessonDate.equals(ConstantPull.FEBRUARY_HOLIDAYS)) {
            lessonDate = lessonDate.plusDays(ConstantPull.LONG_HOLIDAYS_LENGTH);
        }
        if (lessonDate.equals(ConstantPull.NEW_YEAR_HOLIDAYS)) {
            lessonDate = lessonDate.plusDays(ConstantPull.NEW_YEAR_HOLIDAYS_LENGTH);
        }

        lessonDate = lessonDate.plusDays(1);

        return lessonDate;
    }

    private LocalDate dateWithoutHolidays() {

        LocalDate lessonDate = ConstantPull.DATE_NOW.minusDays(1);

        lessonDate = addDays(lessonDate);

        return lessonDate;
    }

    private int counterWithoutHolidays(LocalDate lessonDate) {

        int counter = -1;

        counter = addCounterValue(lessonDate, counter);

        return counter;
    }


    public LocalDate getLastLessonDate() {
        return lastLessonDate;
    }

    public Lesson getLastLesson() {
        return lastLesson;
    }

    abstract long daysBeforeHolidays();

    public abstract String getHolidaysName();
}

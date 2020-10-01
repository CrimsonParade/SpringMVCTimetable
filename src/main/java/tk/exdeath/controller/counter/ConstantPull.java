package tk.exdeath.controller.counter;

import tk.exdeath.model.reader.DataBaseReader;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ConstantPull {

    static final LocalDate DATE_NOW = dateNow();
    static final LocalDate END_OF_YEAR_DATE = LocalDate.of(2021, 5, 31);
    static final LocalDate OCTOBER_HOLIDAYS = LocalDate.of(2020, 10, 6);
    static final LocalDate NOVEMBER_HOLIDAYS = LocalDate.of(2020, 11, 13);
    static final LocalDate NEW_YEAR_HOLIDAYS = LocalDate.of(2020, 12, 30);
    static final LocalDate FEBRUARY_HOLIDAYS = LocalDate.of(2021, 2, 19);
    static final LocalDate APRIL_HOLIDAYS = LocalDate.of(2021, 4, 6);
    static final int SHORT_HOLIDAYS_LENGTH = 5;
    static final int LONG_HOLIDAYS_LENGTH = 9;
    static final int NEW_YEAR_HOLIDAYS_LENGTH = 11;
    static final long DAYS_BEFORE_SUMMER_HOLIDAYS = ChronoUnit.DAYS.between(DATE_NOW, END_OF_YEAR_DATE);
    static final long DAYS_BEFORE_NEAREST_HOLIDAYS = daysBeforeHolidays();
    static final DataBaseReader READER = new DataBaseReader();
    static final DateTimeFormatter DAY_OF_WEEK_FORMAT = DateTimeFormatter.ofPattern("EEEE");


    private static LocalDate dateNow() {
        if (LocalTime.now().getHour() > 17) {
            return LocalDate.now().plusDays(1);
        } else {
            return LocalDate.now();
        }
    }

    private static long daysBeforeHolidays() {
        if (ChronoUnit.DAYS.between(DATE_NOW, OCTOBER_HOLIDAYS) > 0) {
            return ChronoUnit.DAYS.between(DATE_NOW, OCTOBER_HOLIDAYS);
        }
        if (ChronoUnit.DAYS.between(DATE_NOW, NOVEMBER_HOLIDAYS) > 0) {
            return ChronoUnit.DAYS.between(DATE_NOW, NOVEMBER_HOLIDAYS);
        }
        if (ChronoUnit.DAYS.between(DATE_NOW, NEW_YEAR_HOLIDAYS) > 0) {
            return ChronoUnit.DAYS.between(DATE_NOW, NEW_YEAR_HOLIDAYS);
        }
        if (ChronoUnit.DAYS.between(DATE_NOW, FEBRUARY_HOLIDAYS) > 0) {
            return ChronoUnit.DAYS.between(DATE_NOW, FEBRUARY_HOLIDAYS);
        }
        if (ChronoUnit.DAYS.between(DATE_NOW, APRIL_HOLIDAYS) > 0) {
            return ChronoUnit.DAYS.between(DATE_NOW, APRIL_HOLIDAYS);
        }
        return 0;
    }
}
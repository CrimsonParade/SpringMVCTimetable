package tk.exdeath.controller.counter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BeforeSummerHolidays extends LessonCounter {

    @Override
    long daysBeforeHolidays(String userLogin) {

        LocalDate endOfYear = LocalDate.of(2021, 5, 31);

        return ChronoUnit.DAYS.between(dateNow(), endOfYear);
    }

    @Override
    public String getHolidaysNameRU() {
        return "летних";
    }

    @Override
    public String getHolidaysNameENG() {
        return "summer";
    }
}
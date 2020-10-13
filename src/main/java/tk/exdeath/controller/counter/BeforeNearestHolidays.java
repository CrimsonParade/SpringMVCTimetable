package tk.exdeath.controller.counter;

import tk.exdeath.model.Holiday;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BeforeNearestHolidays extends LessonCounter {

    @Override
    long daysBeforeHolidays(String userLogin) {

        for (Holiday holiday : getSortedHolidays(userLogin)) {

            LocalDate holidayDate = LocalDate.of(holiday.getYear(), holiday.getMonth(), holiday.getDay());

            if (ChronoUnit.DAYS.between(dateNow(), holidayDate) > 0) {
                return ChronoUnit.DAYS.between(dateNow(), holidayDate);
            }
        }

        return 0;
    }

    @Override
    public String getHolidaysNameRU() {
        return "ближайших";
    }

    @Override
    public String getHolidaysNameENG() {
        return "nearest";
    }
}

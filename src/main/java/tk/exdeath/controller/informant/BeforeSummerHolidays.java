package tk.exdeath.controller.informant;

import tk.exdeath.controller.counter.SummerHolidays;
import tk.exdeath.controller.counter.LessonsCounter;

public class BeforeSummerHolidays extends NumberOfLessons {

    @Override
    LessonsCounter beforeWhatHolidays() {
        return new SummerHolidays();
    }
}

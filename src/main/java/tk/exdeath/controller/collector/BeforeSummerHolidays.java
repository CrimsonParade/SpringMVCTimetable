package tk.exdeath.controller.collector;

import tk.exdeath.controller.counter.SummerHolidays;
import tk.exdeath.controller.counter.LessonsCounter;

public class BeforeSummerHolidays extends NumberOfLessons {

    @Override
    LessonsCounter beforeWhatHolidays() {
        return new SummerHolidays();
    }
}

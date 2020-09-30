package tk.exdeath.view.lessons;

import tk.exdeath.controller.counter.SummerHolidays;
import tk.exdeath.controller.counter.LessonsCounter;

public class BeforeSummerHolidays extends NumberOfLessonsProcessor {

    @Override
    LessonsCounter beforeWhatHolidays() {
        return new SummerHolidays();
    }
}

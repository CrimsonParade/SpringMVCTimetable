package tk.exdeath.view.lessons;

import tk.exdeath.controller.counter.BeforeSummerHolidays;
import tk.exdeath.controller.counter.LessonsCounter;

public class SummerHolidays extends LessonsProcessor {

    @Override
    LessonsCounter beforeWhatHolidays() {
        return new BeforeSummerHolidays();
    }
}

package tk.exdeath.controller.processor.lessons;

import tk.exdeath.controller.counter.BeforeSummerHolidays;
import tk.exdeath.controller.counter.LessonsCounter;

public class SummerHolidays extends LessonsCountProcessor {

    @Override
    LessonsCounter beforeWhatHolidays() {
        return new BeforeSummerHolidays();
    }
}

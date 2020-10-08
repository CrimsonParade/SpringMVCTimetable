package tk.exdeath.controller.processor.lessons;

import tk.exdeath.controller.counter.BeforeSummerHolidays;
import tk.exdeath.controller.counter.LessonCounter;

public class SummerHolidays extends LessonsCountProcessor {

    @Override
    LessonCounter beforeWhatHolidays() {
        return new BeforeSummerHolidays();
    }
}

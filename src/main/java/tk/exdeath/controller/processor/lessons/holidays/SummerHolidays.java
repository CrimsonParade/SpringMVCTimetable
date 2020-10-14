package tk.exdeath.controller.processor.lessons.holidays;

import tk.exdeath.controller.counter.BeforeSummerHolidays;
import tk.exdeath.controller.processor.lessons.LessonProcessor;

public class SummerHolidays implements Holidays {

    private final LessonProcessor processor;

    public SummerHolidays(LessonProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String getLessonInformation(String lessonName, String userLogin) {
        return processor.getLessonInformation(lessonName, userLogin, new BeforeSummerHolidays());
    }
}

package tk.exdeath.controller.processor.lessons.holidays;

import tk.exdeath.controller.counter.BeforeSummerHolidays;
import tk.exdeath.controller.view.data.lessons.LessonsBeforeHolidays;

public class SummerHolidays implements LessonsBeforeHolidays {

    private LessonCountingProcessor processor;

    public SummerHolidays(LessonCountingProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String getLessonInformation(String lessonName, String userLogin) {
        return processor.getLessonInformation(lessonName, userLogin, new BeforeSummerHolidays());
    }
}

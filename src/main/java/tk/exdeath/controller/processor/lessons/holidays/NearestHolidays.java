package tk.exdeath.controller.processor.lessons.holidays;


import tk.exdeath.controller.counter.BeforeNearestHolidays;
import tk.exdeath.controller.view.data.lessons.LessonsBeforeHolidays;

public class NearestHolidays implements LessonsBeforeHolidays {

    private LessonCountingProcessor processor;

    public NearestHolidays(LessonCountingProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String getLessonInformation(String lessonName, String userLogin) {
        return processor.getLessonInformation(lessonName, userLogin, new BeforeNearestHolidays());
    }
}
package tk.exdeath.controller.processor.lessons.holidays;


import tk.exdeath.controller.counter.LessonCounter;

public interface LessonCountingProcessor {
    String getLessonInformation(String lessonName, String userLogin, LessonCounter counter);
}

package tk.exdeath.controller.processor.lessons;

import tk.exdeath.controller.counter.LessonCounter;

public interface LessonProcessor {
    String getLessonInformation(String lessonName, String userLogin, LessonCounter counter);
}

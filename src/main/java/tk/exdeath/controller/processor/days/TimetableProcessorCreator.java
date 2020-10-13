package tk.exdeath.controller.processor.days;

import tk.exdeath.controller.view.data.days.TimetableProcessor;

public abstract class TimetableProcessorCreator {

    public static TimetableProcessor getInstance(String language) {
        if (language.equals("ENG")) {
            return new TimetableProcessorENG();
        }
        return new TimetableProcessorRU();
    }
}

package tk.exdeath.controller.counter;

public class NearestHolidays extends LessonsCounter {

    @Override
    long daysBeforeHolidays() {
        return ConstantPull.DAYS_BEFORE_HOLIDAYS;
    }

    @Override
    public String getHolidaysName() {
        return "ближайших";
    }
}

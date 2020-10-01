package tk.exdeath.controller.counter;

public class BeforeSummerHolidays extends LessonsCounter {

    @Override
    long daysBeforeHolidays() {
        return ConstantPull.DAYS_BEFORE_SUMMER_HOLIDAYS;
    }

    @Override
    public String getHolidaysName() {
        return "летних";
    }
}
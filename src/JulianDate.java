public class JulianDate extends Date {
    public JulianDate() {
        // Get current date
        long currentMill = System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset();
        currentYear = 1;
        currentMonth = 1;
        currentDay = 1;
        addDays(719164);
        addDays((int)(currentMill / 86_400_000));
    }
    public JulianDate(int year, int month, int day) {
        currentYear = year;
        currentMonth = month;
        currentDay = day;
    }
    public boolean isLeapYear(int year) {
         return year % 4 == 0;
    };
}
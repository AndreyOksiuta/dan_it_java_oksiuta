package java_core_hw_7;

public enum DayOfWeek {
    MONDAY("Monday", "go to work"),
    TUESDAY("Tuesday", "go to gym"),
    WEDNESDAY("Wednesday", " go to parent"),
    THURSDAY("Thursday", "go to shop"),
    FRIDAY("Friday", "go to bar"),
    SATURDAY("Saturday", "go to mall"),
    SUNDAY("Sunday", " go to brother");

    public final String dayOfWeek;
    public final String activity;

    DayOfWeek(String dayOfWeek, String activity) {
        this.dayOfWeek = dayOfWeek;
        this.activity = activity;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getActivity() {
        return activity;
    }
}

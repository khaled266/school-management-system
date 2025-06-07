package javaapplication12;

public class Schedule {
    private String day;
    private String startTime;
    private String endTime;

    public Schedule(String day, String startTime, String endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDay() {
        return day;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return day + " from " + startTime + " to " + endTime;
    }
}
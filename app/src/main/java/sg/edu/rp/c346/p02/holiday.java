package sg.edu.rp.c346.p02;

public class holiday {
    private String holiday;
    private String date;
    private String event;
    public holiday(String holiday, String date, String event ) {
        this.holiday = holiday;
        this.date = date;
        this.event = event;
    }
    public String getHoliday() {
        return holiday;
    }
    public String getDate() {
        return date;
    }
    public String getEvent() {
        return event;
    }
}

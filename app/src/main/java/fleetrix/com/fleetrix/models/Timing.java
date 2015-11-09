package fleetrix.com.fleetrix.models;

/**
 * Created by siddhant.srivastava on 22/02/15.
 */
public class Timing {
    private  String date;
    private String time;

    public Timing(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Timing{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

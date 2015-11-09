package fleetrix.com.fleetrix.models;

import fleetrix.com.fleetrix.models.Client;
import fleetrix.com.fleetrix.models.Timing;

/**
 * Created by siddhant.srivastava on 22/02/15.
 */
public class Booking {


    private String bookingId;
    private Client client;
    private Timing timing;

    public Booking(String bookingId, Client client, Timing timing) {
        this.bookingId = bookingId;
        this.client = client;
        this.timing = timing;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Timing getTiming() {
        return timing;
    }

    public void setTiming(Timing timing) {
        this.timing = timing;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", client=" + client +
                ", timing=" + timing +
                '}';
    }
}

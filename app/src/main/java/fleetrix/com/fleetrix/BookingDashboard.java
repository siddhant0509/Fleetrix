package fleetrix.com.fleetrix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fleetrix.com.fleetrix.R;
import fleetrix.com.fleetrix.models.Booking;
import fleetrix.com.fleetrix.models.Client;
import fleetrix.com.fleetrix.models.Timing;

public class BookingDashboard extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_dashboard);
        List<Booking> bookingList = getBookingList();
        ListView listView = (ListView)findViewById(R.id.bookingList);
        BookingListAdapter bookingListAdapter = new BookingListAdapter(this,R.layout.booking_list,bookingList);
        listView.setAdapter(bookingListAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.booking_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Booking> getBookingList(){
        List<Booking> bookingList = new ArrayList<Booking>();
        bookingList.add(new Booking("85643728",new Client("Flipkart","80 Feet Road Koramangala","+919994797299"),new Timing("13 Feb","08:00 AM")));
        bookingList.add(new Booking("78673992",new Client("Big Basket","HSR Layout 2nd Road","+919332890342"),new Timing("13 Feb","08:00 AM")));
        return bookingList;

    }
}

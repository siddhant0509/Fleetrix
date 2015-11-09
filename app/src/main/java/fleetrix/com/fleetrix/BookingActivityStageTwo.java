package fleetrix.com.fleetrix;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import fleetrix.com.fleetrix.R;
import fleetrix.com.fleetrix.models.Booking;

public class BookingActivityStageTwo extends Activity {

    private GoogleMap map;
    private LatLng latLng = new LatLng(12.9667,77.5667);
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_activity_stage_two);
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapInstance)).getMap();
        if(map != null){
            Marker marker = map.addMarker(new MarkerOptions().position(latLng).title("Home").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        }
        context = this;
        Button stop = (Button)findViewById(R.id.stopJob);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopUp();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.booking_activity_stage_two, menu);
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

    private void createPopUp(){
        AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        final View dialogView = layoutInflater.inflate(R.layout.drive_finish,null);
        alertDialog.setView(dialogView);
        Button finish = (Button)dialogView.findViewById(R.id.journeyFinish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BookingDashboard.class);
                context.startActivity(intent);
            }
        });
        alertDialog.show();
    }


}

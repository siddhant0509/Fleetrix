package fleetrix.com.fleetrix;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class BookingActivityStageOne extends Activity {

    private Context context;
    private GoogleMap map;
    private LatLng latLng = new LatLng(12.9667,77.5667);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        this.context = this;
        Button startDrive = (Button)findViewById(R.id.startJob);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapInstance)).getMap();
        if(map != null){
            Marker marker = map.addMarker(new MarkerOptions().position(latLng).title("Home").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        }



        startDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(context,BookingActivityStageTwo.class);
                Intent intent = new Intent(context,BookingActivityStageTwo.class);
                context.startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.booking, menu);
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
}

package fleetrix.com.fleetrix;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import fleetrix.com.fleetrix.models.Booking;

/**
 * Created by siddhant.srivastava on 22/02/15.
 */
public class BookingListAdapter extends ArrayAdapter<Booking> {

    private List<Booking> bookingList;
    private Context context;


    public BookingListAdapter(Context context, int resource, List<Booking> objects) {
        super(context, resource, objects);
        this.context = context;
        this.bookingList = objects;
    }

    static class ViewHolder{
        public TextView clientName;
        public TextView bookingDate;
        public TextView bookingTime;
        public TextView bookingId;
        public TextView clientPhone;
        public TextView clientAddress;

    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.booking_list,parent,false);

        ViewHolder viewHolder = setViewHolder(rowView);
        rowView.setTag(viewHolder);

        Booking booking = bookingList.get(position);
        viewHolder = (ViewHolder)rowView.getTag();
        viewHolder.clientName.setText(booking.getClient().getName());
        viewHolder.bookingDate.setText(booking.getTiming().getDate());
        viewHolder.bookingTime.setText(booking.getTiming().getTime());
        viewHolder.bookingId.setText(booking.getBookingId());
        viewHolder.clientPhone.setText(booking.getClient().getPhoneNumber());
        viewHolder.clientAddress.setText(booking.getClient().getAddress());


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHolder values = (ViewHolder)v.getTag();
                executeBookingStartDialogBox(values);
            }
        });
        return rowView;

    }

    private void executeBookingStartDialogBox(ViewHolder values){
        AlertDialog.Builder alertDialog= new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        final View dialogView = layoutInflater.inflate(R.layout.dialog_booking_origin,null);
        alertDialog.setView(dialogView);
        ViewHolder viewHolder = setViewHolder(dialogView);
        viewHolder.clientName.setText(values.clientName.getText());
        viewHolder.clientAddress.setText(values.clientAddress.getText());
        viewHolder.clientPhone.setText(values.clientPhone.getText());
        viewHolder.bookingId.setText(values.bookingId.getText());
        viewHolder.bookingDate.setText(values.bookingDate.getText());
        viewHolder.bookingTime.setText(values.bookingTime.getText());
        Button drive = (Button)dialogView.findViewById(R.id.drive);
        drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BookingActivityStageOne.class);
                context.startActivity(intent);

            }
        });
        alertDialog.show();



    }

    private ViewHolder setViewHolder(View rowView){
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.clientName = (TextView)rowView.findViewById(R.id.clientName);
        viewHolder.bookingDate = (TextView)rowView.findViewById(R.id.bookingDate);
        viewHolder.bookingTime = (TextView)rowView.findViewById(R.id.bookingTime);
        viewHolder.bookingId = (TextView)rowView.findViewById(R.id.bookingId);
        viewHolder.clientPhone = (TextView)rowView.findViewById(R.id.clientPhoneNumber);
        viewHolder.clientAddress = (TextView)rowView.findViewById(R.id.clientAddress);
        return viewHolder;

    }



}

package sg.edu.rp.c346.p02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class holidayAdapter extends ArrayAdapter<holiday> {

    private ArrayList<holiday> holiday;
    private Context context;
    private TextView tvHoliday;
    private TextView tvDate;
    private ImageView ivHoliday;

    public holidayAdapter(Context context, int resource, ArrayList<holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvHoliday = (TextView) rowView.findViewById(R.id.holidayTv);
        // Get the ImageView object
        ivHoliday = (ImageView) rowView.findViewById(R.id.holidayImageView);
        //Get the TextView object
        tvDate = (TextView) rowView.findViewById(R.id.dateTv);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        holiday currentHoliday = holiday.get(position);
        // Set the TextView to show the food

        tvHoliday.setText(currentHoliday.getHoliday());
        // Set the image to star or nostar accordingly
        tvDate.setText(currentHoliday.getDate());
        if(currentHoliday.getHoliday().equals("New Year's Day")) {
            ivHoliday.setImageResource(R.drawable.confetti);
        }
        else if (currentHoliday.getHoliday().equals("Labour Day")) {
            ivHoliday.setImageResource(R.drawable.wrench);
        }else if(currentHoliday.getHoliday().equals("Chinese New Year"))
            ivHoliday.setImageResource(R.drawable.cny);
        else{
            ivHoliday.setImageResource(R.drawable.goodfriday);
        }
        return rowView;
    }

}

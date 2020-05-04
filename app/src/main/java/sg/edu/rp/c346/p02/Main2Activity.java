package sg.edu.rp.c346.p02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<holiday> holiday;
    TextView type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = findViewById(R.id.listView);
        type = findViewById(R.id.typeTextView);

        Intent i = getIntent();
        String typeText = i.getStringExtra("type");
        type.setText(typeText);
        holiday = new ArrayList<holiday>();
        if(typeText.equals("Secular")) {
            holiday.add(new holiday("New Year's Day", "1 Jan 2017", "New Year's Day"));
            holiday.add(new holiday("Labour Day", "1 May 2017", "Labour Day"));
        }else{
            holiday.add(new holiday("Chinese New Year", "28-29 Jan 2017", "Chinese New Year"));
            holiday.add(new holiday("Good Friday", "14 April 2017", "Good Friday"));
        }

        aa = new holidayAdapter(this, R.layout.row, holiday);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                holiday selectedHoliday = holiday.get(position);
                if (selectedHoliday.getHoliday().equals("New Year's Day")){
                    Toast.makeText(Main2Activity.this, selectedHoliday.getHoliday() +": "
                            + selectedHoliday.getDate() +"\n This is where new year's resolutions are made", Toast.LENGTH_LONG).show();
                }else if (selectedHoliday.getHoliday().equals("Labour Day")){
                    Toast.makeText(Main2Activity.this, selectedHoliday.getHoliday() +": "
                            + selectedHoliday.getDate() + "\n This is when all the people working get a day off", Toast.LENGTH_LONG).show();
                }else if (selectedHoliday.getHoliday().equals("Chinese New Year")){
                    Toast.makeText(Main2Activity.this, selectedHoliday.getHoliday() +": "
                            + selectedHoliday.getDate() + "\n This is when people visit relatives and exchange red packets", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Main2Activity.this, selectedHoliday.getHoliday() +": "
                            + selectedHoliday.getDate() + "\n Good Friday is a Christian holiday commemorating the crucifixion of Jesus and his death at Calvary", Toast.LENGTH_LONG).show();
                }



            }
        });

    }
}

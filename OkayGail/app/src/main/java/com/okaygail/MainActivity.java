package com.okaygail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;
import java.util.ArrayList;


public class MainActivity extends Activity {


    Toolbar mToolbar;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.color_primary_dark));

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.color_primary));
        mToolbar.setTitle("Appointments");
        mToolbar.setTitleTextColor(Color.WHITE);

        RowAdapter adapter = new RowAdapter(this, generateData());
        ListView listView = (ListView) findViewById(R.id.appointment_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(mContext, OkGailActivity.class);
                i.putExtra("Name", generateData().get(position).getName());
                startActivity(i);
            }
        });
    }

    private ArrayList<PatientAppointment> generateData(){
        ArrayList<PatientAppointment> items = new ArrayList<>();
        items.add(new PatientAppointment(getDrawable(R.drawable.patient_block), "Jeremy A.", "10:00AM"));
        items.add(new PatientAppointment(getDrawable(R.drawable.patient), "Jason S.", "11:00AM"));

        return items;
    }

}

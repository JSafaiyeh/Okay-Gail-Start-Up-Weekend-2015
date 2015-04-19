package com.okaygail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by JSafaiyeh on 4/18/15.
 */
public class RowAdapter extends ArrayAdapter<PatientAppointment> {

    private final Context context;
    private final ArrayList<PatientAppointment> patientAppointmentArrayList;

    public RowAdapter(Context context, ArrayList<PatientAppointment> itemsArrayList) {

        super(context, R.layout.row, itemsArrayList);

        this.context = context;
        this.patientAppointmentArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        CircleImageView circleImageView = (CircleImageView) rowView.findViewById(R.id.profile_image);
        TextView patientName = (TextView) rowView.findViewById(R.id.text_view_patient_name);
        TextView time = (TextView) rowView.findViewById(R.id.text_view_appointment_time);

        circleImageView.setImageDrawable(patientAppointmentArrayList.get(position).getPatientPhoto());
        patientName.setText(patientAppointmentArrayList.get(position).getName());
        time.setText(patientAppointmentArrayList.get(position).getTime());

        return rowView;
    }

}

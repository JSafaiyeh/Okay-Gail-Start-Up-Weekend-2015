package com.okaygail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.afollestad.materialdialogs.MaterialDialog;


public class PatientProfileActivity extends Activity {

    Toolbar mToolbar;
    Intent mIntent;
    TextView mPatientName, mDateOfBirth;
    EditText mHeightEdit;
    Button mConfirmButton;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.color_primary_dark));
        mContext = this;

        mIntent = getIntent();

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.color_primary));
        mToolbar.setTitle("Patient");
        mToolbar.setTitleTextColor(Color.WHITE);

        //Patient Name
        mPatientName = (TextView) findViewById(R.id.patient_profile_name);
        mPatientName.setText(mIntent.getStringExtra("Name"));

        //Date of Birth
        mDateOfBirth = (TextView) findViewById(R.id.date_of_birth);
        mDateOfBirth.setText("Date of Birth: 10/10/95");

        //Height
        String heightInfo = mIntent.getStringExtra("Height");
        mHeightEdit = (EditText) findViewById(R.id.height_edit_text);
        mHeightEdit.setText(heightInfo.substring(7, 8) + "'" + heightInfo.substring(heightInfo.length() - 1));

        mConfirmButton = (Button) findViewById(R.id.confirm_button);
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(mContext)
                        .title("Send to Dr. Franklin")
                        .positiveText("OK")
                        .negativeText("Cancel")
                        .show();
            }
        });
    }
}

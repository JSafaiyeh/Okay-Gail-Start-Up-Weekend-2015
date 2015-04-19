package com.okaygail;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;


public class PatientProfileActivity extends ActionBarActivity {

    Toolbar mToolbar;
    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.color_primary_dark));

        mIntent = getIntent();

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.color_primary));
        mToolbar.setTitle(mIntent.getStringExtra("Name"));
        mToolbar.setTitleTextColor(Color.WHITE);

    }
}

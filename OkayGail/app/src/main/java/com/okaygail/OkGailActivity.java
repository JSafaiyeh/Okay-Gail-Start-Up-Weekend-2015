package com.okaygail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;


public class OkGailActivity extends ActionBarActivity {

    Toolbar mToolbar;
    TextView mTextView;
    Intent mIntent;
    Context mContext;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_gail);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.color_primary_dark));
        mContext = this;
        mIntent = getIntent();

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.color_primary));
        mToolbar.setTitle("Ok Gail");
        mToolbar.setTitleTextColor(Color.WHITE);

        mTextView = (TextView) findViewById(R.id.name_ok_gail);
        mTextView.setText(mIntent.getStringExtra("Name"));

        imageButton = (ImageButton) findViewById(R.id.ok_gial);
        imageButton.setBackgroundColor(Color.WHITE);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, PatientProfileActivity.class);
                i.putExtra("Name", mIntent.getStringExtra("Name"));
                startActivity(i);
            }
        });
    }

}

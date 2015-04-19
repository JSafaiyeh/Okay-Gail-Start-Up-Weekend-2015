package com.okaygail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class OkGailActivity extends Activity {

    private static final int SPEECH_REQUEST_CODE = 1;
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
            /*    Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Gail is listening...");
                startActivityForResult(i, SPEECH_REQUEST_CODE); */
                Intent i = new Intent(mContext, PatientProfileActivity.class);
                i.putExtra("Name", mIntent.getStringExtra("Name"));
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            Intent i = new Intent(mContext, PatientProfileActivity.class);
            i.putExtra("Height", results.get(0));
            i.putExtra("Name", mIntent.getStringExtra("Name"));
            startActivity(i);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

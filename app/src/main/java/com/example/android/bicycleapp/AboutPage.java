package com.example.android.bicycleapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class AboutPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}

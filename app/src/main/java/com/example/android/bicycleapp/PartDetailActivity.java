package com.example.android.bicycleapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;


public class PartDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts_detail);

        Intent intent = getIntent();
        BikeApp bikeApp = new BikeApp(intent);

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(bikeApp.getTitle());

        TextView tvDesc = (TextView) findViewById(R.id.tvDescription);
        tvDesc.setText(bikeApp.getDescription());

        TextView tvSerialNumber = (TextView) findViewById(R.id.tvSerialNumber);
        tvSerialNumber.setText("BikeApp #: " + bikeApp.getserialn());

        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumFractionDigits(1);
        TextView tvRating = (TextView) findViewById(R.id.tvRatings);
        tvRating.setText("Rating: " + formatter.format(bikeApp.getrating()));

        int imageId = getResources().getIdentifier(
                bikeApp.getImageName(), "drawable", getPackageName());
        if (imageId != 0) {
            ImageView iv = (ImageView) findViewById(R.id.imageView);
            iv.setImageResource(imageId);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_part_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

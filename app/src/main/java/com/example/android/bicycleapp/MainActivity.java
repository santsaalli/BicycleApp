package com.example.android.bicycleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    protected List<BikeApp> bikeAppData;

    protected BikeApp aBikeApp;
    public final static String EXTRA_SERIAL_NUMBER = "EXTRA_SERIAL_NUMBER";
    public final static String EXTRA_TITLE = "EXTRA_TITLE";
    public final static String EXTRA_DESC = "EXTRA_DESC";
    public final static String EXTRA_IMAGE = "EXTRA_IMAGE";
    public final static String EXTRA_RATINGS = "EXTRA_RATINGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle(getResources().getString(R.string.Bike));




        bikeAppData = DataManager.getData();

        ArrayAdapter<BikeApp> myAdapter = new ArrayAdapter <>(this,
                android.R.layout.simple_list_item_1, bikeAppData);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BikeApp bikeApp = bikeAppData.get(position);
                displayDetail(bikeApp);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.action_settings:

                return true;


            case R.id.action_about:
                Intent intent = new Intent(this, AboutPage.class);
                startActivity(intent);

                return true;

            case R.id.action_contact:

                return true;

        }
        if (id == R.id.action_display_detail) {
            displayDetail(bikeAppData.get(0));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayDetail(BikeApp bikeApp) {

        Intent intent = new Intent(this, PartDetailActivity.class);
        intent.putExtra(EXTRA_SERIAL_NUMBER, bikeApp.getserialn());
        intent.putExtra(EXTRA_TITLE, bikeApp.getTitle());
        intent.putExtra(EXTRA_DESC, bikeApp.getDescription());
        intent.putExtra(EXTRA_IMAGE, bikeApp.getImageName());
        intent.putExtra(EXTRA_RATINGS, bikeApp.getrating());

        startActivity(intent);
    }

}

package com.midsizemango.sharedelementtransitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    int wall;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView image = (ImageView) findViewById(R.id.image2);
        wall = getIntent().getIntExtra("wall", R.drawable.screen1);
        assert image != null;
        image.setImageResource(wall);

        name = getIntent().getStringExtra("name");
        getSupportActionBar().setTitle(name);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

package com.midsizemango.sharedelementtransitions;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ItemsData[] itemsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsData = new ItemsData[]{
                new ItemsData("Screen1",R.drawable.screen1),
                new ItemsData("Screen2",R.drawable.screen2),
                new ItemsData("Screen3",R.drawable.screen3),
                new ItemsData("Screen4",R.drawable.screen4),
                new ItemsData("Screen5",R.drawable.screen5),
                new ItemsData("Screen6",R.drawable.screen6),
                new ItemsData("Screen7",R.drawable.screen7),
                new ItemsData("Screen8",R.drawable.screen8)
        };

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        assert recyclerView != null;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(new SimpleAdapter());

    }

    class SimpleHolder extends RecyclerView.ViewHolder {

        public ImageView wall;
        public RelativeLayout realBackground;
        public TextView textView;

        public SimpleHolder(final View itemView) {
            super(itemView);

            wall = (ImageView) itemView.findViewById(R.id.galimage);
            realBackground = (RelativeLayout) itemView.findViewById(R.id.backgroundrl);
            textView = (TextView) itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class).putExtra("wall", itemsData[pos].getImageUrl()).putExtra("name", itemsData[pos].getName());
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,wall,"imagetransition");
                    startActivity(intent, options.toBundle());
                }
            });
        }
    }

    class SimpleAdapter extends RecyclerView.Adapter<SimpleHolder> {

        @Override
        public int getItemCount() {
            return itemsData.length;
        }

        @Override
        public SimpleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            final View view = getLayoutInflater().inflate(R.layout.main_adapter, viewGroup, false);
            return new SimpleHolder(view);
        }

        @Override
        public void onBindViewHolder(SimpleHolder simpleHolder, int i) {
            simpleHolder.wall.setImageResource(itemsData[i].getImageUrl());
            simpleHolder.textView.setText(itemsData[i].getName());
        }
    }
}

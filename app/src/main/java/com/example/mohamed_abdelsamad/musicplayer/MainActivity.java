package com.example.mohamed_abdelsamad.musicplayer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> array = new ArrayList<String>();
        array.add("4PL4Y-Floating");
        array.add("Bowie-ArtofWar");
        array.add("EarthquakeBeatScientist-IMissHer");
        array.add("Exclusion-Stranded");
        array.add("SidneySamsonFarEastMovement-BangittothecurbDotcomRemix");
        listView = (ListView) findViewById(R.id.mylist);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list, R.id.text, array);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Recent.class);
                TextView text = view.findViewById(R.id.text);
                String viewText = text.getText().toString();
                intent.putExtra("position", viewText);

                intent.putExtra("image", R.drawable.icon);
                Toast.makeText(MainActivity.this, viewText, Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();


            }
        });
    }


}

package com.example.mohamed_abdelsamad.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;


public class Recent extends AppCompatActivity {
    MediaPlayer md;

    MediaController mediaController;

    Button resume;
    Button pause;
    Button back;
    Song song;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);
        TextView txt = (TextView) findViewById(R.id.txt);
        Intent i = getIntent();
        song=new Song();
        resume = (Button) findViewById(R.id.resume);
        back = (Button) findViewById(R.id.back);
        pause = (Button) findViewById(R.id.pause);
        mediaController = new MediaController(this);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                md.pause();
                resume.setAlpha(1.0f);
                pause.setAlpha(0.0f);


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               md.start();
               resume.setAlpha(0.0f);
               pause.setAlpha(1.0f);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.mediaimage);
        String x = i.getStringExtra("position");

        if (x.equalsIgnoreCase("4PL4Y-Floating")) {
            song.setSongName(x);
            song.setSingerName("Alan Walker");
            md = MediaPlayer.create(getApplicationContext(), R.raw.song1);
            md.start();

        } else if (x.equalsIgnoreCase("Bowie-ArtofWar")) {
            song.setSongName(x);
            song.setSingerName("Marshmellow ");
            md = MediaPlayer.create(getApplicationContext(), R.raw.song2);
            md.start();
        } else if (x.equalsIgnoreCase("EarthquakeBeatScientist-IMissHer")) {
            md = MediaPlayer.create(getApplicationContext(), R.raw.song3);
            song.setSongName(x);
            song.setSingerName("sia");

            md.start();
        } else if (x.equalsIgnoreCase("Exclusion-Stranded")) {
            song.setSongName(x);
            song.setSingerName("zedd");
            md = MediaPlayer.create(getApplicationContext(), R.raw.song4);
            md.start();
        } else if (x.equalsIgnoreCase("SidneySamsonFarEastMovement-BangittothecurbDotcomRemix")) {

            song.setSongName(x);
            song.setSingerName("ella");
            md = MediaPlayer.create(getApplicationContext(), R.raw.song5);
            md.start();
        }
       String singername= song.getSingerName();
        String soneName=song.getSongName();
        txt.setText(soneName+" : "+singername);


    }

    @Override
    protected void onPause() {
        super.onPause();
        md.pause();
    }



}

package com.example.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play=findViewById(R.id.btn1);
        pause=findViewById(R.id.btn2);
        stop=findViewById(R.id.btn3);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);


    }
    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.btn1:
                if(mediaPlayer==null){
                mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.bmusic);
                mediaPlayer.start();}

                else if(!mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(pauseCurrentPosition);
                    mediaPlayer.start();
                }
                break;

            case R.id.btn2:
              if(mediaPlayer!=null){
               mediaPlayer.pause();
               pauseCurrentPosition=mediaPlayer.getCurrentPosition();
              }
                break;

            case R.id.btn3:
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }
                break;


        }
    }

}

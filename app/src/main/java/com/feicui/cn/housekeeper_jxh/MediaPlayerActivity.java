package com.feicui.cn.housekeeper_jxh;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import com.feicui.cn.jxh.R;

public class MediaPlayerActivity extends AppCompatActivity {

    private static final String TAG ="" ;
    private int currentPosition;
    private SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        final MediaPlayer player=MediaPlayer.create(this,R.raw.wzdxy);
        player.setLooping(true);
        int duration=player.getDuration();
        Log.d(TAG,"curation:"+duration);


        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MediaPlayerActivity.this, "完成", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.start();
            }
        });
        findViewById(R.id.pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.pause();
            }
        });
        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
            }
        });
        seekbar= (SeekBar) findViewById(R.id.seekBar);
        seekbar.setMax(duration);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Toast.makeText(MediaPlayerActivity.this,fromUser+ "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MediaPlayerActivity.this, "start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                player.seekTo(seekBar.getProgress());
                Toast.makeText(MediaPlayerActivity.this, "stop", Toast.LENGTH_SHORT).show();
            }
        });
        updateSeekBarProgress(player);
    }
    private void updateSeekBarProgress(final MediaPlayer player) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (currentPosition<=player.getDuration()){
                    try {
                        Thread.sleep(100);
                        currentPosition=player.getCurrentPosition();
                        seekbar.setProgress(currentPosition);
                        Log.d(TAG,"run"+currentPosition);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
    }
}

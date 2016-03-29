package com.lmiceli.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.lmiceli.youtubeplayer.YoutubeConstants.GOOGLE_API_KEY;

public class StandaloneActivity extends AppCompatActivity
        implements View.OnClickListener {

    private static String YOUTUBE_VIDEO_ID = "ZXsQAXx_ao0";
    private static final java.lang.String YOUTUBE_PLAYLIST = "PL6gx4Cwl9DGBMdkKFn3HasZnnAqVjzHn";

    @Bind(R.id.btnPlayVideo)
    Button btnPlayVideo;

    @Bind(R.id.btnPlaylist)
    Button btnPlaylist;

    /*@OnClick(R.id.btnPlayVideo) void submit() {
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        ButterKnife.bind(this);

        btnPlayVideo.setOnClickListener(this);
        btnPlaylist.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()){
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST);
                break;
            default:
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}

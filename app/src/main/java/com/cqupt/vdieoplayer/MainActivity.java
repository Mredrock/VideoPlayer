package com.cqupt.vdieoplayer;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import android.graphics.PixelFormat;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSPARENT);
        setContentView(R.layout.activity_main);

        videoView = (VideoView)findViewById(R.id.video);

        mediaController = new MediaController(this);
        File video = new File("/sdcard/Movies/Shopping.3gp");

        if (video.exists()) {
            videoView.setVideoPath(video.getAbsolutePath());

            // 设置 videoView 与 mediaController关联
            videoView.setMediaController(mediaController);
            // 设置 mediaController 与 videoView关联
            mediaController.setMediaPlayer(videoView);
            // 让videoView获得焦点
            videoView.requestFocus();
        }

    }
}
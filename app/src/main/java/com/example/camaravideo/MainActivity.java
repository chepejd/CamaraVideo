package com.example.camaravideo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private static final int TOMA_VIDEO = 1;
    private VideoView vv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vv1=findViewById(R.id.videoView);
    }

    public void tomarVideo(View v)
    {
        Intent intent= new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, TOMA_VIDEO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== TOMA_VIDEO && resultCode== RESULT_OK)
        {
            Uri VideoUri=data.getData();
            vv1.setVideoURI(VideoUri);
            vv1.start();
        }

    }
}
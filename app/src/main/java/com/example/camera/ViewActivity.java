package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
TextView textView;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        textView=findViewById(R.id.TextView);
        imageView=findViewById(R.id.ImageView);

        Intent intent=getIntent();
        String i=intent.getExtras().getString("name");
       Bitmap bitmap=intent.getParcelableExtra("position");
        textView.setText(i);
        imageView.setImageDrawable(new BitmapDrawable(getApplicationContext().getResources(),bitmap));
    }
}
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
        int i=intent.getExtras().getInt("position");
        ArrayList<Bitmap> list= intent.getParcelableArrayListExtra("bitmap");
        textView.setText("Image-"+(i+1));
        imageView.setImageDrawable(new BitmapDrawable(getApplicationContext().getResources(),list.get(i)));
    }
}
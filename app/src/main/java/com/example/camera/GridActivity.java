package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {
//ImageView imageView;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
//imageView=findViewById(R.id.imageView);
        byte[] byteArray = getIntent().getByteArrayExtra("Image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//        imageView.setImageDrawable(new BitmapDrawable(getApplicationContext().getResources(), bmp));
gridView=findViewById(R.id.gridView);
        ArrayList<Data> list=new ArrayList<>();
        list.add(new Data(bmp,"Image 1"));
        list.add(new Data(bmp,"Image 1"));
        list.add(new Data(bmp,"Image 1"));
        list.add(new Data(bmp,"Image 1"));
        list.add(new Data(bmp,"Image 1"));
        list.add(new Data(bmp,"Image 1"));
        list.add(new Data(bmp,"Image 1"));
        list.add(new Data(bmp,"Image 1"));
        list.add(new Data(bmp,"Image 1"));


        Adapter adapter=new Adapter(getApplicationContext(),list);
        gridView.setAdapter(adapter);

    }
}
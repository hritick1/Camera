package com.example.camera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    RecyclerView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView=findViewById(R.id.gridView);
        Intent intent=getIntent();
        ArrayList <Bitmap> bList=intent.getParcelableArrayListExtra("Bitmap");
        ArrayList<Data> list=new ArrayList<>();
        for(int i=0;i<bList.size();i++){
            list.add(new Data(bList.get(i),"Image-"+(i+1)));

        }
        Adapter adapter=new Adapter(list,getApplicationContext());
        gridView.setLayoutManager(new GridLayoutManager(this,2));
        gridView.setAdapter(adapter);

        
}}
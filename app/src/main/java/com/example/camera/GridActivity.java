package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

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

    GridView gridView;
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
        Adapter adapter=new Adapter(getApplicationContext(),list);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1=new Intent(GridActivity.this,ViewActivity.class);
                intent1.putExtra("position",i);
                intent1.putParcelableArrayListExtra("bitmap",bList);
                startActivity(intent1);
            }
        });

    }
}
package com.example.camera;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Data> {
    public Adapter(@NonNull Context context, ArrayList<Data> list) {
        super(context,0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if(view==null){
            view= LayoutInflater.from(getContext()).inflate(R.layout.items,parent,false);
        }
        TextView textView=view.findViewById(R.id.textView);
        ImageView imageView=view.findViewById(R.id.imageView);
        Data obj =getItem(position);
        textView.setText(obj.getName());
        imageView.setImageDrawable(new BitmapDrawable(getContext().getResources(), obj.getBp()));
        return view;
    }
}

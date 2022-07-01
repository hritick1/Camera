package com.example.camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    public Adapter(ArrayList<Data> list, Context context) {
        this.list = list;
        this.context=context;
    }
    Context context;
    ArrayList<Data> list=new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.items,parent,false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
Data data= list.get(position);
holder.textView.setText(data.getName());
holder.imageView.setImageDrawable(new BitmapDrawable(context.getResources(), data.getBp()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textView=itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.imageView);

        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent().setClass(context, ViewActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            int pos=this.getAdapterPosition();
            Data data=list.get(pos);
            i.putExtra("position",data.getBp());
            i.putExtra("name",data.getName());
// Launch the new activity and add the additional flags to the intent
            context.startActivity(i);
        }
    }


}






//    public Adapter(@NonNull Context context, ArrayList<Data> list) {
//        super(context,0, list);
//    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View view=convertView;
//        if(view==null){
//            view= LayoutInflater.from(getContext()).inflate(R.layout.items,parent,false);
//        }
//        TextView textView=view.findViewById(R.id.textView);
//        ImageView imageView=view.findViewById(R.id.imageView);
//        Data obj =getItem(position);
//        textView.setText(obj.getName());
//
//        return view;
//    }

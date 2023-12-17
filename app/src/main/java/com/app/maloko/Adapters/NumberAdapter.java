package com.app.maloko.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.maloko.Models.Category;
import com.app.maloko.Models.Number;
import com.app.maloko.R;
import com.app.maloko.activities.SetsActivity;

import java.util.ArrayList;

public class NumberAdapter extends  RecyclerView.Adapter<NumberAdapter.ViewHolder> {

    int[] arr;
    Context context;
    ArrayList<Number> list;
    /* public RecyclerAdapter(int[] arr) {
        this.arr = arr;
    } */

    public NumberAdapter(Context context, ArrayList<Number> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Number category = list.get(position);

    holder.imageView.setImageResource(category.getNumId());
    holder.textView.setText(category.getNumber());

    holder.itemView.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, SetsActivity.class);
            intent.putExtra("cat",category.getNumId());
            intent.putExtra("title",category.getNumber());
            context.startActivity(intent);
        }
    });

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           imageView= itemView.findViewById(R.id.catImage);
           textView= itemView.findViewById(R.id.catName);
        }
    }
}

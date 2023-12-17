package com.app.maloko.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.maloko.Models.Word;
import com.app.maloko.R;
import com.app.maloko.activities.QuestionActivity;
import com.app.maloko.activities.SetsActivity;
import com.app.maloko.databinding.ActivitySetsBinding;
import com.app.maloko.databinding.ItemSetBinding;

import java.util.ArrayList;

public class SetAdapter extends  RecyclerView.Adapter<SetAdapter.ViewHolder> {

    Context context;
    ArrayList<Word> list;
    MediaPlayer mediaPlayer;


    public SetAdapter(Context context, ArrayList<Word> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_set,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    final Word model = list.get(position);

    holder.binding.setName.setText(model.getFrancais()+" ==> "+model.getTraduis());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediaPlayer = MediaPlayer.create(context,model.getAudio());
          //  Intent intent = new Intent(context, QuestionActivity.class);
          //  intent.putExtra("set",model.getFrancais());
          //  context.startActivity(intent);

            mediaPlayer.start();
        }
    });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemSetBinding binding;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            binding= ItemSetBinding.bind(itemView);

        }
    }
}

package com.app.maloko.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.maloko.R;
import com.app.maloko.databinding.ActivitySelectionBinding;

public class SelectionActivity extends AppCompatActivity {
    ActivitySelectionBinding selectionBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectionBinding= ActivitySelectionBinding.inflate(getLayoutInflater());
        setContentView(selectionBinding.getRoot());

        Intent intent= getIntent();
        String title = intent.getStringExtra("title");

        selectionBinding.LisantCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionActivity.this, QuestionActivity.class);
                intent.putExtra("method","Lisant");
                intent.putExtra("title",title);
                SelectionActivity.this.startActivity(intent);
            }

        });

        selectionBinding.EcouteCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionActivity.this, VoiceQuestionActivity.class);
                intent.putExtra("method","Ecoute");
                intent.putExtra("title",title);
                SelectionActivity.this.startActivity(intent);
            }

        });


    }


}
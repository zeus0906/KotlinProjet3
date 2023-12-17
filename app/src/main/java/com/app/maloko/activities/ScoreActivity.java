package com.app.maloko.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.maloko.MainActivity;
import com.app.maloko.R;
import com.app.maloko.databinding.ActivityQuestionBinding;
import com.app.maloko.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    ActivityScoreBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int totalScore = getIntent().getIntExtra("total",0);
        int correctAns = getIntent().getIntExtra("score",0);

        int wrong = totalScore- correctAns;


        binding.totalQuestions.setText(String.valueOf(totalScore));
        binding.correctQuestions.setText(String.valueOf(correctAns));
        binding.wrongQuestions.setText(String.valueOf(wrong));

        binding.btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(intent); */
                finish();

            }
        });

        binding.btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
             /*   intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT",true);*/
                startActivity(intent);
                finishAndRemoveTask();

            }
        });
    }
}
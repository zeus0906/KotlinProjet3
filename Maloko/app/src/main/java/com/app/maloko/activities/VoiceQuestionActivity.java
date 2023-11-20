package com.app.maloko.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.maloko.MainActivity;
import com.app.maloko.Models.QuestionModel;
import com.app.maloko.Models.QuestionVoice;
import com.app.maloko.R;
import com.app.maloko.databinding.ActivityVoiceQuestionBinding;

import java.util.ArrayList;
import java.util.Collections;

public class VoiceQuestionActivity extends AppCompatActivity {

    ArrayList<QuestionModel> list = new ArrayList<>();
    ArrayList<QuestionVoice> listVoice = new ArrayList<>();
    private int count = 0;
    private int position = 0;
    private int score = 0;

    MediaPlayer mediaPlayer;
    CountDownTimer timer;
    ActivityVoiceQuestionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVoiceQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Toast toast = Toast.makeText(this,"Touchez l'icone du volume",Toast.LENGTH_LONG);
        toast.show();


        resetTimer();
        timer.start();
        String setname = getIntent().getStringExtra("title");
        String method = getIntent().getStringExtra("method");

         if(setname.equals("Le Corps Humain") && method.equals("Ecoute")){
            HumanVoiceQuestions();
           }else if(setname.equals("10") || setname.equals("20") || setname.equals("30") || setname.equals("40")
                 || setname.equals("50") || setname.equals("60") || setname.equals("70") || setname.equals("80")
                 || setname.equals("90") || setname.equals("100") && method.equals("Ecoute")){

             numVoiceQuestion();
         }
         /////////////////////////////////////////////////////
         else if(setname.equals("Les Animaux")  && method.equals("Ecoute")){
             AnimalsVoiceQuestion();
         }

        // sound for each question
         binding.voiceQuestion.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mediaPlayer = MediaPlayer.create(VoiceQuestionActivity.this,listVoice.get(position).getVoice());

                 mediaPlayer.start();
             }
         });




        for(int i = 0; i<4; i++) {
            binding.optionContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer((Button) v);

                }
            });

        }

        binding.btnQuitQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VoiceQuestionActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        playAnimation(binding.question,0,listVoice.get(position).getQuestion());

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timer != null){
                    timer.cancel();
                }
                timer.start();
                binding.btnNext.setEnabled(false);
                binding.btnNext.setAlpha((float) 0.3);
                enableOption(true);
                position++;

                if(position== listVoice.size()){
                    Intent intent = new Intent(VoiceQuestionActivity.this, ScoreActivity.class);
                    intent.putExtra("score",score);
                    intent.putExtra("total",listVoice.size());
                    startActivity(intent);
                    finish();
                    return;
                }

                count=0;

                playAnimation(binding.question,0,listVoice.get(position).getQuestion());
            }
        });
    }


    private void resetTimer() {
        timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                binding.timer.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog( VoiceQuestionActivity.this);

                if(!VoiceQuestionActivity.this.isFinishing()){
                    dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.timeout_dialogue);
                    dialog.findViewById(R.id.try_again).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(VoiceQuestionActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });

                    dialog.show();
                }

            }
        };
    }


    private void playAnimation(View view, int value, String data) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation) {

                        if(value== 0 && count<4){
                            String option="";
                            if(count == 0){
                                option = listVoice.get(position).getOptionA();
                            }if(count == 1){
                                option = listVoice.get(position).getOptionB();
                            }if(count == 2){
                                option = listVoice.get(position).getOptionC();
                            }if(count == 3){
                                option = listVoice.get(position).getOptionD();
                            }

                            playAnimation(binding.optionContainer.getChildAt(count),0,option);
                            count ++;
                        }
                    }

                    @Override
                    public void onAnimationEnd(@NonNull Animator animation) {

                        if(value == 0){
                            try {
                                ((TextView)view).setText(data);
                                binding.totalQuestion.setText(position+1+"/"+listVoice.size());
                            }catch (Exception e){
                                ((Button)view).setText(data);
                            }
                            view.setTag(data);
                            playAnimation(view,1,data);
                        }
                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) {

                    }
                });

    }

    private void enableOption(boolean enable) {
        for(int i = 0; i<4; i++){
            binding.optionContainer.getChildAt(i).setEnabled(enable);

            if(enable){
                binding.optionContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_opt);
            }
        }


    }

    private void checkAnswer(Button selectedOption) {

        if (timer != null){
            timer.cancel();
        }

        binding.btnNext.setEnabled(true);
        binding.btnNext.setAlpha(1);

        if(selectedOption.getText().toString().equals(listVoice.get(position).getAnswer())){
            score++;

            mediaPlayer = MediaPlayer.create(VoiceQuestionActivity.this,R.raw.correct_buzzer);
            mediaPlayer.start();
            selectedOption.setBackgroundResource(R.drawable.right_answer);

        } else{

            mediaPlayer = MediaPlayer.create(VoiceQuestionActivity.this,R.raw.wrong_buzzer);
            mediaPlayer.start();
            selectedOption.setBackgroundResource(R.drawable.wrong_answer);

            Button correctOption = (Button) binding.optionContainer.findViewWithTag(listVoice.get(position).getAnswer());
            correctOption.setBackgroundResource(R.drawable.right_answer);
        }
    }

    private void HumanVoiceQuestions() {
        listVoice.add(new QuestionVoice(R.raw.mulopo," Quel est cette Partie du Corps ?","visage","Front","Menton","Tete","Tete"));
        listVoice.add(new QuestionVoice(R.raw.mundumbu," Quel est cette Partie du Corps ?","Bouche","visage","Menton","Tete","Bouche"));
        listVoice.add(new QuestionVoice(R.raw.ekelekete," Quel est cette Partie du Corps ?","front","squelette","Menton","Tete","squelette"));

        listVoice.add(new QuestionVoice(R.raw.mbombo," Quel est cette Partie du Corps ?","nez","Front","Menton","Tete","Front"));
        listVoice.add(new QuestionVoice(R.raw.dikata," Quel est cette Partie du Corps ?","BRAS","CERVEAU","EPAULE","SEIN","EPAULE"));
        listVoice.add(new QuestionVoice(R.raw.dibongo," Quel est cette Partie du Corps ?","BRAS","CERVEAU","EPAULE","genou","genou"));

        listVoice.add(new QuestionVoice(R.raw.mwende," Quel est cette Partie du Corps ?","FOIE","ESTOMAC","JAMBE","GENOU","JAMBE"));
        listVoice.add(new QuestionVoice(R.raw.dibe," Quel est cette Partie du Corps ?","SEIN","ESTOMAC","VENTRE","GENOU","SEIN"));
        listVoice.add(new QuestionVoice(R.raw.besaosao," Quel est cette Partie du Corps ?","cuisse","poumons","oeil","bras","SEIN"));

        listVoice.add(new QuestionVoice(R.raw.bwanga," Quel est cette Partie du Corps ?","cuisse","poitrine","bouche","oreille","poitrine"));
        listVoice.add(new QuestionVoice(R.raw.dibebe," Quel est cette Partie du Corps ?","cuisse","bras","tete","oreille","cuisse"));
        listVoice.add(new QuestionVoice(R.raw.ebunga," Quel est cette Partie du Corps ?","SEIN","ESTOMAC","VENTRE","GENOU","ESTOMAC"));

        listVoice.add(new QuestionVoice(R.raw.mulema," Quel est cette Partie du Corps ?","JAMBE","NOMBRIL","COEUR","BASSIN","COEUR"));
        listVoice.add(new QuestionVoice(R.raw.toy," Quel est cette Partie du Corps ?","OREILLE","MENTON","VISAGE","CHEVEUX","OREILLE"));
        listVoice.add(new QuestionVoice(R.raw.nyingo," Quel est cette Partie du Corps ?","FOIE","LANGUE","DENTS","COU","COU"));

    }

    private void AnimalsVoiceQuestion() {
        listVoice.add(new QuestionVoice(R.raw.dibobe," Quel est cet animal ?","ARAIGNEE","ANE","MOUTON","SAUTERELLE","ARAIGNEE"));
        listVoice.add(new QuestionVoice(R.raw.ekabala," Quel est cet animal ?","CHIEN","SOURIS","CHEVAL","SAUTERELLE","CHEVAL"));
        listVoice.add(new QuestionVoice(R.raw.ngule," Quel est cet animal ?","BOEUF","FOURMI","CHEVAL","LEZARD","LEZARD"));

        listVoice.add(new QuestionVoice(R.raw.mbo," Quel est cet animal ?","BOEUF","CHIEN","HIPPOPOTAME","ESCARGOT","CHIEN"));
        listVoice.add(new QuestionVoice(R.raw.singi," Quel est cet animal ?","CHAT","ARAIGNEE","ANTILOPE","LIEVRE","CHAT"));
        listVoice.add(new QuestionVoice(R.raw.pakatolo," Quel est cet animal ?","ELEPHANT","LAPIN","TORTUE","LIEVRE","LAPIN"));

        listVoice.add(new QuestionVoice(R.raw.lungu," Quel est cet animal ?","ABEILLE","LAPIN","MOUSTIQUE","PAPILLON","MOUSTIQUE"));
        listVoice.add(new QuestionVoice(R.raw.ngingi," Quel est cet animal ?","MOUSTIQUE","CAIMAN","FOURMI","MOUCHE","MOUCHE"));
        listVoice.add(new QuestionVoice(R.raw.nyaka," Quel est cet animal ?","BOEUF","SOURIS","CAFARD","GRENOUILLE","BOEUF"));

        listVoice.add(new QuestionVoice(R.raw.mudongi," Quel est cet animal ?","PORC","MOUTON","CAIMAN","LION","MOUTON"));
        listVoice.add(new QuestionVoice(R.raw.ngoa," Quel est cet animal ?","CAIMAN","MOUTON","PORC","LION","PORC"));
        listVoice.add(new QuestionVoice(R.raw.pue," Quel est cet animal ?","MOUSTIQUE","MOUTON","SOURIS","LION","SOURIS"));

        listVoice.add(new QuestionVoice(R.raw.njo," Quel est cet animal ?","PANTHERE","ANTILOPE","MOUSTIQUE","ABEILLE","PANTHERE"));
        listVoice.add(new QuestionVoice(R.raw.kakroti," Quel est cet animal ?","CHAMEAU","CAFARD","MOUSTIQUE","GRENOUILLE","CAFARD"));
        listVoice.add(new QuestionVoice(R.raw.ngando," Quel est cet animal ?","LEZARD","HIPPOPOTAME","MOUSTIQUE","CAIMAN","CAIMAN"));

    }

    private void numVoiceQuestion() {
        listVoice.add(new QuestionVoice(R.raw._12," Quel est ce Chiffre ?","12","2","3","4","12"));
        listVoice.add(new QuestionVoice(R.raw._23," Quel est ce Chiffre ?","23","25","26","4","23"));
        listVoice.add(new QuestionVoice(R.raw._70," Quel est ce Chiffre ?","1","70","6","4","70"));

        listVoice.add(new QuestionVoice(R.raw._100," Quel est ce Chiffre ?","100","20","30","40","100"));
        listVoice.add(new QuestionVoice(R.raw._53," Quel est ce Chiffre ?","12","75","53","48","53"));
        listVoice.add(new QuestionVoice(R.raw._33," Quel est ce Chiffre ?","33","29","13","47","33"));

        listVoice.add(new QuestionVoice(R.raw._18," Quel est ce Chiffre ?","18","28","38","48","18"));
        listVoice.add(new QuestionVoice(R.raw._83," Quel est ce Chiffre ?","81","85","83","74","83"));
        listVoice.add(new QuestionVoice(R.raw._11," Quel est ce Chiffre ?","11","51","21","48","11"));

        listVoice.add(new QuestionVoice(R.raw._10," Quel est ce Chiffre ?","10","28","43","47","10"));
        listVoice.add(new QuestionVoice(R.raw._99," Quel est ce Chiffre ?","16","35","89","99","99"));
        listVoice.add(new QuestionVoice(R.raw._15," Quel est ce Chiffre ?","15","85","27","44","15"));

        listVoice.add(new QuestionVoice(R.raw._80," Quel est ce Chiffre ?","80","25","37","94","80"));
        listVoice.add(new QuestionVoice(R.raw._20," Quel est ce Chiffre ?","87","52","20","40","20"));
        listVoice.add(new QuestionVoice(R.raw._45," Quel est ce Chiffre ?","45","42","38","47","45"));

        listVoice.add(new QuestionVoice(R.raw._78," Quel est ce Chiffre ?","77","42","78","41","78"));
        listVoice.add(new QuestionVoice(R.raw._88," Quel est ce Chiffre ?","13","88","19","45","88"));
        listVoice.add(new QuestionVoice(R.raw._13," Quel est ce Chiffre ?","13","75","20","28","13"));

        listVoice.add(new QuestionVoice(R.raw._50," Quel est ce Chiffre ?","80","50","90","100","50"));
        listVoice.add(new QuestionVoice(R.raw._40," Quel est ce Chiffre ?","40","65","28","49","40"));

    }







}
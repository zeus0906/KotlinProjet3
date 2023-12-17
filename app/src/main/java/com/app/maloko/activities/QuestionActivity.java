package com.app.maloko.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

import com.app.maloko.MainActivity;
import com.app.maloko.Models.QuestionModel;
import com.app.maloko.Models.QuestionVoice;
import com.app.maloko.R;
import com.app.maloko.databinding.ActivityQuestionBinding;
import com.app.maloko.databinding.ActivitySelectionBinding;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionActivity extends AppCompatActivity {

    ArrayList<QuestionModel> list = new ArrayList<>();
    ArrayList<QuestionVoice> listVoice = new ArrayList<>();
    private int count = 0;
    private int position = 0;
    private int score = 0;

    QuestionVoice vn;
    MediaPlayer mediaPlayer;
    CountDownTimer timer;
    ActivityQuestionBinding binding;
    ActivitySelectionBinding selectionBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        resetTimer();
        timer.start();
       String setname = getIntent().getStringExtra("title");
        String method = getIntent().getStringExtra("method");

        if(setname.equals("Le Corps Humain") && method.equals("Lisant")){
            HumanQuestions();

        }else if(setname.equals("10") || setname.equals("20") || setname.equals("30") || setname.equals("40")
                || setname.equals("50") || setname.equals("60") || setname.equals("70") || setname.equals("80")
                || setname.equals("90") || setname.equals("100") && method.equals("Lisant")){

            numQuestion();
        }
        /////////////////////////////////////////////////////
        else if(setname.equals("Les Animaux")  && method.equals("Lisant")){
            AnimalsQuestion();
        }
        else if(setname.equals("Les Oiseaux")  && method.equals("Lisant")){
            BirdQuestion();
        }
        else if(setname.equals("Les Repas") || setname.equals("Les Fruits")
                && method.equals("Lisant")){
            RepasQuestion();
        }else if(setname.equals("Les Poissons") && method.equals("Lisant")){
            PoissonQuestion();
        }
        else if(setname.equals("Les Vetements") && method.equals("Lisant")){
            HabitQuestion();
        }
        else if(setname.equals("Les Moyens de Transport") ||
                setname.equals("Les Couleurs")
                        && method.equals("Lisant")){
            TransportQuestion();
        }
        else if(setname.equals("La Maison")
                        && method.equals("Lisant")){
            MaisonQuestion();
        }
        else if(setname.equals("Le Calendrier")
                && method.equals("Lisant")){
            CalendarQuestion();
        }


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
                Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    playAnimation(binding.question,0,list.get(position).getQuestion());

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

                if(position== list.size()){
                    Intent intent = new Intent(QuestionActivity.this, ScoreActivity.class);
                    intent.putExtra("score",score);
                    intent.putExtra("total",list.size());
                    startActivity(intent);
                    finish();
                    return;
                }

                count=0;

                playAnimation(binding.question,0,list.get(position).getQuestion());
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
                Dialog dialog = new Dialog( QuestionActivity.this);

                if(!QuestionActivity.this.isFinishing()){
                    dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.timeout_dialogue);
                    dialog.findViewById(R.id.try_again).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
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
                                option = list.get(position).getOptionA();
                            }if(count == 1){
                                option = list.get(position).getOptionB();
                            }if(count == 2){
                                option = list.get(position).getOptionC();
                            }if(count == 3){
                                option = list.get(position).getOptionD();
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
                                binding.totalQuestion.setText(position+1+"/"+list.size());
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

        if(selectedOption.getText().toString().equals(list.get(position).getAnswer())){
        score++;

        mediaPlayer = MediaPlayer.create(QuestionActivity.this,R.raw.correct_buzzer);
        mediaPlayer.start();
        selectedOption.setBackgroundResource(R.drawable.right_answer);

        } else{

            mediaPlayer = MediaPlayer.create(QuestionActivity.this,R.raw.wrong_buzzer);
            mediaPlayer.start();
            selectedOption.setBackgroundResource(R.drawable.wrong_answer);

            Button correctOption = (Button) binding.optionContainer.findViewWithTag(list.get(position).getAnswer());
            correctOption.setBackgroundResource(R.drawable.right_answer);
        }
    }

    private void HumanQuestions() {
        list.add(new QuestionModel("Comment appelle-t-on la bouche en DUALA ?","Maya","Mundumbu","Mulopo","Wea","Mudumbu"));
        list.add(new QuestionModel("Trouvez la signification de boso en Francais ?","visage","Front","Menton","Tete","visage"));
        list.add(new QuestionModel("Que signifie EKELEKETE ?","front","squelette","Menton","Tete","squelette"));

        list.add(new QuestionModel("Comment appelle-t-on les CHEVEUX en DUALA ?","Maya","NYO̱","MAYA","Wea","NYO̱"));
        list.add(new QuestionModel("Trouvez la signification de MPEMBA en Francais ?","nez","Front","Menton","Tete","nez"));
        list.add(new QuestionModel("Que signifie MULOPO ?","front","squelette","Menton","Tete","Tete"));

        list.add(new QuestionModel("Comment appelle-t-on les POUMONS en DUALA ?","BESAOSAO","NYO̱","BO̱NGO̱","DIBE̱BE̱","BESAOSAO"));
        list.add(new QuestionModel("Trouvez la signification de DIKATA en Francais ?","BRAS","CERVEAU","EPAULE","SEIN","EPAULE"));
        list.add(new QuestionModel("Que signifie DIBUM ?","BASSIN","ESTOMAC","VENTRE","GENOU","VENTRE"));

        list.add(new QuestionModel("Comment appelle-t-on la POITRINE en DUALA ?","BWANGA","NYO̱","BO̱NGO̱","DIBE̱BE̱","BWANGA"));
        list.add(new QuestionModel("Trouvez la signification de DIKATA en Francais ?","BRAS","CERVEAU","EPAULE","SEIN","EPAULE"));
        list.add(new QuestionModel("Que signifie DIBUM ?","BASSIN","ESTOMAC","VENTRE","GENOU","VENTRE"));

        list.add(new QuestionModel("Comment appelle-t-on la POITRINE en DUALA ?","BWANGA","NYO̱","BO̱NGO̱","DIBE̱BE̱","BWANGA"));
        list.add(new QuestionModel("Trouvez la signification de DIA en Francais ?","BRAS","CERVEAU","EPAULE","SEIN","BRAS"));
        list.add(new QuestionModel("Que signifie MWENDE ?","FOIE","ESTOMAC","JAMBE","GENOU","JAMBE"));

    }

    private void AnimalsQuestion(){
        list.add(new QuestionModel("Comment appelle-t-on l'ARAIGNEE en DUALA ?","Maya","DIBOBE̱","ESEL","Wea","DIBOBE̱"));
        list.add(new QuestionModel("Trouvez la signification de MUDO̱NGI en Francais ?","MOUTON","CHEVRE","BOEUF","Oeil","MOUTON"));
        list.add(new QuestionModel("Le LAPIN en DUALA C'est ?","PUE","toy","PAKATOLO","muson","PAKATOLO"));

        list.add(new QuestionModel("Comment appelle-t-on la souris en DUALA ?","SO̱NO̱","PUE","NYAKA","KAKROTI","PUE"));
        list.add(new QuestionModel("Trouvez la signification de KAKROTI en Francais ?","CAFARD","SO̱NO̱","ESCARGOT","LEOPARD","CAFARD"));
        list.add(new QuestionModel("Le LEOPARD en DUALA C'est ?","NJO̱̱ MBALE","DIPO̱MO̱","MBANGE A NJO̱","NYO̱","MBANGE A NJO̱"));

        list.add(new QuestionModel("Comment appelle-t-on la GUEPE en DUALA ?","DIPO̱MO̱","Ebunga","DIKELE","KAKROTI","DIPO̱MO̱"));
        list.add(new QuestionModel("Trouvez la signification de LUNGU en Francais ?","ANTILOPE","Front","GRENOUILLE","MOUSTIQUE","MOUSTIQUE"));
        list.add(new QuestionModel("L'ELEPHANT en DUALA C'est ?","NJO̱̱U","NDO̱MBI","EKO̱NKO̱N","NGINGI","NJO̱̱U"));

        list.add(new QuestionModel("Comment appelle-t-on la GUEPE en DUALA ?","DIPO̱MO̱","Ebunga","DIKELE","KAKROTI","DIPO̱MO̱"));
        list.add(new QuestionModel("Trouvez la signification de LUNGU en Francais ?","ANTILOPE","Front","GRENOUILLE","MOUSTIQUE","MOUSTIQUE"));
        list.add(new QuestionModel("La MOUCHE en DUALA C'est ?","NJO̱̱U","NGINGI","NGANDO","MUKO̱NGE̱","NGINGI"));

        list.add(new QuestionModel("Comment appelle-t-on l'ABEILLE en DUALA ?","DIPO̱MO̱","NGILA","NDO̱MBI","SINGI","NDO̱MBI"));
        list.add(new QuestionModel("Trouvez la signification de SINGI en Francais ?","CHAT","CHIMPANZE","GRENOUILLE","LEZARD","CHAT"));
        list.add(new QuestionModel("La CHIEN en DUALA C'est ?","NGILA","NJO̱̱","MBO̱","MUKO̱NGE̱","MBO̱"));


    }

    private void BirdQuestion(){
        list.add(new QuestionModel("Comment appelle-t-on l'HIRONDELLE en DUALA ?","PUE","DIBONGA","ESEL","PAKATOLO","DIBONGA"));
        list.add(new QuestionModel("Trouvez la signification de ELELA en Francais ?","CANARD","CORBEAU","TISSERIN","DINDON","CANARD"));
        list.add(new QuestionModel("Le DINDON en DUALA C'est ?","PUE","KOBA KOBA","PAKATOLO","muson","KOBA KOBA"));

        list.add(new QuestionModel("Comment appelle-t-on le PIGEON en DUALA ?","MBENGA","PUE","WUBA","NDO̱MBI","MBENGA"));
        list.add(new QuestionModel("Trouvez la signification de NGOSO en Francais ?","MOUCHE","PERROQUET","ESCARGOT","ABEILLE","PERROQUET"));
        list.add(new QuestionModel("L'AIGLE en DUALA C'est ?","MBELA","DIPO̱MO̱","ELELA","WOMBE","MBELA"));

        list.add(new QuestionModel("Comment appelle-t-on le HIBOU en DUALA ?","DIBONGA","ISUKUDU","WUDU","KAKROTI","ISUKUDU"));
        list.add(new QuestionModel("Trouvez la signification de ISOKOLOKO en Francais ?","CANARD","TISSERIN","COQ","MOUSTIQUE","TISSERIN"));
        list.add(new QuestionModel("Le MOINEAU en DUALA C'est ?","MUTATE MBOA","NDO̱MBI","DIPO̱MO̱","NGINGI","MUTATE MBOA"));

        list.add(new QuestionModel("Comment appelle-t-on l'EPERVIER en DUALA ?","ELELA","WOMBE","DIBONGA","KOBA KOBA","WOMBE"));


    }

    private void RepasQuestion(){
        list.add(new QuestionModel("Comment appelle-t-on l'IGNAME en DUALA ?","MBAA","JINJA","DIKUBE","EPUMA","MBAA"));
        list.add(new QuestionModel("Trouvez la signification de KO̱̱TIMANJO en Francais ?","MANIOC","BASILIC","MACABO","BANANE","BASILIC"));
        list.add(new QuestionModel("Le MANIOC en DUALA C'est ?","MUKOKE̱","MBASI","MAKWAMBA","MASEPO","MAKWAMBA"));

        list.add(new QuestionModel("Comment appelle-t-on le MAIS en DUALA ?","MBASI","MYE̱LE̱","KO̱̱TIMANJO","JINJA","MBASI"));
        list.add(new QuestionModel("Trouvez la signification de MBIA en Francais ?","PIMENT","NOIX","SEL","ANANAS","NOIX"));
        list.add(new QuestionModel("Le SEL en DUALA C'est ?","NDOKO","NDONGO","WANGA","WOMBE","WANGA"));

        list.add(new QuestionModel("Comment appelle-t-on les PLANTAINS en DUALA ?","MYE̱N","PE̱BE̱","MBAA","MYE̱LE̱","MYE̱LE̱"));
        list.add(new QuestionModel("Trouvez la signification de MYE̱N en Francais ?","OEUFS","PAPAYE","PIMENT","AMANDES","OEUFS"));
        list.add(new QuestionModel("La PATATE en DUALA C'est ?","NDONGO","NDOKO","MBASI","MAKABO","NDOKO"));

        list.add(new QuestionModel("Comment appelle-t-on la BANANE en DUALA ?","DIKUBE","WANGA","NDOKO","EPUMA","DIKUBE"));
        list.add(new QuestionModel("Trouvez la signification de MUKOKE̱ en Francais ?","ORANGE","CANNE A SUCRE","AMANDES","PAPAYE","CANNE A SUCRE"));
        list.add(new QuestionModel("Les AMANDES en DUALA C'est ?","NGO̱NDO̱ A BEBONGO","MAKWAMBA","JANGOLO","MYE̱LE̱","NGO̱NDO̱ A BEBONGO"));

        list.add(new QuestionModel("Comment appelle-t-on la MANGUE en DUALA ?","DIKUBE","JANGOLO","NDOKO","EPUMA","JANGOLO"));
        list.add(new QuestionModel("Trouvez la signification de PIA en Francais ?","ORANGE","MYE̱N","JINJA","AVOCAT","AVOCAT"));
        list.add(new QuestionModel("Le CITRON en DUALA C'est ?","EPUMA ESADI","KO̱̱TIMANJO","PE̱BE̱","ESE̱SE̱","EPUMA ESADI"));

        list.add(new QuestionModel("Comment appelle-t-on le PIMENT en DUALA ?","NDONGO","KO̱̱TIMANJO","JINJA","ESE̱SE̱","NDONGO"));
        list.add(new QuestionModel("Trouvez la signification de JANGA LA NYO en Francais ?","ORANGE","ANANAS","LEMON","PAPAYE","ANANAS"));
        list.add(new QuestionModel("La NOIX DE MUSCADE en DUALA C'est ?","PE̱BE̱","MAKWAMBA","JANGOLO","MBASI","PE̱BE̱"));

        list.add(new QuestionModel("Comment appelle-t-on le PAMPLEMOUSSE en DUALA ?","ESE̱SE̱","EPUMA ENDE̱NE̱","NDOKO","PO̱PO̱","EPUMA ENDE̱NE̱"));
        list.add(new QuestionModel("Trouvez la signification de EPUMA A NGUILA en Francais ?","LEMON","CANNE A SUCRE","AMANDES","PAPAYE","LEMON"));

    }

    private void PoissonQuestion(){
        list.add(new QuestionModel("Comment appelle-t-on le CRABE en DUALA ?","DUBA","DIKAKO","ESEL","PAKATOLO","DIKAKO"));
        list.add(new QuestionModel("Trouvez la signification de MUKANJO en Francais ?","MORUE","CAPITAIN","TISSERIN","LA RAIE","MORUE"));
        list.add(new QuestionModel("Le MACHOIRON en DUALA C'est ?","YENDA","NGO̱WE̱","MUKANJO","muson","YENDA"));

        list.add(new QuestionModel("Comment appelle-t-on le BAR en DUALA ?","NGO̱WE̱","NYE̱NDI","WUBA","NDO̱MBI","NYE̱NDI"));
        list.add(new QuestionModel("Trouvez le nom du poisson SE̱ en Francais ?","CAPITAIN","SOLE","ESCARGOT","TISSERIN","CAPITAIN"));
        list.add(new QuestionModel("La SOLE en DUALA C'est ?","SE̱","NYO̱MO̱","WANGA","YENDA","NYO̱MO̱"));

        list.add(new QuestionModel("Comment appelle-t-on L'EPERLAN en DUALA ?","MUANJAMOTO","MUKANJO","DUBA","DIBANGA","MUANJAMOTO"));
        list.add(new QuestionModel("Trouvez la signification de DIBANGA en Francais ?","CREVETTE","NGO̱WE̱","NDOM","CRABE","CREVETTE"));
        list.add(new QuestionModel("LA RAIE en DUALA C'est ?","EPA","DUBA","NDOM","DIKAKO","DUBA"));

        list.add(new QuestionModel("Comment appelle-t-on le REQUIN en DUALA ?","NDOM","DUBA","DIBONGA","DIKAKO","NDOM"));


    }

    private void HabitQuestion(){
        list.add(new QuestionModel("Comment appelle-t-on les CHAUSSURES en DUALA ?","BETAMBI","DIKAKO","ESEL","PAKATOLO","BETAMBI"));
        list.add(new QuestionModel("Trouvez la signification de EKOTO en Francais ?","CHAPEAU","VESTE","PIROGUE","LA RAIE","CHAPEAU"));
        list.add(new QuestionModel("Le VETEMENT en DUALA C'est ?","MBO̱M","MBO̱TI","MUKANJO","BETAMBI","MBO̱TI"));

        list.add(new QuestionModel("Comment appelle-t-on le CALECON en DUALA ?","NGO̱WE̱","EKUBE̱","BETAMBI","TROSISI","EKUBE̱"));
        list.add(new QuestionModel("Trouvez la signification de MBO̱M en Francais ?","CHAUSSURES","DRAP","ESCARGOT","VETEMENT","DRAP"));
        list.add(new QuestionModel("La CEINTURE en DUALA C'est ?","KOTI","NGODI","WANGISI","YENDA","NGODI"));

        list.add(new QuestionModel("Comment appelle-t-on la CHAUSSETTE en DUALA ?","ÑO̱PIÑA","MBO̱TI","BETAMBI","MBO̱M","ÑO̱PIÑA"));
        list.add(new QuestionModel("Trouvez la signification de TROSISI en Francais ?","PANTALON","CHAUSSURES","CALECON","DRAP","PANTALON"));
        list.add(new QuestionModel("Le FOULARD en DUALA C'est ?","EPA","MBO̱TI","TROSISI","WANGISI","WANGISI"));

        list.add(new QuestionModel("Comment appelle-t-on la BAGUE en DUALA ?","EYO̱NDO̱","TROSISI","BETAMBI","MBO̱TI","EYO̱NDO̱"));

    }

    private void TransportQuestion(){
        list.add(new QuestionModel("Comment appelle-t-on la PIROGUE en DUALA ?","BO̱LO̱","MUNJA","MUNDI","BULU","BO̱LO̱"));
        list.add(new QuestionModel("Trouvez la couleur BULU en Francais","BLEU","ORANGE","VIOLET","MARRON","BLEU"));
        list.add(new QuestionModel("L'AVION en DUALA C'est ?","EPUMWAN","DIBUDU","BO̱LO̱","BETAMBI","EPUMWAN"));

        list.add(new QuestionModel("Comment appelle-t-on le VELO en DUALA ?","TUTUTU","MEDI","EPUMWAN","TROSISI","MEDI"));
        list.add(new QuestionModel("Trouvez la couleur DIBO̱NO̱ en Francais","MARRON","GRIS","ORANGE","VERT","MARRON"));
        list.add(new QuestionModel("La CEINTURE en DUALA C'est ?","KOTI","NGODI","WANGISI","YENDA","NGODI"));

        list.add(new QuestionModel("Comment appelle-t-on la MOTO en DUALA ?","TUTUTU","BO̱LO̱","MEDI","MBO̱M","TUTUTU"));
        list.add(new QuestionModel("Trouvez la couleur DIBUDU en Francais","VIOLET","GRIS","ROSE","BLANC","GRIS"));
        list.add(new QuestionModel("Le TRAIN en DUALA C'est ?","BULU","MBO̱TI","MASIN","WANGISI","MASIN"));

        list.add(new QuestionModel("Comment appelle-t-on la VOITURE en DUALA ?","NJABI","MBO̱TI","BETAMBI","MUTOA","MUTOA"));
        list.add(new QuestionModel("Trouvez la couleur NJABI en Francais","JAUNE","GRIS","ROSE","BLANC","JAUNE"));
        list.add(new QuestionModel("Trouvez la couleur JOLA en Francais","JAUNE","GRIS","ROUGE","BLANC","ROUGE"));

        list.add(new QuestionModel("Trouvez la couleur VERT en DUALA","EYADI","TUTUTU","DIBO̱NO̱","SANGA","EYADI"));
        list.add(new QuestionModel("Trouvez la couleur ROSE en DUALA","EYADI","MUNDO","DIBO̱NO̱","DIBUDU","MUKALA"));
        list.add(new QuestionModel("Trouvez la couleur NOIR en DUALA","MUNDO","EYADI","DIBO̱NO̱","DIBUDU","MUNDO"));

    }

    private void MaisonQuestion(){
        list.add(new QuestionModel("Comment appelle-t-on les TISSU en DUALA ?","DIBATO","DIKAKO","KONDA","PAKATOLO","DIBATO"));
        list.add(new QuestionModel("Trouvez la signification de DIWE̱NDI en Francais ?","VITRE","COUTEAU","PIROGUE","BOUTEILLE","COUTEAU"));
        list.add(new QuestionModel("La VITRE en DUALA C'est ?","MBO̱M","MBO̱TI","JE̱NE̱","EPOSI","JE̱NE̱"));

        list.add(new QuestionModel("Comment appelle-t-on le FIL en DUALA ?","DIBATO","MUSINGA","BETAMBI","JO̱MBE̱","MUSINGA"));
        list.add(new QuestionModel("Trouvez la signification de KONDA en Francais ?","CHAISE","DRAP","BOUTEILLE","VETEMENT","CHAISE"));
        list.add(new QuestionModel("La PORTE en DUALA C'est ?","NDO̱NDO̱KI","JO̱MBE̱","WANGISI","NO̱NGO̱","JO̱MBE̱"));

        list.add(new QuestionModel("Comment appelle-t-on la FOURCHETTE en DUALA ?","DIBATO","MWASO","DIWE̱NDI","KONDA","MWASO"));
        list.add(new QuestionModel("Trouvez la signification de NDO̱NDO̱KI en Francais ?","AIGUILLE","CHAUSSURES","CUILLERE","CISEAU","AIGUILLE"));
        list.add(new QuestionModel("Le PEIGNE en DUALA C'est ?","SISAKO","MWASO","TROSISI","WANGISI","SISAKO"));

        list.add(new QuestionModel("Comment appelle-t-on la CUILLERE en DUALA ?","TO","TROSISI","MUSINGA","MBO̱TI","TO"));

    }

    private void CalendarQuestion(){
        list.add(new QuestionModel("Quel est le premier mois de l'année en DUALA ?","DIMO̱DI","DIBABA","ESO̱PE̱SO̱PE̱","EMIASE̱LE̱","DIMO̱DI"));
        list.add(new QuestionModel("Le mois de Decembre en DUALA ?","MADIBE̱DIBE̱","ELAÑE̱","DIMO̱DI","NGONDE̱","ELAÑE̱"));
        list.add(new QuestionModel("Le mois TININI en francais c'est ?","MARS","NOVEMBRE","AOUT","SEPTEMBRE","NOVEMBRE"));

        list.add(new QuestionModel("Comment appelle-t-on le calendrier en DUALA ?","ELANGEMBU","NGANDE̱","ETIÑA","ELAME̱","ELANGEMBU"));
        list.add(new QuestionModel("Trouvez le jour ETIÑA en Francais ?","MERCREDI","LUNDI","DIMANCHE","VENDREDI","DIMANCHE"));
        list.add(new QuestionModel("ÑE̱TE̱KI c'est quel mois de l'annee?","JUILLET","SEPTEMBRE","DECEMBRE","AVRIL","SEPTEMBRE"));

        list.add(new QuestionModel("Le mois de la jeunesse en DUALA","NGONDE̱","MADIBE̱DIBE̱","SONGE̱","MAYESE̱","NGONDE̱"));
        list.add(new QuestionModel("Le premier jour de travail de la semaine en DUALA ?","MO̱SI","SO̱NDY","MO̱nDY","KWASI","MO̱SI"));
        list.add(new QuestionModel("Le PEIGNE en DUALA C'est ?","SISAKO","MWASO","TROSISI","WANGISI","SISAKO"));

        list.add(new QuestionModel("Comment appelle-t-on la CUILLERE en DUALA ?","TO","TROSISI","MUSINGA","MBO̱TI","TO"));

    }

    private void numQuestion(){
        list.add(new QuestionModel("Le nombre DIX en DUALA ?","Maya","Ebunga","Mulopo","Dom","Dom"));
        list.add(new QuestionModel("BELALO en Chiffre c'est ?","3","1","7","12","3"));
        list.add(new QuestionModel("MWABA en Francais C'est ?","Vingt","Vingt cinq","Vingt quatre","Vingt sept","Vingt"));

        list.add(new QuestionModel("Le nombre quinze en DUALA ?","DOM NA EWO̱","DOM NA BETANU","LO̱MBI","Dom","DOM NA BETANU"));
        list.add(new QuestionModel("LO̱MBI en Chiffre c'est ?","38","18","8","12","8"));
        list.add(new QuestionModel("MUTOBA en Francais C'est ?","huit","six","quatorze","Vingt sept","six"));

        list.add(new QuestionModel("Le nombre trente en DUALA ?","DOM NA EWO̱","MUMUTOBA NA LO̱MBI","MWALALO","MULO̱MBI","MWALALO"));
        list.add(new QuestionModel("MULO̱MBI en Chiffre c'est ?","38","18","80","12","80"));
        list.add(new QuestionModel("MWATANU en Francais C'est ?","huit","six","cinquante","soixante","cinquante"));

        list.add(new QuestionModel("Le nombre vingt trois en DUALA ?","MWABA NA BEBA","MWABA NA BELALO","MWALALO","MULO̱MBI","MWABA NA BELALO"));
        list.add(new QuestionModel("MUSAMBA en Chiffre c'est ?","50","60","80","70","70"));
        list.add(new QuestionModel("EBWEA en Francais C'est ?","dix-huit","soixante-six","cinquante","cent","cent"));

        list.add(new QuestionModel("Le nombre quarante en DUALA ?","MWANEI","MWALALO","LO̱MBI","MULO̱MBI","MWANEI"));
        list.add(new QuestionModel("MUDIBUA en Chiffre c'est ?","45","90","83","33","90"));
        list.add(new QuestionModel("MWATANU NA EWO̱ en Francais C'est ?","neuf","soixante-cinq","cinquante-et-un","soixante","cinquante-et-un"));

        list.add(new QuestionModel("Le nombre dix-huit en DUALA ?","DOM NA SAMBA","MWABA NA BENEI","DOM NA LO̱MBI","MWATANU NA DIBUA","DOM NA LO̱MBI"));
        list.add(new QuestionModel("MUMUTOBA NA LO̱MBI en Chiffre c'est ?","15","20","68","73","68"));
        list.add(new QuestionModel("MWALALO NA LO̱MBI en Francais C'est ?","trente-huit","soixante-treize","cinquante-huit","soixante-dix","trente-huit"));

        list.add(new QuestionModel("Le nombre quatre-vingt dix-neuf en DUALA ?","MUDIBUA NA DIBUA","MUSAMBA NA SAMBA","MUMUTOBA NA MUTOBA","MULO̱MBI NA LO̱MBI","MUDIBUA NA DIBUA"));
        list.add(new QuestionModel("MUMUTOBA NA EWO en Chiffre c'est ?","61","95","26","93","61"));
        //////////////////////

    }


}
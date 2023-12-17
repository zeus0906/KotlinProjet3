package com.app.maloko.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.maloko.Adapters.SetAdapter;
import com.app.maloko.Models.Word;
import com.app.maloko.R;
import com.app.maloko.databinding.ActivitySetsBinding;

import java.util.ArrayList;

public class SetsActivity extends AppCompatActivity {

    ActivitySetsBinding binding;
    ArrayList<Word> list;
    ImageView imageView;
    TextView textViewTitle,textViewQuiz;


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       imageView = findViewById(R.id.catImage);
       textViewTitle = findViewById(R.id.setTitle);
       textViewQuiz = findViewById(R.id.setStartQuiz);

        //getSupportActionBar().hide();
        list = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.setRecycle.setLayoutManager(linearLayoutManager);


        Intent intent= getIntent();
      int cat =  intent.getIntExtra("cat",0);
      String title = intent.getStringExtra("title");
       String quiz = "Cliquez ici pour commencer le quiz";

        if(cat == R.drawable.humanbody){
            textViewTitle.setText(title);
            textViewQuiz.setText(quiz);
            HumanBody();
        }else
            if(cat == R.drawable.animaux){
                textViewTitle.setText(title);
                textViewQuiz.setText(quiz);
            Animals();
        }else
            if(cat == R.drawable.oiseau){
                textViewTitle.setText(title);
                textViewQuiz.setText(quiz);
                Birds();
            }
            else
            if(cat == R.drawable.repas){
                textViewTitle.setText(title);
                textViewQuiz.setText(quiz);
                Repas();
            }
            else
            if(cat == R.drawable.fruit){
                textViewTitle.setText(title);
                textViewQuiz.setText(quiz);
                Fruits();
            }else
            if(cat == R.drawable.poisson){
                textViewTitle.setText(title);
                textViewQuiz.setText(quiz);
                Poisson();
            }else
            if(cat == R.drawable.vetements){
                textViewTitle.setText(title);
                textViewQuiz.setText(quiz);
                Vetement();
            }else
            if(cat == R.drawable.couleur_transport){
                textViewTitle.setText(title);
                textViewQuiz.setText(quiz);
                Couleur_Transport();
            }else
            if(cat == R.drawable.maison){
                textViewTitle.setText(title);
                textViewQuiz.setText(quiz);
                Maison();
            }else
            if(cat == R.drawable.calendrier){
                textViewTitle.setText(title);
                textViewQuiz.setText(quiz);
                Calendrier();
            }else
            if(cat == R.drawable.plus){
                textViewTitle.setText(title);
                textViewQuiz.setText(quiz);
                Autre();
            }
            ////////Fetching for Numbers/////////////////////
       if(cat == R.drawable.top10){
           textViewTitle.setText(title);
           textViewQuiz.setText(quiz);
           num10();
       }
       if(cat == R.drawable.num20){
           textViewTitle.setText(title);
           textViewQuiz.setText(quiz);
           num20();
       }
       if(cat == R.drawable.numero30){
           textViewTitle.setText(title);
           textViewQuiz.setText(quiz);
           numero30();
       }
       if(cat == R.drawable.num40){
           textViewTitle.setText(title);
           textViewQuiz.setText(quiz);
           num40();
       }
       if(cat == R.drawable.num50){
           textViewTitle.setText(title);
           textViewQuiz.setText(quiz);
           num50();
       }
       if(cat == R.drawable.num60){
           textViewTitle.setText(title);
           textViewQuiz.setText(quiz);
           num60();
       }
       if(cat == R.drawable.num70){
           textViewTitle.setText(title);
           textViewQuiz.setText(quiz);
           num70();
       }
       if(cat == R.drawable.num80){
           textViewTitle.setText(title);
           textViewQuiz.setText(quiz);
           num80();
       }
       if(cat == R.drawable.num90){
           textViewTitle.setText(title);
           textViewQuiz.setText(quiz);
           num90();
       }
       if(cat == R.drawable.num100){
           textViewTitle.setText(title);
           textViewQuiz.setText(quiz);
           num100();
       }
        binding.QuizCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SetsActivity.this, SelectionActivity.class);
                    intent.putExtra("title",title);
                    SetsActivity.this.startActivity(intent);
                }

        });

       SetAdapter adapter = new SetAdapter(this,list);
       binding.setRecycle.setAdapter(adapter);
    }

    private void HumanBody() {
       //1ERE GRILLE
        list.add(new Word("OEIL","DISO̱",R.raw.diso));
        list.add(new Word("BOUCHE","MUNDUMBU",R.raw.mundumbu));
        list.add(new Word("MUSCLE","MISO̱N",R.raw.mison));
        list.add(new Word("SQUELETTE","EKELEKETE",R.raw.ekelekete));
        list.add(new Word("CHEVEUX","NYO̱",R.raw.nyo));
        list.add(new Word("DENTS","MASONGA",R.raw.masonga));
        list.add(new Word("LANGUE","EYEME̱",R.raw.eyeme));
        list.add(new Word("VISAGE","BOSO",R.raw.boso));
        list.add(new Word("MENTON","NYASO",R.raw.nyaso));
        list.add(new Word("COU","NYINGO",R.raw.nyingo));
        list.add(new Word("OREILLE","TOY",R.raw.toy));
        list.add(new Word("NEZ","MPEMBA",R.raw.mpemba));
        list.add(new Word("TETE","MULOPO",R.raw.mulopo));
        list.add(new Word("FRONT","MBO̱MBO̱",R.raw.mbombo));
        //2NG GRILLE
        list.add(new Word("POUMONS","BESAOSAO",R.raw.besaosao));
        list.add(new Word("CERVEAU","BO̱NGO̱",R.raw.bongo));
        list.add(new Word("POITRINE","BWANGA",R.raw.bwanga));
        list.add(new Word("BRAS","DIA",R.raw.dia));
        list.add(new Word("FOIE","DIBADI",R.raw.dibadi));
        list.add(new Word("SEIN","DIBE̱",R.raw.dibe));
        list.add(new Word("CUISSE","DIBE̱BE̱",R.raw.dibebe));
        list.add(new Word("GENOU","DIBO̱NGO̱",R.raw.dibongo));
        list.add(new Word("VENTRE","DIBUM",R.raw.dibum));
        list.add(new Word("EPAULE","DIKATA",R.raw.dikata));
        list.add(new Word("ESTOMAC","EBUNGA",R.raw.ebunga));
        list.add(new Word("BASSIN","EDUE",R.raw.edue));
        list.add(new Word("COEUR","MULEMA",R.raw.mulema));
        list.add(new Word("NOMBRIL","MUTO̱DI",R.raw.mutodi));
        list.add(new Word("JAMBE","MWENDE",R.raw.mwende));


    }

    private void Animals(){
        list.add(new Word("ARAIGNEE","DIBOBE̱",R.raw.dibobe));
        list.add(new Word("CHEVAL","EKABALA",R.raw.ekabala));
        list.add(new Word("ANE","ESEL",R.raw.esel));
        list.add(new Word("CHIMPANZE","EWAKE̱",R.raw.ewake));
        list.add(new Word("SINGE","KEMA",R.raw.kema));
        list.add(new Word("CHIEN","MBO",R.raw.mbo));
        list.add(new Word("CHEVRE","MBODI",R.raw.mbodi));
        list.add(new Word("MOUTON","MUDO̱NGI",R.raw.mudongi));
        list.add(new Word("PORC","MUDO̱NGI",R.raw.ngoa));
        list.add(new Word("LEZARD","NGULE̱",R.raw.ngule));
        list.add(new Word("BOEUF","NYAKA",R.raw.nyaka));
        list.add(new Word("LAPIN","PAKATOLO",R.raw.pakatolo));
        list.add(new Word("SOURIS","PUE",R.raw.pue));
        list.add(new Word("CHAT","SINGI",R.raw.singi));
        list.add(new Word("FOURMI","SO̱NO̱",R.raw.sono));
        list.add(new Word("HIPPOPOTAME","NGUBU",R.raw.ngubu));
        //2NG GRILLE
        list.add(new Word("SAUTERELLE","DIKELE",R.raw.dikele));
        list.add(new Word("LIEVRE","ISE̱DU",R.raw.isedu));
        list.add(new Word("CAFARD","KAKROTI",R.raw.kakroti));
        list.add(new Word("ESCARGOT","KO̱",R.raw.ko));
        list.add(new Word("MOUSTIQUE","LUNGU",R.raw.lungu));
        list.add(new Word("LEOPARD","MBANGE A NJO̱",R.raw.mbanganjo));
        list.add(new Word("GRENOUILLE","MUKO̱NGE̱",R.raw.mukonge));
        list.add(new Word("CAIMAN","NGANDO",R.raw.ngando));
        list.add(new Word("LION","NGILA",R.raw.ngila));
        list.add(new Word("MOUCHE","NGINGI",R.raw.ngingi));
        list.add(new Word("ANTILOPE","NGO̱LO̱N",R.raw.ngolon));
        list.add(new Word("PANTHERE","NJO̱̱",R.raw.njo));
        list.add(new Word("CHAMEAU","NJO̱̱ MBALE̱",R.raw.njombale));
        list.add(new Word("ELEPHANT","NJO̱̱U",R.raw.njou));
        list.add(new Word("TORTUE","WUDU",R.raw.wudu));
        list.add(new Word("GUEPE","DIPO̱MO̱",R.raw.dipomo));
        list.add(new Word("PAPILLON","EKO̱NKO̱N",R.raw.ekonkon));
        list.add(new Word("ABEILLE","NDO̱MBI",R.raw.ndombi));

    }

    private void Birds() {
        list.add(new Word("HIRONDELLE", "DIBONGA", R.raw.dibonga));
        list.add(new Word("CANARD", "ELELA", R.raw.elela));
        list.add(new Word("CORBEAU", "ESE̱SE̱", R.raw.esese));
        list.add(new Word("TISSERIN", "ISOKOLOKO", R.raw.isokoloko));
        list.add(new Word("HIBOU", "ISUKUDU", R.raw.isukudu));
        list.add(new Word("PINTADE", "KAN", R.raw.kan));
        list.add(new Word("DINDON", "KOBA KOBA", R.raw.kobakoba));
        list.add(new Word("AIGLE", "MBELA", R.raw.mbela));
        list.add(new Word("PIGEON", "MBENGA", R.raw.mbenga));
        list.add(new Word("PERROQUET", "NGOSO", R.raw.ngoso));
        list.add(new Word("PAON", "PIKOK", R.raw.pikok));
        list.add(new Word("EPERVIER", "WOMBE", R.raw.wombe));
        list.add(new Word("COQ", "WUBA", R.raw.wuba));
        list.add(new Word("MOINEAU", "MUTATE MBOA", R.raw.mutatemboa));

    }



    private void Repas() {
        list.add(new Word("TETRAPLEURA", "ESE̱SE̱", R.raw.esese));
        list.add(new Word("GINGEMBRE", "JINJA", R.raw.jinja));
        list.add(new Word("BASILIC", "KO̱̱TIMANJO", R.raw.kotimanjo));
        list.add(new Word("MACABO", "MAKABO", R.raw.makabo));
        list.add(new Word("MANIOC", "MAKWAMBA", R.raw.makwamba));
        list.add(new Word("BASILIC SACRE", "MASEPO", R.raw.masepo));
        list.add(new Word("IGNAME", "MBAA", R.raw.mbaa));
        list.add(new Word("MAIS", "MBASI", R.raw.mbasi));
        list.add(new Word("NOIX", "MBIA", R.raw.mbia));
        list.add(new Word("PLANTAIN", "MYE̱LE̱", R.raw.myele));
        list.add(new Word("OEUFS", "MYE̱N", R.raw.myen));
        list.add(new Word("PATATE", "NDOKO", R.raw.ndoko));
        list.add(new Word("PIMENT", "NDONGO", R.raw.ndongo));
        list.add(new Word("NOIX DE MUSCADE", "PE̱BE̱", R.raw.pebe));
        list.add(new Word("SEL", "WANGA", R.raw.wanga));

    }
    private void Fruits() {
        list.add(new Word("BANANE", "DIKUBE", R.raw.dikube));
        list.add(new Word("ORANGE", "EPUMA", R.raw.epuma));
        list.add(new Word("LEMON", "EPUMA A NGUILA", R.raw.epuma_nguila));
        list.add(new Word("PAMPLEMOUSSE", "EPUMA ENDE̱NE̱", R.raw.epuma_endene));
        list.add(new Word("CITRON", "EPUMA ESADI", R.raw.epuma_esadi));
        list.add(new Word("ANANAS", "JANGA LA NYO̱", R.raw.jangala_nyo));
        list.add(new Word("MANGUE", "JANGOLO", R.raw.jangolo));
        list.add(new Word("CANNE A SUCRE", "MUKOKE̱", R.raw.mukoke));
        list.add(new Word("AMANDES", "NGO̱NDO̱ A BEBONGO", R.raw.ngondo_bebongo));
        list.add(new Word("AVOCAT", "PIA", R.raw.pia));
        list.add(new Word("PAPAYE", "PO̱PO̱", R.raw.popo));

    }
    private void Poisson() {
        list.add(new Word("CREVETTE", "DIBANGA", R.raw.dibanga));
        list.add(new Word("CRABE", "DIKAKO", R.raw.dikako));
        list.add(new Word("LA RAIE", "DUBA", R.raw.duba));
        list.add(new Word("L'ALOSE", "EPA", R.raw.epa));
        list.add(new Word("L'EPERLAN", "MUANJAMOTO", R.raw.muanjaloto));
        list.add(new Word("MORUE", "MUKANJO", R.raw.mukanjo));
        list.add(new Word("REQUIN", "NDOM", R.raw.ndom));
        list.add(new Word("DORADE", "NGO̱WE̱", R.raw.ngowe));
        list.add(new Word("BAR", "NYE̱NDI", R.raw.nyendi));
        list.add(new Word("SOLE", "NYO̱MO̱", R.raw.nyomo));
        list.add(new Word("CAPITAIN", "SE̱", R.raw.se));
        list.add(new Word("CARPE", "WANGA", R.raw.wanga));
        list.add(new Word("MACHOIRON", "YENDA", R.raw.yenda));

    }
    private void Vetement() {
        list.add(new Word("CHAUSSURES", "BETAMBI", R.raw.betambi));
        list.add(new Word("CALECON", "EKUBE̱", R.raw.ekube));
        list.add(new Word("CHAPEAU", "EKOTO", R.raw.ekoto));
        list.add(new Word("VESTE", "KOTI", R.raw.koti));
        list.add(new Word("DRAP", "MBO̱M", R.raw.mbom));
        list.add(new Word("VETEMENT", "MBO̱TI", R.raw.mboti));
        list.add(new Word("CEINTURE", "NGODI", R.raw.ngodi));
        list.add(new Word("CHAUSSETTE", "ÑO̱PIÑA", R.raw.nopina));
        list.add(new Word("CHEMISE", "SO̱TI", R.raw.soti));
        list.add(new Word("PANTALON", "TROSISI", R.raw.trosisi));
        list.add(new Word("FOULARD", "WANGISI", R.raw.wangisi));

    }
    private void Couleur_Transport() {
        list.add(new Word("PIROGUE", "BO̱LO̱", R.raw.bolo));
        list.add(new Word("BLEU", "BULU", R.raw.bulu));
        list.add(new Word("MARRON", "DIBO̱NO̱", R.raw.dibono));
        list.add(new Word("GRIS", "DIBUDU", R.raw.dibudu));
        list.add(new Word("AVION", "EPUMWAN", R.raw.epumwan));
        list.add(new Word("VERT", "EYADI", R.raw.eyadi));
        list.add(new Word("ROUGE", "JOLA", R.raw.jola));
        list.add(new Word("TRAIN", "MASIN", R.raw.masin));
        list.add(new Word("VELO", "MEDI", R.raw.medi));
        list.add(new Word("ROSE", "MUKALA", R.raw.mukala));
        list.add(new Word("BRUN", "MUNANGA", R.raw.munanga));
        list.add(new Word("NOIR", "MUNDO", R.raw.mundo));
        list.add(new Word("VOITURE", "MUTOA", R.raw.mutoa));
        list.add(new Word("JAUNE", "NJABI", R.raw.njabi));
        list.add(new Word("BLANC", "SANGA", R.raw.sanga));
        list.add(new Word("MOTO", "TUTUTU", R.raw.tututu));

    }
    private void Maison() {
        list.add(new Word("TISSU", "DIBATO", R.raw.dibato));
        list.add(new Word("COUTEAU", "DIWE̱NDI", R.raw.diwendi));
        list.add(new Word("BOUTEILLE", "EPOSI", R.raw.eposi));
        list.add(new Word("VITRE", "JE̱NE̱", R.raw.jene));
        list.add(new Word("PORTE", "JO̱MBE̱", R.raw.jombe));
        list.add(new Word("CHAISE", "KONDA", R.raw.konda));
        list.add(new Word("DRAP", "MBO̱M", R.raw.mbom));
        list.add(new Word("FIL", "MUSINGA", R.raw.musinga));
        list.add(new Word("FOURCHETTE", "MWASO", R.raw.mwaso));
        list.add(new Word("AIGUILLE", "NDO̱NDO̱KI", R.raw.ndondoki));
        list.add(new Word("CISEAU", "NJASO", R.raw.njaso));
        list.add(new Word("LIT", "NO̱NGO̱", R.raw.nongo));
        list.add(new Word("PEIGNE", "SISAKO", R.raw.sisako));
        list.add(new Word("PLAT", "TANDAM", R.raw.tandam));
        list.add(new Word("CUILLERE", "TO", R.raw.to));


    }
    private void Calendrier() {
        list.add(new Word("JANVIER", "DIMO̱DI", R.raw.dimodi));
        list.add(new Word("FEVRIER", "NGONDE̱", R.raw.ngonde));
        list.add(new Word("MARS", "SONGE̱", R.raw.songe));
        list.add(new Word("AVRIL", "DIBABA", R.raw.dibaba));
        list.add(new Word("MAI", "EMIASE̱LE̱", R.raw.emiasele));
        list.add(new Word("JUIN", "ESO̱PE̱SO̱PE̱", R.raw.esopesope));
        list.add(new Word("JUILLET", "MADIBE̱DIBE̱", R.raw.madibedibe));
        list.add(new Word("AOUT", "DINGINDI", R.raw.dingindi));
        list.add(new Word("SEPTEMBRE", "ÑE̱TE̱KI", R.raw.nyeteki));
        list.add(new Word("OCTOBRE", "MAYESE̱", R.raw.mayese));
        list.add(new Word("NOVEMBRE", "TININI", R.raw.tinini));
        list.add(new Word("DECEMBRE", "ELAÑE̱", R.raw.elane));
        list.add(new Word("LUNDI", "MO̱SI", R.raw.mosi));
        list.add(new Word("MARDI", "KWASI", R.raw.kwasi));
        list.add(new Word("MERCREDI", "MUKO̱SI", R.raw.mukosi));
        list.add(new Word("JEUDI", "NGISI", R.raw.ngisi));
        list.add(new Word("VENDREDI", "NDO̱SI", R.raw.ndosi));
        list.add(new Word("SAMEDI", "ESABA", R.raw.esaba));
        list.add(new Word("DIMANCHE", "ETIÑA", R.raw.etina));
        list.add(new Word("CALENDRIER", "ELANGEMBU", R.raw.elangembu));
        list.add(new Word("L'HEURE", "NGANDE̱", R.raw.ngande));
        list.add(new Word("1H", "ELAME̱", R.raw.elame));
        list.add(new Word("2H", "ELAKETI", R.raw.elaketi));
        list.add(new Word("3H", "MUKINGO", R.raw.mukingo));
        list.add(new Word("4H", "MALO̱NGO̱LO̱NGO̱", R.raw.malongolongo));
        list.add(new Word("5H", "MESANEDI", R.raw.mesanedi));
        list.add(new Word("6H", "MBATI", R.raw.mbati));
        list.add(new Word("7H", "IDIBAIDIBA", R.raw.idiba));
        list.add(new Word("8H", "INYANYO", R.raw.inyanyo));
        list.add(new Word("9H", "MADIKALE̱", R.raw.madikale));
        list.add(new Word("10H", "YAKA", R.raw.yaka));
        list.add(new Word("11H", "TI", R.raw.ti));
        list.add(new Word("12H", "KO̱SI", R.raw.kosi));
        list.add(new Word("13H", "LANLAN", R.raw.lanlan));
        list.add(new Word("14H", "MUNGAN", R.raw.mungan));
        list.add(new Word("15H", "EBONGOBONGO", R.raw.ebongobongo));
        list.add(new Word("16H", "EMOI", R.raw.emoi));
        list.add(new Word("17H", "EBANGUBANGU", R.raw.ebangu));
        list.add(new Word("18H", "MABOLOBOLO", R.raw.mabolobolo));
        list.add(new Word("19H", "NGOKELI", R.raw.ngokeli));
        list.add(new Word("20H", "MBOTOKI", R.raw.mbotoki));
        list.add(new Word("21H", "EBINGOLO", R.raw.ebingolo));
        list.add(new Word("22H", "BITI", R.raw.biti));
        list.add(new Word("23H", "EBATUME̱", R.raw.ebatume));
        list.add(new Word("24H", "EKONGOLO", R.raw.ekongolo));

    }
    private void Autre() {
        list.add(new Word("GENESE", "BEBAYEDI", R.raw.bebayedi));
        list.add(new Word("ANNONCE", "BEBISEDI", R.raw.bebisedi));
        list.add(new Word("CAPTURE", "BEDAMEDI", R.raw.bedamedi));
        list.add(new Word("PREDICATION", "BELANGWEDI", R.raw.belangwedi));
        list.add(new Word("VAGUE", "EMUNE̱", R.raw.emune));
        list.add(new Word("OISEAU", "INO̱N", R.raw.inon));
        list.add(new Word("UNION", "JALATANE̱", R.raw.jalatane));
        list.add(new Word("VAINQUEUR", "JE̱KI", R.raw.jeki));
        list.add(new Word("VIOLENCE", "KONJO", R.raw.konjo));
        list.add(new Word("EXCITATION", "LUMALUMA", R.raw.lumaluma));
        list.add(new Word("VERITE", "MBALE̱", R.raw.mbale));
        list.add(new Word("DEVINETTE", "PILO", R.raw.pilo));
        list.add(new Word("RIVIERE", "TONGO", R.raw.tongo));
        list.add(new Word("ABONDANCE", "TUTE̱", R.raw.tututu));
        list.add(new Word("ACCOUCHEMENT", "YADI", R.raw.yadi));

        //GRILLE 2
        list.add(new Word("CIRCONSTANCE", "BETEMEDI", R.raw.betemedi));
        list.add(new Word("COURAGE", "BWANGANGA", R.raw.bwanganga));
        list.add(new Word("ESPOIR", "DIPITA", R.raw.dipita));
        list.add(new Word("MATIN", "IDIBA", R.raw.idiba_matin));
        list.add(new Word("SEPARATION", "JABANE̱", R.raw.jabane));
        list.add(new Word("REPONSE", "JALABE̱", R.raw.jalabe));
        list.add(new Word("HAUTEUR", "JASAME̱", R.raw.jasame));
        list.add(new Word("AGITATION", "KUDUKUDU", R.raw.kudukudu));
        list.add(new Word("TESTAMENT", "MALE", R.raw.male));
        list.add(new Word("MESSAGE", "MWE̱NDI", R.raw.mwendi));
        list.add(new Word("DESIR", "ÑO̱NGI", R.raw.nongi));
        list.add(new Word("COMMERCE", "ÑUNGA", R.raw.nunga));
        list.add(new Word("RECTITUDE", "SIM", R.raw.sim));
        list.add(new Word("RETARD", "SUKANE̱", R.raw.sukane));
        list.add(new Word("PERSEVERANCE", "TITIMBE̱", R.raw.titimbe));
        //GRILLE 3
        list.add(new Word("EPARGNE", "BEKOMBEDI", R.raw.bekombedi));
        list.add(new Word("SALUT", "BESUNGEDI", R.raw.besungedi));
        list.add(new Word("COQUILLE", "DIKOKA", R.raw.dikoka));
        list.add(new Word("SILENCE", "DIMUME", R.raw.dimume));
        list.add(new Word("SITUATION", "EBE̱YEDI", R.raw.ebeyedi));
        list.add(new Word("SOIR", "EBIAMU", R.raw.ebiamu));
        list.add(new Word("PALME", "EYE̱NGE̱", R.raw.eyenge));
        list.add(new Word("MILLION", "IDUN", R.raw.idun));
        list.add(new Word("GRAND", "INDE̱NE̱", R.raw.indene));
        list.add(new Word("ACHAT", "JANDANE̱", R.raw.jandane));
        list.add(new Word("EXAMEN", "KEKISE̱", R.raw.kekise));
        list.add(new Word("PIEGE", "LAMBI", R.raw.lambi));
        list.add(new Word("COLERE", "MALINGA", R.raw.malinga));
        list.add(new Word("LUMIERE", "MWE̱NE̱N", R.raw.mwenen));
        list.add(new Word("APRES MIDI", "MWESE", R.raw.mwese));
      //GRILLE 4
        list.add(new Word("DEMANDE", "BEBAISEDI", R.raw.bebaisedi));
        list.add(new Word("CONCLUSION", "BEDOMSEDI", R.raw.bedomsedi));
        list.add(new Word("REUNION", "JAKOTONE̱", R.raw.jakotone));
        list.add(new Word("POSSESSION", "JALEA", R.raw.jalea));
        list.add(new Word("PRUDENCE", "JANGAME̱YE̱", R.raw.jangameye));
        list.add(new Word("AVERTISSEMENT", "JOME̱LE̱", R.raw.jomele));
        list.add(new Word("CONSEIL", "MALEA", R.raw.malea));
        list.add(new Word("DERNIER", "NUSUKAN", R.raw.nusukan));
        list.add(new Word("PAGAIE", "PAI", R.raw.pai));
        list.add(new Word("TEMPS", "PONDA", R.raw.ponda));
        list.add(new Word("SOUPIR", "SUNJUMEA", R.raw.sunjumea));
        list.add(new Word("PARTICULIER", "TOBOTOBO", R.raw.tobotobo));
        list.add(new Word("BOIS", "WEA", R.raw.wea));
        list.add(new Word("MARMITE", "WO̱NGO̱", R.raw.wongo));
        list.add(new Word("CONGE", "WUMSE̱", R.raw.wumse));
//GRILLE 5
        list.add(new Word("CONFIRMATION", "BEBAMSEDI", R.raw.bebamsedi));
        list.add(new Word("FIN", "BESUEDI", R.raw.besuedi));
        list.add(new Word("INTRODUCTION", "BINGEDI", R.raw.bingedi));
        list.add(new Word("DESERT", "EYANG", R.raw.eyang));
        list.add(new Word("DESACCORD", "JABULANE̱", R.raw.jabulane));
        list.add(new Word("VENTE", "JANDISE̱", R.raw.jandise));
        list.add(new Word("DEPART", "JASUMWE̱", R.raw.jasumwe));
        list.add(new Word("TENTATION", "MAKE̱KE̱MBE̱", R.raw.makekembe));
        list.add(new Word("CROYANT", "MUDUBEDI", R.raw.mudubedi));
        list.add(new Word("OBSTACLE", "MWEKA", R.raw.mweka));
        list.add(new Word("ABONDANCE", "NJOASOA", R.raw.njoasoa));
        list.add(new Word("AUTRE", "NUPE̱PE̱", R.raw.nupepe));
        list.add(new Word("HIER", "KIE̱LE̱", R.raw.kiele));
        list.add(new Word("AUJOURD'HUI", "WE̱NGE̱", R.raw.wenge));
//GRILLE 6
        list.add(new Word("VENGEANCE", "DIBO̱MBE̱", R.raw.dibombe));
        list.add(new Word("FOULE", "DIMUTI", R.raw.dimuti));
        list.add(new Word("EMERGENCE", "JABWE̱LE̱", R.raw.jabwele));
        list.add(new Word("RECONCILIATION", "JADOUSANE̱", R.raw.jadousane));
        list.add(new Word("JUMEAUX", "MAWASA", R.raw.mawasa));
        list.add(new Word("BASTONNADE", "MBE̱TI", R.raw.mbeti));
        list.add(new Word("EXCUSE", "MILAKISAN", R.raw.milakisan));
        list.add(new Word("OBSCURITE", "MWITITI", R.raw.mwititi));
        list.add(new Word("DISCRIMINATION", "NDANDO", R.raw.ndando));
        list.add(new Word("SECRET", "NDITI", R.raw.nditi));
        list.add(new Word("AMERTUME", "NJONJONGI", R.raw.njonjongi));
        list.add(new Word("RAPIDITE", "PE̱LE̱PE̱LE̱", R.raw.pelepele));
        list.add(new Word("SOUVENIR", "JONGE̱LE̱", R.raw.jongele));
        list.add(new Word("SOUTIEN", "JONGWANE̱", R.raw.jongwane));
//GRILLE 7
        list.add(new Word("SORTIE", "BEBUSEDI", R.raw.bebusedi));
        list.add(new Word("ETERNEL", "DIBENGA", R.raw.dibenga));
        list.add(new Word("GAUCHE", "DIMOSE̱", R.raw.dimose));
        list.add(new Word("DISCORDE", "DIWANJE̱", R.raw.diwanje));
        list.add(new Word("APPELLATION", "JABE̱LE̱", R.raw.jabele));
        list.add(new Word("CONSECRATION", "JO̱KISABE̱", R.raw.jokisabe));
        list.add(new Word("PRESENCE", "JUKEA", R.raw.jukea));
        list.add(new Word("OBJET", "LAMBO", R.raw.lambo));
        list.add(new Word("CERTITUDE", "MBAKI", R.raw.mbaki));
        list.add(new Word("FONDATEUR", "MUBOKEDI", R.raw.mubokedi));
        list.add(new Word("FOYER", "MWE̱BE̱", R.raw.mwebe));
        list.add(new Word("ETAGE", "NDE̱KI", R.raw.ndeki));
        list.add(new Word("CHAINE", "NGO̱KO̱BI", R.raw.ngokobi));
        list.add(new Word("CALME", "PI", R.raw.pi));
        list.add(new Word("DOULEUR", "SESE", R.raw.sese));
        //GRILLE 8
        list.add(new Word("CHOIX", "BEPO̱SEDI", R.raw.beposedi));
        list.add(new Word("RECHERCHE", "BEWASEDI", R.raw.bewasedi));
        list.add(new Word("SAGESSE", "DIBIE̱", R.raw.dibie));
        list.add(new Word("FAUTE", "DIWUSE̱", R.raw.diwuse));
        list.add(new Word("DIVINATION", "EDINGE", R.raw.edinge));
        list.add(new Word("DOUCHE", "JOKE̱LE̱", R.raw.jokele));
        list.add(new Word("ARGENT", "MBOLO", R.raw.mbolo));
        list.add(new Word("PLUIE", "MBUA", R.raw.mbua));
        list.add(new Word("GARDIEN", "MUTATEDI", R.raw.mutatedi));
        list.add(new Word("HEURE", "NGANDE̱", R.raw.ngande));
        list.add(new Word("ETOILE", "NGENGETI", R.raw.ngengeti));
        list.add(new Word("TAMBOUR", "NGO̱MO̱", R.raw.ngomo));
        list.add(new Word("CHOISIR", "PO̱SO̱", R.raw.poso));
        list.add(new Word("SCIE", "SO̱", R.raw.so));
        list.add(new Word("CHERCHER", "WASA", R.raw.wasa));
        //GRILLE 9
        list.add(new Word("PROMESSE", "DIKAKI", R.raw.dikaki));
        list.add(new Word("GRAISSE", "DIWO̱NGI", R.raw.diwongi));
        list.add(new Word("BAPTEME", "DUBISE̱", R.raw.dubise));
        list.add(new Word("VIDE", "ETO̱LO̱KI", R.raw.etoloki));
        list.add(new Word("APPARENCE", "JE̱NE̱NE̱", R.raw.jenene));
        list.add(new Word("ONDIN", "JENGU", R.raw.jengu));
        list.add(new Word("TOILETTE", "JOE̱", R.raw.joe));
        list.add(new Word("BAUME", "JO̱KI", R.raw.joki));
        list.add(new Word("VOLONTE", "JEMEA", R.raw.jemea));
        list.add(new Word("PRINCE", "KUM", R.raw.kum));
        list.add(new Word("ROI", "KUMKAN", R.raw.kumkan));
        list.add(new Word("CHEFFERIE", "JANEA", R.raw.janea));
        list.add(new Word("CHEF", "MWANEDI", R.raw.mwanedi));
        list.add(new Word("ANCIEN", "KWAN", R.raw.kwan));
        list.add(new Word("RUISSEAU", "MPO̱LO̱LO̱", R.raw.mpolo));
        list.add(new Word("PROFONDEUR", "NJIBA", R.raw.njiba));
        list.add(new Word("NOUVEAU", "PEÑA", R.raw.pena));



    }

    //////////Methods for Numbers///////////////////////

    private void num10() {
        //1ERE GRILLE
        list.add(new Word("1","EWO̱",R.raw._1));
        list.add(new Word("2","BEBA",R.raw._2));
        list.add(new Word("3","BELALO",R.raw._3));
        list.add(new Word("4","BENEI",R.raw._4));
        list.add(new Word("5","BETANU",R.raw._5));
        list.add(new Word("6","MUTOBA",R.raw._6));
        list.add(new Word("7","SAMBA",R.raw._7));
        list.add(new Word("8","LO̱MBI",R.raw._8));
        list.add(new Word("9","DIBUA",R.raw._9));
        list.add(new Word("10","DOM",R.raw._10));

    }
    private void num20() {
        //1ERE GRILLE
        list.add(new Word("11","DOM NA EWO̱",R.raw._11));
        list.add(new Word("12","DOM NA BEBA",R.raw._12));
        list.add(new Word("13","DOM NA BELALO",R.raw._13));
        list.add(new Word("14","DOM NA BENEI",R.raw._14));
        list.add(new Word("15","DOM NA BETANU",R.raw._15));
        list.add(new Word("16","DOM NA MUTOBA",R.raw._16));
        list.add(new Word("17","DOM NA SAMBA",R.raw._17));
        list.add(new Word("18","DOM NA LO̱MBI",R.raw._18));
        list.add(new Word("19","DOM NA DIBUA",R.raw._19));
        list.add(new Word("20","MWABA",R.raw._20));

    }
    private void numero30() {
        //1ERE GRILLE
        list.add(new Word("21","MWABA NA EWO̱",R.raw._21));
        list.add(new Word("22","MWABA NA BEBA",R.raw._22));
        list.add(new Word("23","MWABA NA BELALO",R.raw._23));
        list.add(new Word("24","MWABA NA BENEI",R.raw._24));
        list.add(new Word("25","MWABA NA BETANU",R.raw._25));
        list.add(new Word("26","MWABA NA MUTOBA",R.raw._26));
        list.add(new Word("27","MWABA NA SAMBA",R.raw._27));
        list.add(new Word("28","MWABA NA LO̱MBI",R.raw._28));
        list.add(new Word("29","MWABA NA DIBUA",R.raw._29));
        list.add(new Word("30","MWALALO",R.raw._30));

    }
    private void num40() {
        list.add(new Word("31","MWALALO NA EWO̱",R.raw._31));
        list.add(new Word("32","MWALALO NA BEBA",R.raw._32));
        list.add(new Word("33","MWALALO NA BELALO",R.raw._33));
        list.add(new Word("34","MWALALO NA BENEI",R.raw._34));
        list.add(new Word("35","MWALALO NA BETANU",R.raw._35));
        list.add(new Word("36","MWALALO NA MUTOBA",R.raw._36));
        list.add(new Word("37","MWALALO NA SAMBA",R.raw._37));
        list.add(new Word("38","MWALALO NA LO̱MBI",R.raw._38));
        list.add(new Word("39","MWALALO NA DIBUA",R.raw._39));
        list.add(new Word("40","MWANEI",R.raw._40));

    }
    private void num50() {
        list.add(new Word("41","MWANEI NA EWO̱",R.raw._41));
        list.add(new Word("42","MWANEI NA BEBA",R.raw._42));
        list.add(new Word("43","MWANEI NA BELALO",R.raw._43));
        list.add(new Word("44","MWANEI NA BENEI",R.raw._44));
        list.add(new Word("45","MWANEI NA BETANU",R.raw._45));
        list.add(new Word("46","MWANEI NA MUTOBA",R.raw._46));
        list.add(new Word("47","MWANEI NA SAMBA",R.raw._47));
        list.add(new Word("48","MWANEI NA LO̱MBI",R.raw._48));
        list.add(new Word("49","MWANEI NA DIBUA",R.raw._49));
        list.add(new Word("50","MWATANU",R.raw._50));

    }

    private void num60() {
        list.add(new Word("51","MWATANU NA EWO̱",R.raw._51));
        list.add(new Word("52","MWATANU NA BEBA",R.raw._52));
        list.add(new Word("53","MWATANU NA BELALO",R.raw._53));
        list.add(new Word("54","MWATANU NA BENEI",R.raw._54));
        list.add(new Word("55","MWATANU NA BETANU",R.raw._55));
        list.add(new Word("56","MWATANU NA MUTOBA",R.raw._56));
        list.add(new Word("57","MWATANU NA SAMBA",R.raw._57));
        list.add(new Word("58","MWATANU NA LO̱MBI",R.raw._58));
        list.add(new Word("59","MWATANU NA DIBUA",R.raw._59));
        list.add(new Word("60","MUMUTOBA",R.raw._60));

    }
    private void num70() {
        list.add(new Word("61","MUMUTOBA NA EWO̱",R.raw._61));
        list.add(new Word("62","MUMUTOBA NA BEBA",R.raw._62));
        list.add(new Word("63","MUMUTOBA NA BELALO",R.raw._63));
        list.add(new Word("64","MUMUTOBA NA BENEI",R.raw._64));
        list.add(new Word("65","MUMUTOBA NA BETANU",R.raw._65));
        list.add(new Word("66","MUMUTOBA NA MUTOBA",R.raw._66));
        list.add(new Word("67","MUMUTOBA NA SAMBA",R.raw._67));
        list.add(new Word("68","MUMUTOBA NA LO̱MBI",R.raw._68));
        list.add(new Word("69","MUMUTOBA NA DIBUA",R.raw._69));
        list.add(new Word("70","MUSAMBA",R.raw._70));

    }
    private void num80() {
        list.add(new Word("71","MUSAMBA NA EWO̱",R.raw._71));
        list.add(new Word("72","MUSAMBA NA BEBA",R.raw._72));
        list.add(new Word("73","MUSAMBA NA BELALO",R.raw._73));
        list.add(new Word("74","MUSAMBA NA BENEI",R.raw._74));
        list.add(new Word("75","MUSAMBA NA BETANU",R.raw._75));
        list.add(new Word("76","MUSAMBA NA MUTOBA",R.raw._76));
        list.add(new Word("77","MUSAMBA NA SAMBA",R.raw._77));
        list.add(new Word("78","MUSAMBA NA LO̱MBI",R.raw._78));
        list.add(new Word("79","MUSAMBA NA DIBUA",R.raw._79));
        list.add(new Word("80","MULO̱MBI",R.raw._80));

    }
    private void num90() {
        list.add(new Word("81","MULO̱MBI NA EWO̱",R.raw._81));
        list.add(new Word("82","MULO̱MBI NA BEBA",R.raw._82));
        list.add(new Word("83","MULO̱MBI NA BELALO",R.raw._83));
        list.add(new Word("84","MULO̱MBI NA BENEI",R.raw._84));
        list.add(new Word("85","MULO̱MBI NA BETANU",R.raw._85));
        list.add(new Word("86","MULO̱MBI NA MUTOBA",R.raw._86));
        list.add(new Word("87","MULO̱MBI NA SAMBA",R.raw._87));
        list.add(new Word("88","MULO̱MBI NA LO̱MBI",R.raw._88));
        list.add(new Word("89","MULO̱MBI NA DIBUA",R.raw._89));
        list.add(new Word("90","MUDIBUA",R.raw._90));

    }

    private void num100() {
        list.add(new Word("91","MUDIBUA NA EWO̱",R.raw._91));
        list.add(new Word("92","MUDIBUA NA BEBA",R.raw._92));
        list.add(new Word("93","MUDIBUA NA BELALO",R.raw._93));
        list.add(new Word("94","MUDIBUA NA BENEI",R.raw._94));
        list.add(new Word("95","MUDIBUA NA BETANU",R.raw._95));
        list.add(new Word("96","MUDIBUA NA MUTOBA",R.raw._96));
        list.add(new Word("97","MUDIBUA NA SAMBA",R.raw._97));
        list.add(new Word("98","MUDIBUA NA LO̱MBI",R.raw._98));
        list.add(new Word("99","MUDIBUA NA DIBUA",R.raw._99));
        list.add(new Word("100","EBWEA",R.raw._100));

    }


}
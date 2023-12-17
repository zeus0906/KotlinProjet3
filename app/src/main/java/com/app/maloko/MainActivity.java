package com.app.maloko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.maloko.Adapters.RecyclerAdapter;
import com.app.maloko.Fragments.WordFragment;
import com.app.maloko.Fragments.NumberFragment;
import com.app.maloko.Models.Category;
import com.app.maloko.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    ArrayList<Category> list;
    CardView human, animals;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter recyclerAdapter;


    int[] arr={R.drawable.humanbody,R.drawable.animaux,R.drawable.oiseau,R.drawable.repas,
            R.drawable.calendrier,R.drawable.couleur,R.drawable.fruit,R.drawable.maison,
            R.drawable.poisson,R.drawable.transport,R.drawable.vetements};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new WordFragment());



        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.letters) {
                replaceFragment(new WordFragment());
            } else
                if (item.getItemId() == R.id.chiffre) {
                replaceFragment(new NumberFragment());
            }
            return true;
        });


/*
        recyclerView= findViewById(R.id.GridRecycleView);
        layoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        //fill the category elements...
        list = new ArrayList<>();

        list.add(new Category(R.drawable.humanbody,"Le Corps Humain"));
        list.add(new Category(R.drawable.animaux,"Les Animaux"));
        list.add(new Category(R.drawable.oiseau,"Les Oiseaux"));
        list.add(new Category(R.drawable.repas,"Les Repas"));
        list.add(new Category(R.drawable.calendrier,"Le Calendrier"));
        list.add(new Category(R.drawable.couleur,"Les Couleurs"));
        list.add(new Category(R.drawable.fruit,"Les Fruits"));
        list.add(new Category(R.drawable.maison,"La Maison"));
        list.add(new Category(R.drawable.poisson,"Les Poissons"));
        list.add(new Category(R.drawable.transport,"Les Moyens de Transport"));
        list.add(new Category(R.drawable.vetements,"Les Vetements"));

        recyclerAdapter = new RecyclerAdapter(this,list);

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setHasFixedSize(true); */

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=  fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_letter,fragment);
        fragmentTransaction.commit();
    }


}
package com.app.maloko.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.maloko.Adapters.NumberAdapter;
import com.app.maloko.Models.Category;
import com.app.maloko.Models.Number;
import com.app.maloko.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumberFragment extends Fragment {

    ArrayList<Number> list;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    NumberAdapter numberAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NumberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumberFragment newInstance(String param1, String param2) {
        NumberFragment fragment = new NumberFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_number, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialized();

        recyclerView= view.findViewById(R.id.GridRecycleNumber);
        layoutManager= new GridLayoutManager(getContext(),2);

        recyclerView.setLayoutManager(layoutManager);
        numberAdapter = new NumberAdapter(getContext(),list);

        recyclerView.setAdapter(numberAdapter);
        recyclerView.setHasFixedSize(true);
        numberAdapter.notifyDataSetChanged();
    }

    private void dataInitialized() {

        list = new ArrayList<>();

        list.add(new Number(R.drawable.top10,"10"));
        list.add(new Number(R.drawable.num20,"20"));
        list.add(new Number(R.drawable.numero30,"30"));
        list.add(new Number(R.drawable.num40,"40"));
        list.add(new Number(R.drawable.num50,"50"));
        list.add(new Number(R.drawable.num60,"60"));
        list.add(new Number(R.drawable.num70,"70"));
        list.add(new Number(R.drawable.num80,"80"));
        list.add(new Number(R.drawable.num90,"90"));
        list.add(new Number(R.drawable.num100,"100"));

    }
}
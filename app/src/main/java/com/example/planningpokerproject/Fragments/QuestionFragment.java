package com.example.planningpokerproject.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.planningpokerproject.Adapter.VoteRecyclerViewAdapter;
import com.example.planningpokerproject.R;
import com.example.planningpokerproject.R;

public class QuestionFragment extends Fragment  {

    VoteRecyclerViewAdapter adapter;
    public QuestionFragment(){};

    public void Oncreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question, container, false);

        String[] data = {"0", "7", "1", "2", "3", "5", "8", "13", "20"};

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvNumbers);

        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
        adapter = new VoteRecyclerViewAdapter(getContext(), data);

        recyclerView.setAdapter(adapter);


        Button submit_button = view.findViewById(R.id.button_submitanswers);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GroupListFragment Gfragment = new GroupListFragment();
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, Gfragment);
                fr.addToBackStack(null);
                fr.commit();
            }
        });


        return  view;
    }



}

package com.example.planningpokerproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.planningpokerproject.R;
import com.example.planningpokerproject.R;

public class QuestionFragment extends Fragment {


    public QuestionFragment(){};

    public void Oncreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(
                R.layout.fragment_question, container, false);

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

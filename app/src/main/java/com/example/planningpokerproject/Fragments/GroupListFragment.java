package com.example.planningpokerproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.planningpokerproject.R;

public class GroupListFragment extends Fragment {


    public GroupListFragment(){};

    public void Oncreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(
                R.layout.fragment_grouplist, container, false);



        return  view;
    }
}

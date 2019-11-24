package com.example.planningpokerproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.planningpokerproject.Adapter.AnswerListAdapter;
import com.example.planningpokerproject.R;
import com.example.planningpokerproject.R;

import java.util.ArrayList;

public class AnswerListFragment extends Fragment {
    AnswerListAdapter adapter;
    RecyclerView recyclerView;

    public AnswerListFragment(){};

    public void Oncreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(
                R.layout.fragment_answerlist, container, false);

        Bundle bundle = this.getArguments();
        ArrayList <String> userAnswers = bundle.getStringArrayList("answers");


        recyclerView = (RecyclerView)view.findViewById(R.id.answerrecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        adapter = new AnswerListAdapter(userAnswers,getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return  view;
    }
}

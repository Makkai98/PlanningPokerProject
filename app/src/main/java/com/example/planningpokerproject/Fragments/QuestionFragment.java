package com.example.planningpokerproject.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.planningpokerproject.Adapter.VoteRecyclerViewAdapter;
import com.example.planningpokerproject.Model.Group;
import com.example.planningpokerproject.Model.Question;
import com.example.planningpokerproject.R;
import com.example.planningpokerproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QuestionFragment extends Fragment  {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    VoteRecyclerViewAdapter adapter;
    public QuestionFragment(){};

    public void Oncreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_question, container, false);

        final String[] data = {"0", "7", "1", "2", "3", "5", "8", "13", "20"};
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvNumbers);

        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
        adapter = new VoteRecyclerViewAdapter(getContext(), data,0);

        recyclerView.setAdapter(adapter);

        Bundle bundle = this.getArguments();
        final String groupid = bundle.getString("groupid");
        String name = bundle.getString("name");

        //Log.d("tags", groupid + " "+ name);
        TextView question_tv = view.findViewById(R.id.Question_textview);
        Button submit_button = view.findViewById(R.id.button_submitanswers);

        setQuestion(submit_button,question_tv,groupid,0);



        return  view;
    }

    public void setQuestion (final Button b ,final TextView t, final String groupid, final int position)
    {
        Question question;
        databaseReference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               Group g = dataSnapshot.child(groupid).getValue(Group.class);
               ArrayList<Question> q1 = g.getQuestions();

               if (position<q1.size()) {
                   t.setText(q1.get(position).getQuestion());
                   Log.d("question", g.getQuestions().toString());
               }

               if (position>=q1.size())
               {
                   t.setText("All the questions were answered!");
               }

               b.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v ) {



                       if (t.getText().toString().equals("All the questions were answered!")) {
                           GroupListFragment Gfragment = new GroupListFragment();
                           FragmentTransaction fr = getFragmentManager().beginTransaction();
                           fr.replace(R.id.fragment_container, Gfragment);
                           fr.addToBackStack(null);
                           fr.commit();
                       }
                       else
                       {
                           Log.d("pos", adapter.getItem(adapter.getPos()));
                           setQuestion(b, t,groupid,position+1);
                       }
                   }
               });

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });


    }





}

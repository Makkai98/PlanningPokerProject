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
import com.example.planningpokerproject.Model.User;
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
    static int position = 0;

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
        final String name = bundle.getString("name");

        //Log.d("tags", groupid + " "+ name);
        TextView question_tv = view.findViewById(R.id.Question_textview);
        Button submit_button = view.findViewById(R.id.button_submitanswers);

        setQuestion(submit_button,question_tv,groupid, name);



        return  view;
    }

    public void setQuestion (final Button b ,final TextView t, final String groupid, final String name )
    {
        final Question question;
        databaseReference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               Group g = dataSnapshot.child(groupid).getValue(Group.class);

               final Question question = dataSnapshot.child(groupid).child("questions").child(String.valueOf(position)).getValue(Question.class);
             final   ArrayList<Question> q1 = g.getQuestions();
               final ArrayList<User> users;

               if (position<q1.size()) {


                   if (q1.get(position).getUsers() == null) {
                       users = new ArrayList<>();
                   } else {
                       users = question.getUsers();
                   }
               }
               else
               {
                   users = new ArrayList<>();
               }
             final ArrayList<String> questionString = new ArrayList<String>();
             for(Question q : q1)
             {

                     questionString.add(q.getQuestion());

             }

               if ((position<q1.size() ) && (question.isStatus().equals("active"))) {
                       // Log.d("status", q1.get(position).isStatus());
                       t.setText(question.getQuestion());
                      // Log.d("question", q1.get(position).getQuestion());

               }
               else
               {
                   position++;
                   setQuestion(b, t,groupid, name);
               }
               if (position>=q1.size())
               {
                   t.setText("All the questions were answered!");
                   b.setText("Submit all Answers");

               }

               b.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v ) {


                       if (t.getText().toString().equals("All the questions were answered!")) {
                           QuestionListFragment Gfragment = new QuestionListFragment();

                           final Bundle bundle = new Bundle();
                           bundle.putStringArrayList("questions", questionString);
                           bundle.putString("groupid",groupid);
                           Gfragment.setArguments(bundle);

                           FragmentTransaction fr = getFragmentManager().beginTransaction();
                           fr.replace(R.id.fragment_container, Gfragment);
                           fr.addToBackStack(null);
                           fr.commit();
                       }
                       else
                       {

                        String key = databaseReference.child(groupid).child("questions").child(String.valueOf(position)).child("users").push().getKey();
                         User user = new User(key, name,  adapter.getItem(adapter.getPos()));
                          // databaseReference.child(groupid).child("questions").child(Integer.toString(position)).child("users").child(key).setValue(user);

                            users.add(user);
                            question.setUsers(users);
                            databaseReference.child(groupid).child("questions").child(String.valueOf(position)).setValue(question);
                           Log.d ("questionpos", String.valueOf(position));
                           Log.d("position", position + "");
                           Log.d("pos", adapter.getItem(adapter.getPos()));
                           position++;
                           setQuestion(b, t,groupid, name);
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

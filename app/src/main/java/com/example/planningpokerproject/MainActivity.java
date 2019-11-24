package com.example.planningpokerproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.planningpokerproject.Fragments.LoginFragment;
import com.example.planningpokerproject.Model.Group;
import com.example.planningpokerproject.Model.Question;
import com.example.planningpokerproject.Model.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    /*
        ArrayList<Integer> groupId = new ArrayList<>();
        groupId.add(10);



        ArrayList <User> users = new ArrayList<>();

        //users.add(user2);
        Question question1 = new Question(0,"Rate this app!", "active", users );
        Question question2 = new Question(1,"Do you like Java?", "active", users );
        Question question3 = new Question(2,"Answer this question?", "inactive", users );
        Question question4 = new Question(3,"Next question?", "active", users );



        ArrayList <Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

       // final String id = databaseReference.push().getKey();
        //String id2 = databaseReference.push().getKey();
        Group group1 = new Group("1", true, questions);
        Log.d("tag" , group1.toString());

        Group group2 = new Group("2", false, questions);
        Group group3 = new Group("3", false, questions);
        Group group4 = new Group("4", true, questions);
        Group group5 = new Group("5", true, questions);


        databaseReference.child(group1.getId()).setValue(group1);
        databaseReference.child(group2.getId()).setValue(group2);
        databaseReference.child(group3.getId()).setValue(group3);
        databaseReference.child(group4.getId()).setValue(group4);
        databaseReference.child(group5.getId()).setValue(group5);
      /* databaseReference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               Group g = dataSnapshot.child(id).getValue(Group.class);
           //    Question q = dataSnapshot.child(id).child("questions").child("0").getValue(Question.class);
            //   Log.d("Group:",q.toString());
               ArrayList<Question> q1 = g.getQuestions();
            for(Question q : q1)
              {
                  Log.d("Question",q.getQuestion());
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });*/




          FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new LoginFragment());
        fragmentTransaction.commit();



    }
}

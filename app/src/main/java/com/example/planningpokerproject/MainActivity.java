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

        ArrayList<Integer> groupId = new ArrayList<>();
        groupId.add(10);

        User user1 = new User(1, "Matyas", "", groupId);
        User user2 = new User(2, "Karcsi", "", groupId);
        User user3 = new User (3, "Peter");


        ArrayList <User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        Question question1 = new Question(1,"Rate this app!", true, users );
        Question question2 = new Question(2,"Do you like Java?", true, users );

        ArrayList <Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);


        final String id = databaseReference.push().getKey();
        String id2 = databaseReference.push().getKey();
        Group group1 = new Group(1, true, questions);
        Log.d("tag" , group1.toString());

        Group group2 = new Group(2, false, questions);

        databaseReference.child(id).setValue(group1);
        databaseReference.child(id2).setValue(group2);

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

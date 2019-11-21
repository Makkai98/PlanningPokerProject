package com.example.planningpokerproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.planningpokerproject.R;

public class LoginFragment extends Fragment {




    public LoginFragment(){};

    public void Oncreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(
                R.layout.fragment_login, container, false);




        EditText et_groupId = view.findViewById(R.id.Login_groupId);
        EditText et_name = view.findViewById(R.id.Login_name);

        Button login_button = view.findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionFragment Qfragment = new QuestionFragment();
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, Qfragment);
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        return  view;
    }
}
package com.example.planningpokerproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


        final View view = inflater.inflate(
                R.layout.fragment_login, container, false);




        final EditText et_groupId = view.findViewById(R.id.Login_groupId);
        final EditText et_name = view.findViewById(R.id.Login_name);

        Button login_button = view.findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_name.getText().toString().isEmpty() || (et_groupId.toString().isEmpty())) {

                    Toast.makeText(getContext(), "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
                } else {

                    String groupId = et_groupId.getText().toString();
                    String name = et_name.getText().toString();


                    final Bundle bundle = new Bundle();
                    bundle.putString("name", name);
                    bundle.putString("groupid", groupId);

                    QuestionFragment Qfragment = new QuestionFragment();
                    Qfragment.setArguments(bundle);
                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container, Qfragment);
                    fr.addToBackStack(null);
                    fr.commit();
                }
            }
        });

        return  view;
    }
}
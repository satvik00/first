package com.example.userinterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignupTabFragment extends Fragment {
    EditText username;
    EditText password;
    EditText email;
    EditText name;
    Button signup;
    float v=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root=(ViewGroup)  inflater.inflate(R.layout.signup_tab_fragment,container,false);
        name=root.findViewById(R.id.Name);
        email=root.findViewById(R.id.email1);
        username=root.findViewById(R.id.Username);
        password=root.findViewById(R.id.pass1);
        signup=root.findViewById(R.id.Signup);

        username.setTranslationX(800);
        name.setTranslationX(800);
        email.setTranslationX(800);
        password.setTranslationX(800);
        signup.setTranslationX(800);

        username.setAlpha(v);
        name.setAlpha(v);
        email.setAlpha(v);
        password.setAlpha(v);
        signup.setAlpha(v);

        name.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(100).start();
        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(200).start();
        username.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(400).start();
        signup.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openFeedActivity();
            }
        });
        return root;
    }
    public void openFeedActivity(){
        Intent intent=new Intent(this.getActivity(),feedActivity.class);
        startActivity(intent);
    }
}

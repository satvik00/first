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

public class loginTabFragment extends Fragment {
    EditText username;
    EditText password;
    Button login;
    float v=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root=(ViewGroup)  inflater.inflate(R.layout.login_tab_fragment,container,false);
        username=root.findViewById(R.id.email);
        password=root.findViewById(R.id.pass);
        login=root.findViewById(R.id.login);

        username.setTranslationX(800);
        password.setTranslationX(800);
        login.setTranslationX(800);

        username.setAlpha(v);
        password.setAlpha(v);
        login.setAlpha(v);

        username.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        login.setOnClickListener(new View.OnClickListener(){

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

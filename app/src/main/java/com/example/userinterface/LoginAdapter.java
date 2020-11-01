package com.example.userinterface;


import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTabs;
    public LoginAdapter(FragmentManager fm, Context c, int totalTabs){
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context=c;
        this.totalTabs=totalTabs;
    }
    @Override
    public int getCount(){
        return totalTabs;
    }
    public Fragment getItem(int position){
        switch(position){
            case 0:
                loginTabFragment login=new loginTabFragment();
                return login;
            case 1:
                SignupTabFragment signup=new SignupTabFragment();
                return signup;
            default:
                return null;
        }
    }
}

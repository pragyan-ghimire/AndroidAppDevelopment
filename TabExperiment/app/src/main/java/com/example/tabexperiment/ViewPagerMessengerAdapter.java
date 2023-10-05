package com.example.tabexperiment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMessengerAdapter extends FragmentPagerAdapter {
    public ViewPagerMessengerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new ChatFragment();
            case 1:return new StatusFragment();
            case 2:return new CallFragment();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return 3;//number of tabs
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:return "Chats";
            case 1:return "Status";
            case 2:return "Calls";
            default:return null;
        }
    }
}

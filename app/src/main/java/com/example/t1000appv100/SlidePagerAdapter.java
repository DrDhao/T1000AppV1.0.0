package com.example.t1000appv100;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SlidePagerAdapter extends FragmentPagerAdapter {

    private static SlidePagerAdapter instance;
    private List<Fragment> fragmentList;

    public SlidePagerAdapter(FragmentManager fm, List<Fragment> fragmentList){
        super(fm);
        this.fragmentList = fragmentList;
        instance = this;
    }



    @Override
    public Fragment getItem(int position) {
        stopOtherFragments(position);
        return fragmentList.get(position);
    }

    public void stopOtherFragments(int selectedFragment) {
        if(!fragmentList.isEmpty()){
            ArrayList<MyFragment> myFragments = new ArrayList<>();
            for (int i = 0; i < fragmentList.size(); i++) {
                if (i != selectedFragment) {
                    myFragments.add((MyFragment) fragmentList.get(i));
                }
            }
            for (MyFragment fragment : myFragments) {
                fragment.stop();
            }
            MainActivity.getInstance().setMotorData(null);
        }
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public static SlidePagerAdapter getInstance() {
        return instance;
    }



}

package com.example.gtech.Adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gtech.Fragments.MuttonFragment;
import com.example.gtech.Fragments.PoultryFragment;
import com.example.gtech.Fragments.SeafoodFragment;

public class TabAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public TabAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
               PoultryFragment poultryFrag=new PoultryFragment();
               return poultryFrag;
            case 1:
                MuttonFragment muttonFragment=new MuttonFragment();
                return muttonFragment;
              case 2:
                  SeafoodFragment seafoodFragment=new SeafoodFragment();
                  return seafoodFragment;
               default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }

}

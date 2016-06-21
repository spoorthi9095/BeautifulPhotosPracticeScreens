package com.example.spoorthi.fragmentexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by spoorthi on 18/5/16.
 */
public class PagerAdapter extends FragmentStatePagerAdapter
{

    public PagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new SquareFragment();
                break;
            case 1:
                frag=new PortraitFragment();
                break;
            case 2:
                frag=new LandscapeFragment();
                break;
        }
        return frag;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        String title=" ";
        switch (position)
        {
            case 0:
                title="SQUARE";
                break;
            case 1:
                title="PORTRAIT";
                break;
            case 2:
                title="LANDSCAPE";
                break;
        }
        return title;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

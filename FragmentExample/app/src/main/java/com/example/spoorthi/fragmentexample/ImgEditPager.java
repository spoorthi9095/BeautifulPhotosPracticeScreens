package com.example.spoorthi.fragmentexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by spoorthi on 23/5/16.
 */
public class ImgEditPager extends FragmentStatePagerAdapter
{
    public ImgEditPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment frag=null;
        switch (position){
            case 0:
                frag=new CanvasFragment();
                break;
            case 1:
                frag=new PreviewFragment();
                break;
        }
        return frag;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position)
        {
            case 0:
                title="CANVAS";
                break;
            case 1:
                title="PREVIEW";
                break;
        }
        return title;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

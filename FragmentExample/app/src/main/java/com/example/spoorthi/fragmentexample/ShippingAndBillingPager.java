package com.example.spoorthi.fragmentexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by spoorthi on 27/5/16.
 */
public class ShippingAndBillingPager extends FragmentStatePagerAdapter
{
    public ShippingAndBillingPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment frag=null;
        switch (position){
            case 0:
                frag=new ShippingFragment();
                break;
            case 1:
                frag=new BillingFragment();
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
                title="SHIPPING";
                break;
            case 1:
                title="BILLING";
                break;
        }
        return title;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

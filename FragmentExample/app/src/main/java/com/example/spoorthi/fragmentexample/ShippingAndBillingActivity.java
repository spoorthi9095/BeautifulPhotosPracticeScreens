package com.example.spoorthi.fragmentexample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ShippingAndBillingActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_and_billing);

        toolbar = (Toolbar) findViewById(R.id.SB_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout)findViewById(R.id.SB_tab_layout);
        viewPager = (ViewPager)findViewById(R.id.SB_view_pager);

        FragmentManager manager=getSupportFragmentManager();

        //object of PagerAdapter passing fragment manager object as a parameter of constructor of PagerAdapter class.
        ShippingAndBillingPager adapter=new ShippingAndBillingPager(manager);

        //set Adapter to view pager
        viewPager.setAdapter(adapter);
        //set tablayout with viewpager
        tabLayout.setupWithViewPager(viewPager);

        // adding functionality to tab and viewpager to manage each other when a page is changed or when a tab is selected
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Setting tabs from adpater
        //tabLayout.setTabsFromPagerAdapter(adapter);

        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Address");
    }
}

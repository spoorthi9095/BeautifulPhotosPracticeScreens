package com.example.spoorthi.fragmentexample;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

public class ImageEditing extends AppCompatActivity
{

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    CoordinatorLayout coordinatorLayout;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_editing);

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.collageEditCoordinate);

        toolbar = (Toolbar) findViewById(R.id.collageEdittoolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout)findViewById(R.id.collageEdit_tab_layout);
        viewPager = (ViewPager)findViewById(R.id.collageEdit_view_pager);

        FragmentManager manager=getSupportFragmentManager();

        //object of PagerAdapter passing fragment manager object as a parameter of constructor of PagerAdapter class.
        ImgEditPager adapter=new ImgEditPager(manager);

        //set Adapter to view pager
        viewPager.setAdapter(adapter);
        //set tablayout with viewpager
        tabLayout.setupWithViewPager(viewPager);

        // adding functionality to tab and viewpager to manage each other when a page is changed or when a tab is selected
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Setting tabs from adpater
        tabLayout.setTabsFromPagerAdapter(adapter);

        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.bottom_menu, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.item1:
                        Snackbar.make(coordinatorLayout, "Recent Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.item2:
                        Snackbar.make(coordinatorLayout, "Favorite Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.item3:
                        Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.item4:
                        Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                }
            }
        });

        b1 = (Button)findViewById(R.id.IE_nextBtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(ImageEditing.this,Main2Activity.class);
                startActivity(i1);
            }
        });

    }
}

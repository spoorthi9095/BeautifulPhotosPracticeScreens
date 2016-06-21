package com.example.spoorthi.fragmentexample;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SquareFragment extends Fragment {

    ArrayList<BeanSquare> arr = new ArrayList<BeanSquare>();
    AdapterSquare as;
    ListView lv;
    Button b1;
    Context context;

    public SquareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v1 = inflater.inflate(R.layout.fragment_square,container,false);
        lv = (ListView)v1.findViewById(R.id.sizeList);
        String[] photoSize = new String[] { "8x8",
                "10x10",
                "12x12",
                "14x14",
                "16x16",
                "20x20" };
        String[] cost = new String[]{"Rs.55","Rs.90","Rs.130","Rs.295","Rs.385","Rs.595"};

        int i;
        for(i=0;i<cost.length;i++)
        {
            BeanSquare sq = new BeanSquare();

            sq.setPhotoSize(photoSize[i]);
            sq.setCost(cost[i]);

            arr.add(sq);
        }

        as = new AdapterSquare(getActivity(),arr);
        lv.setAdapter(as);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                as.setSelectedIndex(i);
                as.notifyDataSetChanged();

                Fragment  frag = new AnotherSquareFragment();
                FrameLayout fl = (FrameLayout) v1.findViewById(R.id.square);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.square, frag);
                fragmentTransaction.addToBackStack(fl.toString());
                fragmentTransaction.commit();
            }
        });
       /* b1 = (Button)v1.findViewById(R.id.nextButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Fragment  frag = new AnotherSquareFragment();
                FrameLayout fl = (FrameLayout) v1.findViewById(R.id.square);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.square, frag);
                fragmentTransaction.addToBackStack(fl.toString());
                fragmentTransaction.commit();
            }
        });*/
        return v1;
    }



}

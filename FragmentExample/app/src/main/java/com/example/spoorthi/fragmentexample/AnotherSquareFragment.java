package com.example.spoorthi.fragmentexample;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnotherSquareFragment extends Fragment {

    GridView gv;
    Context context;
    FrameAdapter fa;

    public AnotherSquareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v1 = inflater.inflate(R.layout.fragment_another_square, container, false);
        final int [] frameImages={R.drawable.square1,
                R.drawable.square2,
                R.drawable.square3,
                R.drawable.square4,
                R.drawable.square5,
                R.drawable.square6,
                R.drawable.square7,
                R.drawable.square8,
                R.drawable.square9,
                R.drawable.square10,
                R.drawable.square11,
                R.drawable.square12
        };

        final int [] selectedFrames = {R.drawable.square1_red,
                R.drawable.square2_red,
                R.drawable.square3_red,
                R.drawable.square4_red,
                R.drawable.square5_red,
                R.drawable.square6_red,
                R.drawable.square7_red,
                R.drawable.square8_red,
                R.drawable.square9_red,
                R.drawable.square10_red,
                R.drawable.square11_red,
                R.drawable.square12_red
        };

         fa = new FrameAdapter(getActivity(),frameImages);
        gv = (GridView)v1.findViewById(R.id.gridView);
        gv.setAdapter(fa);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent = new Intent(getActivity(),ImageEditing.class);
                startActivity(intent);
            }
        });

        return v1;
    }

}

package com.example.spoorthi.fragmentexample;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckoutFragment extends Fragment {

    Button checkout;

    public CheckoutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v1 = inflater.inflate(R.layout.fragment_checkout, container, false);

        checkout = (Button)v1.findViewById(R.id.chekout_btn);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),ShippingAndBillingActivity.class);
                startActivity(i);
            }
        });

        return v1;
    }

}

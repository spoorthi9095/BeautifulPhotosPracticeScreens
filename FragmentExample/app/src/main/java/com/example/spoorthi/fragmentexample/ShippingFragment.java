package com.example.spoorthi.fragmentexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShippingFragment extends Fragment {

    String[] shippingAddList = {"John Smith"+"\n123, New Street"+"\nNew Church Street, City-590001"+"\nMobile:+91-9999999999","John Smith"+"\n123, New Street"+"\nNew Church Street, City-590001"+"\nMobile:+91-9999999999"};
    String[] addressList = {"Name","Mobile no.","Address","City","PinCode","Email"};
    ArrayList<BeanShippingAddress> arr = new ArrayList<BeanShippingAddress>();
    ArrayList<BeanShippingAddress> arr2 = new ArrayList<BeanShippingAddress>();
    ShippingAddressAdapter as;
    AddingAddressAdapter as2;
    ListView lv,lv2;

    public ShippingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v1 = inflater.inflate(R.layout.fragment_shipping, container, false);
        lv = (ListView)v1.findViewById(R.id.shippingAddressList);
        lv2 = (ListView)v1.findViewById(R.id.addingAddressFields);

        int i = 0;
        for(i=0;i<shippingAddList.length;i++)
        {
            BeanShippingAddress bean = new BeanShippingAddress();
            bean.setName(shippingAddList[i]);

            arr.add(bean);
        }
        as = new ShippingAddressAdapter(getActivity(),arr);
        lv.setAdapter(as);


       for(i=0;i<addressList.length;i++)
        {
            BeanShippingAddress bean = new BeanShippingAddress();
            bean.setName(addressList[i]);

            arr2.add(bean);
        }

        as2 = new AddingAddressAdapter(getActivity(),arr2);
        lv2.setAdapter(as2);

        return v1;
    }

}

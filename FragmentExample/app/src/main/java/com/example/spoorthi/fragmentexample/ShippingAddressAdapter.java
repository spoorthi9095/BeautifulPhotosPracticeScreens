package com.example.spoorthi.fragmentexample;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by spoorthi on 27/5/16.
 */
public class ShippingAddressAdapter extends BaseAdapter
{
    Context mContext;
    ArrayList<BeanShippingAddress> addList = new ArrayList<BeanShippingAddress>();
    LayoutInflater inflater;
    int selectedIndex;
    int mResourceId = 0;
    RadioButton mSelectedRB;
    int mSelectedPosition = -1;


    public ShippingAddressAdapter(Context mContext, ArrayList<BeanShippingAddress> addList) {
        this.mContext = mContext;
        this.addList = addList;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }
    @Override
    public int getCount() {
        return addList.size();
    }

    @Override
    public Object getItem(int i) {
        return addList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder
    {
        RadioButton tv;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup)
    {
        final Holder holder;
        view = null;
        View rowView = view;
        if (rowView==null)
        {
            inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.shipping_address_list,viewGroup,false);
        }
        holder = new Holder();
        holder.tv = (RadioButton) rowView.findViewById(R.id.address1);

        BeanShippingAddress bean = addList.get(i);
        holder.tv.setText(bean.getName());

        /*if(i == selectedIndex)
        {
            //ivv.setVisibility(View.VISIBLE);

        }
        else {
            ivv.setVisibility(View.INVISIBLE);
        }*/

        holder.tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i!= mSelectedPosition && mSelectedRB != null){
                    mSelectedRB.setChecked(false);
                }

                mSelectedPosition = i;
                mSelectedRB = (RadioButton)view;
            }
        });

        if(mSelectedPosition != i){
            holder.tv.setChecked(false);
        }else{
            holder.tv.setChecked(true);
            if(mSelectedRB != null && holder.tv != mSelectedRB){
                mSelectedRB = holder.tv;
            }
        }
        return rowView;
    }
}

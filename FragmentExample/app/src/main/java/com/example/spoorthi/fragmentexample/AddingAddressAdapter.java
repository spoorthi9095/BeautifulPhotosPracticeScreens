package com.example.spoorthi.fragmentexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by spoorthi on 28/5/16.
 */
public class AddingAddressAdapter extends BaseAdapter
{
    Context mContext;
    ArrayList<BeanShippingAddress> addList = new ArrayList<BeanShippingAddress>();
    LayoutInflater inflater;

    public AddingAddressAdapter(Context mContext, ArrayList<BeanShippingAddress> addList) {
        this.mContext = mContext;
        this.addList = addList;
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
        EditText editText;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        final Holder holder;
        view = null;
        View rowView = view;
        if (rowView==null)
        {
            inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.address_list_shipping,viewGroup,false);
        }
        holder = new Holder();
        holder.editText = (EditText) rowView.findViewById(R.id.name);

        BeanShippingAddress bean = addList.get(i);
        holder.editText.setHint(bean.getName());

        return rowView;
    }
}

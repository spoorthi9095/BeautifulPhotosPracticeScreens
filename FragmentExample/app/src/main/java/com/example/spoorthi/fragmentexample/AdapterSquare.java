package com.example.spoorthi.fragmentexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by spoorthi on 17/5/16.
 */
public class AdapterSquare extends BaseAdapter
{
    Context mContext;
    ArrayList<BeanSquare> sqareList = new ArrayList<BeanSquare>();
    LayoutInflater inflater;
    int selectedIndex;
    ImageView ivv;

    public AdapterSquare(Context mContext, ArrayList<BeanSquare> sqList)
    {
        this.mContext = mContext;

        sqareList=sqList;
    }

    @Override
    public int getCount()
    {
        return sqareList.size();
    }

    @Override
    public Object getItem(int i) {
        return sqareList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public class Holder
    {
        TextView size;
        TextView cost;
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
            rowView = inflater.inflate(R.layout.cell_square,viewGroup,false);
        }
        holder = new Holder();
        holder.size = (TextView)rowView.findViewById(R.id.squareSize);
        holder.cost = (TextView)rowView.findViewById(R.id.squareCost);
        ivv = (ImageView)rowView.findViewById(R.id.tick);

        if(i == selectedIndex)
        {
            ivv.setVisibility(View.VISIBLE);
        }
        else {
            ivv.setVisibility(View.INVISIBLE);
        }

        BeanSquare sqBean = sqareList.get(i);
        holder.size.setText(sqBean.getPhotoSize());
        holder.cost.setText(sqBean.getCost());

        return rowView;
    }
}

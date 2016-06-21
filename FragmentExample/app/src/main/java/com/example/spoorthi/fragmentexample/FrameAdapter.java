package com.example.spoorthi.fragmentexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by spoorthi on 20/5/16.
 */
public class FrameAdapter extends BaseAdapter
{
    int[] imageId;

    Context mContext;
    LayoutInflater inflater;

    public FrameAdapter(Context mContext, int[] imgId)
    {
        this.mContext = mContext;
        imageId = imgId;
    }

    @Override
    public int getCount()
    {
        return imageId.length;
    }

    @Override
    public Object getItem(int i)
    {
        return imageId[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder
    {
        ImageView iv;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        Holder holder=new Holder();
        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView;

        rowView = inflater.inflate(R.layout.frames_square, null);

        holder.iv=(ImageView) rowView.findViewById(R.id.img_frame);

        holder.iv.setImageResource(imageId[i]);
        return rowView;
    }
}

package com.android.callbackexam;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment{
    private OnColorSelectedListener mListener;
    @Override
    public void onViewCreated(View view, Bundle SaveInstanceState){
        super.onViewCreated(view,SaveInstanceState);
        List<String> colorList = Arrays.asList("Red","Green","Blue");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,colorList);
        setListAdapter(adapter);
    }


    interface OnColorSelectedListener{
        void onColorSelected(int color);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            mListener = (OnColorSelectedListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(((Activity)context).getLocalClassName()+" 구현해야됨");
        }
    }

    public void setOnColorSelectedListener(OnColorSelectedListener listener){
        mListener = listener;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        ArrayAdapter<String> adapter = (ArrayAdapter<String>)l.getAdapter();
        String colorString = adapter.getItem(position);
        int color = Color.RED;
        switch(colorString){
            case"Red":
                color = Color.RED;
                break;
            case "Green":
                color = Color.GREEN;
                break;
            case "Blue":
                color = Color.BLUE;
                break;

        }
        if(mListener != null){
            mListener.onColorSelected(color);
        }


    }
}

package com.example.qhsj.indexesviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

/**
 * Created by Chris on 2017/7/11.
 */
public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private MainActivity mAct;

    public MyAdapter(Context context){
        this.mContext = context;
        this.mAct = (MainActivity)context;
    }

    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder ;
        if (convertView == null){
            convertView = mAct.getLayoutInflater().inflate(R.layout.item,null,false);
            holder = new MyHolder();
        }else {

        }
        return null;
    }

    class MyHolder {

    }
}

package com.hngy.rjxh.artifactforcar.Activity_Setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hngy.rjxh.artifactforcar.R;

import java.util.LinkedList;

/**
 * Created by 57677 on 2018/6/27.
 */

public class setting_Activity_Adapter extends BaseAdapter {

    private LinkedList<modul_1> mData;
    private Context mContext;

    public setting_Activity_Adapter(LinkedList<modul_1> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_setting_tiem, parent, false);

//        convertView = View.inflate(mContext, R.layout.activity_setting_tiem, parent);
        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView content = (TextView) convertView.findViewById(R.id.content);
        content.setText(mData.get(position).getText());
        return convertView;
    }


}

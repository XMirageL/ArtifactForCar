package com.hngy.rjxh.artifactforcar.Activity_Setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hngy.rjxh.artifactforcar.R;

import java.util.List;

/**
 * Created by 57677 on 2018/6/28.
 */

public class setting3_yuyinbao_Adapter extends BaseAdapter {
    private List<setting_info> mList;
    private Context mContext;

    public setting3_yuyinbao_Adapter(List<setting_info> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_setting3_item, null);
      if (convertView != null){
          TextView Textview1 = (TextView) convertView.findViewById(R.id.textView2);
          ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
          Textview1.setText(mList.get(position).getText());
          imageView.setBackgroundResource(mList.get(position).getImage());
      }
        return convertView;
    }
}

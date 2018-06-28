package com.hngy.rjxh.artifactforcar.Activity_Setting;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.hngy.rjxh.artifactforcar.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class setting_Activity extends AppCompatActivity {

    private Switch switch_1_1;
    private SeekBar seekBar;
    private SeekBar seekBar3;
    private SeekBar seekBar4;
    private TextView tv_seekBar;
    private TextView tv_seekBar3;
    private TextView tv_seekBar4;
    private RelativeLayout rl_1;
    private RelativeLayout rl_2;
    private RelativeLayout rl_3;
    private CheckBox checkBox;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("软件设置");
//            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        rl_1 = (RelativeLayout) findViewById(R.id.rl_1);
        rl_2 = (RelativeLayout) findViewById(R.id.rl_2);
        rl_3 = (RelativeLayout) findViewById(R.id.rl_3);
        final ListView list_set = (ListView) findViewById(R.id.list_set);
        LinkedList<modul_1> mData = new LinkedList<>();
        mData.add(new modul_1("1","报警阈值设置"));
        mData.add(new modul_1("2","警护联系电话设置"));
        mData.add(new modul_1("3","语言播报设置"));
        mData.add(new modul_1("4","设备检测"));
        mData.add(new modul_1("5","关于"));
        final setting_Activity_Adapter mAdapter = new setting_Activity_Adapter((LinkedList<modul_1>) mData,getApplicationContext());
        list_set.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (((ListView)parent).getTag() != null){
                    ((View)((ListView)parent).getTag()).setBackgroundDrawable(null);
                }
                ((ListView)parent).setTag(view);
                view.setBackgroundColor(Color.rgb(211,211,211));
                if (position == 0){
                    rl_1.setVisibility(View.VISIBLE);
                    rl_2.setVisibility(View.INVISIBLE);
                    rl_3.setVisibility(View.INVISIBLE);
                } else if (position == 1){
                    rl_2.setVisibility(View.VISIBLE);
                    rl_1.setVisibility(View.INVISIBLE);
                    rl_3.setVisibility(View.INVISIBLE);
                } else if (position == 2){
                    rl_3.setVisibility(View.VISIBLE);
                    rl_2.setVisibility(View.INVISIBLE);
                    rl_1.setVisibility(View.INVISIBLE);
                }
            }
        });
        list_set.setAdapter(mAdapter);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                list_set.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        list_set.getChildAt(0).setBackgroundColor(Color.rgb(211,211,211));
//                    }
//                });
//            }
//        },500);

        spinner = (Spinner) findViewById(R.id.spinner);
        List<setting_info> mData_3 = new ArrayList<setting_info>();
        mData_3.add(new setting_info("林志玲",R.mipmap.touxiang_lizhiling));
        mData_3.add(new setting_info("王俊凯",R.mipmap.touxiang_wangjunkai));
        mData_3.add(new setting_info("罗永浩",R.mipmap.touxiang_luoyonghao));
        mData_3.add(new setting_info("大师兄",R.mipmap.touxiang_dashixiong));
        setting3_yuyinbao_Adapter adapter_3 = new setting3_yuyinbao_Adapter(mData_3,getApplicationContext());
        spinner.setAdapter(adapter_3);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                } else {
                    if (!checkBox1.isChecked() && !checkBox2.isChecked()){
                        checkBox.setChecked(true);
                        Toast.makeText(getApplicationContext(), "必须选中一项",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBox.setChecked(false);
                    checkBox2.setChecked(false);
                }else {
                    if (!checkBox.isChecked() && !checkBox2.isChecked()){
                        checkBox1.setChecked(true);
                        Toast.makeText(getApplicationContext(), "必须选中一项",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBox1.setChecked(false);
                    checkBox.setChecked(false);
                }else {
                    if (!checkBox1.isChecked() && !checkBox.isChecked()){
                        checkBox2.setChecked(true);
                        Toast.makeText(getApplicationContext(), "必须选中一项",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        tv_seekBar = (TextView) findViewById(R.id.textView5);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_seekBar.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        tv_seekBar3 = (TextView) findViewById(R.id.textView7);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_seekBar3.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        tv_seekBar4 = (TextView) findViewById(R.id.textView9);
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_seekBar4.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        switch_1_1 = (Switch) findViewById(R.id.switch_1_1);
        switch_1_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    seekBar.setEnabled(true);
                    seekBar3.setEnabled(true);
                    seekBar4.setEnabled(true);
                } else {
                    seekBar.setEnabled(false);
                    seekBar3.setEnabled(false);
                    seekBar4.setEnabled(false);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

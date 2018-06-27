package com.hngy.rjxh.artifactforcar.Activity_Setting;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ListView;

import com.hngy.rjxh.artifactforcar.R;

import java.util.LinkedList;

public class setting_Activity extends AppCompatActivity {

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

        ListView list_set = (ListView) findViewById(R.id.list_set);
        LinkedList<modul_1> mData = new LinkedList<>();
        mData.add(new modul_1("1","报警阈值设置"));
        mData.add(new modul_1("2","警护联系电话设置"));
        mData.add(new modul_1("3","语言播报设置"));
        mData.add(new modul_1("4","设备检测"));
        mData.add(new modul_1("5","关于"));
        setting_Activity_Adapter mAdapter = new setting_Activity_Adapter((LinkedList<modul_1>) mData,getApplicationContext());
        list_set.setAdapter(mAdapter);
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

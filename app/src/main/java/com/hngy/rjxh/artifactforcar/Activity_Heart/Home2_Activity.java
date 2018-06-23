package com.hngy.rjxh.artifactforcar.Activity_Heart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.hngy.rjxh.artifactforcar.Activity_Heart.dummy.DummyContent;
import com.hngy.rjxh.artifactforcar.R;
import com.hngy.rjxh.artifactforcar.rewrite.CircleProgressBar;

/**
 * Created by 57677 on 2018/6/22.
 */

public class Home2_Activity extends AppCompatActivity  {
    private CircleProgressBar color_progress_view;
    private CircleProgressBar color_progress_view1;
    private RelativeLayout rl_xieya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2_activty);

        Intent intent = getIntent();//获取传来的intent对象
        String data = intent.getStringExtra("frag_Id");//获取键值对的键名
        switch (data){
            case "1":
                getSupportFragmentManager().beginTransaction().replace(R.id.home2_main, new Heart_Fragment())
                        .commit();
                break;
            case "2":
                getSupportFragmentManager().beginTransaction().replace(R.id.home2_main, new Xieya_Fragment())
                        .commit();
                break;
            case "3":
                getSupportFragmentManager().beginTransaction().replace(R.id.home2_main, new Tz_Fragment())
                        .commit();
                break;
            case "4":
                break;
        }
    }

}

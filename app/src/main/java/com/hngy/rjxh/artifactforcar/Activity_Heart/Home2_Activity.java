package com.hngy.rjxh.artifactforcar.Activity_Heart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.hngy.rjxh.artifactforcar.R;
import com.hngy.rjxh.artifactforcar.rewrite.CircleProgressBar;

/**
 * Created by 57677 on 2018/6/22.
 */

public class Home2_Activity extends AppCompatActivity {
    private CircleProgressBar color_progress_view;
    private CircleProgressBar color_progress_view1;
    private RelativeLayout rl_xieya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2_activty);
        getSupportFragmentManager().beginTransaction().replace(R.id.home2_main, new Heart_Activity())
                .commit();
    }

}

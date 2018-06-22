package com.hngy.rjxh.artifactforcar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.hngy.rjxh.artifactforcar.Activity_Heart.Heart_Activity;
import com.hngy.rjxh.artifactforcar.fragment.HomeFragment;
import com.hngy.rjxh.artifactforcar.fragment.ShowDatasFragment;
import com.hngy.rjxh.artifactforcar.model.SensorDataBean;
import com.hngy.rjxh.artifactforcar.presenter.MainPresenter;
import com.hngy.rjxh.artifactforcar.view.IMainView;
import com.wang.avi.AVLoadingIndicatorView;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    private ShowDatasFragment showDatasFragment;
    private MainPresenter mPresenter;
    private Button btn_start;
    private AVLoadingIndicatorView loadingIndicatorView;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Utils.init(MainActivity.this);
        initView();
    }


    private void initView() {
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_frame, new HomeFragment())
                        .commit();
            }
        });
    }


//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn_start://实例化Presenter
//                mPresenter = new MainPresenter(this);
//                mPresenter.fetch(); break;
//        }
//    }
//
//    @Override
//    public void showLoading() {
//        loadingIndicatorView.setIndicatorColor(Color.RED);
//        ToastUtils.showShort("正在体检");
//    }

//    @Override
//    public void showData(SensorDataBean sensorDataBean) {
//        mFragmentTransaction = mFragmentManager.beginTransaction();
//        showDatasFragment = new ShowDatasFragment();
//        homeFragment = new HomeFragment();
//        showDatasFragment.setDataBean(sensorDataBean);
//        mFragmentTransaction.add(R.id.fl_container,homeFragment);
//        //提交事务，调用commit方法提交。
//        mFragmentTransaction.commit();
//    }
}
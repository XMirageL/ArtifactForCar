package com.hngy.rjxh.artifactforcar;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.hngy.rjxh.artifactforcar.Activity_Heart.More_Fragment;
import com.hngy.rjxh.artifactforcar.Activity_Heart.dummy.DummyContent;
import com.hngy.rjxh.artifactforcar.fragment.HomeFragment;
import com.hngy.rjxh.artifactforcar.fragment.ShowDatasFragment;
import com.hngy.rjxh.artifactforcar.presenter.MainPresenter;
import com.wang.avi.AVLoadingIndicatorView;

public class MainActivity extends AppCompatActivity  {

    public static boolean useThemestatusBarColor = true;//是否使用特殊的标题栏背景颜色，android5
    // .0以上可以设置状态栏背景色，如果不使用则使用透明色值
    public static boolean useStatusBarColor = false;//是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6
    // .0以上可以设置

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

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
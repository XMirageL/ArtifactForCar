package com.hngy.rjxh.artifactforcar.presenter;

import com.hngy.rjxh.artifactforcar.model.IMainModel;
import com.hngy.rjxh.artifactforcar.model.MainModelImpl;
import com.hngy.rjxh.artifactforcar.model.SensorDataBean;
import com.hngy.rjxh.artifactforcar.view.IMainView;

public class MainPresenter {
    private IMainModel mModel;
    private IMainView mView;

    public MainPresenter(IMainView view) {
        mModel = new MainModelImpl();
        mView = view;
    }

    public void fetch() {
        mView.showLoading();
        mModel.loadData(new IMainModel.OnLoadCompleteListener() {
            @Override
            public void onComplete(SensorDataBean sensorDataBean) {
                mView.showData(sensorDataBean);
            }

        });
    }
}

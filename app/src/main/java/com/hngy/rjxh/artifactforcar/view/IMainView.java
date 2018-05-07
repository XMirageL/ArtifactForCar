package com.hngy.rjxh.artifactforcar.view;

import com.hngy.rjxh.artifactforcar.model.SensorDataBean;

public interface IMainView {
    void showLoading();
    void showData(SensorDataBean sensorDataBean);
}

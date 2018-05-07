package com.hngy.rjxh.artifactforcar.model;

public class MainModelImpl implements IMainModel {

    @Override
    public void loadData(OnLoadCompleteListener listener) {
        SensorDataBean sensorDataBean = new SensorDataBean(38.33, 50.52, 72.65, 70.25,
                100.21, 3.51, 1.12, 1.01, 2.01);
        listener.onComplete(sensorDataBean);
    }
}

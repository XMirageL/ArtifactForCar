package com.hngy.rjxh.artifactforcar.model;

public interface IMainModel {
    void loadData(OnLoadCompleteListener listener);
    interface OnLoadCompleteListener{
        void onComplete(SensorDataBean sensorDataBean);
    }
}

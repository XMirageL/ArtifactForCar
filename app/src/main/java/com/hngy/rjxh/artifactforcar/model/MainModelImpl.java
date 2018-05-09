package com.hngy.rjxh.artifactforcar.model;

public class MainModelImpl implements IMainModel {

    @Override
    public void loadData(final OnLoadCompleteListener listener){
        final SensorDataBean sensorDataBean = new SensorDataBean(38.33, 50.52, 72.65, 70.25,
                100.21, 3.51, 1.12, 1.01, 2.01);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                listener.onComplete(sensorDataBean);
            }
        }).start();

    }
}

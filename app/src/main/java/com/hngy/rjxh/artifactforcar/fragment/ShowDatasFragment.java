package com.hngy.rjxh.artifactforcar.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hngy.rjxh.artifactforcar.R;
import com.hngy.rjxh.artifactforcar.model.SensorDataBean;


public class ShowDatasFragment extends Fragment {
    private TextView vT,vBW,vP,vBP,vBFTC,vBFTG,vBFHD,vBFLD;
    private SensorDataBean dataBean = null;

    public void setDataBean(SensorDataBean dataBean) {
        this.dataBean = dataBean;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_show_datas, container, false);
        vT = (TextView)v.findViewById(R.id.tv_vT);
        vBW = (TextView)v.findViewById(R.id.tv_vBW);
        vP= (TextView)v.findViewById(R.id.tv_vP);
        vBP = (TextView)v.findViewById(R.id.tv_vBP);
        vBFTC = (TextView)v.findViewById(R.id.tv_vBFTC );
        vBFTG = (TextView)v.findViewById(R.id.tv_vBFTG);
        vBFHD = (TextView)v.findViewById(R.id.tv_vBFHD);
        vBFLD = (TextView)v.findViewById(R.id.tv_vBFLD);

        if(dataBean != null){
            vT.setText(dataBean.getData("T"));
            vBW.setText(dataBean.getData("BW"));
            vP.setText(dataBean.getData("P"));
            vBP.setText(dataBean.getData("BP"));
            vBFTC.setText(dataBean.getData("BFTC"));
            vBFTG.setText(dataBean.getData("BFTG"));
            vBFHD.setText(dataBean.getData("BFHD"));
            vBFLD.setText(dataBean.getData("BFLD"));
        }
        return v;
    }

}


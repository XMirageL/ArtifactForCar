package com.hngy.rjxh.artifactforcar.Activity_Heart;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hngy.rjxh.artifactforcar.R;
import com.hngy.rjxh.artifactforcar.rewrite.CircleProgressBar;

public class Heart_Activity extends Fragment {
    private View view;
    private View view1;
    private TextView fanhui_cancel;
    private CircleProgressBar color_progress_view;
    private CircleProgressBar color_progress_view1;
    private RelativeLayout rl_xieya;

    public Heart_Activity(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_heart_, container, false);
        view1 = inflater.inflate(R.layout.home2_activty, container, false);
        bindviews();
        return view;
    }

    private void bindviews() {
        fanhui_cancel = (TextView) view.findViewById(R.id.textView17);
        fanhui_cancel.bringToFront();
        fanhui_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        color_progress_view  = (CircleProgressBar) view.findViewById(R.id.point_main);
        color_progress_view.setMaxStepNum(100);
        color_progress_view.update(90,1000);
        color_progress_view1  = (CircleProgressBar) view.findViewById(R.id.point_main1);
        color_progress_view1.setMaxStepNum(100);
        color_progress_view1.update(50,1000);
        rl_xieya = (RelativeLayout) view.findViewById(R.id.rl8);
        rl_xieya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.home2_main, new Xieya_Fragment())
                        .commit();
            }
        });
    }
}

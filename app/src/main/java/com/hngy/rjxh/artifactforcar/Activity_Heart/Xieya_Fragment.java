package com.hngy.rjxh.artifactforcar.Activity_Heart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hngy.rjxh.artifactforcar.R;
import com.hngy.rjxh.artifactforcar.rewrite.CircleProgressBar;

/**
 * Created by 57677 on 2018/6/22.
 */

public class Xieya_Fragment extends Fragment {

    private View view;
    private TextView fanhui_cancel;
    private CircleProgressBar color_progress_view;
    private CircleProgressBar color_progress_view1;
    private CircleProgressBar color_progress_view2;

    public Xieya_Fragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_xieya, container, false);
        bindViews();
        return view;
    }

    private void bindViews() {

        fanhui_cancel = (TextView) view.findViewById(R.id.textView17);
        fanhui_cancel.bringToFront();
        fanhui_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        color_progress_view2  = (CircleProgressBar) view.findViewById(R.id.point_main2);
        color_progress_view2.setMaxStepNum(100);
        color_progress_view2.update(90,1000);
        color_progress_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.home2_main, new Heart_Activity())
                        .commit();
            }
        });

        color_progress_view  = (CircleProgressBar) view.findViewById(R.id.point_main);
        color_progress_view.setMaxStepNum(100);
        color_progress_view.update(50,1000);

        color_progress_view1  = (CircleProgressBar) view.findViewById(R.id.point_main1);
        color_progress_view1.setMaxStepNum(100);
        color_progress_view1.update(60,1000);

    }
}

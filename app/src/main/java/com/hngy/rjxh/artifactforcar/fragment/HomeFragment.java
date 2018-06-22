package com.hngy.rjxh.artifactforcar.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hngy.rjxh.artifactforcar.Activity_Heart.Heart_Activity;
import com.hngy.rjxh.artifactforcar.Activity_Heart.Home2_Activity;
import com.hngy.rjxh.artifactforcar.MainActivity;
import com.hngy.rjxh.artifactforcar.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private Button btn_start;
    private LinearLayout ll_heart;


    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        btn_start = (Button) view.findViewById(R.id.btn_start);
        ll_heart = (LinearLayout) view.findViewById(R.id.ll11);
        ll_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Home2_Activity.class);
                startActivity(intent);
            }
        });
    }

}
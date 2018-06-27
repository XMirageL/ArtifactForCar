package com.hngy.rjxh.artifactforcar.fragment;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.hngy.rjxh.artifactforcar.Activity_Heart.Home2_Activity;
import com.hngy.rjxh.artifactforcar.Activity_Heart.More_Fragment;
import com.hngy.rjxh.artifactforcar.Activity_Setting.setting_Activity;
import com.hngy.rjxh.artifactforcar.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private Button btn_start;
    private LinearLayout ll_heart, ll_xieya, ll_tz, ll_more;

    private RadarChart mChart;
    private TextView tv_healthy_point;
    private TextView tv_heart_mes;
    private TextView tv_xieya_mes;
    private TextView tv_weight_mes;
    private TextView tv_suggest_mes;
    private CardView card1;
    private CardView card3;
    private ImageView imageView;

    public HomeFragment() {

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
//        card3 = (CardView) view.findViewById(R.id.card3);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Setting_ItemFragment().show(getFragmentManager(), "");
                Intent intent = new Intent(getContext(), setting_Activity.class);
                startActivity(intent);
            }
        });
        card1 = (CardView) view.findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ViewGroup.LayoutParams layoutParams = card1.getLayoutParams();
//                layoutParams
//                card3.setLayoutParams(layoutParams);
//                card3.bringToFront();
//                ObjectAnimator animator = ObjectAnimator.ofFloat(card1, "translationX", 0, 200);
//                ObjectAnimator animator1 = ObjectAnimator.ofFloat(card1, "translationY", 0, 200);
//                ObjectAnimator animator2 = ObjectAnimator.ofFloat(card1, "scaleX", 1f, 2f);
//                ObjectAnimator animator3 = ObjectAnimator.ofFloat(card1, "scaleY", 1f, 2f);
//
//                AnimatorSet set = new AnimatorSet();
//                set.setDuration(2500);
//                set.play(animator2).with(animator3).with(animator).with(animator1);
//                set.start();
            }
        });

        tv_healthy_point = (TextView) view.findViewById(R.id.tv_healthy_point);
        double num_1 = Math.random() * 100;
        tv_healthy_point.setText(String.format("%.0f",num_1));
        tv_heart_mes = (TextView) view.findViewById(R.id.tv_heart_mes);
        tv_heart_mes.setText(String.format("%.0f",Math.random() * 100));
        tv_xieya_mes = (TextView) view.findViewById(R.id.tv_xieya_mes);
        tv_xieya_mes.setText(String.format("%.0f",Math.random() * 100));
        tv_weight_mes = (TextView) view.findViewById(R.id.tv_weight_mes);
        tv_weight_mes.setText(String.format("%.0f",Math.random() * 100));

        tv_suggest_mes = (TextView) view.findViewById(R.id.tv_suggest_mes);
        String poi = tv_healthy_point.getText().toString();
        tv_suggest_mes.setText("哇赛，您的身体数据击败了全国"+String.format("%.0f",num_1)+"%的人哦！身体是革命的本钱，继续加油，勇往直前，进击！");

        btn_start = (Button) view.findViewById(R.id.btn_start);
        ll_heart = (LinearLayout) view.findViewById(R.id.ll11);
        ll_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent_from("1");
            }
        });
        ll_xieya = (LinearLayout) view.findViewById(R.id.ll12);
        ll_xieya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent_from("2");
            }
        });
        ll_tz = (LinearLayout) view.findViewById(R.id.ll13);
        ll_tz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent_from("3");
            }
        });
        ll_more = (LinearLayout) view.findViewById(R.id.ll14);
        ll_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new More_Fragment().show(getFragmentManager(), "");
            }
        });

        //MP表开始
        mChart = view.findViewById(R.id.chart1);
        mChart.setBackgroundColor(Color.rgb(230, 230, 250));

//        mChart.getDescription().setEnabled(false);

        mChart.setWebLineWidth(3f);
        Description description = new Description();
        description.setText("个人健康指标图");
        description.setTextSize(15f);
        mChart.setDescription(description);
        mChart.setWebColor(Color.BLACK);
        mChart.setWebLineWidthInner(3f);
        mChart.setWebColorInner(Color.BLACK);
        mChart.setWebAlpha(300);
        setData();

        mChart.animateXY(2400,2400);
        XAxis xAxis = mChart.getXAxis();
//        xAxis.setTypeface(mTfLight);
        xAxis.setTextSize(9f);
        xAxis.setYOffset(0f);
        xAxis.setXOffset(0f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private String[] mActivities = new String[]{"体重", "血压", "心率", "体脂", "水分"};

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mActivities[(int) value % mActivities.length];
            }
        });
        xAxis.setTextColor(Color.BLACK);

        YAxis yAxis = mChart.getYAxis();
//        yAxis.setTypeface(mTfLight);
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(9f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(80f);
        yAxis.setDrawLabels(false);

//        Legend l = mChart.getLegend();
//        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
//        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
//        l.setDrawInside(false);
////        l.setTypeface(mTfLight);
//        l.setXEntrySpace(17f);
//        l.setYEntrySpace(15f);
//        l.setTextColor(Color.WHITE);
    }

    private void Intent_from(String id) {
        Intent intent = new Intent(getContext(), Home2_Activity.class);
        intent.putExtra("frag_Id", id);
        startActivity(intent);
    }



    public void setData() {

        float mult = 80;
        float min = 20;
        int cnt = 5;

        ArrayList<RadarEntry> entries1 = new ArrayList<RadarEntry>();
        ArrayList<RadarEntry> entries2 = new ArrayList<RadarEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < cnt; i++) {
            float val1 = (float) (Math.random() * mult) + min;
            entries1.add(new RadarEntry(val1));

            float val2 = (float) (Math.random() * mult) + min;
            entries2.add(new RadarEntry(val2));
        }

        RadarDataSet set1 = new RadarDataSet(entries1, "上周");
        set1.setValueTextSize(8f);
        set1.setColor(Color.rgb(103, 110, 129));
        set1.setFillColor(Color.rgb(103, 110, 129));
        set1.setDrawFilled(true);
        set1.setFillAlpha(180);
        set1.setLineWidth(2f);
        set1.setDrawHighlightCircleEnabled(true);
        set1.setDrawHighlightIndicators(false);

        RadarDataSet set2 = new RadarDataSet(entries2, "这周");
        set1.setValueTextSize(8f);
        set2.setColor(Color.rgb(121, 162, 175));
        set2.setFillColor(Color.rgb(121, 162, 175));
        set2.setDrawFilled(true);
        set2.setFillAlpha(180);
        set2.setLineWidth(2f);
        set2.setDrawHighlightCircleEnabled(true);
        set2.setDrawHighlightIndicators(false);

        ArrayList<IRadarDataSet> sets = new ArrayList<IRadarDataSet>();
        sets.add(set1);
        sets.add(set2);

        RadarData data = new RadarData(sets);
//        data.setValueTypeface(mTfLight);
        data.setValueTextSize(8f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.BLACK);

        mChart.setData(data);
        for (IDataSet<?> set : mChart.getData().getDataSets())
            set.setDrawValues(!set.isDrawValuesEnabled());
        mChart.invalidate();
    }
}
package com.hngy.rjxh.artifactforcar.Activity_Heart;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Utils;
import com.hngy.rjxh.artifactforcar.MainActivity;
import com.hngy.rjxh.artifactforcar.R;
import com.hngy.rjxh.artifactforcar.rewrite.CircleProgressBar;

import java.util.ArrayList;

/**
 * Created by 57677 on 2018/6/22.
 */

public class Xieya_Fragment extends Fragment implements OnChartValueSelectedListener {


    private String sign_click = "";
    private LineChart mChart;
    private View view;
    private TextView fanhui_cancel;
    private CircleProgressBar color_progress_view;
    private CircleProgressBar color_progress_view1;
    private CircleProgressBar color_progress_view2;
    private ImageView img_left;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private ImageView img_right;

    public Xieya_Fragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_xieya, container, false);
        setTitle();
        bindViews();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sign_click.equals("right")){
                    ObjectAnimator animator = ObjectAnimator.ofFloat(color_progress_view, "translationX", 400f, 0);
                    ObjectAnimator animator3 = ObjectAnimator.ofFloat(color_progress_view, "scaleX", 0.5f, 1f);
                    ObjectAnimator animator4 = ObjectAnimator.ofFloat(color_progress_view, "scaleY", 0.5f, 1f);

                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(color_progress_view1, "translationX", 400f, 0);
                    ObjectAnimator animator5 = ObjectAnimator.ofFloat(color_progress_view1, "scaleX", 0.1f, 1f);
                    ObjectAnimator animator6 = ObjectAnimator.ofFloat(color_progress_view1, "scaleY", 0.1f, 1f);

                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(color_progress_view2, "translationX", 400f, 0);
                    ObjectAnimator animator7 = ObjectAnimator.ofFloat(color_progress_view2, "scaleX", 1.5f, 1f);
                    ObjectAnimator animator8 = ObjectAnimator.ofFloat(color_progress_view2, "scaleY", 1.5f, 1f);
                    AnimatorSet set = new AnimatorSet();
                    set.play(animator).with(animator1).with(animator2).with(animator3).with(animator4).with(animator5).with(animator6).with(animator7).with(animator8);
                    set.setDuration(2500);
                    set.start();
                } else {
                    ObjectAnimator animator = ObjectAnimator.ofFloat(color_progress_view, "translationX", -400f, 0);
                    ObjectAnimator animator3 = ObjectAnimator.ofFloat(color_progress_view, "scaleX", 0.5f, 1f);
                    ObjectAnimator animator4 = ObjectAnimator.ofFloat(color_progress_view, "scaleY", 0.5f, 1f);

                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(color_progress_view1, "translationX", -400f, 0);
                    ObjectAnimator animator5 = ObjectAnimator.ofFloat(color_progress_view1, "scaleX", 1.5f, 1f);
                    ObjectAnimator animator6 = ObjectAnimator.ofFloat(color_progress_view1, "scaleY", 1.5f, 1f);

                    ObjectAnimator animator2 = ObjectAnimator.ofFloat(color_progress_view2, "translationX", -400f, 0);
                    ObjectAnimator animator7 = ObjectAnimator.ofFloat(color_progress_view2, "scaleX", 0.1f, 1f);
                    ObjectAnimator animator8 = ObjectAnimator.ofFloat(color_progress_view2, "scaleY", 0.1f, 1f);
                    AnimatorSet set = new AnimatorSet();
                    set.play(animator).with(animator1).with(animator2).with(animator3).with(animator4).with(animator5).with(animator6).with(animator7).with(animator8);
                    set.setDuration(2500);
                    set.start();
                }

//                color_progress_view.startAnimation(left_3);
//                color_progress_view1.startAnimation(left_3);
//                color_progress_view.setVisibility(View.VISIBLE);
//                color_progress_view1.setVisibility(View.VISIBLE);
            }
        },50);
        return view;
    }

    private void bindViews() {
        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        sign_click = preferences.getString("sign_click", "");

        fanhui_cancel = (TextView) view.findViewById(R.id.textView17);
        fanhui_cancel.bringToFront();
        fanhui_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        color_progress_view2 = (CircleProgressBar) view.findViewById(R.id.point_main2);
        color_progress_view2.setMaxStepNum(100);
        color_progress_view2.update(90, 1000);
        color_progress_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.home2_main, new Heart_Fragment())
                        .commit();
            }
        });

        color_progress_view = (CircleProgressBar) view.findViewById(R.id.point_main);
        color_progress_view.setMaxStepNum(100);
        color_progress_view.update(50, 1000);

        color_progress_view1 = (CircleProgressBar) view.findViewById(R.id.point_main1);
        color_progress_view1.setMaxStepNum(100);
        color_progress_view1.update(60, 1000);
        color_progress_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.home2_main, new Tz_Fragment())
                        .commit();
            }
        });

        img_left = (ImageView) view.findViewById(R.id.imageView4);
        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.home2_main, new Heart_Fragment())
                        .commit();
            }
        });
        img_right = (ImageView) view.findViewById(R.id.imageView3);
        img_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.home2_main, new Tz_Fragment())
                        .commit();
                editor = preferences.edit();
                editor.putString("sign_click", "right");
                editor.apply();
            }
        });

        //MP线表开始
        mChart = view.findViewById(R.id.chart1);
        mChart.setOnChartValueSelectedListener(this);
        mChart.getDescription().setEnabled(false);
        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);

//        mChart.setDraw(false);

        mChart.setDrawGridBackground(false);

        XAxis xAxis = mChart.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        //xAxis.setValueFormatter(new MyCustomXAxisValueFormatter());
        //xAxis.addLimitLine(llXAxis); // add x-axis limit line

        LimitLine ll1 = new LimitLine(80f, "标准上限");
        ll1.setLineWidth(2f);
        ll1.setLineColor(Color.GRAY);
        ll1.enableDashedLine(10f, 10f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        ll1.setTextSize(10f);
//        ll1.setTypeface(tf);

        LimitLine ll2 = new LimitLine(40f, "标准下限");
        ll2.setLineWidth(2f);
        ll2.setLineColor(Color.GRAY);
        ll2.enableDashedLine(10f, 10f, 0f);
        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        ll2.setTextSize(10f);
//        ll2.setTypeface(tf);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.addLimitLine(ll1);
        leftAxis.addLimitLine(ll2);
        leftAxis.setAxisMaximum(200f);
        leftAxis.setAxisMinimum(-50f);
        //leftAxis.setYOffset(20f);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);

        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);

        mChart.getAxisRight().setEnabled(false);

        //数据插入在此
        setData(10, 50);

        //出场动画 (X轴动画时间,Y轴动画时间)
        mChart.animateXY(3000, 3000);
        //mChart.invalidate();

        // get the legend (only possible after setting data)
        Legend l = mChart.getLegend();

        // modify the legend ...
        l.setForm(Legend.LegendForm.LINE);

    }

    private void setData(int count, float range) {

        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {

            float val = (float) (Math.random() * range) + 3;
//            values.add(new Entry(i, val, getResources().getDrawable(R.drawable.star)));
            values.add(new Entry(i, val));
//            values.add(new Entry(i, 10));
        }

        LineDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "血压");

            set1.setDrawIcons(false);

            // set the line to be drawn like this "- - - - - -"
            set1.enableDashedLine(10f, 5f, 0f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(Color.WHITE);   //设置线条颜色
            set1.setCircleColor(Color.WHITE);  //设置圈点颜色
            set1.setValueTextColor(Color.WHITE);  //设置点的字体颜色;
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);
            //曲线更圆润
            set1.setMode(set1.getMode() == LineDataSet.Mode.CUBIC_BEZIER
                    ? LineDataSet.Mode.LINEAR
                    : LineDataSet.Mode.CUBIC_BEZIER);

            if (Utils.getSDKInt() >= 18) {
                // fill drawable only supported on api level 18 and above
                Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_red);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.WHITE);
            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1); // add the datasets

            // create a data object with the datasets
            LineData data = new LineData(dataSets);

            // set data
            mChart.setData(data);
        }
    }


    @Override
    public void onValueSelected(Entry entry, Highlight highlight) {
        Log.i("Activity", "Selected: " + entry.toString() + ", dataSet: " + highlight.getDataSetIndex());
    }

    @Override
    public void onNothingSelected() {
        Log.i("Activity", "Nothing selected.");
    }

    public void setTitle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getActivity().getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //根据上面设置是否对状态栏单独设置颜色
            if (MainActivity.useThemestatusBarColor) {
                getActivity().getWindow().setStatusBarColor(Color.rgb(204, 221, 231));
            } else {
                getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !MainActivity.useStatusBarColor) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}

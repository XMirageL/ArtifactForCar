package com.hngy.rjxh.artifactforcar.Activity_Setting;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.hngy.rjxh.artifactforcar.R;
import com.hngy.rjxh.artifactforcar.bluetooth.adapter.BlueListAdapter;
import com.hngy.rjxh.artifactforcar.bluetooth.bean.BlueDevice;
import com.hngy.rjxh.artifactforcar.bluetooth.task.BlueAcceptTask;
import com.hngy.rjxh.artifactforcar.bluetooth.task.BlueConnectTask;
import com.hngy.rjxh.artifactforcar.bluetooth.task.BlueReceiveTask;
import com.hngy.rjxh.artifactforcar.bluetooth.util.BluetoothUtil;
import com.hngy.rjxh.artifactforcar.bluetooth.widget.InputDialogFragment;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class setting_Activity extends AppCompatActivity implements
        View.OnClickListener, AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener,
        BlueConnectTask.BlueConnectListener, InputDialogFragment.InputCallbacks, BlueAcceptTask.BlueAcceptListener {

    private Switch switch_1_1;
    private SeekBar seekBar;
    private SeekBar seekBar3;
    private SeekBar seekBar4;
    private TextView tv_seekBar;
    private TextView tv_seekBar3;
    private TextView tv_seekBar4;
    private RelativeLayout rl_1;
    private RelativeLayout rl_2;
    private RelativeLayout rl_3;
    private CheckBox checkBox;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private Spinner spinner;
    private LinearLayout rl_4;
    
    private static final String TAG = "setting_Activity";
    private CheckBox ck_bluetooth;
    private TextView tv_discovery;
    private ListView lv_bluetooth;
    private BluetoothAdapter mBluetooth;
    private ArrayList<BlueDevice> mDeviceList = new ArrayList<BlueDevice>();
    private TextView textView19;
    private RelativeLayout rl_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("软件设置");
//            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        rl_1 = (RelativeLayout) findViewById(R.id.rl_1);
        rl_2 = (RelativeLayout) findViewById(R.id.rl_2);
        rl_3 = (RelativeLayout) findViewById(R.id.rl_3);
        rl_4 = (LinearLayout) findViewById(R.id.rl_4);
        rl_5 = (RelativeLayout) findViewById(R.id.rl_5);
        final ListView list_set = (ListView) findViewById(R.id.list_set);
        LinkedList<modul_1> mData = new LinkedList<>();
        mData.add(new modul_1("1","报警阈值设置"));
        mData.add(new modul_1("2","警护联系电话设置"));
        mData.add(new modul_1("3","语言播报设置"));
        mData.add(new modul_1("4","设备检测"));
        mData.add(new modul_1("5","关于"));
        final setting_Activity_Adapter mAdapter = new setting_Activity_Adapter((LinkedList<modul_1>) mData,getApplicationContext());
        list_set.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (((ListView)parent).getTag() != null){
                    ((View)((ListView)parent).getTag()).setBackgroundDrawable(null);
                }
                ((ListView)parent).setTag(view);
                view.setBackgroundColor(Color.rgb(211,211,211));
                if (position == 0){
                    rl_1.setVisibility(View.VISIBLE);
                    rl_2.setVisibility(View.INVISIBLE);
                    rl_3.setVisibility(View.INVISIBLE);
                    rl_4.setVisibility(View.INVISIBLE);
                    rl_5.setVisibility(View.INVISIBLE);
                } else if (position == 1){
                    rl_2.setVisibility(View.VISIBLE);
                    rl_1.setVisibility(View.INVISIBLE);
                    rl_3.setVisibility(View.INVISIBLE);
                    rl_4.setVisibility(View.INVISIBLE);
                    rl_5.setVisibility(View.INVISIBLE);
                } else if (position == 2){
                    rl_3.setVisibility(View.VISIBLE);
                    rl_2.setVisibility(View.INVISIBLE);
                    rl_1.setVisibility(View.INVISIBLE);
                    rl_4.setVisibility(View.INVISIBLE);
                    rl_5.setVisibility(View.INVISIBLE);
                } else if (position == 3){
                    rl_3.setVisibility(View.INVISIBLE);
                    rl_2.setVisibility(View.INVISIBLE);
                    rl_1.setVisibility(View.INVISIBLE);
                    rl_4.setVisibility(View.VISIBLE);
                    rl_5.setVisibility(View.INVISIBLE);
                } else if (position == 4){

                    rl_3.setVisibility(View.INVISIBLE);
                    rl_2.setVisibility(View.INVISIBLE);
                    rl_1.setVisibility(View.INVISIBLE);
                    rl_4.setVisibility(View.INVISIBLE);
                    rl_5.setVisibility(View.VISIBLE);
                }
            }
        });
        list_set.setAdapter(mAdapter);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                list_set.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        list_set.getChildAt(0).setBackgroundColor(Color.rgb(211,211,211));
//                    }
//                });
//            }
//        },500);

        spinner = (Spinner) findViewById(R.id.spinner);
        List<setting_info> mData_3 = new ArrayList<setting_info>();
        mData_3.add(new setting_info("林志玲",R.mipmap.touxiang_lizhiling));
        mData_3.add(new setting_info("王俊凯",R.mipmap.touxiang_wangjunkai));
        mData_3.add(new setting_info("罗永浩",R.mipmap.touxiang_luoyonghao));
        mData_3.add(new setting_info("大师兄",R.mipmap.touxiang_dashixiong));
        setting3_yuyinbao_Adapter adapter_3 = new setting3_yuyinbao_Adapter(mData_3,getApplicationContext());
        spinner.setAdapter(adapter_3);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                } else {
                    if (!checkBox1.isChecked() && !checkBox2.isChecked()){
                        checkBox.setChecked(true);
                        Toast.makeText(getApplicationContext(), "必须选中一项",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBox.setChecked(false);
                    checkBox2.setChecked(false);
                }else {
                    if (!checkBox.isChecked() && !checkBox2.isChecked()){
                        checkBox1.setChecked(true);
                        Toast.makeText(getApplicationContext(), "必须选中一项",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBox1.setChecked(false);
                    checkBox.setChecked(false);
                }else {
                    if (!checkBox1.isChecked() && !checkBox.isChecked()){
                        checkBox2.setChecked(true);
                        Toast.makeText(getApplicationContext(), "必须选中一项",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        tv_seekBar = (TextView) findViewById(R.id.textView5);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_seekBar.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        tv_seekBar3 = (TextView) findViewById(R.id.textView7);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_seekBar3.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        tv_seekBar4 = (TextView) findViewById(R.id.textView9);
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_seekBar4.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        switch_1_1 = (Switch) findViewById(R.id.switch_1_1);
        switch_1_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    seekBar.setEnabled(true);
                    seekBar3.setEnabled(true);
                    seekBar4.setEnabled(true);
                } else {
                    seekBar.setEnabled(false);
                    seekBar3.setEnabled(false);
                    seekBar4.setEnabled(false);
                }
            }
        });
        textView19 = (TextView) findViewById(R.id.textView19);
        textView19.setText(Html.fromHtml("<u>"+"Git"+"</u>"));
        textView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL("https://github.com/XLwn/ArtifactForCar");
            }
        });

        bluetoothPermissions();
        ck_bluetooth = (CheckBox) findViewById(R.id.ck_bluetooth);
        tv_discovery = (TextView) findViewById(R.id.tv_discovery);
        lv_bluetooth = (ListView) findViewById(R.id.lv_bluetooth);
        if (BluetoothUtil.getBlueToothStatus(this) == true) {
            ck_bluetooth.setChecked(true);
        }
        ck_bluetooth.setOnCheckedChangeListener(this);
        tv_discovery.setOnClickListener(this);
        mBluetooth = BluetoothAdapter.getDefaultAdapter();
        if (mBluetooth == null) {
            Toast.makeText(this, "本机未找到蓝牙功能", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // 定义获取基于地理位置的动态权限
    private void bluetoothPermissions() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
    }

    /**
     * 重写onRequestPermissionsResult方法
     * 获取动态权限请求的结果,再开启蓝牙
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (BluetoothUtil.getBlueToothStatus(this) == true) {
                ck_bluetooth.setChecked(true);
            }
            ck_bluetooth.setOnCheckedChangeListener(this);
            tv_discovery.setOnClickListener(this);
            mBluetooth = BluetoothAdapter.getDefaultAdapter();
            if (mBluetooth == null) {
                Toast.makeText(this, "本机未找到蓝牙功能", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            Toast.makeText(this, "用户拒绝了权限", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.ck_bluetooth) {
            if (isChecked == true) {
                beginDiscovery();
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(intent, 1);
                // 下面这行代码为服务端需要，客户端不需要
                mHandler.postDelayed(mAccept, 1000);
                Toast.makeText(getApplicationContext(),"部分模拟器不具备蓝牙，请尽量用真机测试",Toast.LENGTH_LONG).show();
            } else {
                cancelDiscovery();
                BluetoothUtil.setBlueToothStatus(this, false);
                mDeviceList.clear();
                BlueListAdapter adapter = new BlueListAdapter(this, mDeviceList);
                lv_bluetooth.setAdapter(adapter);
            }
        }
    }

    private Runnable mAccept = new Runnable() {
        @Override
        public void run() {
            if (mBluetooth.getState() == BluetoothAdapter.STATE_ON) {
                BlueAcceptTask acceptTask = new BlueAcceptTask(true);
                acceptTask.setBlueAcceptListener(setting_Activity.this);
                acceptTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            } else {
                mHandler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_discovery) {
            beginDiscovery();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "允许本地蓝牙被附近的其它蓝牙设备发现", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "不允许蓝牙被附近的其它蓝牙设备发现", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private Runnable mRefresh = new Runnable() {
        @Override
        public void run() {
            beginDiscovery();
            mHandler.postDelayed(this, 2000);
        }
    };

    private void beginDiscovery() {
        if (mBluetooth.isDiscovering() != true) {
            mDeviceList.clear();
            BlueListAdapter adapter = new BlueListAdapter(setting_Activity.this, mDeviceList);
            lv_bluetooth.setAdapter(adapter);
            tv_discovery.setText("正在搜索蓝牙设备");
            mBluetooth.startDiscovery();
        }
    }

    private void cancelDiscovery() {
        mHandler.removeCallbacks(mRefresh);
        tv_discovery.setText("取消搜索蓝牙设备");
        if (mBluetooth.isDiscovering() == true) {
            mBluetooth.cancelDiscovery();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mHandler.postDelayed(mRefresh, 50);
        blueReceiver = new BluetoothReceiver();
        //需要过滤多个动作，则调用IntentFilter对象的addAction添加新动作
        IntentFilter foundFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        foundFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        foundFilter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        registerReceiver(blueReceiver, foundFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        cancelDiscovery();
        unregisterReceiver(blueReceiver);
    }

    private BluetoothReceiver blueReceiver;

    private class BluetoothReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(TAG, "onReceive action=" + action);
            // 获得已经搜索到的蓝牙设备
            if (action.equals(BluetoothDevice.ACTION_FOUND)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                BlueDevice item = new BlueDevice(device.getName(), device.getAddress(), device.getBondState() - 10);
                mDeviceList.add(item);
                BlueListAdapter adapter = new BlueListAdapter(setting_Activity.this, mDeviceList);
                lv_bluetooth.setAdapter(adapter);
                lv_bluetooth.setOnItemClickListener(setting_Activity.this);
            } else if (action.equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {
                mHandler.removeCallbacks(mRefresh);
                tv_discovery.setText("蓝牙设备搜索完成");
            } else if (action.equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getBondState() == BluetoothDevice.BOND_BONDING) {
                    tv_discovery.setText("正在配对" + device.getName());
                } else if (device.getBondState() == BluetoothDevice.BOND_BONDED) {
                    tv_discovery.setText("完成配对" + device.getName());
                    mHandler.postDelayed(mRefresh, 50);
                } else if (device.getBondState() == BluetoothDevice.BOND_NONE) {
                    tv_discovery.setText("取消配对" + device.getName());
                }
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        cancelDiscovery();
        BlueDevice item = mDeviceList.get(position);
        BluetoothDevice device = mBluetooth.getRemoteDevice(item.address);
        try {
            if (device.getBondState() == BluetoothDevice.BOND_NONE) {
                Method createBondMethod = BluetoothDevice.class.getMethod("createBond");
                Log.d(TAG, "开始配对");
                Boolean result = (Boolean) createBondMethod.invoke(device);
            } else if (device.getBondState() == BluetoothDevice.BOND_BONDED &&
                    item.state != BlueListAdapter.CONNECTED) {
                tv_discovery.setText("开始连接");
                BlueConnectTask connectTask = new BlueConnectTask(item.address);
                connectTask.setBlueConnectListener(this);
                connectTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, device);
            } else if (device.getBondState() == BluetoothDevice.BOND_BONDED &&
                    item.state == BlueListAdapter.CONNECTED) {
                tv_discovery.setText("正在发送消息");
                InputDialogFragment dialog = InputDialogFragment.newInstance(
                        "", 0, "请输入要发送的消息");
                String fragTag = getResources().getString(R.string.app_name);
                dialog.show(getFragmentManager(), fragTag);
            }
        } catch (Exception e) {
            e.printStackTrace();
            tv_discovery.setText("配对异常：" + e.getMessage());
        }
    }

    //向对方发送消息
    @Override
    public void onInput(String title, String message, int type) {
        Log.d(TAG, "onInput message=" + message);
        Log.d(TAG, "mBlueSocket is " + (mBlueSocket == null ? "null" : "not null"));
        BluetoothUtil.writeOutputStream(mBlueSocket, message);
    }

    private BluetoothSocket mBlueSocket;

    //客户端主动连接
    @Override
    public void onBlueConnect(String address, BluetoothSocket socket) {
        mBlueSocket = socket;
        tv_discovery.setText("连接成功");
        refreshAddress(address);
    }

    //刷新已连接的状态
    private void refreshAddress(String address) {
        for (int i = 0; i < mDeviceList.size(); i++) {
            BlueDevice item = mDeviceList.get(i);
            if (item.address.equals(address) == true) {
                item.state = BlueListAdapter.CONNECTED;
                mDeviceList.set(i, item);
            }
        }
        BlueListAdapter adapter = new BlueListAdapter(this, mDeviceList);
        lv_bluetooth.setAdapter(adapter);
    }

    //服务端侦听到连接
    @Override
    public void onBlueAccept(BluetoothSocket socket) {
        Log.d(TAG, "onBlueAccept socket is " + (socket == null ? "null" : "not null"));
        if (socket != null) {
            mBlueSocket = socket;
            BluetoothDevice device = mBlueSocket.getRemoteDevice();
            refreshAddress(device.getAddress());
            BlueReceiveTask receive = new BlueReceiveTask(mBlueSocket, mHandler);
            receive.start();
        }
    }

    //收到对方发来的消息
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                byte[] readBuf = (byte[]) msg.obj;
                String readMessage = new String(readBuf, 0, msg.arg1);
                Log.d(TAG, "handleMessage readMessage=" + readMessage);
                AlertDialog.Builder builder = new AlertDialog.Builder(setting_Activity.this);
                builder.setTitle("我收到消息啦").setMessage(readMessage).setPositiveButton("确定", null);
                builder.create().show();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBlueSocket != null) {
            try {
                mBlueSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void openURL(String s) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(s);
        intent.setData(content_url);
        startActivity(intent);
    }

}

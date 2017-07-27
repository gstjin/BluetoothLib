package com.gstjin.myapplication;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.gstjin.btlib.BluetoothLib;
import com.gstjin.btlib.OnConnectListener;
import com.gstjin.btlib.OnDiscoverListener;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        BluetoothLib.build(this)
                .startDiscovery(new OnDiscoverListener() {
                    @Override
                    public void onStart(List<BluetoothDevice> boundedDevices) {
                        showToast("boundedDevices:" + boundedDevices.size());
                    }

                    @Override
                    public void onNewDevicesFound(BluetoothDevice device) {
                        showToast("foundNewDevices:" + device.getName());
                    }

                    @Override
                    public void onFinish(int foundedCount) {
                        showToast("foundFinish:" + foundedCount);
                    }
                })
                .setOnConnectListener(new OnConnectListener() {
                    @Override
                    public void onConnected(String deivceName) {
                        showToast("onConnected:" + deivceName);
                    }

                    @Override
                    public void onConnecting() {
                        showToast("onConnecting:");

                    }

                    @Override
                    public void onNoConnect(String error) {
                        showToast("onNoConnect:" + error);
                    }

                    @Override
                    public void onRead(byte[] readBuf) {
                        showToast("onRead:" + new String(readBuf));
                    }

                    @Override
                    public void onWrite(byte[] writeBuf) {
                        showToast("onWrite:" + new String(writeBuf));

                    }
                });


        findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothLib.build(MainActivity.this).write("FE:9E:46:03:21:C9","sendmsg".getBytes());
            }
        });

    }


    public void onDestroy() {
        super.onDestroy();
        BluetoothLib.build(this).destroy();
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}

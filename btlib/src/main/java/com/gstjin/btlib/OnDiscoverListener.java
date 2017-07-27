package com.gstjin.btlib;

import android.bluetooth.BluetoothDevice;

import java.util.List;

/**
 * Created by jin.xu on 2017/7/26.
 */

public interface OnDiscoverListener {

    public void onStart(List<BluetoothDevice> boundedDevices);

    public void onNewDevicesFound(BluetoothDevice device);

    public void onFinish(int foundedCount);

}

package com.gstjin.btlib;

/**
 * Created by jin.xu on 2017/7/26.
 */

public interface OnConnectListener {
    public void onConnected(String deivceName);
    public void onConnecting();
    public void onNoConnect(String error);
    public void onRead(byte[] readBuf);
    public void onWrite(byte[] writeBuf);
}

# BluetoothLib


A library make bluetooth use simple 


## Dependency
- Step 1. Add the JitPack repository to your build file
> Add it in your root build.gradle at the end of repositories:
```
    allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```
- Step 2. Add the dependency 
```
    dependencies {
	        compile 'com.github.gstjin:BluetoothLib:1.0'
	}

```

## How to use
- build single instance
```
        BluetoothLib.build(this)
```
- destory instance
```
   protected void onDestroy() {
        super.onDestroy();
        ...
        BluetoothLib.build(this).destroy();
    }
```

 - Search bluetooth Devices
 ```java
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
                });
 ```
- set connect listener and monitor data
```
BluetoothLib.build(this)             
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
```
- send data to device 
```
findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothLib.build(MainActivity.this).write("FE:9E:46:03:21:C9","sendmsg".getBytes());
            }
        });
```




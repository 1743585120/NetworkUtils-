package com.yz.demoflowingdrawer.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil {
    /**
     *无网络
     */
    public static final int NETWORK_NONE = -1;
    /**
     * 移动网络
     */
    public static final int NETWORK_MOBILE = 0;
    /**
     * 无线网络
     */
    public static final int NETWORK_WIFI = 1;

    public static int getNetWorkState(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isConnected()){
            if (info.getType() == (ConnectivityManager.TYPE_WIFI)){
                return NETWORK_WIFI;
            }else if (info.getType() == (ConnectivityManager.TYPE_MOBILE)){
                return NETWORK_MOBILE;
            }
        }else {
            return NETWORK_NONE;
        }
        return NETWORK_NONE;
    }
}

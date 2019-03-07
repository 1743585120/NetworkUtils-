package com.yz.demoflowingdrawer.base;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yz.demoflowingdrawer.R;
import com.yz.demoflowingdrawer.network.NetBroadcastReceiver;
import com.yz.demoflowingdrawer.network.NetUtil;

public class BaseActivity extends FragmentActivity implements NetBroadcastReceiver.NetEvevt {

    public static NetBroadcastReceiver.NetEvevt evevt;

    /**
     * 网络类型
     */
    private int netMobile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        evevt = this;

    }

    public boolean inspectNet() {

        this.netMobile = NetUtil.getNetWorkState(BaseActivity.this);

        return isNetConnect();
    }

    @Override
    public void onNetChange(int netMobile) {
        isNetConnect();
    }

    public boolean isNetConnect() {
        if (netMobile == 1) {
            return true;
        }else if (netMobile == 0) {
            return true;
        }else if (netMobile == -1) {
            return false;
        }
        return false;
    }
}

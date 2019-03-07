package com.yz.demoflowingdrawer;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yz.demoflowingdrawer.base.BaseActivity;
import com.yz.demoflowingdrawer.network.NetUtil;

public class MainActivity extends BaseActivity {

    private TextView textView,txtView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textView);

        txtView=(TextView)this.findViewById(R.id.txtView);

        boolean netConnect = this.isNetConnect();
        if (netConnect){
            textView.setVisibility(View.GONE);
            txtView.setText("网络连接正常");
        }else {
            textView.setVisibility(View.VISIBLE);
            txtView.setText("网络连接异常");
        }
    }

    @Override
    public void onNetChange(int netMobile) {
        super.onNetChange(netMobile);
        if (netMobile==NetUtil.NETWORK_NONE){
            textView.setVisibility(View.VISIBLE);
            txtView.setText("网络连接异常");
        }else {
            textView.setVisibility(View.GONE);
            txtView.setText("网络连接正常");
        }
    }
}

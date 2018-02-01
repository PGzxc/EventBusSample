package com.pgzxc.eventbussample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by admin on 2018/2/1.
 */

public class SecondActivity extends AppCompatActivity {
    private TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvContent = findViewById(R.id.tv_content);

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEventMainThread(MessageEvent event) {
        tvContent.setText(event.getMsg());
    }
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}

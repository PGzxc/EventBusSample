package com.pgzxc.eventbussample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private Button btnClick;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void setListener() {
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestEvent event = new TestEvent();
                event.setMsg("已接收到事件!");
                EventBus.getDefault().postSticky(event);
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });


    }

    private void initView() {
        btnClick = findViewById(R.id.btn_click);
        tvContent = findViewById(R.id.tv_content);
    }
//    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
//    public void onEventMainThread(TestEvent event) {
//        tvContent.setText(event.getMsg());
//    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        EventBus.getDefault().unregister(this);
//    }
}

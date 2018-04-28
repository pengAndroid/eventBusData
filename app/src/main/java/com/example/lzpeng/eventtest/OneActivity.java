package com.example.lzpeng.eventtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;


/**
 * @author lzPeng
 * @desc 第一个界面（用来发送数据）
 * @time 2018/4/27  20:10
 */
public class OneActivity extends Activity {

    private EditText etName;
    private EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
    }


    /**
     * @desc 点击发送数据过去第二个界面
     * @author lzPeng
     * @time 2018/4/27  20:15
     */
    public void btnSend(View view) {
        EventBus.getDefault().postSticky(new ObjEvent(etName.getText().toString(), etAge.getText().toString()));
        startActivity(new Intent(OneActivity.this, TwoActivity.class));
    }

}

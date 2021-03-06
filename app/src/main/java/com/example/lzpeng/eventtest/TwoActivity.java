package com.example.lzpeng.eventtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author lzPeng
 * @desc 第二个界面（用来接收第一个界面传递过来的数据）
 * @time 2018/4/27  20:10
 */

public class TwoActivity extends Activity {

    //用来赋值传递过来的对象
    ObjEvent mObjEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        //注册绑定事件即可接收相关数据
        EventBus.getDefault().register(this);
        //处理相关数据
        if (null != mObjEvent) {
            ((TextView) findViewById(R.id.tv_data)).setText("name：" + mObjEvent.getName() + "\n\n" + "age：" + mObjEvent.getAge());
        }
    }


    /**
     * @desc 接收第一个界面传递过来的数据
     * @author lzPeng
     * @time 2018/4/27  20:15
     */
    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMoonEvent(ObjEvent objEvent) {
        if (null != objEvent) {
            //赋值
            this.mObjEvent = objEvent;
        }
    }


    @Override
    protected void onDestroy() {
        //移除全部粘性事件
        EventBus.getDefault().removeAllStickyEvents();
        //解绑事件
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

}

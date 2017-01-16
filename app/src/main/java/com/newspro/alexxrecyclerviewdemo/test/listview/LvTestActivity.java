package com.newspro.alexxrecyclerviewdemo.test.listview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.newspro.alexxrecyclerviewdemo.R;
import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.ordinarylistview.XMultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class LvTestActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView testListView;
    private List<User> list;
    private XMultiItemTypeAdapter<User> adapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter.updateSingleRow(testListView, list.get(msg.arg2), msg.arg2);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvtest);
        //查找控件
        testListView = (ListView) findViewById(R.id.testListView);
        //设置集合
        list = new ArrayList<>();
        for (int i = 1; i < 30; i++) {
            list.add(new User(i%2==0,"我是第" + i + "条，我的名字是Alex" + i));
        }
        adapter = new MultTestAdapter(this,list);
        testListView.setOnItemClickListener(this);
        testListView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        if (adapter.getItemDelegate(list.get(position),position) instanceof ComeDelegate) {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    for (int i = 0;i<100;i++){
                        list.get(position).setSize(i);
                        try {
                            sleep(500);
                            Message msg = handler.obtainMessage();
                            msg.arg2 = position;
                            handler.sendMessage(msg);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }.start();
        }
    }
}

package com.newspro.alexxrecyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.ordinarylistview.XMultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView testListView;
    private List<String> list;
//    private XBaseAdapter<String> adapter;
    private XMultiItemTypeAdapter<User> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //查找控件
        testListView = (ListView) findViewById(R.id.testListView);
        //设置集合
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("我是第" + i + "条");
        }
//        adapter = new XBaseAdapter<String>(this,R.layout.item_test_lv,list) {
//            @Override
//            protected void convert(XViewHolder viewHolder, String item, int position) {
//                TextView userName = viewHolder.getItemView(R.id.userName);
//                userName.setText(item);
//            }
//        };



        testListView.setAdapter(adapter);

    }
}

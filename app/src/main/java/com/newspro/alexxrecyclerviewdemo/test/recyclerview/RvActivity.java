package com.newspro.alexxrecyclerviewdemo.test.recyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.newspro.alexxrecyclerviewdemo.R;
import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvMultiItemTypeAdapter;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RvActivity extends AppCompatActivity {

    private RecyclerView rvActRecyclerView;
    private List<User> users;
//    private XHFRvBaseAdapter<User> adapter;
    private RvMultTestAdapter adapter;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter.notifyItemByPosi(msg.arg2);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        rvActRecyclerView = (RecyclerView) findViewById(R.id.rvActRecyclerView);
        users = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            users.add(new User(i%2==0,"alex" + i + "名"));
        }

        adapter = new RvMultTestAdapter(this,users);

//        adapter = new XHFRvBaseAdapter<User>(this,R.layout.item_test_lv,users) {
//            @Override
//            protected void convert(XRvViewHolder viewHolder, User item, int position) {
//                TextView userName = viewHolder.getItemView(R.id.userName);
//                userName.setText(item.getName());
//            }
//        };

        rvActRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter.setOnItemClickListener(new XRvMultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, XRvViewHolder holder, final int position) {
                System.out.println("position = " + position);
                if (adapter.getItemViewDelegate(position) instanceof RvComeDelegate){
                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            for (int i = 0;i<100;i++){
                                users.get(position).setSize(i);
                                try {
                                    sleep(100);
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
        });

        TextView textView1 = new TextView(this);
        textView1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView1.setText("header1");
        TextView textView2 = new TextView(this);
        textView2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView2.setText("header2");
//        headerAndFooterWrapper.addHeaders(textView2);
        rvActRecyclerView.setAdapter(adapter);

    }
}

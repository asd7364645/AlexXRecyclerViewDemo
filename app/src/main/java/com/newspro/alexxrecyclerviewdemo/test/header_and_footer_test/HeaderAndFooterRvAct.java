package com.newspro.alexxrecyclerviewdemo.test.header_and_footer_test;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.newspro.alexxrecyclerviewdemo.R;
import com.newspro.alexxrecyclerviewdemo.bean.User;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvMultiItemTypeAdapter;
import com.newspro.xbaseadapter.recycler_baseadapter.XRvViewHolder;

import java.util.ArrayList;
import java.util.List;

public class HeaderAndFooterRvAct extends AppCompatActivity {

    private RecyclerView headerAndFooterRv;
    private List<User> users;
    private RvMultTestAdapter adapter;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter.notifyItemByPosi(msg.arg2);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_and_footer_rv);
        headerAndFooterRv = (RecyclerView) findViewById(R.id.headerAndFooterRv);
        users = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            users.add(new User(i % 2 == 0, "alex" + i + "名"));
        }

        adapter = new RvMultTestAdapter(this, users);
//        headerAndFooterRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        headerAndFooterRv.setLayoutManager(new GridLayoutManager(this, 3));

        View view = LayoutInflater.from(this).inflate(R.layout.header_view, null);
        adapter.addHeaders(view);
        View view2 = LayoutInflater.from(this).inflate(R.layout.header_view, null);
        adapter.addFooters(view2);
        headerAndFooterRv.setAdapter(adapter);


        adapter.setOnItemClickListener(new XRvMultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, XRvViewHolder holder, final int position) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        for (int i = 0; i < 100; i++) {
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
        });

    }
}

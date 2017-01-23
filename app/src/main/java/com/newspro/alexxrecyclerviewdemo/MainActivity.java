package com.newspro.alexxrecyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.newspro.alexxrecyclerviewdemo.test.header_and_footer_test.HeaderAndFooterRvAct;
import com.newspro.alexxrecyclerviewdemo.test.listview.LvTestActivity;
import com.newspro.alexxrecyclerviewdemo.test.recyclerview.RvActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lvClick(View v) {
        Intent intent = new Intent(this, LvTestActivity.class);
        startActivity(intent);
    }
    public void rvHeaderClick(View v) {
        Intent intent = new Intent(this, HeaderAndFooterRvAct.class);
        startActivity(intent);
    }

    public void rvClick(View v) {
        Intent intent = new Intent(this, RvActivity.class);
        startActivity(intent);
    }

}

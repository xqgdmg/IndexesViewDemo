package com.example.qhsj.indexesviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.qhsj.indexesviewdemo.view.IndexesView;

public class MainActivity extends AppCompatActivity {

    private ListView mLv;
    private IndexesView mIndexesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mLv = (ListView) findViewById(R.id.lv);
        mIndexesView = (IndexesView) findViewById(R.id.indexesView);

        mLv.setAdapter(new MyAdapter(MainActivity.this));
    }
}

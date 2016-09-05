package com.jackson.tagdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> strings=new ArrayList<>();
    RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.rv_tag);
        strings.add("你");
        strings.add("你");
        strings.add("你");
        strings.add("你很");
        strings.add("你好你");
        strings.add("你好好好");
        strings.add("好好你好");
        strings.add("你好好");
        initTagRecyclerView(strings,R.layout.item_tag);
    }

    public void initTagRecyclerView(List<String> strings,int resId ){
        int lines=(int) Math.floor(strings.size()/4)+1;
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(lines, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter=new RecyclerAdapter<String>(this,strings,resId) {

            @Override
            public void convert(RecycleHolder holder, String data, int position) {
                holder.setText(R.id.tv_tag_item,data);
            }

        });
//        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
//            @Override
//            public void OnItemClickListener(View view, int position) {
//                Toast.makeText(MainActivity.this, "你点击了"+position, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}

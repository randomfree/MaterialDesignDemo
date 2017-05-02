package com.ly.materialdesigndemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.ly.materialdesigndemo.R;
import com.ly.materialdesigndemo.adapter.SearchAdapter;
import com.ly.materialdesigndemo.layoutmanager.AutoNextLineLayoutManger;
import com.ly.materialdesigndemo.layoutmanager.SpaceItemDecoration;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SearchActivity extends AppCompatActivity {

    @InjectView(R.id.recyclerview_search)
    RecyclerView recyclerviewSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.inject(this);
        AutoNextLineLayoutManger autoNextLineLayoutManger = new AutoNextLineLayoutManger();
        recyclerviewSearch.setLayoutManager(autoNextLineLayoutManger);
        recyclerviewSearch.setAdapter(new SearchAdapter());
        recyclerviewSearch.addItemDecoration(new SpaceItemDecoration(20));
    }
}

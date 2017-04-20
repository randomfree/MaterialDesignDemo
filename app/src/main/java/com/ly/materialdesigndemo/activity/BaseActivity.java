package com.ly.materialdesigndemo.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by txw_pc on 2017/4/19.
 * acativity基类，AppCompatActivity继承自FragmentActivity所以可以使用v4fragment标签
 */

public class BaseActivity extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}

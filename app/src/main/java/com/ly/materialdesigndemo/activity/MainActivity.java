package com.ly.materialdesigndemo.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ly.materialdesigndemo.R;
import com.ly.materialdesigndemo.fragment.FindFragment;
import com.ly.materialdesigndemo.fragment.MineFragment;
import com.ly.materialdesigndemo.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 首页，项目采用Material Design设计，并尽量多的采用主流的框架，以达到更好的练手效果，
 * 减慢节奏，注意前期的技术选型，注意设计细节，注意代码的编写习惯，修正已养成的不好的编程习惯，
 * 尽量将项目做的完整，并准备初步学习，python爬虫，java后台，数据库，安全等方面，尽量用一个项目
 * 做到全面的复习及学习,可以开很多分支，以达到用同样的项目实验不同的框架的需求，这样可以加深对各种框架
 * 使用，及优缺点的认识
 */

public class MainActivity extends BaseActivity {
    @InjectView(R.id.icon_img)
    ImageView iconImg;
    @InjectView(R.id.search_bar)
    TextView searchBar;
    @InjectView(R.id.search_rlt)
    RelativeLayout searchRlt;
    @InjectView(R.id.main_vp)
    ViewPager mainVp;
    @InjectView(R.id.main_bnv)
    BottomNavigationView mainBnv;

    private List<Fragment> fragments = new ArrayList<>();

    private MenuItem prevMenuItem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initFragments();
        initViewPager();
        initBottomNavitionView();

    }
    private void initFragments(){
        RecommendFragment recommendFragment = new RecommendFragment();
        FindFragment findFragment = new FindFragment();
        MineFragment mineFragment = new MineFragment();
        fragments.add(recommendFragment);
        fragments.add(findFragment);
        fragments.add(mineFragment);


    }
    private void initViewPager(){
        mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem!=null){
                    prevMenuItem.setChecked(false);
                }else{
                    mainBnv.getMenu().getItem(0).setChecked(false);
                }
                mainBnv.getMenu().getItem(position).setChecked(true);
                prevMenuItem = mainBnv.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //fragmentpageradapter会保留状态，fragmentstatepageradapter会立即销毁
        FragmentPagerAdapter fpa = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        mainVp.setAdapter(fpa);
    }

    private void initBottomNavitionView(){
        mainBnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bnv_recommend:
                        mainVp.setCurrentItem(0);
                        break;
                    case R.id.bnv_find:
                        mainVp.setCurrentItem(1);
                        break;
                    case R.id.bnv_me:
                        mainVp.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });
    }
    @OnClick(R.id.search_rlt)
    public void onViewClicked() {
        startActivity(new Intent(this,SearchActivity.class));
    }
}

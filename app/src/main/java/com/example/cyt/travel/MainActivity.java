package com.example.cyt.travel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;

import com.example.cyt.travel.Fragment.FindFragment;
import com.example.cyt.travel.Fragment.MainFragment;
import com.example.cyt.travel.Fragment.MeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected LinearLayoutCompat mMenuMain;
    protected LinearLayoutCompat mMenuFind;
    protected LinearLayoutCompat mMenuMe;

    protected MainFragment mMainFragment = new MainFragment();//首页
    protected FindFragment mFindFragment = new FindFragment();//发现页
    protected MeFragment mMeFragment = new MeFragment();//我的

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //获取管理类
        this.getSupportFragmentManager()
                //事务
                .beginTransaction()
                //添加
                .add(R.id.container_content, mMainFragment)
                .add(R.id.container_content, mFindFragment)
                .hide(mFindFragment)
                .add(R.id.container_content, mMeFragment)
                .hide(mMeFragment)
                //提交
                .commit();
    }

    private void initView() {
        mMenuMain = findViewById(R.id.menu_main);
        mMenuFind = findViewById(R.id.menu_find);
        mMenuMe = findViewById(R.id.menu_me);
        mMenuMain.setOnClickListener(this);
        mMenuFind.setOnClickListener(this);
        mMenuMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu_main://首页
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(mMainFragment)
                        .hide(mFindFragment)
                        .hide(mMeFragment)
                        .commit();
                break;
            case R.id.menu_find://发现页
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mMainFragment)
                        .show(mFindFragment)
                        .hide(mMeFragment)
                        .commit();
                break;
            case R.id.menu_me://我的
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mMainFragment)
                        .hide(mFindFragment)
                        .show(mMeFragment)
                        .commit();
                break;
        }
    }
}

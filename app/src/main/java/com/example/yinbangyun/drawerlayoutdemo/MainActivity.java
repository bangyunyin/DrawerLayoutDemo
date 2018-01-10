package com.example.yinbangyun.drawerlayoutdemo;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mLeftView;
    private CharSequence mTitle;
    private String[] mLeftViewItems;
    private ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();


    }

    private void initUI() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawlayout);
        mLeftView = (ListView)findViewById(R.id.left_draw);
//        mTitle = getTitle();
        mLeftViewItems = getResources().getStringArray(R.array.list_item);
        //设置覆盖主布局的时候阴影
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);

        mLeftView.setAdapter(new ArrayAdapter<String>(
                this, R.layout.listview_item, mLeftViewItems));

        //显示AcitonBar的返回的图标且可点击
      //  getActionBar().setDisplayHomeAsUpEnabled(true);
       // getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();



    }
}

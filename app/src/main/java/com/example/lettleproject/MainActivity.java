package com.example.lettleproject;

import androidx.annotation.IdRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lettleproject.fragment.HomeFragment;
import com.example.lettleproject.fragment.MessageFragment;
import com.example.lettleproject.fragment.MyFragment;
import com.example.lettleproject.fragment.ShopFragment;
import com.example.lettleproject.fragment.TypeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRadioGroup;
    private List<Fragment> fragments = new ArrayList<>();
    private Fragment fragment;
    private FragmentManager fm;
    private FragmentTransaction transaction;
    private RadioButton rb_Home,rb_Message,rb_Find,rb_My;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        View decorView = getWindow().getDecorView();
//        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(option);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        initView(); //初始化组件
        mRadioGroup.setOnCheckedChangeListener(this); //点击事件
        fragments = getFragments(); //添加布局
        //添加默认布局
        normalFragment();

    }

    //默认布局
    private void normalFragment() {
        fm=getSupportFragmentManager();
        transaction=fm.beginTransaction();
        fragment=fragments.get(0);
        transaction.replace(R.id.mFragment,fragment);
        transaction.commit();
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        rb_Home= (RadioButton) findViewById(R.id.mRb_home);
        rb_Message= (RadioButton) findViewById(R.id.mRb_message);
        rb_Find= (RadioButton) findViewById(R.id.mRb_find);
        rb_My= (RadioButton) findViewById(R.id.mRb_my);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        fm=getSupportFragmentManager();
        transaction=fm.beginTransaction();
        switch (checkedId){
            case R.id.mRb_home:
                fragment=fragments.get(0);
                transaction.replace(R.id.mFragment,fragment);
//                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mRb_message:
                fragment=fragments.get(1);
                transaction.replace(R.id.mFragment,fragment);
//                Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mRb_find:
                fragment=fragments.get(2);
                transaction.replace(R.id.mFragment,fragment);
//                Toast.makeText(this, "Find", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mRb_shop:
                fragment=fragments.get(3);
                transaction.replace(R.id.mFragment,fragment);
//                Toast.makeText(this, "Find", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mRb_my:
                fragment=fragments.get(3);
                transaction.replace(R.id.mFragment,fragment);
//                Toast.makeText(this, "My", Toast.LENGTH_SHORT).show();
                break;
        }
//        setTabState();
        transaction.commit();
    }

    //设置选中和未选择的状态
    private void setTabState() {
        setHomeState();
        setMessageState();
        setFindState();
        setMyState();
    }

    private void setMyState() {
        if (rb_My.isChecked()){
//            rb_My.setTextColor(ContextCompat.getColor(this,R.color.colorRadioButtonP));
        }else{
//            rb_My.setTextColor(ContextCompat.getColor(this,R.color.colorRadioButtonN));
        }
    }

    private void setFindState() {
        if (rb_Find.isChecked()){
//            rb_Find.setTextColor(ContextCompat.getColor(this,R.color.colorRadioButtonP));
        }else{
//            rb_Find.setTextColor(ContextCompat.getColor(this,R.color.colorRadioButtonN));
        }
    }

    private void setMessageState() {
        if (rb_Message.isChecked()){
//            rb_Message.setTextColor(ContextCompat.getColor(this,R.color.colorRadioButtonP));
        }else{
//            rb_Message.setTextColor(ContextCompat.getColor(this,R.color.colorRadioButtonN));
        }
    }

    private void setHomeState() {
        if (rb_Home.isChecked()){
//            rb_Home.setTextColor(ContextCompat.getColor(this,R.color.colorRadioButtonP));
        }else{
//            rb_Home.setTextColor(ContextCompat.getColor(this,R.color.colorRadioButtonN));
        }
    }

    public List<Fragment> getFragments() {
        fragments.add(new HomeFragment());
        fragments.add(new MessageFragment());
        fragments.add(new TypeFragment());
        fragments.add(new ShopFragment());
        fragments.add(new MyFragment());
        return fragments;
    }


}
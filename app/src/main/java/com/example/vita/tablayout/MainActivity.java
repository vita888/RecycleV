package com.example.vita.tablayout;


import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mTextViewHome;
    TextView mTextViewSearch;
    TextView mTextViewShop;
    TextView mTextViewMy;
    private Fragment mCurrentFragment;
    ;
    private Fragment mFragmenthome;
    private Fragment mFragmentsearch;
    private Fragment mFragmentshop;
    private Fragment mFragmentmy;
    FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        mTextViewHome = (TextView) findViewById(R.id.home);
        mTextViewSearch = (TextView) findViewById(R.id.find);
        mTextViewShop = (TextView) findViewById(R.id.shop);
        mTextViewMy = (TextView) findViewById(R.id.my);

        changeTab(0);


        mTextViewHome.setOnClickListener(this);

        mTextViewSearch.setOnClickListener(this);

        mTextViewShop.setOnClickListener(this);

        mTextViewMy.setOnClickListener(this);




//        mTextViewhome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fragmenthome =   new HomeFragment();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.add(R.id.framelayout,fragmenthome);
//                fragmentTransaction.commit();
//            }
//        });
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home:
                changeTab(0);break;
            case R.id.find:
                changeTab(1);break;
            case R.id.shop:
                changeTab(2);break;
            case  R.id.my:
                changeTab(3);break;
        }
    }


    private void changeTab(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        android.support.v4.app.Fragment mfragment;
//        detachFragement();
        switch (index) {
            case 0:
                if (mFragmenthome == null) {
                    mFragmenthome = new HomeFragment();

                }
                mfragment = mFragmenthome;
                break;

            case 1:
                if (mFragmentsearch == null) {
                    mFragmentsearch = new SearchFragment();


                }
                mfragment = mFragmentsearch;
                break;

            case 2:
                if (mFragmentshop == null) {
                    mFragmentshop = new ShopFragment();


                }
                mfragment = mFragmentshop;
                break;

            case 3:
                if (mFragmentmy == null) {
                    mFragmentmy = new MyFragment();

                }
                mfragment = mFragmentmy;
                break;

            default:
                if (mFragmentsearch == null) {
                    mFragmentsearch = new HomeFragment();
                }
                mfragment = mFragmenthome;
                break;
        }

        if (mfragment != mCurrentFragment) {
            if (mCurrentFragment != null && !mCurrentFragment.isDetached()) {
                fragmentTransaction.detach(mCurrentFragment);
            }

            mCurrentFragment = mfragment;

            if (!mfragment.isAdded() && !mfragment.isDetached()) {
                fragmentTransaction.add(R.id.framelayout, mfragment);
            } else {
                if (mfragment.isDetached()) {
                    fragmentTransaction.attach(mfragment);
                } else {
                    fragmentTransaction.show(mfragment);
                }
            }

            fragmentTransaction.commit();
            fragmentManager.executePendingTransactions();
        }

//        if (mCurrentFragment!=null){
//            if (mCurrentFragment != mfragment) {
//                if ( !mCurrentFragment.isDetached()) {
//                    fragmentTransaction.detach(mCurrentFragment);
//                }
//
//                if (mfragment.isDetached()) {
//                    fragmentTransaction.attach(mfragment);
//                    mCurrentFragment = mfragment;
//                } else {
//                    fragmentTransaction.show(mfragment);
//                    mCurrentFragment = mfragment;
//                }
//                fragmentTransaction.commit();
//                fragmentManager.executePendingTransactions();
//            }
//        }else {
//            mCurrentFragment = fragmenthome;
//            changeTab(0);
//
//        }


    }
}
//    private  void detachFragement(){
//
//        if (fragmenthome.isAdded()){
//            fragmentTransaction.detach(fragmenthome);
//        }
//        if (fragmentshop.isAdded()){
//            fragmentTransaction.detach(fragmentshop);
//        }
//        if (fragmentsearch.isAdded()){
//            fragmentTransaction.detach(fragmentsearch);
//        }
//        if (fragmentmy.isAdded()){
//            fragmentTransaction.detach(fragmentmy);
//        }
//    }



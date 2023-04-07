package com.example.medicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    ViewPager sliderViewPager;
    LinearLayout dotIndicator;
    ViewPagerAdapter viewPagerAdapter;
    TextView  nextview, finishview;

ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position>0){
            nextview.setText("ПРОПУСТИТЬ");
        }

        if(position==2){
            finishview.setText("Завершить");
        } else{
            nextview.setText("Пропустить");
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
};

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        finishview = findViewById(R.id.skipTitle);
        nextview = findViewById(R.id.skipTitle);

        nextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getItem(0)> 0){
                    sliderViewPager.setCurrentItem(getItem(-1), true);
                }
            }
        });
        finishview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getItem(0) < 2){
                    sliderViewPager.setCurrentItem(getItem(1), true);
                } else{
                    Intent intent =  new Intent(NavigationActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        sliderViewPager = (ViewPager) findViewById(R.id.sliderViewPager);

        viewPagerAdapter =  new ViewPagerAdapter(this);
        sliderViewPager.setAdapter(viewPagerAdapter);

        sliderViewPager.addOnPageChangeListener(viewPagerListener);

    }

    private int getItem(int i){
        return sliderViewPager.getCurrentItem() + i;}
}
package com.example.medicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;

    int sliderAllTitles1[] = {R.string.screen1, R.string.screen2, R.string.screen3};
    int sliderAllTitles2[] = {R.string.screenDesc1, R.string.screenDesc2, R.string.screenDesc3};
    int sliderAllImages1[] = {R.drawable.circles1, R.drawable.circles2, R.drawable.circles3};
    int sliderAllImages2[] = {R.drawable.img_3, R.drawable.img_1, R.drawable.img_2};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderAllTitles1.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_screen, container, false);

        TextView sliderTitle1 = (TextView) view.findViewById(R.id.sliderTitle1);
        TextView sliderTitle2 = (TextView) view.findViewById(R.id.sliderTitle2);
        ImageView sliderImage1 = (ImageView) view.findViewById(R.id.sliderImage1);
        ImageView sliderImage2 = (ImageView) view.findViewById(R.id.sliderImage2);

        sliderTitle1.setText(this.sliderAllTitles1[position]);
        sliderTitle2.setText(this.sliderAllTitles2[position]);
        sliderImage1.setImageResource(this.sliderAllImages1[position]);
        sliderImage2.setImageResource(this.sliderAllImages2[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}

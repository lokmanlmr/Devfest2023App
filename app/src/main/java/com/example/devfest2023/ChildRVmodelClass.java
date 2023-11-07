package com.example.devfest2023;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class ChildRVmodelClass {
        private int iconUrl;
        private int iconBgColor;
        private String Title;

    public ChildRVmodelClass(int iconUrl, int iconBgColor, String title) {
        this.iconUrl = iconUrl;
        this.iconBgColor = iconBgColor;
        Title = title;
    }

    public int getIconUrl() {
        return iconUrl;
    }

    public int getIconBgColor() {
        return iconBgColor;
    }

    public String getTitle() {
        return Title;
    }

    @BindingAdapter("android:loadImg")
    public static void loadImg(ImageView view , int imgID){
        view.setImageResource(imgID);
    }

    @BindingAdapter("android:setBgImg")
    public static void setBgImg(ImageView view , int color){
        view.setBackgroundColor(color);
    }
}

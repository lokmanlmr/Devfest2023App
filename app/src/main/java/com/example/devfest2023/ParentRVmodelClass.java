package com.example.devfest2023;

import android.widget.ImageView;


import androidx.databinding.BindingAdapter;

import java.util.List;

public class ParentRVmodelClass {

    //Declaring The view type identifier
    //1---> Devfest item
    //2---> image
    //3---> another horizontal recycler view
    public static final int LayoutOne=1, LayoutTwo=2, LayoutThree=3;
    private final int viewType;


    private int imgID;
    private String title;
    private List<ChildRVmodelClass> ChildRvList;

    public ParentRVmodelClass(int viewType, List<ChildRVmodelClass> childRvList) {
        this.viewType = viewType;
        ChildRvList = childRvList;
    }

    public List<ChildRVmodelClass> getChildRvList() {
        return ChildRvList;
    }

    public ParentRVmodelClass(int viewType, int imgID, String title) {
        this.viewType = viewType;
        this.imgID = imgID;
        this.title = title;
    }

    public ParentRVmodelClass(int viewType, int imgID) {
        this.viewType = viewType;
        this.imgID = imgID;
    }

    public int getViewType() {
        return viewType;
    }

    public int getImgID() {
        return imgID;
    }

    public String getTitle() {
        return title;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    @BindingAdapter("android:loadImg")
    public static void loadImg(ImageView view ,int imgID){
        view.setImageResource(imgID);
    }
}

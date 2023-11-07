package com.example.devfest2023;

import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MainFragment extends Fragment {

    Context context;

    public MainFragment(Context context) {
        this.context = context;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    parentRVAdapter parentRVAadapter;
    private int currentIndex = 0;
    private int[] imageResources = {R.drawable.adsone, R.drawable.adstwo};

    private Handler handler = new Handler();
    private Runnable imageChangeRunnable = new Runnable() {
        @Override
        public void run() {
            if (currentIndex < imageResources.length - 1) {
                currentIndex++;
            } else {
                currentIndex = 0;
            }

            // Update the image for the item at position 0 in the RecyclerView
            parentRVAadapter.updateImage(0, imageResources[currentIndex]);

            // Schedule the next image change after 1.5 second
            handler.postDelayed(this, 1500);
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main, container, false);


        //data source of the child rv
        ArrayList<ChildRVmodelClass> childList =new ArrayList<>();
        childList.add(new ChildRVmodelClass(R.drawable.mobile_programming_01,
                ContextCompat.getColor(context, R.color.blue),"Mobile"));
        childList.add(new ChildRVmodelClass(R.drawable.web_design_01,
                ContextCompat.getColor(context, R.color.yellow),"Web"));
        childList.add(new ChildRVmodelClass(R.drawable.developer,
                ContextCompat.getColor(context, R.color.blue),"Ai"));
        childList.add(new ChildRVmodelClass(R.drawable.web_security,
                ContextCompat.getColor(context, R.color.yellow),"Security"));
        childList.add(new ChildRVmodelClass(R.drawable.gameboy,
                ContextCompat.getColor(context, R.color.blue),"Game Dev"));



        //Creating the data source For Parent Recycler View
        ArrayList<ParentRVmodelClass> List =new ArrayList<>();
        List.add(new ParentRVmodelClass(2,R.drawable.adsone));
        List.add(new ParentRVmodelClass(3,childList));
        List.add(new ParentRVmodelClass(1,R.drawable.blueimg,"Devfest22"));
        List.add(new ParentRVmodelClass(1,R.drawable.yellowimg,"Devfest21"));
        List.add(new ParentRVmodelClass(1,R.drawable.blueimg,"Devfest20"));
        List.add(new ParentRVmodelClass(1,R.drawable.yellowimg,"Devfest19"));


        //creating the adapter instance
        parentRVAadapter =new parentRVAdapter(context,List);

        //setting the adapter
        RecyclerView recyclerView=view.findViewById(R.id.parent_rv);
        recyclerView.setAdapter(parentRVAadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        // Start the image change process
        handler.postDelayed(imageChangeRunnable, 1000);

        parentRVAadapter.notifyDataSetChanged();














        return view;
    }
}
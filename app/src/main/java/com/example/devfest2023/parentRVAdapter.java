package com.example.devfest2023;

import static com.example.devfest2023.ParentRVmodelClass.LayoutOne;
import static com.example.devfest2023.ParentRVmodelClass.LayoutThree;
import static com.example.devfest2023.ParentRVmodelClass.LayoutTwo;

import android.content.Context;
import android.view.LayoutInflater;

import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.devfest2023.databinding.ChildRecyclerViewBinding;
import com.example.devfest2023.databinding.ChildRecyclerViewItemBinding;
import com.example.devfest2023.databinding.DevfestItemLayoutBinding;
import com.example.devfest2023.databinding.SwithingImgLayoutBinding;

import java.util.List;

public class parentRVAdapter extends RecyclerView.Adapter{

    Context context;
    List<ParentRVmodelClass> list ;


    public parentRVAdapter(Context context, List<ParentRVmodelClass> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        switch(list.get(position).getViewType()){
            case 1 :
                return LayoutOne ;

            case 2 :
                return LayoutTwo ;

            case 3 :
                return LayoutThree ;

            default:
                return -1;
        }
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
            case LayoutOne:
                LayoutInflater inflater =LayoutInflater.from(context);
                DevfestItemLayoutBinding binding1 = DevfestItemLayoutBinding.inflate(inflater, parent, false);
                return new viewHolderOne(binding1);

            case LayoutTwo:
                inflater =LayoutInflater.from(context);
                SwithingImgLayoutBinding binding2 = SwithingImgLayoutBinding.inflate(inflater, parent, false);
                return new viewHolderTwo(binding2);

            case LayoutThree:
                inflater =LayoutInflater.from(context);
                ChildRecyclerViewBinding binding3 = ChildRecyclerViewBinding.inflate(inflater, parent, false);
                return new viewHolderThree(binding3);

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (list.get(position).getViewType()){
            case LayoutOne:
                ParentRVmodelClass item1 = list.get(position);
                ((viewHolderOne)holder).bind(item1);
                break;
            case LayoutTwo:
                ParentRVmodelClass item2 = list.get(position);
                ((viewHolderTwo)holder).bind(item2);
                break;
            case LayoutThree:
                ParentRVmodelClass item3 = list.get(position);
                childClassAdapter adapter=new childClassAdapter(item3.getChildRvList(),context);
                LinearLayoutManager linearLayoutManager =new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                ((viewHolderThree)holder).binding.childRV.setAdapter(adapter);
                ((viewHolderThree)holder).binding.childRV.setLayoutManager(linearLayoutManager);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class viewHolderOne extends RecyclerView.ViewHolder{
        private final DevfestItemLayoutBinding binding;

        public viewHolderOne(DevfestItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(ParentRVmodelClass item) {
            binding.setCurrentItem(item);
            binding.executePendingBindings();
        }
    }
    static class viewHolderTwo extends RecyclerView.ViewHolder{
        private final SwithingImgLayoutBinding binding;

        public viewHolderTwo(SwithingImgLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(ParentRVmodelClass item) {
            binding.setCurrentImg(item);
            binding.executePendingBindings();
        }
    }

    static class viewHolderThree extends RecyclerView.ViewHolder{
        private final ChildRecyclerViewBinding binding;

        public viewHolderThree(ChildRecyclerViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }
    public void updateImage(int position, int newImageResource) {
        // Update the image resource for the item at the given position
        list.get(position).setImgID(newImageResource);
        notifyItemChanged(position);
    }
}

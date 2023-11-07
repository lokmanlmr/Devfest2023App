package com.example.devfest2023;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.devfest2023.databinding.ChildRecyclerViewItemBinding;
import com.example.devfest2023.databinding.DevfestItemLayoutBinding;

import java.util.List;

public class childClassAdapter extends RecyclerView.Adapter<childClassAdapter.MyViewHolder> {

    List<ChildRVmodelClass> list ;
    Context context;

    public childClassAdapter(List<ChildRVmodelClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        ChildRecyclerViewItemBinding binding =ChildRecyclerViewItemBinding.inflate(inflater,parent,false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            ChildRVmodelClass item =list.get(position);
            holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private final ChildRecyclerViewItemBinding binding;

        public MyViewHolder(ChildRecyclerViewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(ChildRVmodelClass item) {
            binding.setCurrentItem(item);
            binding.executePendingBindings();
        }

    }
}

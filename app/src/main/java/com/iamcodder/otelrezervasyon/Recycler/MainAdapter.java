package com.iamcodder.otelrezervasyon.Recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iamcodder.otelrezervasyon.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Holder> {

    private List<Integer> list;
    private Context mContext;

    public MainAdapter(List<Integer> list,Context mContext) {
        this.list = list;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootView= LayoutInflater.from(parent.getContext()).inflate(R.layout.full_screen_image,parent,false);

        Holder holder=new Holder(rootView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Glide.with(mContext).load(list.get(position)).into(holder.full_screen_img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView full_screen_img;

        public Holder(@NonNull View itemView) {
            super(itemView);
            full_screen_img=itemView.findViewById(R.id.full_screen_img);
        }
    }
}

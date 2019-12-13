package com.zuleyha.otelrezervasyon.Recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zuleyha.otelrezervasyon.Interface.RoomTypeInterface;
import com.zuleyha.otelrezervasyon.Model.chooseRoomModel;
import com.zuleyha.otelrezervasyon.R;

import java.util.List;

public class ChooseRoomAdapter extends RecyclerView.Adapter<ChooseRoomAdapter.Holder> {

    private List<chooseRoomModel> list;
    private Context mContext;
    private RoomTypeInterface roomTypeInterface;

    public ChooseRoomAdapter(List<chooseRoomModel> list, Context mContext,RoomTypeInterface roomTypeInterface) {
        this.list = list;
        this.mContext = mContext;
        this.roomTypeInterface=roomTypeInterface;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootView= LayoutInflater.from(mContext).inflate(R.layout.roomtypedesign,parent,false);
        Holder holder=new Holder(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {

        holder.txt_baslik.setText(list.get(position).getBaslik());
        holder.txt_icerik.setText(list.get(position).getIcerik());

        Glide.with(mContext).load(list.get(position).getImage()).into(holder.img);

        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomTypeInterface.buttonNumber(position+1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txt_baslik;
        TextView txt_icerik;
        Button mButton;

        public Holder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.roomtypedesign_image);
            txt_baslik=itemView.findViewById(R.id.roomtypedesign_txt_baslik);
            txt_icerik=itemView.findViewById(R.id.roomtypedesign_txt_aciklama);
            mButton=itemView.findViewById(R.id.roomtypedesign_txt_button);

        }
    }
}

package com.zuleyha.otelrezervasyon.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.zuleyha.otelrezervasyon.Interface.RoomTypeInterface;
import com.zuleyha.otelrezervasyon.Model.chooseRoomModel;
import com.zuleyha.otelrezervasyon.R;
import com.zuleyha.otelrezervasyon.Recycler.ChooseRoomAdapter;

import java.util.ArrayList;

public class ChooseRoomType extends AppCompatActivity implements RoomTypeInterface {

    private RecyclerView recyclerView;
    private ChooseRoomAdapter adapter;
    private ArrayList<chooseRoomModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_room_type);
        init();
        listAdd();
        recyclerSet();
    }

    private void init(){
        recyclerView=findViewById(R.id.activity_choose_room_type_recyc);
        list=new ArrayList<>();
    }

    private void listAdd(){
        list.add(new chooseRoomModel(R.drawable.roomstudio,"Studio Room","vs"));
        list.add(new chooseRoomModel(R.drawable.roomsuite,"Suite Room","vs"));
        list.add(new chooseRoomModel(R.drawable.roomjrsuit,"Jr Suite Room","vs"));
        list.add(new chooseRoomModel(R.drawable.roompresidentialsuite,"Presidential Room","vs"));
        list.add(new chooseRoomModel(R.drawable.roomfamilysuite,"Family Suite Room","vs"));
    }

    private void recyclerSet(){
        adapter=new ChooseRoomAdapter(list,this,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void buttonNumber(int position) {

        Intent intent=new Intent(this, ChooseRoomTypeLoad.class);
        intent.putExtra("value",position);
        startActivity(intent);
    }
}

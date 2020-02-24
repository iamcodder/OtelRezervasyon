package com.iamcodder.otelrezervasyon.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iamcodder.otelrezervasyon.Interface.RoomTypeInterface;
import com.iamcodder.otelrezervasyon.Model.chooseRoomModel;
import com.iamcodder.otelrezervasyon.R;
import com.iamcodder.otelrezervasyon.Recycler.ChooseRoomAdapter;

import java.util.ArrayList;

public class ChooseRoomType extends AppCompatActivity implements RoomTypeInterface {

    private RecyclerView recyclerView;
    private ChooseRoomAdapter adapter;
    private ArrayList<chooseRoomModel> list;

    private ArrayList<String> liste1, liste2;
    private int sayac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_room_type);
        init();
        listAdd();
        recyclerSet();
    }

    private void init() {
        sayac = 0;
        recyclerView = findViewById(R.id.activity_choose_room_type_recyc);
        list = new ArrayList<>();
        liste1 = getIntent().getStringArrayListExtra("liste1");
        liste2 = getIntent().getStringArrayListExtra("liste2");

        getIntent().removeExtra("liste2");
        getIntent().removeExtra("liste1");
    }

    private void listAdd() {

        list.add(new chooseRoomModel(R.drawable.roomstudio, liste1.get(0), liste2.get(0)));
        list.add(new chooseRoomModel(R.drawable.roomsuite, liste1.get(1), liste2.get(1)));
        list.add(new chooseRoomModel(R.drawable.roomjrsuit, liste1.get(2), liste2.get(2)));
        list.add(new chooseRoomModel(R.drawable.roompresidentialsuite, liste1.get(3), liste2.get(3)));
        list.add(new chooseRoomModel(R.drawable.roomfamilysuite, liste1.get(4), liste2.get(4)));


    }

    private void recyclerSet() {
        adapter = new ChooseRoomAdapter(list, this, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void buttonNumber(int position) {

        Intent intent = new Intent(this, ChooseRoomTypeLoad.class);
        intent.putExtra("value", position);
        startActivity(intent);
    }

}

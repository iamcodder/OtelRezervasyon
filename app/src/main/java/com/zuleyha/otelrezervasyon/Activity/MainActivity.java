package com.zuleyha.otelrezervasyon.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zuleyha.otelrezervasyon.Activity.ChooseRoomType;
import com.zuleyha.otelrezervasyon.R;
import com.zuleyha.otelrezervasyon.Recycler.MainAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Integer> list;
    private ImageView img_reservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listAdd();
        recylerSet();
        clicked();


    }


    private void init(){
        recyclerView=findViewById(R.id.main_recycler);
        list =new ArrayList<>();
        img_reservation=findViewById(R.id.main_img_reservation);
    }

    private void clicked(){

        img_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChooseRoomType.class));
            }
        });

    }
    private void listAdd(){
        list.add(R.drawable.otel);
        list.add(R.drawable.otell);
        list.add(R.drawable.otelll);
        list.add(R.drawable.otellll);
    }
    private void recylerSet(){

        MainAdapter adapter=new MainAdapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }
}

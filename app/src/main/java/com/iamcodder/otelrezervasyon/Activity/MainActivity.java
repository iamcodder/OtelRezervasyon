package com.iamcodder.otelrezervasyon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iamcodder.otelrezervasyon.R;
import com.iamcodder.otelrezervasyon.Recycler.MainAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Integer> list;
    private ImageView img_reservation,img_sorgula;

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
        img_sorgula=findViewById(R.id.main_img_reservation2);
    }

    private void clicked(){

        img_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivityLoad.class));
            }
        });

        img_sorgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RezervasyonNumarasi.class));
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

    @Override
    public void onBackPressed() {

    }
}

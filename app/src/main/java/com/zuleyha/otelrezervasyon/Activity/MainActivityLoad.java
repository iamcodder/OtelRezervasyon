package com.zuleyha.otelrezervasyon.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.zuleyha.otelrezervasyon.Firebase.GetFirebase;
import com.zuleyha.otelrezervasyon.Interface.FirebaseGETInterface;
import com.zuleyha.otelrezervasyon.Model.odaBilgileri;
import com.zuleyha.otelrezervasyon.Model.odaTipi;
import com.zuleyha.otelrezervasyon.R;

import java.util.ArrayList;

public class MainActivityLoad extends AppCompatActivity implements FirebaseGETInterface.odaAktar{

    private Intent intent ;
    private GetFirebase getFirebase;

    private ArrayList<String> liste1,liste2;
    private int sayac;
    private int i1,i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_load);
        init();

    }

    private void init(){
        sayac=0;
        i1=1;
        i2=1;
        liste1=new ArrayList<>();
        liste2=new ArrayList<>();
        getFirebase=new GetFirebase(this);

        getFirebase.fetchOdaBilgileri(""+i1);
        getFirebase.fetchOdaTipi(""+i2);

    }

    @Override
    public void odaAktar(odaTipi odaTipi) {
        if(i2<=5){
            liste1.add(odaTipi.getTip());
            i2++;
            getFirebase.fetchOdaTipi(""+i2);
            control();
        }

    }

    @Override
    public void odaBilgi(odaBilgileri odaBilgileri) {
        if(i1<=5){
            liste2.add(odaBilgileri.getBilgi());
            i1++;
            getFirebase.fetchOdaBilgileri(""+i1);
            control();
        }



    }

    private void control(){
        sayac++;
        if(sayac==10){
            intent=new Intent(this,ChooseRoomType.class);
            intent.putStringArrayListExtra("liste1",liste1);
            intent.putStringArrayListExtra("liste2",liste2);
            startActivity(intent);
            finish();
        }
    }

}

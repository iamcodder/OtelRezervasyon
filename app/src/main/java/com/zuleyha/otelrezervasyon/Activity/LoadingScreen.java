package com.zuleyha.otelrezervasyon.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.zuleyha.otelrezervasyon.Interface.FirebaseInterface;
import com.zuleyha.otelrezervasyon.Model.BosOdaSayisi;
import com.zuleyha.otelrezervasyon.Model.FirebaseObj;
import com.zuleyha.otelrezervasyon.R;

public class LoadingScreen extends AppCompatActivity implements FirebaseInterface {

    private int value;
    private Intent intent;
    private FirebaseObj firebaseObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        init();
        control();
    }

    private void init(){
        intent=getIntent();
        firebaseObj=new FirebaseObj(this);
    }
    private void control() {
        value = getIntent().getExtras().getInt("value");
        firebaseObj.fetchBosOdaSayisi(String.valueOf(value));

        firebaseObj.fetchTekKisilikId(String.valueOf(value));
        firebaseObj.fetchCiftKisilikId(String.valueOf(value));
        firebaseObj.fetchUcKisilikId(String.valueOf(value));

    }

    @Override
    public void bosOdaSayisi(BosOdaSayisi bosOdaSayisi) {
        Log.d("Sülo Boş Tek : ",bosOdaSayisi.getTek());
        Log.d("Sülo Boş Çift : ",bosOdaSayisi.getCift());
        Log.d("Sülo Boş Üç : ",bosOdaSayisi.getUc());
    }


    @Override
    public void tekKisiId(String id) {
        firebaseObj.fetchTekUcret(id);
    }

    @Override
    public void ciftKisiId(String id) {
        firebaseObj.fetchTekUcret(id);
    }

    @Override
    public void ucKisiId(String id) {
        firebaseObj.fetchUcUcret(id);
    }

    @Override
    public void ucretTekKisi(String ucret) {
        Log.d("Sülo Ücret Tek : ",ucret);

    }

    @Override
    public void ucretCiftKisi(String ucret) {
        Log.d("Sülo Ücret Çift : ",ucret);

    }

    @Override
    public void ucretUcKisi(String ucret) {
        Log.d("Sülo Ücret Üç : ",ucret);

    }

}

package com.zuleyha.otelrezervasyon.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.zuleyha.otelrezervasyon.Firebase.PostFirebase;
import com.zuleyha.otelrezervasyon.Interface.FirebasePOSTInterface;
import com.zuleyha.otelrezervasyon.Model.BosOdaSayisi;
import com.zuleyha.otelrezervasyon.Model.Musteri;
import com.zuleyha.otelrezervasyon.R;

import java.util.UUID;

public class UserInfoLoad extends AppCompatActivity implements FirebasePOSTInterface {

    private String uuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_load);
        Intent intent=getIntent();

        Musteri musteri=intent.getParcelableExtra("musteri");
        BosOdaSayisi bosOdaSayisi=intent.getParcelableExtra("bosOdaSayisi");

        Log.d("Sülo ",musteri.getOdaTipi());

        uuid = UUID.randomUUID().toString();

        PostFirebase firebase=new PostFirebase(this);
        firebase.postRezervasyon(musteri,uuid);
        firebase.postOdaBosluk(musteri.getOdaTipi(),musteri.getOdaSecimi(),bosOdaSayisi);


    }

    @Override
    public void isSucces(boolean isSucces, String Message) {
        if(isSucces){
            Toast.makeText(this,Message,Toast.LENGTH_SHORT).show();
            Intent intentt=new Intent(getApplicationContext(),SuccesRezervation.class);
            intentt.putExtra("uuid",uuid);
            startActivity(intentt);
            finish();
        }
        else {
            Toast.makeText(this,Message,Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onBackPressed() {

    }
}

package com.iamcodder.otelrezervasyon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.iamcodder.otelrezervasyon.Firebase.PostFirebase;
import com.iamcodder.otelrezervasyon.Interface.FirebasePOSTInterface;
import com.iamcodder.otelrezervasyon.Model.BosOdaSayisi;
import com.iamcodder.otelrezervasyon.Model.Musteri;
import com.iamcodder.otelrezervasyon.R;

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

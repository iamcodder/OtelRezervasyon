package com.iamcodder.otelrezervasyon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.iamcodder.otelrezervasyon.Firebase.GetFirebase;
import com.iamcodder.otelrezervasyon.Interface.FirebaseGETInterface;
import com.iamcodder.otelrezervasyon.Model.Musteri;
import com.iamcodder.otelrezervasyon.R;

public class RezervasyonLoad extends AppCompatActivity implements FirebaseGETInterface.Rezervasyon {

    private String str_rez_no;
    private GetFirebase getFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervasyon_load);
        str_rez_no=getIntent().getStringExtra("rezNo");
        getIntent().removeExtra("rezNo");

        getFirebase=new GetFirebase(this);
        getFirebase.fetchKullaniciBilgileri(str_rez_no);

    }

    @Override
    public void musteriAktar(Musteri musteri,boolean isSucces) {
        if(isSucces){
            Intent intent =new Intent(this,showUserInfo.class);
            intent.putExtra("musteri",musteri);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(),"Rezervasyon Numarası Hatalı",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}

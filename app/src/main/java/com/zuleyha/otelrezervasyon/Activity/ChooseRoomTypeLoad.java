package com.zuleyha.otelrezervasyon.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.zuleyha.otelrezervasyon.Interface.FirebaseGETInterface;
import com.zuleyha.otelrezervasyon.Model.BosOdaSayisi;
import com.zuleyha.otelrezervasyon.Firebase.GetFirebase;
import com.zuleyha.otelrezervasyon.Model.ciftKisilik;
import com.zuleyha.otelrezervasyon.Model.tekKisilik;
import com.zuleyha.otelrezervasyon.Model.ucKisilik;
import com.zuleyha.otelrezervasyon.R;

public class ChooseRoomTypeLoad extends AppCompatActivity implements FirebaseGETInterface {

    private int odaTipi;
    private Intent intent;
    private GetFirebase getFirebase;
    private int sayac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        init();
        control();
    }

    private void init(){
        getFirebase =new GetFirebase(this);
        intent=new Intent(this,ChooseRoomGen.class);

        sayac=0;
    }
    private void control() {
        odaTipi = getIntent().getExtras().getInt("value");
        getFirebase.fetchBosOdaSayisi(String.valueOf(odaTipi));

        getFirebase.fetchTekKisilikId(String.valueOf(odaTipi));
        getFirebase.fetchCiftKisilikId(String.valueOf(odaTipi));
        getFirebase.fetchUcKisilikId(String.valueOf(odaTipi));

        intent.putExtra("odaTipi",String.valueOf(odaTipi));
        sayac_kontrol();

        getIntent().removeExtra("value");

    }


    //boş oda sayısı nesnesi de aktarılacak
    @Override
    public void bosOdaSayisi(BosOdaSayisi bosOdaSayisi) {
        intent.putExtra("bosOdaSayisi",bosOdaSayisi);
        sayac_kontrol();
    }


    //bir sonraki activitye burada tek kişilik mi seçildiği yoksa çift mi yoksa
    //yoksa üç mü olduğunu burada stringe atayıp intentle aktarma yapmamız lazım.
    //En son kullanıcı rezerve edince tek çift kişi bilgisi gerekli
    @Override
    public void tekKisiId(tekKisilik tekKisilik) {
        getFirebase.fetchTekUcret(tekKisilik.getUcretId());
        intent.putExtra("tekKisi",tekKisilik);
        sayac_kontrol();
    }

    @Override
    public void ciftKisiId(ciftKisilik ciftKisilik) {
        getFirebase.fetchCiftUcret(ciftKisilik.getUcretId());
        intent.putExtra("ciftKisi",ciftKisilik);
        sayac_kontrol();
    }

    @Override
    public void ucKisiId(ucKisilik ucKisilik) {
        getFirebase.fetchUcUcret(ucKisilik.getUcretId());
        intent.putExtra("ucKisi",ucKisilik);
        sayac_kontrol();
    }

    @Override
    public void ucretTekKisi(String ucret) {
        intent.putExtra("TekKisiUcret",ucret);
        sayac_kontrol();
    }

    @Override
    public void ucretCiftKisi(String ucret) {
        intent.putExtra("CiftKisiUcret",ucret);
        sayac_kontrol();
    }

    @Override
    public void ucretUcKisi(String ucret) {
        intent.putExtra("UcKisiUcret",ucret);
        sayac_kontrol();
    }

    private void sayac_kontrol(){
        sayac++;
        if(sayac==8){

            sayac=0;
            finish();

            startActivity(intent);

        }
    }


    /*intent içinde
        Oda tipinin idsini gönderiyor
        intent.putExtra("odaTipi",String.valueOf(odaTipi));

        O seçilen odanın idsiyle OdaGenisligi tablosuna gidip oda idsiyle BosOdaSayisi
        dalına gidiyor
        intent.putExtra("bosOdaSayisi",bosOdaSayisi);

        Oda genişliklerinini (tek,çift,üç) gönderiyoruz
        intent.putExtra("ucKisi",ucKisilik);
        intent.putExtra("ciftKisi",ciftKisilik);
        intent.putExtra("tekKisi",tekKisilik);

        alınan ücret idleri ile Ucret tablosuna gidip ücretleri buluyor
        intent.putExtra("ucretTekKisi",ucret);
        intent.putExtra("ucretCiftKisi",ucret);
        intent.putExtra("ucretUcKisi",ucret);
     */

}

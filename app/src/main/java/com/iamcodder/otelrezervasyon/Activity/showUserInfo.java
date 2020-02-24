package com.iamcodder.otelrezervasyon.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.iamcodder.otelrezervasyon.Model.Musteri;
import com.iamcodder.otelrezervasyon.R;

public class showUserInfo extends AppCompatActivity {

    private TextView txt_tc,txt_isim,txt_telefon,txt_email,txt_dogum,
            txt_gidis,txt_donus,txt_odatipi,txt_odagenis,txt_ucret;

    private Musteri musteri;

    private String odaTipi,odaGenislik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_info);
        musteri=getIntent().getParcelableExtra("musteri");
        getIntent().removeExtra("musteri");

        init();
        controlTip();
        controlGenislik();
        setData();

    }

    private void init(){
        txt_tc=findViewById(R.id.txt_user_tc);
        txt_isim=findViewById(R.id.txt_user_isim);
        txt_email=findViewById(R.id.txt_user_email);
        txt_dogum=findViewById(R.id.txt_user_dogum);
        txt_gidis=findViewById(R.id.txt_user_gidis);
        txt_donus=findViewById(R.id.txt_user_donus);
        txt_odatipi=findViewById(R.id.txt_user_oda_tipi);
        txt_odagenis=findViewById(R.id.txt_user_oda_genisligi);
        txt_ucret=findViewById(R.id.txt_user_ucret);
        txt_telefon=findViewById(R.id.txt_user_telefon);

    }

    private void controlTip(){
        String kontrolTip=musteri.getOdaTipi();
        if(kontrolTip.equals("1")){
            odaTipi="Studio";
        }
        else if(kontrolTip.equals("2")){
            odaTipi="Suite";
        }
        else if(kontrolTip.equals("3")){
            odaTipi="Jr Suite";
        }
        else if(kontrolTip.equals("4")){
            odaTipi="Presidential Suite";
        }
        else if(kontrolTip.equals("5")){
            odaTipi="Family Suite";
        }
    }

    private void controlGenislik(){
        String kontrolTip=musteri.getOdaSecimi();

        if(kontrolTip.equals("1")){
            odaGenislik="Tek Kişilik";
        }
        else if(kontrolTip.equals("2")){
            odaGenislik="Çift Kişilik";
        }
        else if(kontrolTip.equals("3")){
            odaGenislik="Üç Kişilik";
        }
    }

    private void setData(){

        txt_tc.setText(musteri.getTc());
        txt_isim.setText(musteri.getIsim());
        txt_email.setText(musteri.getEmail());
        txt_dogum.setText(musteri.getDogum_tarihi());
        txt_gidis.setText(musteri.getGidis_tarihi());
        txt_donus.setText(musteri.getDonus_tarihi());
        txt_odatipi.setText(odaTipi);
        txt_odagenis.setText(odaGenislik);
        txt_ucret.setText(musteri.getOdenecekTutar());
        txt_telefon.setText(musteri.getNumara());


    }
}

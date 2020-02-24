package com.iamcodder.otelrezervasyon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.iamcodder.otelrezervasyon.Model.BosOdaSayisi;
import com.iamcodder.otelrezervasyon.Model.ciftKisilik;
import com.iamcodder.otelrezervasyon.Model.tekKisilik;
import com.iamcodder.otelrezervasyon.Model.ucKisilik;
import com.iamcodder.otelrezervasyon.R;

public class ChooseRoomGen extends AppCompatActivity {

    private String odaTipi,ucretTekKisi,ucretCiftKisi,ucretUcKisi;
    private tekKisilik tekKisi;
    private ciftKisilik ciftKisi;
    private ucKisilik ucKisi;
    private BosOdaSayisi bosOdaSayisi;
    private ImageView img1,img2,img3;
    private TextView txt_baslik1,txt_baslik2,txt_baslik3,txt_bosluk1,txt_bosluk2,txt_bosluk3,txt_ucret1,txt_ucret2,txt_ucret3;
    private Button mButton_tek,mButton_cift,mButton_uc;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_room_gen);
        getData();
        init();
        setData();
        clicked();

    }
    private void clicked(){
        mButton_tek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bosOdaSayisi.getTek().equals("0")){
                    Toast.makeText(v.getContext(),"Tek kişilik odada boş yer yok",Toast.LENGTH_SHORT).show();
                }
                else {
                        intent.putExtra("secim","1");
                        intent.putExtra("odaTipi",odaTipi);
                        intent.putExtra("kisi",tekKisi);
                        intent.putExtra("ucret",ucretTekKisi);
                        intent.putExtra("bosOdaSayisi",bosOdaSayisi);
                        startActivity(intent);
                }
            }
        });

        mButton_cift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bosOdaSayisi.getCift().equals("0")){
                    Toast.makeText(v.getContext(),"Çift kişilik odada boş yer yok",Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra("secim","2");
                    intent.putExtra("odaTipi",odaTipi);
                    intent.putExtra("kisi",ciftKisi);
                    intent.putExtra("ucret",ucretCiftKisi);
                    intent.putExtra("bosOdaSayisi",bosOdaSayisi);
                    startActivity(intent);
                }
            }
        });

        mButton_uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bosOdaSayisi.getUc().equals("0")){
                    Toast.makeText(v.getContext(),"Üç odada boş yer yok",Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra("secim","3");
                    intent.putExtra("odaTipi",odaTipi);
                    intent.putExtra("kisi",ucKisi);
                    intent.putExtra("ucret",ucretUcKisi);
                    intent.putExtra("bosOdaSayisi",bosOdaSayisi);
                    startActivity(intent);
                }
            }
        });
    }

    private void setData(){
        txt_baslik1.setText("Tek Kişilik Oda");
        txt_bosluk1.setText("Boş Oda Sayısı : "+bosOdaSayisi.getTek());
        txt_ucret1.setText("Günlük Ücret : "+ucretTekKisi);

        txt_baslik2.setText("Çift Kişilik Oda");
        txt_bosluk2.setText("Boş Oda Sayısı : "+bosOdaSayisi.getCift());
        txt_ucret2.setText("Günlük Ücret : "+ucretCiftKisi);

        txt_baslik3.setText("Üç Kişilik Oda");
        txt_bosluk3.setText("Boş Oda Sayısı : "+bosOdaSayisi.getUc());
        txt_ucret3.setText("Günlük Ücret : "+ucretUcKisi);

    }

    private void init(){

        img1=findViewById(R.id.choose_rom_img);
        img2=findViewById(R.id.choose_rom_img2);
        img3=findViewById(R.id.choose_rom_img3);

        txt_baslik1=findViewById(R.id.choose_rom_txt_baslik);
        txt_baslik2=findViewById(R.id.choose_rom_txt_baslik2);
        txt_baslik3=findViewById(R.id.choose_rom_txt_baslik3);

        txt_bosluk1=findViewById(R.id.choose_rom_txt_aciklama10);
        txt_bosluk2=findViewById(R.id.choose_rom_txt_aciklama20);
        txt_bosluk3=findViewById(R.id.choose_rom_txt_aciklama30);

        txt_ucret1=findViewById(R.id.choose_rom_txt_aciklama15);
        txt_ucret2=findViewById(R.id.choose_rom_txt_aciklama25);
        txt_ucret3=findViewById(R.id.choose_rom_txt_aciklama35);

        mButton_tek=findViewById(R.id.choose_rom_button);
        mButton_cift=findViewById(R.id.choose_rom_button2);
        mButton_uc=findViewById(R.id.choose_rom_button3);

        intent=new Intent(getApplicationContext(),UserInfo.class);
    }
    private void getData(){
        odaTipi=getIntent().getStringExtra("odaTipi");
        bosOdaSayisi=getIntent().getParcelableExtra("bosOdaSayisi");
        tekKisi=getIntent().getParcelableExtra("tekKisi");
        ciftKisi=getIntent().getParcelableExtra("ciftKisi");
        ucKisi=getIntent().getParcelableExtra("ucKisi");
        ucretTekKisi=getIntent().getStringExtra("TekKisiUcret");
        ucretCiftKisi=getIntent().getStringExtra("CiftKisiUcret");
        ucretUcKisi=getIntent().getStringExtra("UcKisiUcret");

        getIntent().removeExtra("odaTipi");
        getIntent().removeExtra("bosOdaSayisi");
        getIntent().removeExtra("tekKisi");
        getIntent().removeExtra("ciftKisi");
        getIntent().removeExtra("ucKisi");
        getIntent().removeExtra("TekKisiUcret");
        getIntent().removeExtra("CiftKisiUcret");
        getIntent().removeExtra("UcKisiUcret");

    }

}

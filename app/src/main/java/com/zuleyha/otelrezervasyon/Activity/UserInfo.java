package com.zuleyha.otelrezervasyon.Activity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zuleyha.otelrezervasyon.Model.BosOdaSayisi;
import com.zuleyha.otelrezervasyon.Model.Musteri;
import com.zuleyha.otelrezervasyon.Model.ciftKisilik;
import com.zuleyha.otelrezervasyon.Model.tekKisilik;
import com.zuleyha.otelrezervasyon.Model.ucKisilik;
import com.zuleyha.otelrezervasyon.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class UserInfo extends AppCompatActivity {

    private String odaTipi, ucret;
    private BosOdaSayisi bosOdaSayisi;
    private tekKisilik tekKisi;
    private ciftKisilik ciftKisi;
    private ucKisilik ucKisi;
    private String secim;

    private int toplam_suree;

    private Button btn_gidis_tarihi, btn_gelis_tarihi, btn_dogum_tarihi, btn_rezervasyon_yap;
    private EditText edx_isim_soyisim, edx_tc, edx_email, edx_phone;
    private TextView txt_toplam_sure, txt_ucret;

    private Calendar mCalendar;
    private DatePickerDialog DatePicker;
    private int day, month, year,odenecekTutar;

    private String gidis_tarihi, gelis_tarihi, dogum_tarihi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        getData();
        init();
        clicked();
    }

    private void yazdir() {

        odenecekTutar= 0;

        if (secim.equals("1")) {
            txt_toplam_sure.setText(toplam_suree + " Gece");
            odenecekTutar = Integer.parseInt(ucret) * toplam_suree;
        } else if (secim.equals("2")) {
            txt_toplam_sure.setText(toplam_suree + " Gece");
            odenecekTutar = (Integer.parseInt(ucret) * toplam_suree) * 2;
        } else if (secim.equals("3")) {
            txt_toplam_sure.setText(toplam_suree + " Gece");
            odenecekTutar = (Integer.parseInt(ucret) * toplam_suree) * 3;
        }

        txt_ucret.setText("Ödenecek Tutar " + odenecekTutar + " TL");

    }

    private void clicked() {

        btn_gidis_tarihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePicker = new DatePickerDialog(UserInfo.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        gidis_tarihi = dayOfMonth + "/" + (month + 1) + "/" + year;
                        btn_gidis_tarihi.setText(gidis_tarihi);
                        if (gelis_tarihi != null && !gelis_tarihi.equals("")) {
                            toplam_suree = (int) getDateDiff(new SimpleDateFormat("dd/MM/yyyy"), gelis_tarihi, gidis_tarihi);
                            if (toplam_suree < 0) {
                                txt_toplam_sure.setText("Hatalı Tarih Seçimi");
                                txt_ucret.setText("Hatalı Tarih Seçimi");
                            } else {
                                yazdir();
                            }
                        }
                    }
                }, day, month, year);
                DatePicker.updateDate(2019, 11, 14);
                DatePicker.show();
            }
        });

        btn_gelis_tarihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker = new DatePickerDialog(UserInfo.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        gelis_tarihi = dayOfMonth + "/" + (month + 1) + "/" + year;
                        btn_gelis_tarihi.setText(gelis_tarihi);
                        if (gidis_tarihi != null && !gidis_tarihi.equals("")) {
                            toplam_suree = (int) getDateDiff(new SimpleDateFormat("dd/MM/yyyy"), gelis_tarihi, gidis_tarihi);
                            if (toplam_suree < 0) {
                                txt_toplam_sure.setText("Hatalı Tarih Seçimi");
                                txt_ucret.setText("Hatalı Tarih Seçimi");
                            } else {
                                yazdir();
                            }
                        }
                    }
                }, day, month, year);
                DatePicker.updateDate(2019, 11, 14);
                DatePicker.show();
            }
        });

        btn_dogum_tarihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker = new DatePickerDialog(UserInfo.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dogum_tarihi = dayOfMonth + "/" + (month + 1) + "/" + year;
                        btn_dogum_tarihi.setText(dogum_tarihi);

                    }
                }, day, month, year);
                DatePicker.updateDate(2019, 11, 14);
                DatePicker.show();
            }
        });

        btn_rezervasyon_yap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // edx_isim_soyisim,edx_tc,edx_email,edx_phone
                // String gidis_tarihi,gelis_tarihi,dogum_tarihi

                Intent intent = new Intent(getApplicationContext(), UserInfoLoad.class);



                Musteri musteri=new Musteri();

                musteri.setOdaSecimi(secim);
                musteri.setOdaTipi(odaTipi);
                musteri.setOdenecekTutar(String.valueOf(odenecekTutar));
                musteri.setTc(edx_tc.getText().toString());
                musteri.setIsim(edx_isim_soyisim.getText().toString());
                musteri.setNumara(edx_phone.getText().toString());
                musteri.setEmail(edx_email.getText().toString());
                musteri.setDogum_tarihi(dogum_tarihi);
                musteri.setGidis_tarihi(gidis_tarihi);
                musteri.setDonus_tarihi(gelis_tarihi);

                intent.putExtra("musteri",musteri);
                intent.putExtra("bosOdaSayisi",bosOdaSayisi);

                startActivity(intent);


            }
        });

    }

    private void init() {
        btn_gidis_tarihi = findViewById(R.id.btn_gidis_tarihi);
        btn_gelis_tarihi = findViewById(R.id.btn_gelis_tarihi);
        btn_dogum_tarihi = findViewById(R.id.btn_dogum_Tarihi);
        btn_rezervasyon_yap = findViewById(R.id.btn_rezervasyon);

        edx_email = findViewById(R.id.edx_email);
        edx_tc = findViewById(R.id.edx_tc);
        edx_isim_soyisim = findViewById(R.id.edx_isim_soyisim);
        edx_phone = findViewById(R.id.edx_cep_no);

        txt_toplam_sure = findViewById(R.id.txt_toplam_sure);
        txt_ucret = findViewById(R.id.txt_ucret);

        mCalendar = Calendar.getInstance();


        day = mCalendar.get(Calendar.DAY_OF_MONTH);
        month = mCalendar.get(Calendar.MONTH);
        year = mCalendar.get(Calendar.YEAR);
    }

    private void getData() {

        //oda seçimi 1se tek,2yse çift,3se üç
        secim = getIntent().getStringExtra("secim");

        //odaTipi idyi veriyor
        odaTipi = getIntent().getStringExtra("odaTipi");

        //tek gecelik ücreti
        ucret = getIntent().getStringExtra("ucret");

        //seçtiği oda tipi ve kişi sayısındaki oda sayısı
        bosOdaSayisi = getIntent().getParcelableExtra("bosOdaSayisi");


        getIntent().removeExtra("secim");
        getIntent().removeExtra("odaTipi");
        getIntent().removeExtra("ucret");
        getIntent().removeExtra("bosOdaSayisi");

    }

    public static long getDateDiff(SimpleDateFormat format, String oldDate, String newDate) {
        try {
            return TimeUnit.DAYS.convert(format.parse(newDate).getTime() - format.parse(oldDate).getTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

package com.iamcodder.otelrezervasyon.Activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.iamcodder.otelrezervasyon.R;

public class SuccesRezervation extends AppCompatActivity {

    private TextView txt_uid;
    private Button btn_kopyala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_rezervation);

        txt_uid=findViewById(R.id.rez_numara);
        final String uid=getIntent().getStringExtra("uuid");
        txt_uid.setText(uid);

        btn_kopyala=findViewById(R.id.btn_kopyla);
        btn_kopyala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("uid", uid);
                clipboard.setPrimaryClip(clip);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                Toast.makeText(getApplicationContext(),"Rezervasyon numarası kopyalandı",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}

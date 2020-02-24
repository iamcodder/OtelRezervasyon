package com.iamcodder.otelrezervasyon.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.iamcodder.otelrezervasyon.R;

public class RezervasyonNumarasi extends AppCompatActivity {

    private EditText edx_rez_no;
    private String str_rez_no;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervasyon_numarasi);

        edx_rez_no=findViewById(R.id.edx_rez_no);
        mButton=findViewById(R.id.sorgula);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_rez_no=edx_rez_no.getText().toString();
                if(!str_rez_no.equals("")){
                    Intent intent =new Intent(v.getContext(),RezervasyonLoad.class);
                    intent.putExtra("rezNo",str_rez_no);
                    startActivity(intent);
                }
            }
        });

    }
}

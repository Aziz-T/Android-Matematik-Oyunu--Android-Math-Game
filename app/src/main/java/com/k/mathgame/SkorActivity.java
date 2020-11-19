package com.k.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class SkorActivity extends AppCompatActivity {
    private TextView soruSayisi, dogruSayisi,yanlisSayisi;
    private Button bitirButton;
    private Toolbar toolbar;
    private int ss,ds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);
        bitirButton=findViewById(R.id.bitirButton);
        soruSayisi = findViewById(R.id.soruSayisi);
        dogruSayisi = findViewById(R.id.dogruSayi);
        yanlisSayisi=findViewById(R.id.yanlisSayi);

        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setTitle("SONUÇ");


        ss=getIntent().getIntExtra("soruSayisi",0);
        ds=getIntent().getIntExtra("skor",0);

        soruSayisi.setText("Soru Sayisi: "+ss);
        dogruSayisi.setText(String.valueOf(ds));
        yanlisSayisi.setText(String.valueOf(ss-ds));

        bitirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkorActivity.this,SeviyeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

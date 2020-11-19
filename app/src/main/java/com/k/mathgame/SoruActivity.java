package com.k.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;


public class SoruActivity extends AppCompatActivity {
    private TextView soruText, sayiText, dogruYanlis, timerText;
    private GridLayout gridLayout;
    private String seviyeAdi;
    private Button nextbutton,tryButton;
    private int position=0 , deger=0 ,toplam=0, skor=0,saniye=60,zaman ;
    private int[] intDizi = new int[8];
    private int[] secilenDizi = new int[8];
    private SoruModeliVeriTabani soruModeliVeriTabani;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru);

        soruText=findViewById(R.id.soruText);
        sayiText=findViewById(R.id.sayiText);
        dogruYanlis=findViewById(R.id.dogruYanlis);
        gridLayout=findViewById(R.id.grid);
        nextbutton= findViewById(R.id.nextButton);
        timerText=findViewById(R.id.timerText);
        tryButton=findViewById(R.id.tryButton);

        zaman=getIntent().getIntExtra("zaman",0);
        seviyeAdi = getIntent().getStringExtra("seviyeAdi");

        soruModeliVeriTabani = new SoruModeliVeriTabani(seviyeAdi);

        seviyeOlustur(gridLayout,0,seviyeAdi,sayiText);
        nextbutton.setEnabled(false);
        zaman--;
        if(zaman!=0){
        countDownTimer = new CountDownTimer(zaman*60000,1000) {
            @Override
            public void onTick(long l) {
                if(saniye==0){
                    timerText.setText("0"+String.valueOf(zaman) + ":" + String.valueOf(saniye));
                    saniye=59;
                    zaman--;
                }else{
                    timerText.setText("0"+String.valueOf(zaman) + ":" + String.valueOf(saniye));
                    saniye--;

                } }
            @Override
            public void onFinish() {
                timerText.setText("Bitti");
                Intent intent = new Intent(SoruActivity.this, SkorActivity.class);
                intent.putExtra("skor",skor);
                intent.putExtra("soruSayisi",soruModeliVeriTabani.soruModelList.size());
                startActivity(intent);
                finish();
            }
        }.start();
        }else {
            timerText.setText("Süre Yok");
        }

        diziSifirla(secilenDizi);
        for(int i=0 ; i<8; i++){
           final int k = i;
            gridLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    deger++;
                    ((Button)gridLayout.getChildAt(k)).setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.secilenbutton));
                    gridLayout.getChildAt(k).setClickable(false);
                    secilenDizi[k]=k;

                    String option;
                    option = String.valueOf(((Button)gridLayout.getChildAt(k)).getText());
                    intDizi[k] = Integer.parseInt(option);

                    if(deger==3){
                        nextbutton.setEnabled(true);
                        for(int c=0 ; c<8; c++){
                            enable((Button)gridLayout.getChildAt(c));
                            toplam = toplam+ intDizi[c];
                            intDizi[c]= 0;}
                            if(toplam==Integer.parseInt(sayiText.getText().toString())){
                                dogruYanlis.setText("DOĞRU");
                                desitir(gridLayout,secilenDizi,"dogru");
                                dogruYanlis.setTextColor(Color.GREEN);
                                skor++;
                                toplam=0;
                                deger=0;
                            } else {
                                dogruYanlis.setText("YANLIŞ");
                                dogruYanlis.setTextColor(Color.RED);
                                desitir(gridLayout,secilenDizi,"yanlis");
                                toplam=0;
                                deger=0;
                            }
                        tryButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                buttonDuzenle(gridLayout);
                                diziSifirla(secilenDizi);
                                deger=0;
                            }
                        });
                    }

                }
            });
        }

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position++;
                nextbutton.setEnabled(false);
                dogruYanlis.setTextColor(Color.BLACK);
                diziSifirla(secilenDizi);
                Toast.makeText(SoruActivity.this, ""+position+soruModeliVeriTabani.soruModelList.size(), Toast.LENGTH_SHORT).show();
                if(position==soruModeliVeriTabani.soruModelList.size()){
                    Intent intent = new Intent(SoruActivity.this, SkorActivity.class);
                    intent.putExtra("skor",skor);
                    intent.putExtra("soruSayisi",soruModeliVeriTabani.soruModelList.size());
                    startActivity(intent);
                    finish();
                } else {
                    seviyeOlustur(gridLayout,position,seviyeAdi,sayiText);
                    buttonDuzenle(gridLayout);
                }

            }
        });

    }

    private void diziSifirla(int[] secilenDizi) {
        for(int j =0 ; j<8 ; j++){
            secilenDizi[j]=-1;
        }
    }

    private void desitir(GridLayout gridLayout, int[] secilenDizi, String durum) {
        for(int j =0 ; j<8 ; j++){
            if(secilenDizi[j]==j){
                if(durum.equals("yanlis")){
                    ((Button)gridLayout.getChildAt(j)).setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.yanlis_cevap));
                }else if(durum.equals("dogru")){
                    ((Button)gridLayout.getChildAt(j)).setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.dogru_cevap));
                }
            }
        }
    }


    private void buttonDuzenle(GridLayout gridLayout) {
        for(int i =0 ; i<8 ; i++)
        {
            dogruYanlis.setText("-");
            ((Button)gridLayout.getChildAt(i)).setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.cervelibutton));
            ((Button)gridLayout.getChildAt(i)).setClickable(true);
        }
    }


    private void seviyeOlustur(GridLayout gridLayout, int position, String seviyeAdi, TextView sayiText) {
        if(seviyeAdi.equals("Seviye 1")||seviyeAdi.equals("Seviye 2")||seviyeAdi.equals("Seviye 3")||seviyeAdi.equals("Seviye 4")){
            sayiText.setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getSayi()));
        for(int i =0 ; i<8 ; i++)
        {   if(i==0)
            ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR1()));
            if(i==1)
                ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR2()));
            if(i==2)
                ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR3()));
            if(i==3)
                ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR4()));
            if (i>3){
                kapat((Button)gridLayout.getChildAt(i));
            }
        }
        } else
            if(seviyeAdi.equals("Seviye 5")||seviyeAdi.equals("Seviye 6")||seviyeAdi.equals("Seviye 7")||seviyeAdi.equals("Seviye 8")){
            sayiText.setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getSayi()));
            for(int i =0 ; i<8 ; i++)
            {   if(i==0)
                ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR1()));
                if(i==1)
                    ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR2()));
                if(i==2)
                    ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR3()));
                if(i==3)
                    ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR4()));
                if(i==4)
                    ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR5()));
                if(i==5)
                    ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR6()));
                if(i==6)
                    ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR7()));
                if(i==7)
                    ((Button)gridLayout.getChildAt(i)).setText(String.valueOf(soruModeliVeriTabani.soruModelList.get(position).getR8()));
                if (i>7){
                    kapat((Button)gridLayout.getChildAt(i));
                }
            }
        }
    }

    private void enable(Button childAt) {
        childAt.setClickable(false);

    }
    private void kapat(Button childAt) {
        childAt.setEnabled(false);
        childAt.setAlpha(0);
    }

}

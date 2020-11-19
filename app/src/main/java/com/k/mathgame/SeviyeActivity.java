package com.k.mathgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class SeviyeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<SeviyeModel> seviyeModelList;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye);
        recyclerView=findViewById(R.id.seviyeRec);
        seviyeModelList=new ArrayList<>();
        toolbar=findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Seviyeler");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        final SeviyeAdapter seviyeAdapter = new SeviyeAdapter(seviyeModelList);
        recyclerView.setAdapter(seviyeAdapter);

        for (int i = 1 ; i<=10 ; i++ ){
            String isim = "Seviye " + i;
            seviyeModelList.add(new SeviyeModel(isim));
        }

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

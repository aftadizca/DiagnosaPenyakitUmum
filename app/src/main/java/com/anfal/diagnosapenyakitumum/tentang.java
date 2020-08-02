package com.anfal.diagnosapenyakitumum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tentang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Tentang Aplikasi");
        setContentView(R.layout.activity_tentang);
    }
    public void profilpakar(View view){
        Intent i = new Intent(tentang.this,profilpakar.class);
        startActivity(i);
    }
}
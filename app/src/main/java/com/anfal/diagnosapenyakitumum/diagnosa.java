package com.anfal.diagnosapenyakitumum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class diagnosa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_diagnosa);
    }
    //berpindah ke halaman pilih diagnosa
    public void diagnosa2(View view){
        Intent i = new Intent(diagnosa.this, diagnosa2.class);
        startActivity(i);
    }
}
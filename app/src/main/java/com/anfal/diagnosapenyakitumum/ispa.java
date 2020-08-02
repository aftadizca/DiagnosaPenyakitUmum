package com.anfal.diagnosapenyakitumum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ispa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Informasi Penyakit ISPA");
        setContentView(R.layout.activity_ispa);
    }
    public void kembali (View view) {
        Intent i = new Intent(ispa.this, infopenyakit.class);
        startActivity(i);
    }
}
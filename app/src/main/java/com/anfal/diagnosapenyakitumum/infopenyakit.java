package com.anfal.diagnosapenyakitumum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class infopenyakit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Info Penyakit");
        setContentView(R.layout.activity_infopenyakit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //Fungsi berpindah activity dari info penyakit ke activity tifus//
    public void tifus(View view) {
        Intent i = new Intent(infopenyakit.this, tifus.class);
        startActivity(i);
    }
    //Fungsi berpindah activity dari informasi penyakit ke faringitis//
    public void faringitis(View view) {
        Intent i = new Intent(infopenyakit.this, faringitis.class);
        startActivity(i);
    }
    //Fungsi berpindah activity dari informasi penyakit ke diare//
    public void diare(View view) {
        Intent i = new Intent(infopenyakit.this, diare.class);
        startActivity(i);
    }
    //Fungsi berpindah activity dari info penyakit ke maag//
    public void maag(View view) {
        Intent i = new Intent(infopenyakit.this, maag.class);
        startActivity(i);
    }
    //Fungsi berpindah activity dari info penyakit ke maag//
    public  void ispa(View vew) {
        Intent i = new Intent(infopenyakit.this, ispa.class);
        startActivity(i);
    }
    //Fungsi berpindah activity dari info penyakit ke vertigo//
    public void vertigo(View view) {
        Intent i = new Intent(infopenyakit.this, vertigo.class);
        startActivity(i);
    }
}
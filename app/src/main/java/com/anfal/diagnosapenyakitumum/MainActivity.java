package com.anfal.diagnosapenyakitumum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("SiPaDAKU");
        setContentView(R.layout.activity_main);

    }
    //fungsi untuk berpindah ke activity, dari main ke diagnosa//
    public void diagnosa(View view) {
        Intent i = new Intent(MainActivity.this, diagnosa.class);
        startActivity(i);
    }
    //fungsi untuk berpindah activity dari main ke halaman info penyakit//
    public void infopenyakit(View view) {
        Intent i = new Intent(MainActivity.this, infopenyakit.class);
        startActivity(i);
    }
    //fungsi untuk berpindah actifity dari main ke bantuan//
    public void bantuan(View view) {
        Intent i = new Intent(MainActivity.this, bantuan.class);
        startActivity(i);
    }
    //fungsi untuk berpindah activity dari main ke tentang//
    public void tentang(View view) {
        Intent i = new Intent(MainActivity.this, tentang.class);
        startActivity(i);
    }
}
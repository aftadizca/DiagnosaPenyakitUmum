package com.anfal.diagnosapenyakitumum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class tifus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Informsai Penyakit Tifus");
        setContentView(R.layout.activity_tifus);

        //inisialisasi dan mendeklarasikan textview untuk scroll
        TextView textView = findViewById(R.id.tifus);
        //menambahkan method scroll agar text view dapat di scroll vertikal
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
package com.anfal.diagnosapenyakitumum;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class hasildiagnosa_berhasil extends AppCompatActivity {

    String kodePenyakit;
    ArrayList<String> listGejala;
    TextView hasilDiagnosa;
    Penyakit penyakit;
    Button btnGoHome;
    Button btnInfoPenyakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasildiagnosa_berhasil);
        getSupportActionBar().hide();

        penyakit = new Penyakit();

        //get intent data
        Intent intent = getIntent();
        kodePenyakit = intent.getStringExtra(Constant.KODE_PENYAKIT);
        listGejala = intent.getStringArrayListExtra(Constant.LIST_GEJALA);

        //get view
        hasilDiagnosa = findViewById(R.id.hasil_diagnosa);
        btnGoHome = findViewById(R.id.btn_go_home);
        btnInfoPenyakit = findViewById(R.id.btn_go_info);

        int countDetectedGejala = listGejala.size();
        int countGejala = penyakit.getGejala(kodePenyakit);

        if((float)countDetectedGejala/(float)countGejala >= 0.5){
            hasilDiagnosa.setText(String.format("Anda mengalami %s gejala dari %s gejala penyakit %s",countDetectedGejala,countGejala, penyakit.getPenyakit(kodePenyakit)));
        }else{
            hasilDiagnosa.setText("Mohon maaf, kami tidak bisa mendiagnosa penyakit berdasarkan gejala yang anda alami.");
            btnInfoPenyakit.setVisibility(View.INVISIBLE);
        }

        btnGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        btnInfoPenyakit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (kodePenyakit){
//                    case "P1":
//                        Intent i = new Intent(hasildiagnosa_berhasil.this,tifus.class);
//                        startActivity(i);
//                        break;
//                    case "P2":
//                        Intent i = new Intent(hasildiagnosa_berhasil.this,tifus.class);
//                        startActivity(i);
//                        break;
//                    case "P3":
//                        Intent i = new Intent(hasildiagnosa_berhasil.this,tifus.class);
//                        startActivity(i);
//                        break;
//                    case "P4":
//                        Intent i = new Intent(hasildiagnosa_berhasil.this,tifus.class);
//                        startActivity(i);
//                        break;
//                    case "P5":
//                        Intent i = new Intent(hasildiagnosa_berhasil.this,tifus.class);
//                        startActivity(i);
//                        break;
//                    case "P6":
//                        Intent i = new Intent(hasildiagnosa_berhasil.this,tifus.class);
//                        startActivity(i);
//                        break;
//                }
//            }
//        });

    }

    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(hasildiagnosa_berhasil.this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        // code here to show dialog
        //super.onBackPressed();  // optional depending on your needs
    }
}
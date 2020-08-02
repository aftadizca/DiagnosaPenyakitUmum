package com.anfal.diagnosapenyakitumum;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class hasildiagnosa_berhasil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasildiagnosa_berhasil);
        getSupportActionBar().hide();
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
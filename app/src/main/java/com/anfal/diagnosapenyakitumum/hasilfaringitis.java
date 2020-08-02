package com.anfal.diagnosapenyakitumum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hasilfaringitis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasilfaringitis);
    }
    public void home(View view){
        Intent i = new Intent(hasilfaringitis.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(hasilfaringitis.this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        // code here to show dialog
        //super.onBackPressed();  // optional depending on your needs
    }
}
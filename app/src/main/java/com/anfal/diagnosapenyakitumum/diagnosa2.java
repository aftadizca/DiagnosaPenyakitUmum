package com.anfal.diagnosapenyakitumum;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.scalified.tree.TreeNode;

import java.util.ArrayList;

public class diagnosa2 extends AppCompatActivity {

Button btnDiagnosa;
RadioGroup rg;
TreeNode<String> root;
TreeNode<String> currentNode;
GejalaPenyakit gejalaPenyakit;
String gejala;
ArrayList<String> listGejala;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa2);
        getSupportActionBar().hide();

        btnDiagnosa = findViewById(R.id.buttondiagnosa);
        btnDiagnosa.setEnabled(false);
        rg = findViewById(R.id.rgDiagnosa2);
        rg.removeAllViews();
        listGejala = new ArrayList<>();
        root = new Tree().getRoot();
        gejalaPenyakit = new GejalaPenyakit();

        for(TreeNode<String> node : root.subtrees()){
            RadioButton rb = new RadioButton(diagnosa2.this);
            rb.setText(gejalaPenyakit.getGejalaPenyakit(node.data()));
            rb.setTag(node.data());
            rb.setPadding(0,10,0,10);
            rb.setTextAppearance(R.style.RadioButtonStyle);
            rg.addView(rb);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                gejala = rb.getTag().toString();
                btnDiagnosa.setEnabled(true);
            }
        });

        btnDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pergi(v);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TEST", "diagnosa 2 on pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!listGejala.isEmpty()){
            listGejala.remove(listGejala.size()-1);
            Log.d("TEST", "diagnosa 2 on resume");
        }
    }

    public void pergi(View view){
        Intent i = new Intent(diagnosa2.this,Diagnosa3.class);
        listGejala.add(gejala);
        for(TreeNode<String> node : root.subtrees()){
            if(node.data().equals(gejala)){
                currentNode = node;
            }
        }
        i.putExtra("list_gejala", listGejala);
        i.putExtra("current_node",currentNode);
        startActivity(i);
    }
}
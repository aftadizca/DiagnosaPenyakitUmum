package com.anfal.diagnosapenyakitumum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.scalified.tree.TreeNode;

import java.util.ArrayList;

public class Diagnosa3 extends AppCompatActivity implements View.OnClickListener{

    TextView pertanyaanDiagnosa;
    GejalaPenyakit gejalaPenyakit;
    ArrayList<String> listGejala;
    TreeNode<String> currentNode;
    TreeNode<String> nextNode;
    int siblingIndex;
    Button yesBtn;
    Button noBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosa3);
        getSupportActionBar().hide();

        yesBtn = findViewById(R.id.button_yes);
        noBtn = findViewById(R.id.button_no);
        yesBtn.setOnClickListener(this);
        noBtn.setOnClickListener(this);
        pertanyaanDiagnosa = findViewById(R.id.pertanyaanDiagnosa);

        Log.d("TEST","----------------------------------");

        gejalaPenyakit = new GejalaPenyakit();
        Intent intent = getIntent();
        //get data from previous diagnose
        siblingIndex = intent.getIntExtra("sibling_index",0);
        listGejala = intent.getStringArrayListExtra("list_gejala");
        currentNode = (TreeNode<String>) intent.getSerializableExtra("current_node");
        Log.d("TEST","sibling index : "+siblingIndex);
        if(currentNode.subtrees().size() == 1 ){
            nextNode = Tree.getSubTree(currentNode);
        }else if(siblingIndex == currentNode.subtrees().size()-1){
            nextNode = Tree.getSubTree(Tree.getSibling(currentNode,siblingIndex));
        }else{
            nextNode = Tree.getSibling(currentNode,siblingIndex);
        }

        Log.d("TEST","list_gejala: "+listGejala.toString());
        Log.d("TEST","curentnode : "+currentNode.data());
        Log.d("TEST","curentnode size : "+currentNode.subtrees().size());
        Log.d("TEST","nextNode : "+nextNode.data());
        Log.d("TEST","nextNode_size : "+nextNode.subtrees().size());

        if(nextNode.subtrees().size() == 0){
            Intent i = new Intent(Diagnosa3.this, hasildiagnosa_berhasil.class);
            startActivity(i);
        }

        pertanyaanDiagnosa.setText("Apakah anda mengalami gejala "+gejalaPenyakit.getGejalaPenyakit(nextNode.data())+" ?");

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Diagnosa3.this,Diagnosa3.class);
        switch (v.getId()) {
            case R.id.button_yes:
                listGejala.add(nextNode.data());
                i.putExtra("list_gejala", listGejala);
                i.putExtra("current_node",nextNode);
                break;
            case R.id.button_no:
                i.putExtra("list_gejala", listGejala);
                // jika tidak ada cabang
                if(currentNode.subtrees().size() == 1 || siblingIndex == currentNode.subtrees().size()-1){
                    Log.d("TEST","pindah ke bawah");
                    i.putExtra("current_node",nextNode);
                    i.putExtra("sibling_index",0);
                }else{
                    Log.d("TEST","pindah ke samping");
                    i.putExtra("current_node",currentNode);
                    i.putExtra("sibling_index",siblingIndex+1);
                }
                break;
        }
        startActivity(i);
    }
}
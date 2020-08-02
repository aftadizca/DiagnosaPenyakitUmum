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
        siblingIndex = intent.getIntExtra(Constant.SIBLING_INDEX,0);
        listGejala = intent.getStringArrayListExtra(Constant.LIST_GEJALA);
        currentNode = (TreeNode<String>) intent.getSerializableExtra(Constant.CURRENT_NODE);

        Log.d("TEST","sibling index : "+siblingIndex);

        //cek jika tree memiliki sibling atau tidak
        if(currentNode.subtrees().size() == 1 ){
            //jika tidak memiliki sibling, geser ke node bawahnya
            Log.d("TEST","nextnode1");
            nextNode = Tree.getSubTree(currentNode);
        }else{
            //jika punya sibling, geser ke samping kanan
            nextNode = Tree.getSibling(currentNode,siblingIndex);
            Log.d("TEST","nextnode3");
        }

        Log.d("TEST","list_gejala: "+listGejala.toString());
        Log.d("TEST","curentnode : "+currentNode.data());
        Log.d("TEST","curentnode size : "+currentNode.subtrees().size());
        Log.d("TEST","nextNode : "+nextNode.data());
        Log.d("TEST","nextNode_size : "+nextNode.subtrees().size());

        if(nextNode.subtrees().size() == 0){
            Intent i = new Intent(Diagnosa3.this, hasildiagnosa_berhasil.class);
            i.putExtra(Constant.KODE_PENYAKIT, nextNode.data());
            i.putExtra(Constant.LIST_GEJALA, listGejala);
            startActivity(i);

            switch (nextNode.data()){
                case "P1":
                    Intent tifus = new Intent(Diagnosa3.this,hasiltifus.class);
                    startActivity(tifus);
                    break;
                case "P2":
                    Intent faringitis = new Intent(Diagnosa3.this,hasilfaringitis.class);
                    startActivity(faringitis);
                    break;
                case "P3":
                    Intent diare = new Intent(Diagnosa3.this,hasildiare.class);
                    startActivity(diare);
                    break;
                case "P4":
                    Intent ispa = new Intent(Diagnosa3.this,hasilispa.class);
                    startActivity(ispa);
                    break;
                case "P5":
                    Intent maag = new Intent(Diagnosa3.this,hasilmaag.class);
                    startActivity(maag);
                    break;
                case "P6":
                    Intent vertigo = new Intent(Diagnosa3.this,hasilvertigo.class);
                    startActivity(vertigo);
                    break;
            }

        }

        pertanyaanDiagnosa.setText("Apakah anda mengalami gejala "+gejalaPenyakit.getGejalaPenyakit(nextNode.data())+" ?");

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Diagnosa3.this,Diagnosa3.class);
        switch (v.getId()) {
            case R.id.button_yes:
                listGejala.add(nextNode.data());
                i.putExtra(Constant.LIST_GEJALA, listGejala);
                i.putExtra(Constant.CURRENT_NODE, nextNode);
                break;
            case R.id.button_no:
                i.putExtra("list_gejala", listGejala);
                // jika tidak ada cabang
                if(currentNode.subtrees().size() == 1 || siblingIndex == currentNode.subtrees().size()-1){
                    Log.d("TEST","pindah ke bawah");
                    i.putExtra(Constant.CURRENT_NODE,nextNode);
                    i.putExtra(Constant.SIBLING_INDEX,0);
                }else{
                    Log.d("TEST","pindah ke samping");
                    i.putExtra(Constant.CURRENT_NODE,currentNode);
                    i.putExtra(Constant.SIBLING_INDEX,siblingIndex+1);
                }
                break;
        }
        startActivity(i);
    }
}
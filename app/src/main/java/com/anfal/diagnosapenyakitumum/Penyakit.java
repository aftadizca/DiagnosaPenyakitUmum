package com.anfal.diagnosapenyakitumum;

import java.util.HashMap;

public class Penyakit {
    //kode penyakit
    private HashMap<String,String> penyakit = new HashMap<>();
    //jumlah gejala
    private HashMap<String,Integer> gejala = new HashMap<>();


    private void setPenyakit(String key, String value) {
        this.penyakit.put(key, value);
    }

    public String getPenyakit(String key) {
        return this.penyakit.get(key);
    }

    private void setGejala(String key, Integer value) {
        this.gejala.put(key, value);
    }

    public Integer getGejala(String key) {
        return this.gejala.get(key);
    }

    public Penyakit(){
        setPenyakit("P1", "Tifus");
        setPenyakit("P2", "Radang Tenggorokan");
        setPenyakit("P3", "Diare");
        setPenyakit("P4", "ISPA");
        setPenyakit("P5", "Maag");
        setPenyakit("P6", "Vertigo");

        setGejala("P1", 8);
        setGejala("P2", 6);
        setGejala("P3", 7);
        setGejala("P4", 6);
        setGejala("P5", 7);
        setGejala("P6", 6);
    }

}

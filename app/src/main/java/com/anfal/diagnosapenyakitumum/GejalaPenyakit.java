package com.anfal.diagnosapenyakitumum;

import java.util.HashMap;

public class GejalaPenyakit {
    private HashMap<String,String> gejalaPenyakit = new HashMap<>();


    private void setGejalaPenyakit(String key, String value) {
        this.gejalaPenyakit.put(key, value);
    }

    public String getGejalaPenyakit(String key) {
        return this.gejalaPenyakit.get(key);
    }

    public GejalaPenyakit(){
        setGejalaPenyakit("G1", "Demam bertahap dari 38C sampai 40C");
        setGejalaPenyakit("G2", "Kelelahan dan Lemas");
        setGejalaPenyakit("G3", "Batuk Kering");
        setGejalaPenyakit("G4", "Sakit Perut");
        setGejalaPenyakit("G5", "Penurunan Berat Badan");
        setGejalaPenyakit("G6", "Kehilangan nafsu makan atau berkurangnya nafsu makan");
        setGejalaPenyakit("G7", "Muncul ruam pada kulit berupa bintik-bintik kecil merah");
        setGejalaPenyakit("G9", "Sakit kepala");
        setGejalaPenyakit("G11", "Sakit tenggorokan (nyeri)");
        setGejalaPenyakit("G12", "Nyeri sendi dan nyeri otot");
        setGejalaPenyakit("G13", "Membengkaknya kelenjar getah bening di leher");
        setGejalaPenyakit("G18", "Feses (BAB) lembek atau cair");
        setGejalaPenyakit("G19", "Kram perut");
        setGejalaPenyakit("G20", "Mual dan muntah");
        setGejalaPenyakit("G22", "Terus menerus buang air besar");
        setGejalaPenyakit("G29", "Hidung tersumbat dan pilek");
        setGejalaPenyakit("G30", "Demam ringan pada anak");
        setGejalaPenyakit("G31", "Gejala sinusitis seperti wajah terasa nyeri, hidung beringus.");
        setGejalaPenyakit("G32", "Ritme atau kecepatan bernafas cepat atau kesulitan bernafas");
        setGejalaPenyakit("G34", "Naiknya asam lambung yang ditandai dengan kembung pada perut.");
        setGejalaPenyakit("G35", "Mudah kenyang");
        setGejalaPenyakit("G36", "Sering bersendawa");
        setGejalaPenyakit("G37", "Nyeri pada ulu hati disertai dengan sensasi terbakar di bagian dada");
        setGejalaPenyakit("G38", "Nyeri perut yang tiba – tiba dan terasa begitu menyakitkan.");
        setGejalaPenyakit("G39", "Anemia atau kurang darah pada tubuh.");
        setGejalaPenyakit("G40", "Pergerakan bola mata yang tidak normal");
        setGejalaPenyakit("G42", "Penglihatan berbayang");
        setGejalaPenyakit("G44", "Kesulitan berbicara");
        setGejalaPenyakit("G45", "Penurunan kesadaran pada otak (mengigau, dll)");
        setGejalaPenyakit("G47", "Migrain atau sakit kepala");
    }

}
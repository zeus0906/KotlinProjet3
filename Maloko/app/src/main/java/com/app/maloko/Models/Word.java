package com.app.maloko.Models;

public class Word {
    private String francais;
    private String traduis;

    private int audio;

    public Word(String francais, String traduis,int audio) {
        this.francais = francais;
        this.traduis = traduis;
        this.audio = audio;
    }

    public String getFrancais() {
        return francais;
    }

    public void setFrancais(String francais) {
        this.francais = francais;
    }

    public String getTraduis() {
        return traduis;
    }

    public void setTraduis(String traduis) {
        this.traduis = traduis;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }
}

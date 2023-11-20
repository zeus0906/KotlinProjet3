package com.app.maloko.Models;

public class Number {

        int NumId;
        String number;

    public Number(int numId, String number) {
        NumId = numId;
        this.number = number;
    }

    public int getNumId() {
        return NumId;
    }

    public void setNumId(int numId) {
        NumId = numId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

package com.app.maloko.Models;

public class Category {

        int CatId;
        String CatName;

    public Category(int catId, String catName) {
        CatId = catId;
        CatName = catName;
    }

    public int getCatId() {
        return CatId;
    }

    public void setCatId(int catId) {
        CatId = catId;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String catName) {
        CatName = catName;
    }
}

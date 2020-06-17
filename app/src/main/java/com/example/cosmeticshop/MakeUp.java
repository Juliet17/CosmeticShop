package com.example.cosmeticshop;

import androidx.annotation.NonNull;

public class MakeUp {

    private String title;
    private String info;
    private int imageId; // saves image id

    public MakeUp(String title, String info, int imageId) {
        this.title = title;
        this.info = info;
        this.imageId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageId() {
        return imageId;
    }

    // чтобы было понятно, какой элемент выводить, надо переопределить toString()
    @NonNull
    @Override
    public String toString() {
        return title;
    }
}

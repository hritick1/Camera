package com.example.camera;

import android.graphics.Bitmap;

public class Data {
    public Data(Bitmap bp, String name) {
        this.bp = bp;
        this.name = name;
    }

    public Bitmap getBp() {
        return bp;
    }

    public String getName() {
        return name;
    }

    Bitmap bp;
    String name;
}

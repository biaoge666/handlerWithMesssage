package com.example.activitystudy;


import android.graphics.Bitmap;

public  class Real{
    private String text;
    private Bitmap bitmap;


    public void setText(String text) {
        this.text = text;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getText() {
        return text;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

}

package com.example.vita.tablayout;

import android.graphics.drawable.Drawable;

/**
 * Created by vita on 2017/6/15.
 */

public class Classifydata {
    private  String mIntro;
    private Drawable mIcon;

    public Classifydata(String intro, Drawable img) {
        this.mIcon = img;
        this.mIntro = intro;
    }

    public String getaName() {
        return mIntro;
    }



    public Drawable getaImg() {
        return mIcon;
    }

    public void setaName(String aName) {
        this.mIntro = aName;
    }

    public void setaIncon(Drawable aIncon) {
        this.mIcon = aIncon;
    }

}

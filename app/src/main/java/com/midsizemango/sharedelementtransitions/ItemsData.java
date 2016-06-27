package com.midsizemango.sharedelementtransitions;

/**
 * Created by Pooja S on 6/27/2016.
 */
public class ItemsData {

    private String name;
    private int imageUrl;

    public ItemsData(String name, int imageUrl){
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

}
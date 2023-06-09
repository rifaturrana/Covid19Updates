package com.asp1.navigationdrawe.ui.slideshow;

public class ModelCountry {
    private String country;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ModelCountry(String country, int image) {
        this.country = country;
        this.image = image;
    }

    public ModelCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

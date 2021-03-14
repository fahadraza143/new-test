package com.example.eventdiary;

public class events {

    String text;
    int pic;

    public events(String tex, int pic) {
        this.text=tex;
        this.pic=pic;
    }

    public String getTex() {
        return text;
    }

    public void setTex(String tex) {
        this.text = tex;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
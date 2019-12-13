package com.zuleyha.otelrezervasyon.Model;

public class chooseRoomModel {

    private int Image;
    private String baslik,icerik;

    public chooseRoomModel(int image, String baslik, String icerik) {
        Image = image;
        this.baslik = baslik;
        this.icerik = icerik;
    }

    public int getImage() {
        return Image;
    }

    public String getBaslik() {
        return baslik;
    }

    public String getIcerik() {
        return icerik;
    }
}

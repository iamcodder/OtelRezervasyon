package com.zuleyha.otelrezervasyon.Model;

public class Ucret {

    private String id;
    private String ucret;

    Ucret(){}

    public Ucret(String id, String ucret) {
        this.id = id;
        this.ucret = ucret;
    }

    public String getId() {
        return id;
    }

    public String getUcret() {
        return ucret;
    }
}

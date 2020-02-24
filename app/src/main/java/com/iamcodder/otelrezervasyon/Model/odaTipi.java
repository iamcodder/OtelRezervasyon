package com.iamcodder.otelrezervasyon.Model;

public class odaTipi {

    private String id,tip;

    public odaTipi(String id, String tip) {
        this.id = id;
        this.tip = tip;
    }
    public odaTipi(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}

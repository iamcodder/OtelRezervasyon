package com.zuleyha.otelrezervasyon.Model;

public class BosOdaSayisi {

    private String cift,tek,uc;

    public BosOdaSayisi(){};

    public BosOdaSayisi(String cift, String tek, String uc) {
        this.cift = cift;
        this.tek = tek;
        this.uc = uc;
    }

    public String getCift() {
        return cift;
    }

    public String getTek() {
        return tek;
    }

    public String getUc() {
        return uc;
    }
}

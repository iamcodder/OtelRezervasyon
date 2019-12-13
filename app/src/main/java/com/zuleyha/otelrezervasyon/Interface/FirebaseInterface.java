package com.zuleyha.otelrezervasyon.Interface;

import com.zuleyha.otelrezervasyon.Model.BosOdaSayisi;

public interface FirebaseInterface {

    void bosOdaSayisi(BosOdaSayisi bosOdaSayisi);

    void tekKisiId(String id);
    void ciftKisiId(String id);
    void ucKisiId(String id);

    void ucretTekKisi(String ucret);
    void ucretCiftKisi(String ucret);
    void ucretUcKisi(String ucret);


}

package com.zuleyha.otelrezervasyon.Interface;

import com.zuleyha.otelrezervasyon.Model.BosOdaSayisi;
import com.zuleyha.otelrezervasyon.Model.Musteri;
import com.zuleyha.otelrezervasyon.Model.ciftKisilik;
import com.zuleyha.otelrezervasyon.Model.odaBilgileri;
import com.zuleyha.otelrezervasyon.Model.odaTipi;
import com.zuleyha.otelrezervasyon.Model.tekKisilik;
import com.zuleyha.otelrezervasyon.Model.ucKisilik;

public interface FirebaseGETInterface {

    void bosOdaSayisi(BosOdaSayisi bosOdaSayisi);

    void tekKisiId(tekKisilik tekKisilik);
    void ciftKisiId(ciftKisilik ciftKisilik);
    void ucKisiId(ucKisilik ucKisilik);

    void ucretTekKisi(String ucret);
    void ucretCiftKisi(String ucret);
    void ucretUcKisi(String ucret);

    interface Rezervasyon{
        void musteriAktar(Musteri musteri,boolean isSucces);
    }

    interface odaAktar{
        void odaAktar(odaTipi odaTipi);
        void odaBilgi(odaBilgileri odaBilgileri);
    }

}

package com.iamcodder.otelrezervasyon.Interface;

import com.iamcodder.otelrezervasyon.Model.BosOdaSayisi;
import com.iamcodder.otelrezervasyon.Model.Musteri;
import com.iamcodder.otelrezervasyon.Model.ciftKisilik;
import com.iamcodder.otelrezervasyon.Model.odaBilgileri;
import com.iamcodder.otelrezervasyon.Model.odaTipi;
import com.iamcodder.otelrezervasyon.Model.tekKisilik;
import com.iamcodder.otelrezervasyon.Model.ucKisilik;

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

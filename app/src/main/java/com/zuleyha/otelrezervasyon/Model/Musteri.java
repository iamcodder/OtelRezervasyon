package com.zuleyha.otelrezervasyon.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Musteri implements Parcelable {

    private String kimlikNo;
    private String musteriAdi;
    private String musteriSoyadi;
    private String dogumTarihi;
    private String cepTelNo;
    private String eMail;
    private String adress;

    public Musteri(){}

    public Musteri(String kimlikNo, String musteriAdi, String musteriSoyadi, String dogumTarihi, String cepTelNo, String eMail,  String adress) {
        this.kimlikNo = kimlikNo;
        this.musteriAdi = musteriAdi;
        this.musteriSoyadi = musteriSoyadi;
        this.dogumTarihi = dogumTarihi;
        this.cepTelNo = cepTelNo;
        this.eMail = eMail;
        this.adress = adress;
    }

    protected Musteri(Parcel in) {
        kimlikNo = in.readString();
        musteriAdi = in.readString();
        musteriSoyadi = in.readString();
        dogumTarihi = in.readString();
        cepTelNo = in.readString();
        eMail = in.readString();
        adress = in.readString();
    }

    public static final Creator<Musteri> CREATOR = new Creator<Musteri>() {
        @Override
        public Musteri createFromParcel(Parcel in) {
            return new Musteri(in);
        }

        @Override
        public Musteri[] newArray(int size) {
            return new Musteri[size];
        }
    };

    public String getKimlikNo() {
        return kimlikNo;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public String getMusteriSoyadi() {
        return musteriSoyadi;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public String getCepTelNo() {
        return cepTelNo;
    }

    public String geteMail() {
        return eMail;
    }


    public String getAdress() {
        return adress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(kimlikNo);
        dest.writeString(musteriAdi);
        dest.writeString(musteriSoyadi);
        dest.writeString(dogumTarihi);
        dest.writeString(cepTelNo);
        dest.writeString(eMail);
        dest.writeString(adress);
    }
}

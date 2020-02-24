package com.iamcodder.otelrezervasyon.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Musteri implements Parcelable {

    private String odaSecimi;
    private String odaTipi;
    private String odenecekTutar;
    private String tc,isim,numara,email,dogum_tarihi;
    private String gidis_tarihi,donus_tarihi;

    public Musteri(){}

    protected Musteri(Parcel in) {
        odaSecimi = in.readString();
        odaTipi = in.readString();
        odenecekTutar = in.readString();
        tc = in.readString();
        isim = in.readString();
        numara = in.readString();
        email = in.readString();
        dogum_tarihi = in.readString();
        gidis_tarihi = in.readString();
        donus_tarihi = in.readString();
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

    public String getOdaSecimi() {
        return odaSecimi;
    }

    public void setOdaSecimi(String odaSecimi) {
        this.odaSecimi = odaSecimi;
    }

    public String getOdaTipi() {
        return odaTipi;
    }

    public void setOdaTipi(String odaTipi) {
        this.odaTipi = odaTipi;
    }

    public String getOdenecekTutar() {
        return odenecekTutar;
    }

    public void setOdenecekTutar(String odenecekTutar) {
        this.odenecekTutar = odenecekTutar;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(String dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
    }

    public String getGidis_tarihi() {
        return gidis_tarihi;
    }

    public void setGidis_tarihi(String gidis_tarihi) {
        this.gidis_tarihi = gidis_tarihi;
    }

    public String getDonus_tarihi() {
        return donus_tarihi;
    }

    public void setDonus_tarihi(String donus_tarihi) {
        this.donus_tarihi = donus_tarihi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(odaSecimi);
        dest.writeString(odaTipi);
        dest.writeString(odenecekTutar);
        dest.writeString(tc);
        dest.writeString(isim);
        dest.writeString(numara);
        dest.writeString(email);
        dest.writeString(dogum_tarihi);
        dest.writeString(gidis_tarihi);
        dest.writeString(donus_tarihi);
    }
}

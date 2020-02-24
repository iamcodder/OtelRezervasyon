package com.iamcodder.otelrezervasyon.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ciftKisilik implements Parcelable {

    private String ucretId;
    private String kisiSayisi;

    ciftKisilik(){}

    public ciftKisilik(String ucretId, String kisiSayisi) {
        this.ucretId = ucretId;
        this.kisiSayisi = kisiSayisi;
    }

    protected ciftKisilik(Parcel in) {
        ucretId = in.readString();
        kisiSayisi = in.readString();
    }

    public static final Creator<ciftKisilik> CREATOR = new Creator<ciftKisilik>() {
        @Override
        public ciftKisilik createFromParcel(Parcel in) {
            return new ciftKisilik(in);
        }

        @Override
        public ciftKisilik[] newArray(int size) {
            return new ciftKisilik[size];
        }
    };

    public String getUcretId() {
        return ucretId;
    }

    public String getKisiSayisi() {
        return kisiSayisi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ucretId);
        dest.writeString(kisiSayisi);
    }
}

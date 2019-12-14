package com.zuleyha.otelrezervasyon.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ucKisilik implements Parcelable {

    private String ucretId;
    private String kisiSayisi;

    ucKisilik(){}

    public ucKisilik(String ucretId, String kisiSayisi) {
        this.ucretId = ucretId;
        this.kisiSayisi = kisiSayisi;
    }

    protected ucKisilik(Parcel in) {
        ucretId = in.readString();
        kisiSayisi = in.readString();
    }

    public static final Creator<ucKisilik> CREATOR = new Creator<ucKisilik>() {
        @Override
        public ucKisilik createFromParcel(Parcel in) {
            return new ucKisilik(in);
        }

        @Override
        public ucKisilik[] newArray(int size) {
            return new ucKisilik[size];
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

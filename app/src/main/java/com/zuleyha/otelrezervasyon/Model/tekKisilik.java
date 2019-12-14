package com.zuleyha.otelrezervasyon.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class tekKisilik implements Parcelable {

    private String ucretId;
    private String kisiSayisi;

    tekKisilik(){}

    public tekKisilik(String ucretId,String kisiSayisi)
    {
        this.kisiSayisi=kisiSayisi;
        this.ucretId = ucretId;
    }

    protected tekKisilik(Parcel in) {
        ucretId = in.readString();
        kisiSayisi = in.readString();
    }

    public static final Creator<tekKisilik> CREATOR = new Creator<tekKisilik>() {
        @Override
        public tekKisilik createFromParcel(Parcel in) {
            return new tekKisilik(in);
        }

        @Override
        public tekKisilik[] newArray(int size) {
            return new tekKisilik[size];
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

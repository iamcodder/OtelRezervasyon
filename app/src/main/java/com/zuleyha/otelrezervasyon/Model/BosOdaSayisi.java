package com.zuleyha.otelrezervasyon.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class BosOdaSayisi implements Parcelable {

    private String cift,tek,uc;

    public BosOdaSayisi(){};

    public BosOdaSayisi(String cift, String tek, String uc) {
        this.cift = cift;
        this.tek = tek;
        this.uc = uc;
    }

    protected BosOdaSayisi(Parcel in) {
        cift = in.readString();
        tek = in.readString();
        uc = in.readString();
    }

    public static final Creator<BosOdaSayisi> CREATOR = new Creator<BosOdaSayisi>() {
        @Override
        public BosOdaSayisi createFromParcel(Parcel in) {
            return new BosOdaSayisi(in);
        }

        @Override
        public BosOdaSayisi[] newArray(int size) {
            return new BosOdaSayisi[size];
        }
    };

    public String getCift() {
        return cift;
    }

    public String getTek() {
        return tek;
    }

    public String getUc() {
        return uc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cift);
        dest.writeString(tek);
        dest.writeString(uc);
    }

    public void setCift(String cift) {
        this.cift = cift;
    }

    public void setTek(String tek) {
        this.tek = tek;
    }

    public void setUc(String uc) {
        this.uc = uc;
    }
}

package com.zuleyha.otelrezervasyon.Model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.zuleyha.otelrezervasyon.Interface.FirebaseInterface;

public class FirebaseObj {

    private FirebaseDatabase fdatabase;
    private DatabaseReference dReference;

    private BosOdaSayisi bosOdaSayisi;
    private tekKisilik objtekKisilik;
    private ciftKisilik objciftKisilik;
    private ucKisilik objuckisilik;

    private Ucret objUcretTek,objUcretCift,objUcretUc;

    private FirebaseInterface firebaseInterface;

    public FirebaseObj(FirebaseInterface firebaseInterface) {
        this.firebaseInterface = firebaseInterface;
        fdatabase=FirebaseDatabase.getInstance();
        dReference=fdatabase.getReference().child("Hotel");
    }

    //Seçilen oda için tek,çift ve üç kişilik odanın boşluk durumu
    public void fetchBosOdaSayisi(String konum){

        ValueEventListener postListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bosOdaSayisi=dataSnapshot.getValue(BosOdaSayisi.class);
                firebaseInterface.bosOdaSayisi(bosOdaSayisi);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dReference.child("OdaGenisligi").child(konum).child("BosOdaSayisi").addValueEventListener(postListener);

    }


    //Odaların ücretleri için idlerini çekme metotları
    public void fetchTekKisilikId(String konum){
        ValueEventListener mpostListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                objtekKisilik =dataSnapshot.getValue(tekKisilik.class);
                if (objtekKisilik != null) {
                    firebaseInterface.tekKisiId(objtekKisilik.getUcretId());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dReference.child("OdaGenisligi").child(konum).child("TekKisilik").addValueEventListener(mpostListener);

    }

    public void fetchCiftKisilikId(String konum){
        ValueEventListener mpostListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                objciftKisilik=dataSnapshot.getValue(ciftKisilik.class);
                if (objciftKisilik != null) {
                    firebaseInterface.tekKisiId(objciftKisilik.getUcretId());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dReference.child("OdaGenisligi").child(konum).child("CiftKisilik").addValueEventListener(mpostListener);

    }

    public void fetchUcKisilikId(String konum){
        ValueEventListener mpostListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                objuckisilik=dataSnapshot.getValue(ucKisilik.class);
                if (objuckisilik != null) {
                    firebaseInterface.tekKisiId(objuckisilik.getUcretId());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dReference.child("OdaGenisligi").child(konum).child("UcKisilik").addValueEventListener(mpostListener);

    }


    public void fetchTekUcret(String id){
        ValueEventListener mpostListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                objUcretTek =dataSnapshot.getValue(Ucret.class);
                if (objUcretTek != null) {
                    firebaseInterface.ucretTekKisi(objUcretTek.getUcret());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dReference.child("Ucret").child(id).addValueEventListener(mpostListener);

    }

    public void fetchCiftUcret(String id){
        ValueEventListener mpostListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                objUcretCift =dataSnapshot.getValue(Ucret.class);
                if (objUcretCift != null) {
                    firebaseInterface.ucretCiftKisi(objUcretCift.getUcret());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dReference.child("Ucret").child(id).addValueEventListener(mpostListener);

    }

    public void fetchUcUcret(String id){
        ValueEventListener mpostListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                objUcretUc =dataSnapshot.getValue(Ucret.class);
                if (objUcretUc != null) {
                    firebaseInterface.ucretUcKisi(objUcretUc.getUcret());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dReference.child("Ucret").child(id).addValueEventListener(mpostListener);

    }


}

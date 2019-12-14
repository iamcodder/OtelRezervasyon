package com.zuleyha.otelrezervasyon.Firebase;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.zuleyha.otelrezervasyon.Interface.FirebaseGETInterface;
import com.zuleyha.otelrezervasyon.Model.BosOdaSayisi;
import com.zuleyha.otelrezervasyon.Model.Ucret;
import com.zuleyha.otelrezervasyon.Model.ciftKisilik;
import com.zuleyha.otelrezervasyon.Model.tekKisilik;
import com.zuleyha.otelrezervasyon.Model.ucKisilik;

public class GetFirebase {

    private FirebaseDatabase fdatabase;
    private DatabaseReference dReference;

    private BosOdaSayisi bosOdaSayisi;
    private tekKisilik objtekKisilik;
    private ciftKisilik objciftKisilik;
    private ucKisilik objuckisilik;

    private Ucret objUcretTek,objUcretCift,objUcretUc;

    private FirebaseGETInterface firebaseGETInterface;

    public GetFirebase(FirebaseGETInterface firebaseGETInterface) {
        this.firebaseGETInterface = firebaseGETInterface;
        fdatabase=FirebaseDatabase.getInstance();
        dReference=fdatabase.getReference().child("Hotel");
    }

    //Seçilen oda için tek,çift ve üç kişilik odanın boşluk durumu
    public void fetchBosOdaSayisi(String konum){
        ValueEventListener postListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bosOdaSayisi=dataSnapshot.getValue(BosOdaSayisi.class);
                firebaseGETInterface.bosOdaSayisi(bosOdaSayisi);
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
                    firebaseGETInterface.tekKisiId(objtekKisilik);
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
                    firebaseGETInterface.ciftKisiId(objciftKisilik);
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
                    firebaseGETInterface.ucKisiId(objuckisilik);
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
                    firebaseGETInterface.ucretTekKisi(objUcretTek.getUcret());
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
                    firebaseGETInterface.ucretCiftKisi(objUcretCift.getUcret());
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
                    firebaseGETInterface.ucretUcKisi(objUcretUc.getUcret());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dReference.child("Ucret").child(id).addValueEventListener(mpostListener);

    }




}
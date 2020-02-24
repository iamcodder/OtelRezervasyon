package com.iamcodder.otelrezervasyon.Firebase;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.iamcodder.otelrezervasyon.Interface.FirebaseGETInterface;
import com.iamcodder.otelrezervasyon.Model.BosOdaSayisi;
import com.iamcodder.otelrezervasyon.Model.Musteri;
import com.iamcodder.otelrezervasyon.Model.Ucret;
import com.iamcodder.otelrezervasyon.Model.ciftKisilik;
import com.iamcodder.otelrezervasyon.Model.odaBilgileri;
import com.iamcodder.otelrezervasyon.Model.odaTipi;
import com.iamcodder.otelrezervasyon.Model.tekKisilik;
import com.iamcodder.otelrezervasyon.Model.ucKisilik;

public class GetFirebase {

    private FirebaseDatabase fdatabase;
    private DatabaseReference dReference;

    private BosOdaSayisi bosOdaSayisi;
    private tekKisilik objtekKisilik;
    private ciftKisilik objciftKisilik;
    private ucKisilik objuckisilik;

    private Musteri musteri;
    private odaTipi odaTipi;
    private odaBilgileri odaBilgileri;

    private Ucret objUcretTek,objUcretCift,objUcretUc;

    private FirebaseGETInterface firebaseGETInterface;
    private FirebaseGETInterface.Rezervasyon rezervasyon;
    private FirebaseGETInterface.odaAktar odaAktar;

    public GetFirebase(FirebaseGETInterface firebaseGETInterface) {
        this.firebaseGETInterface = firebaseGETInterface;
        fdatabase=FirebaseDatabase.getInstance();
        dReference=fdatabase.getReference().child("Hotel");
    }

    public GetFirebase(FirebaseGETInterface.Rezervasyon rezervasyon) {
        this.rezervasyon = rezervasyon;
        fdatabase=FirebaseDatabase.getInstance();
        dReference=fdatabase.getReference().child("Hotel");
    }

    public GetFirebase(FirebaseGETInterface.odaAktar odaAktar){
        this.odaAktar=odaAktar;
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


    public void fetchKullaniciBilgileri(String uid){

        ValueEventListener mpostListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                musteri =dataSnapshot.getValue(Musteri.class);

                if (musteri != null) {
                    rezervasyon.musteriAktar(musteri,true);
                }
                else {
                    rezervasyon.musteriAktar(musteri,false);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dReference.child("Rezervasyon").child(uid).addValueEventListener(mpostListener);
    }



    public void fetchOdaTipi(String konum){

        ValueEventListener mpostListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                odaTipi =dataSnapshot.getValue(odaTipi.class);
                odaAktar.odaAktar(odaTipi);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dReference.child("OdaTipi").child(konum).addValueEventListener(mpostListener);
    }

    public void fetchOdaBilgileri(String konum){

        ValueEventListener mpostListener=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                odaBilgileri =dataSnapshot.getValue(odaBilgileri.class);
                odaAktar.odaBilgi(odaBilgileri);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        dReference.child("OdaBilgileri").child(konum).addValueEventListener(mpostListener);
    }


}

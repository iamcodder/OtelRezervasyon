package com.zuleyha.otelrezervasyon.Firebase;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.zuleyha.otelrezervasyon.Interface.FirebasePOSTInterface;
import com.zuleyha.otelrezervasyon.Model.BosOdaSayisi;
import com.zuleyha.otelrezervasyon.Model.Musteri;

public class PostFirebase {

    private DatabaseReference mDatabaseReference;
    private FirebasePOSTInterface postInterface;


    public PostFirebase(FirebasePOSTInterface postInterface){
        mDatabaseReference= FirebaseDatabase.getInstance().getReference().child("Hotel");
        this.postInterface=postInterface;
    }

    public void postRezervasyon(Musteri musteri,String UUID){
        mDatabaseReference.child("Rezervasyon").child(UUID).setValue(musteri);
    }

    public void postOdaBosluk(String odaTipi, String odaSecimi, BosOdaSayisi bosOdaSayisi){

        int sayi=0;
        String tip;

        if(odaSecimi.equals("1")){
            sayi=Integer.parseInt(bosOdaSayisi.getTek());
            sayi--;
            bosOdaSayisi.setTek(String.valueOf(sayi));
        }
        else if(odaSecimi.equals("2")){
            sayi=Integer.parseInt(bosOdaSayisi.getCift());
            sayi--;
            bosOdaSayisi.setCift(String.valueOf(sayi));
        }
        else if(odaSecimi.equals("3")){
            sayi=Integer.parseInt(bosOdaSayisi.getUc());
            sayi--;
            bosOdaSayisi.setUc(String.valueOf(sayi));
        }

        mDatabaseReference.child("OdaGenisligi").child(odaTipi).child("BosOdaSayisi").setValue(bosOdaSayisi)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        postInterface.isSucces(true,"Rezervasyonunuz yapıldı");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        postInterface.isSucces(false,e.getLocalizedMessage());
                    }
                });


    }
}

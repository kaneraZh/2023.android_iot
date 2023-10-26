package com.example.fundamentos.models;

import android.view.View;

import androidx.annotation.NonNull;

import com.example.fundamentos.dtos.Producto;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ProductoModel {
    private final static DatabaseReference firebase_reference = FirebaseDatabase.getInstance().getReference("producto");


    public void add_listener(View view) {
        firebase_reference.addValueEventListener(
                new ValueEventListener() {
//                    context
//                    addView
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for (DataSnapshot snap : snapshot.getChildren()) {
                            Producto p = snap.getValue(Producto.class);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {}
                }
        );
    }

    private List<Producto> list_productos;
    public void add(String key, Producto producto){
        firebase_reference.child(key).setValue(producto);
    }
}

package com.example.fundamentos.models;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.fundamentos.R;
import com.example.fundamentos.dtos.Producto;
import com.example.fundamentos.views.DetalleActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ProductoModel {
    private final static DatabaseReference firebase_reference = FirebaseDatabase.getInstance().getReference("producto");

    public void setListener(ViewGroup listener, Context context) {
        firebase_reference.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot snap : snapshot.getChildren()) {
                            Producto p = snap.getValue(Producto.class);
                            View serial = View.inflate(context, R.layout.serial_producto, null);

                            TextView nombre = (TextView) serial.findViewById(R.id.text_nombre);
                            nombre.setText( p.getNombre() );
                            TextView precio = (TextView) serial.findViewById(R.id.text_precio);
                            precio.setText( String.valueOf(p.getPrecio()) );
                            Button detalle = (Button) serial.findViewById(R.id.btn_detalles);
                            detalle.setOnClickListener(
                                    new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(context, DetalleActivity.class);
                                            intent.putExtra( "producto", p);
                                            context.startActivity( intent );
                                        }
                                    }
                            );

                            listener.addView( serial );

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

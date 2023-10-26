package com.example.fundamentos.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.fundamentos.R;
import com.example.fundamentos.dtos.Producto;
import com.example.fundamentos.models.ProductoModel;

public class CreateFragment extends Fragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setText_nombre(view.findViewById( R.id.text_nombre ));
        setText_precio(view.findViewById( R.id.text_precio ));
        setText_stock(view.findViewById( R.id.text_stock ));
        setText_descripcion(view.findViewById( R.id.text_descripcion ));
        setBtn_crear(view.findViewById( R.id.btn_crear ));
    }

    public CreateFragment() {
        super(R.layout.fragment_create);
//        setText_nombre(getView().findViewById( R.id.text_nombre ));
//        setText_precio(getView().findViewById( R.id.text_precio ));
//        setText_stock(getView().findViewById( R.id.text_stock ));
//        setText_descripcion(getView().findViewById( R.id.text_descripcion ));
//        setBtn_crear(getView().findViewById( R.id.btn_crear ));
        setFirebase_instance( new ProductoModel() );
    }
    private EditText text_nombre;
    public void setText_nombre(EditText text_nombre) {this.text_nombre = text_nombre;}
    public String get_nombre(){ return this.text_nombre.getText().toString(); }

    private EditText text_precio;
    public void setText_precio(EditText text_precio) {this.text_precio = text_precio;}
    public int get_precio(){ return Integer.valueOf(this.text_precio.getText().toString()); }

    private EditText text_stock;
    public void setText_stock(EditText text_stock) {this.text_stock = text_stock;}
    public int get_stock(){ return Integer.valueOf(this.text_stock.getText().toString()); }

    private EditText text_descripcion;
    public void setText_descripcion(EditText text_descripcion) {this.text_descripcion = text_descripcion;}
    public String get_descripcion(){ return this.text_descripcion.getText().toString(); }
    public Producto get_producto(){ return new Producto(get_nombre(),get_descripcion(),get_precio(),get_stock()); }

    ProductoModel firebase_instance;
    public void setFirebase_instance(ProductoModel firebase_instance) { this.firebase_instance = firebase_instance; }

    private Button btn_crear;
    public void setBtn_crear(Button btn_crear) {
        btn_crear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        firebase_instance.add(get_nombre(), get_producto());
                    }
                }
        );
        this.btn_crear = btn_crear;
    }
}
package com.example.fundamentos.views;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.fundamentos.R;
import com.example.fundamentos.models.ProductoModel;

public class ListaFragment extends Fragment {
    LinearLayout layout;
    public void setLayout(LinearLayout layout) {
        this.layout = layout;
    }
    ProductoModel model;
    public void setModel(ProductoModel model) {
        model.setListener(this.layout, getContext());
        this.model = model;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setLayout( view.findViewById( R.id.layout ));
        setModel( new ProductoModel() );
    }
    public ListaFragment(){
        super(R.layout.fragment_lista);
    }

}

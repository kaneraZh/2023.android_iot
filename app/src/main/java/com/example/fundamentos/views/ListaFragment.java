package com.example.fundamentos.views;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.fundamentos.R;

public class ListaFragment extends Fragment {
    LinearLayout layout;
    public void setLayout(LinearLayout layout) {this.layout = layout;}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setLayout( view.findViewById( R.id.layout ));
    }
    public ListaFragment() {
            super(R.layout.fragment_lista);
        }
}

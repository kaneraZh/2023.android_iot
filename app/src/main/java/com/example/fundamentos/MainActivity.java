package com.example.fundamentos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout main_tab_layout;
    public void setMain_tab_layout(TabLayout main_tab_layout) {
        this.main_tab_layout = main_tab_layout;
        this.main_tab_layout.addOnTabSelectedListener(
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
package com.example.fundamentos.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fundamentos.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class LoggedUserActivity extends AppCompatActivity {
    private FragmentContainerView fragment_container_view;
    public void setFragment_container_view(FragmentContainerView fragment_container_view) {this.fragment_container_view = fragment_container_view;}
    private TabLayout tab_layout;
    public void setTab_layout(TabLayout tab_layout) {
        tab_layout.addOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
//=======================================================================================
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        SwitchFragmentFocus(tab.getPosition());
                    }
//=======================================================================================
                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {}
                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {}
                }
        );
        this.tab_layout = tab_layout;
    }
    private TabItem item_list;
    public void setItem_list(TabItem item_list) {this.item_list = item_list;}
    private TabItem item_create;
    public void setItem_create(TabItem item_create) {this.item_create = item_create;}
    private void SwitchFragmentFocus(int id){
        Fragment fragment;
        switch ( id ){
            case 1:
                fragment = new CreateFragment();
                break;
            default:
                fragment = new ListaFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(fragment_container_view.getId(), fragment, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
    private Button btn_logout;
    public void setBtn_logout(Button btn_logout) {
        btn_logout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        logout();
                    }
                }
        );
        this.btn_logout = btn_logout;
    }
    public void logout(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_user);
        setFragment_container_view( findViewById(R.id.fragment_container_view) );
        setTab_layout( findViewById(R.id.tab_layout) );
        setItem_list( findViewById(R.id.item_list) );
        setItem_create( findViewById(R.id.item_create) );
        setBtn_logout( findViewById(R.id.btn_logout) );
        SwitchFragmentFocus(0);
        }
}
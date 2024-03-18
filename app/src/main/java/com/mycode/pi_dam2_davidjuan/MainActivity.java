package com.mycode.pi_dam2_davidjuan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Fragment homeFragment;
    private Fragment settingsFragment;
    private Fragment activeFragment;
    private FragmentManager fragmentManager;
    private static ArrayList<ItemLista> lista;
    private static String nombre;
    private static String contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeFragment = new HomeFragment();
        settingsFragment = new SettingsFragment();

        nombre = getIntent().getStringExtra("email");
        contrasena = getIntent().getStringExtra("password");

        fragmentManager = getSupportFragmentManager();
        activeFragment = homeFragment;

        fragmentManager.beginTransaction().add(R.id.fragmentContainer, settingsFragment, "2").hide(settingsFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fragmentContainer, homeFragment, "1").commit();

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit();
                        activeFragment = homeFragment;
                        break;
                    case 1:
                        fragmentManager.beginTransaction().hide(activeFragment).show(settingsFragment).commit();
                        activeFragment = settingsFragment;
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getContrasena() {
        return contrasena;
    }
}

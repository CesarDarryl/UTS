package com.example.uts.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.uts.R;
import com.example.uts.fragments.PermenFragment;
import com.example.uts.fragments.SnackFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
        PermenFragment.OnFragmentInteractionListener,SnackFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new PermenFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.permen:
                fragment = new PermenFragment();
                break;
            case R.id.snack:
                fragment = new SnackFragment();
                break;
        }
        return loadFragment(fragment);
    }
    public void onLollipopClicked(){
        Intent intent = new Intent(this,InformasiActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Informasi Permen", Toast.LENGTH_SHORT).show();
    }



    @Override
    public void OnSnackClicked() {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Informasi Snack", Toast.LENGTH_SHORT).show();
    }
}

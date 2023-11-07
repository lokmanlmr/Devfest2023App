package com.example.devfest2023;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {



    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new MainFragment(this));



        drawerLayout = findViewById(R.id.draw_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        ImageButton imgbtn=findViewById(R.id.NavigationBtn);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    // If the drawer is open, close it
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    // If the drawer is closed, open it
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.Home:
                        if (!isFragmentLoaded(MainFragment.class.getSimpleName())) {
                            // Load The Main Fragment
                            loadFragment(new MainFragment(getApplicationContext()), MainFragment.class.getSimpleName());
                        }
                        break;

                    case R.id.about_us:
                        if (!isFragmentLoaded(AboutUsFragment.class.getSimpleName())) {
                            // Load The AboutUs Fragment
                            loadFragment(new AboutUsFragment(), AboutUsFragment.class.getSimpleName());
                        }
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
    private boolean isInMainActivity() {
        // Check if the current activity is the MainActivity
        return getClass() == MainActivity.class;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();

    }
    private void loadFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment, tag)
                .commit();
    }

    // Helper method to check if a fragment is already loaded
    private boolean isFragmentLoaded(String tag) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        return fragment != null && fragment.isAdded();
    }

}



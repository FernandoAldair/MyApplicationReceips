package com.example.myapplication2;


import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication2.ui.home.HomeFragment;
import com.example.myapplication2.ui.notifications.NotificationsFragment;
import com.example.myapplication2.ui.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        showSelectedFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.navigation_home){
                    showSelectedFragment(new HomeFragment());
                }
                if (item.getItemId()==R.id.navigation_search){
                    showSelectedFragment(new SearchFragment());
                }
                if (item.getItemId()==R.id.navigation_notifications){
                    showSelectedFragment(new NotificationsFragment());
                }
                if (item.getItemId()==R.id.navigation_myList){
                    showSelectedFragment(new MyListFragment());
                }
                return true;
            }
        });

    }
    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}
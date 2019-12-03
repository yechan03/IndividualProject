package com.example.individualproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.individualproject.Fragment.ChoiceFragment;
import com.example.individualproject.Fragment.FavoriteFragment;
import com.example.individualproject.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    TextView TV;

    private FragmentManager fm = getSupportFragmentManager();

    private SearchFragment searchFragment = new SearchFragment();
    private ChoiceFragment choiceFragment = new ChoiceFragment();
    private FavoriteFragment favoriteFragment = new FavoriteFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment, searchFragment).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fm.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.bottom_search: {
                        transaction.replace(R.id.fragment,searchFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.bottom_choice: {
                        transaction.replace(R.id.fragment, choiceFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.bottom_favorite: {
                        transaction.replace(R.id.fragment, favoriteFragment).commitAllowingStateLoss();
                        break;
                    }
                }

                return true;
            }
        });
    }

}

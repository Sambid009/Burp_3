package com.earth.burp3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentLearningActivity extends AppCompatActivity {

    Button btnFragmentOne, btnFragmentTwo;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_learning);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnFragmentOne = findViewById(R.id.btnFragmentOne);
        btnFragmentTwo = findViewById(R.id.btnFragmentTwo);
        frameLayout = findViewById(R.id.frameLayout);



     btnFragmentOne.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             loadFragment(new FirstFragment());

         }
     });

     btnFragmentTwo.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             loadFragment(new SecondFragment());

         }


     });







    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
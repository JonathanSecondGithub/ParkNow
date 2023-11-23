package com.example.parknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.parknow.ui.login.LoginActivity;


public class HomePageActivity extends AppCompatActivity {

    Button moi_avenue, nation_center;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        moi_avenue = findViewById(R.id.moibtn);
        nation_center = findViewById(R.id.nationbtn);

        moi_avenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, MoiAvenueActivity.class);
                startActivity(intent);
                finish();
            }
        });

        nation_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, NationCenter.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
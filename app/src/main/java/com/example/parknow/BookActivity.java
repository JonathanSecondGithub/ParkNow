package com.example.parknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {

    TextView streetname, lanename, price;
    Button button1, bookbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        streetname = findViewById(R.id.text1);
        lanename = findViewById(R.id.text2);
        price = findViewById(R.id.text3);
        button1 = findViewById(R.id.backbutton);
        bookbtn = findViewById(R.id.bookbtn);

        streetname.setText(MoiAvenueActivity.getSteetName());
        lanename.setText(MoiAvenueActivity.getLaneName());
        price.setText("100 bob per hour");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this, MoiAvenueActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this, ReceiptActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
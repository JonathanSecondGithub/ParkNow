package com.example.parknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoiAvenueActivity extends AppCompatActivity {

    public static int buttonstate1,buttonstate2,buttonstate3,buttonstate4 ;

    public static int getButtonState1(){
        return buttonstate1;
    }

    public static int getButtonState2(){
        return buttonstate2;
    }

    public static int getButtonState3(){
        return buttonstate3;
    }

    public static int getButtonState4(){
        return buttonstate4;
    }

    public static String lane = "";
    public static String getSteetName(){
        return "MoiAvenue";
    }
    public static String getLaneName(){
        return lane;
    }


    Button button1, button2, button3, button4,button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moi_avenue);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.backbutton);

        if (buttonstate1 == 1) {
            button1.setBackgroundColor(Color.RED);
        }

        if (buttonstate2 == 1) {
            button2.setBackgroundColor(Color.RED);
        }

        if (buttonstate3 == 1) {
            button3.setBackgroundColor(Color.RED);
        }

        if (buttonstate4 == 1) {
            button4.setBackgroundColor(Color.RED);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonstate1 = 1;

                if (buttonstate1 == 1) {
                    button1.setBackgroundColor(Color.RED);

                }

                Intent intent = new Intent(MoiAvenueActivity.this, BookActivity.class);
                startActivity(intent);
                finish();

                lane = "MV_1";
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonstate2 = 1;

                if (buttonstate2 == 1) {
                    button2.setBackgroundColor(Color.RED);
                }

                Intent intent = new Intent(MoiAvenueActivity.this, BookActivity.class);
                startActivity(intent);
                finish();

                lane = "MV_2";
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonstate3 = 1;

                if (buttonstate3 == 1) {
                    button3.setBackgroundColor(Color.RED);
                }

                Intent intent = new Intent(MoiAvenueActivity.this, BookActivity.class);
                startActivity(intent);
                finish();

                lane = "MV_3";
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonstate4 = 1;

                if (buttonstate4 == 1) {
                    button4.setBackgroundColor(Color.RED);
                }

                Intent intent = new Intent(MoiAvenueActivity.this, BookActivity.class);
                startActivity(intent);
                finish();

                lane = "MV_4";
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoiAvenueActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
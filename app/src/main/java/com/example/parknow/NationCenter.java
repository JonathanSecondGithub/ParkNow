package com.example.parknow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NationCenter extends AppCompatActivity {
    
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
        return "Nation Center";
    }
    public static String getLaneName(){
        return lane;
    }
    Button button1, button2, button3, button4,button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nation_center);


//        // Initialize Firebase
//        databaseReference = FirebaseDatabase.getInstance().getReference("parking-slots");

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.backbutton);

//        int buttonColor1 = ((ColorDrawable) button1.getBackground()).getColor();
//        int buttonColor2 = ((ColorDrawable) button1.getBackground()).getColor();
//        int buttonColor3 = ((ColorDrawable) button1.getBackground()).getColor();
//        int buttonColor4 = ((ColorDrawable) button1.getBackground()).getColor();


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

                Intent intent = new Intent(NationCenter.this, BookActivity2.class);
                startActivity(intent);
                finish();

                lane = "NC_1";
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonstate2 = 1;

                if (buttonstate2 == 1) {
                    button2.setBackgroundColor(Color.RED);

                }

                Intent intent = new Intent(NationCenter.this, BookActivity2.class);
                startActivity(intent);
                finish();

                lane = "NC_2";
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonstate3 = 1;

                if (buttonstate3 == 1) {
                    button3.setBackgroundColor(Color.RED);

                }

                Intent intent = new Intent(NationCenter.this, BookActivity2.class);
                startActivity(intent);
                finish();

                lane = "NC_3";
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonstate4 = 1;

                if (buttonstate4 == 1) {
                    button4.setBackgroundColor(Color.RED);

                }

                Intent intent = new Intent(NationCenter.this, BookActivity2.class);
                startActivity(intent);
                finish();

                lane = "NC_4";
            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NationCenter.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

//    private void changeParkingSlotStatus(String parkingSlotName, int newStatus) {
//        // Get the reference to the specific parking slot
//        DatabaseReference slotRef = databaseReference.child(parkingSlotName).child("status");
//
//        // Update the value
//        slotRef.setValue(newStatus);
//    }
//
//    private void readParkingSlotStatus(String parkingSlotName) {
//        // Get the reference to the specific parking slot's status
//        DatabaseReference slotRef = databaseReference.child(parkingSlotName).child("status");
//
//        // Attach a listener to read the value
//        slotRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                // The value has changed, do something with it
//                int status = dataSnapshot.getValue(Integer.class);
//                // Now 'status' contains the value of the parking slot's status
//                // You can update your UI or perform other actions based on this value
//                updateUI(status,parkingSlotName);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                // Handle error
//            }
//        });
//    }
//
//    private void updateUI(int status,String parkingSlotName) {
//        if (parkingSlotName == "NC_1" && status == 1)
//        {
//            button1.setBackgroundColor(Color.RED);
//        }
//        if (parkingSlotName == "NC_2" && status == 1)
//        {
//            button1.setBackgroundColor(Color.RED);
//        }
//        if (parkingSlotName == "NC_3" && status == 1)
//        {
//            button1.setBackgroundColor(Color.RED);
//        }
//        if (parkingSlotName == "NC_4" && status == 1)
//        {
//            button1.setBackgroundColor(Color.RED);
//        }
//    }
}
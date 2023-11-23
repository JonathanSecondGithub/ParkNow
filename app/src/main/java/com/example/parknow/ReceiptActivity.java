package com.example.parknow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parknow.ui.login.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class ReceiptActivity extends AppCompatActivity {

    FirebaseAuth auth;
    private DatabaseReference databaseReference;



    private int generateRandomNumber() {
        // Create a Random object
        Random random = new Random();

        // Generate a random integer
        return random.nextInt();
    }

    int randomNumber = generateRandomNumber();
    String stringValue = Integer.toString(randomNumber);

    TextView name,reg,pho,code,dat,slt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child("NjpbIv6Rb7rEdA_tAWb");

        reg = findViewById(R.id.regno1);
        code = findViewById(R.id.code1);
        dat = findViewById(R.id.date1);
        slt = findViewById(R.id.spot1);



        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);
        dat.setText(formattedDate);
        code.setText(stringValue);
        slt.setText(MoiAvenueActivity.getSteetName() + MoiAvenueActivity.getLaneName());

//        // Read data from Firebase Realtime Database only once
//        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                user user1 = dataSnapshot.getValue(user.class);
//
//                if (user1 != null) {
//                    reg.setText(user1.getCarreg());
//                    name.setText(user1.getName());
//                    pho.setText(user1.getPhone());
//                }else {
//                    Toast.makeText(ReceiptActivity.this, "NULL", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                // Handle errors here
//            }
//        });


    }
}
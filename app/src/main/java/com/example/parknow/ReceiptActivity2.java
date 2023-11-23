package com.example.parknow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class ReceiptActivity2 extends AppCompatActivity {

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
        setContentView(R.layout.activity_receipt2);

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
        slt.setText(NationCenter.getSteetName() + NationCenter.getLaneName());
    }
}
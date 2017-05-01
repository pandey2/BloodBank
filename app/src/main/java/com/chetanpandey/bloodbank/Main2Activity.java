package com.chetanpandey.bloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void donor(View view)
    {
        Intent intent = new Intent(this,Donor.class);
        startActivity(intent);
    }
    public void reciever(View view)
    {
        Intent intent = new Intent(this,Reciever.class);
        startActivity(intent);
    }
    public void hospital(View view)
    {
        Intent intent = new Intent(this,Hospital.class);
        startActivity(intent);
    }
}

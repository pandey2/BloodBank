package com.chetanpandey.bloodbank;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class Donor extends AppCompatActivity {

    private String[] Blood;
    private String[] Gen;
    private String[] State;
    EditText Name,Add,phone,distt;
    Spinner B,G,S;
    Button Submit;
    Contact contact;
    SQLiteDatabase SQLITEDATABASE;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery ;
    String n,p,b,d,s,g,a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
        B = (Spinner) findViewById(R.id.blood);
        G = (Spinner) findViewById(R.id.gen);
        S = (Spinner) findViewById(R.id.state);
        Submit = (Button) findViewById(R.id.submit);
        Name = (EditText) findViewById(R.id.name);
        Add = (EditText) findViewById(R.id.add);
        distt = (EditText) findViewById(R.id.distt);
        phone = (EditText) findViewById(R.id.phone);
        contact = new Contact();
        this.Blood= new String[] {
                "Blood Group","A+","A-","B+","B-","O+","O-","AB+","AB-"
        };
        this.Gen = new String[] {
                "Gender","Male", "Female","Other"
        };
        this.State= new String[] {
                "State","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana ","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana",
                "Tripura","Uttar Pradesh","Uttarakhand","West Bengal"
        };

        ArrayAdapter<String> cadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Blood);
        B.setAdapter(cadapter);
        B.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

              switch (i)
              {
                  case 1:contact.setBgrp(Blood[1]);
                      break;
                  case 2:contact.setBgrp(Blood[2]);
                      break;
                  case 3:contact.setBgrp(Blood[3]);
                      break;
                  case 4:contact.setBgrp(Blood[4]);
                      break;
                  case 5:contact.setBgrp(Blood[5]);
                      break;
                  case 6:contact.setBgrp(Blood[6]);
                      break;
                  case 7:contact.setBgrp(Blood[7]);
                      break;
                  case 8:contact.setBgrp(Blood[8]);
                      break;
              }


            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


        final ArrayAdapter<String> yadapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Gen);
        G.setAdapter(yadapter1);
        G.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 1: contact.setGen("Male");
                        break;
                    case 2: contact.setGen("Female");
                        break;
                    case 3:contact.setGen(Gen[3]);



                }






            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        final ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, State);
        S.setAdapter(stringArrayAdapter);
        S.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 1: contact.setState(State[1]);
                        break;
                    case 2: contact.setState(State[2]);
                        break;
                    case 3: contact.setState(State[3]);
                        break;
                    case 4: contact.setState(State[4]);
                        break;
                    case 5: contact.setState(State[5]);
                        break;
                    case 6: contact.setState(State[6]);
                        break;
                    case 7: contact.setState(State[7]);
                        break;
                    case 8: contact.setState(State[8]);
                        break;
                    case 9: contact.setState(State[9]);
                        break;
                    case 10: contact.setState(State[10]);
                        break;
                    case 11: contact.setState(State[11]);
                        break;
                    case 12: contact.setState(State[12]);
                        break;
                    case 13: contact.setState(State[13]);
                        break;
                    case 14: contact.setState(State[14]);
                        break;
                    case 15: contact.setState(State[15]);
                        break;
                    case 16: contact.setState(State[16]);
                        break;
                    case 17: contact.setState(State[17]);
                        break;
                    case 18: contact.setState(State[18]);
                        break;
                    case 19: contact.setState(State[19]);
                        break;
                    case 20: contact.setState(State[20]);
                        break;
                    case 21: contact.setState(State[21]);
                        break;
                    case 22: contact.setState(State[22]);
                        break;
                    case 23: contact.setState(State[23]);
                        break;
                    case 24: contact.setState(State[24]);
                        break;
                    case 25: contact.setState(State[25]);
                        break;
                    case 26: contact.setState(State[26]);
                        break;
                    case 27: contact.setState(State[27]);
                        break;
                    case 28: contact.setState(State[28]);
                        break;
                    case 29: contact.setState(State[29]);
                        break;


                }


            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

Submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        DBCreate();

        SubmitData2SQLiteDB();
        Intent intent = new Intent(Donor.this,Main2Activity.class);
        startActivity(intent);
        finish();
    }
});

}
    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase("DemoDataBase", Context.MODE_PRIVATE, null);
        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS demoTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT, phone_number TEXT, bgrp TEXT, distt TEXT, state TEXT, gen TEXT, address TEXT);");

    }

    public void SubmitData2SQLiteDB(){

        n= Name.getText().toString();
        p = phone.getText().toString();
        b =contact.getBgrp();
        d = distt.getText().toString();
        s = contact.getState();
        g = contact.getGen();
        a = Add.getText().toString();


            SQLiteQuery = "INSERT INTO demoTable (name, phone_number, bgrp, distt, state, gen, address) VALUES('"+n+"', '"+p+"', '"+b+"', '"+d+"', '"+s+"', '"+g+"', '"+a+"');";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(Donor.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();

            ClearEditTextAfterDoneTask();

        }

    public void ClearEditTextAfterDoneTask(){

        Name.getText().clear();
        Add.getText().clear();
        phone.getText().clear();
        distt.getText().clear();



    }
}
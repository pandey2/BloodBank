package com.chetanpandey.bloodbank;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Hospital extends Activity {

    private EditText editTextInput;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        editTextInput = (EditText) findViewById(R.id.editText);
    }

    public void onSearchClick(View v)
    {
        try {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            String term = editTextInput.getText().toString();
            intent.putExtra(SearchManager.QUERY, term);
            startActivity(intent);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}

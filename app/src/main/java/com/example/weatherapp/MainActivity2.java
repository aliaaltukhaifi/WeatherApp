package com.example.weatherapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity {
    private EditText user_id, first_name, last_name, email_address, phnum;
    private Button button;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        user_id = findViewById(R.id.add_user_id);
        first_name = findViewById(R.id.add_first_name);
        last_name= findViewById(R.id.add_last_name);
        email_address = (EditText) findViewById(R.id.add_email_address);
        phnum = (EditText) findViewById(R.id.add_phnum);
        button =  findViewById(R.id.confirm_addition);
        reference = FirebaseDatabase.getInstance().getReference().child("users");

        //button function
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "Successfully Added", Toast.LENGTH_LONG).show();

                int uid = Integer.parseInt(user_id.getText().toString().trim());
                UserData u = new UserData(email_address.getText().toString().trim(),first_name.getText().toString().trim(),last_name.getText().toString().trim(),phnum.getText().toString().trim(),uid);
                reference.push().setValue(u);
                Toast.makeText(MainActivity2.this,"Successfully Added",Toast.LENGTH_LONG).show();

            }
        });


    }
}
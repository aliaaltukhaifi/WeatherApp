package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteData extends AppCompatActivity {
    private EditText id;
    private Button button;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
        id = findViewById(R.id.deletetext);
        button  = findViewById(R.id.deletebutton);
        reference = FirebaseDatabase.getInstance().getReference().child("users");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reference.getRoot().getKey() == id.getText().toString())
                {
                    Toast.makeText(DeleteData.this, "Successfully Deleted", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
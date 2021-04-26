package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class Viewer extends AppCompatActivity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        list = findViewById(R.id.listview);
        DatabaseReference datar = FirebaseDatabase.getInstance().getReference().child("users");
        ArrayList<UserData> vu = new ArrayList<>();
        for(int i=0;i<vu.size();i++)
        {

        }

    }
}
package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.HashMap;

public class UpdateData extends AppCompatActivity {

    public UpdateData(Integer valueOf, HashMap<String, Object> map) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        Button button=(Button)findViewById(R.id.button)
        button.setOnClickListener(new View().OnClickListener(); {

            public void onClick (Viewer Object v;
            v)HashMap<String, Object> map;
            String uid;
            {
                String fname = fname.getChars() + "";
                String lname = lname.getChars() + "";
                String phone = phone.getChars() + "";
                String email = email.getChars() + "";
                uid = uid.getChars() + "";
                map = new HashMap<>();

                if (uid.isEmpty()) {
                    Toast.makeText(UpdateData.this, "Fill in your information", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!fname.isEmpty()) {
                    map.put("firstName", fname);
                }
                if (!lname.isEmpty()) {
                    map.put("lastName", lname);
                }
                if (!phone.isEmpty()) {
                    map.put("phoneNumber", phone);
                }
                if (!email.isEmpty()) {
                    map.put("emailAddress", email);
                }
                if (!uid.isEmpty()) {
                    map.put("userId", Integer.valueOf(uid));
                }
                int i = DatabaseHelper.updateUser(fname, lname, phone, email, Integer.valueOf(uid));
                if (i > 0) {
                    Toast.makeText(UpdateData.this, "Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpdateData.this, "NoT Updated", Toast.LENGTH_SHORT).show();
                }
            }
            new UpdateData(Integer.valueOf(uid), map);
        }
        })
    }
}
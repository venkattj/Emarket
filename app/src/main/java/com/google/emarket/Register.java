package com.google.emarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.io.IOException;

public class Register extends AppCompatActivity {

    private EditText newUserName, newUserShop, newUserLocation;
    private Button save;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        newUserName = (EditText) findViewById(R.id.etNameUpdate);
        newUserShop = (EditText) findViewById(R.id.etShopUpdate);
        newUserLocation =(EditText) findViewById(R.id.etLocationUpdate);
        save = (Button)findViewById(R.id.btnSave);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = newUserName.getText().toString();
                String age = newUserShop.getText().toString();
                String email = newUserLocation.getText().toString();

                UserProfile userProfile = new UserProfile(email,name,age);

                databaseReference.setValue(userProfile);

                Intent intent = new Intent(Register.this,SellerHome.class);
                startActivity(intent);
            }
        });


    }


}


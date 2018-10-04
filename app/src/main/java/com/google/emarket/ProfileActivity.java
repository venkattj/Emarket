package com.google.emarket;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileActivity extends AppCompatActivity {


    private ImageView profilePic;
    private TextView profileName, profileShop, profileLocation;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private Button Edit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
       profilePic = (ImageView) findViewById(R.id.ivProfilePic);
        profileName = (TextView) findViewById(R.id.tvProfileName);
        profileShop = (TextView) findViewById(R.id.tvProfileShop);
        profileLocation = (TextView) findViewById(R.id.tvProfileLocation);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Edit = (Button) findViewById(R.id.Edit);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditProfile.class);
                startActivity(intent);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
               profileName.setText("Name:" + userProfile.getName());
                profileShop.setText("Shop:" + userProfile.getShop());
                profileLocation.setText("Pincode :" + userProfile.getLocation());

                Toast.makeText(getApplicationContext(), "Sucessful " + userProfile.getName(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "No Detalis", Toast.LENGTH_SHORT).show();

            }
        });


    }
}


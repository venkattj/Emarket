package com.google.emarket;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Items extends AppCompatActivity {

    private ImageButton Add,Save,Delete;
    private EditText name,price;
    private TextView listView;
    private FirebaseDatabase mdatabase;
    private DatabaseReference mdatabaseref;
    private List<Item> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);


        name=(EditText)findViewById(R.id.name);
        price=(EditText)findViewById(R.id.price);
        listView=(TextView)findViewById(R.id.List_data);

        Add=(ImageButton)findViewById(R.id.add);
        Save=(ImageButton)findViewById(R.id.save);
        Delete=(ImageButton)findViewById(R.id.delete);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createItem();
            }
        });
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item1=new Item(name.getText().toString(),price.getText().toString());
                update(item1);


            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item1=new Item(name.getText().toString(),price.getText().toString());

                deleteItem(item1);
            }
        });

        FirebaseApp.initializeApp(this);
        mdatabase=FirebaseDatabase.getInstance();
        mdatabaseref=mdatabase.getReference();


    }


    @Override
    protected void onStart() {
        super.onStart();

        mdatabaseref.child(" items ").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot post:dataSnapshot.getChildren())
                {
                    Item item=post.getValue(Item.class);
                    listView.append("\n"+item.getName());
                    listView.append("\n"+item.getPrice());
                    Toast.makeText(Items.this, item.getName(), Toast.LENGTH_SHORT).show();

                }

                Toast.makeText(Items.this, "results!", Toast.LENGTH_SHORT).show();




            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Items.this, "no results!", Toast.LENGTH_SHORT).show();

            }
        });
    }






    private void deleteItem(Item selecteditem) {
        mdatabaseref.child("items").child(selecteditem.getName()).removeValue();
        clearEdittext();
        listView.append("\n deleted "+ selecteditem.getName());
    }

    private void update(Item item) {
        mdatabaseref.child("items").child(item.getName()).child("name").setValue(item.getName());
        mdatabaseref.child("items").child(item.getPrice()).child("price").setValue(item.getName());
        listView.append("\n"+item.getName());
        listView.append("\n"+item.getPrice());
        clearEdittext();

    }

    private void createItem() {

        Item item = new Item(name.getText().toString(),price.getText().toString());
        mdatabaseref.child("items").child(item.getName()).setValue(item);
        listView.append("\n"+item.getName());
        listView.append("\n"+item.getPrice());
        clearEdittext();
    }

    private void clearEdittext() {
        name.setText("");
        price.setText("");
    }


}


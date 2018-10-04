package com.google.emarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Buy extends AppCompatActivity {

    private CheckBox i1,i2,i3;
    private TextView Bill;
   private Button conform;
   private static int bill;
   private EditText Add;
   private String delails;
   private FirebaseDatabase database;
   private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        i1=(CheckBox)findViewById(R.id.cb1);
        i2=(CheckBox)findViewById(R.id.cb2);
        i3=(CheckBox)findViewById(R.id.cb3);
        Bill=(TextView)findViewById(R.id.Bill);
        Add=(EditText)findViewById(R.id.etAddress);
        conform=(Button)findViewById(R.id.conform);
         database = FirebaseDatabase.getInstance();
         myRef = database.getReference("Orders");

        conform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delails="\n"+Add.getText().toString();
                myRef.child("shop1").child("location").setValue(delails);
                Intent intent = new Intent(Buy.this,Home.class);
                startActivity(intent);





            }
        });

    }

    public void checkone(View view) {
        bill=0;
        delails="";
        if(i1.isChecked()) {
            bill = bill + 40;
            delails+="\n Item1";
        }
        if(i2.isChecked()) {
            bill = bill + 50;
            delails+="\n Item2";

        }
        {
            if (i3.isChecked()) {
                bill = bill + 70;
                delails += "\n Item3";
            }

        }

        Bill.setText("Your bill:" + String.valueOf(bill));
        myRef.child("shop1").child("Items").setValue(delails);


    }

}

package com.google.emarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Coustomer extends AppCompatActivity {

    private TextView  t1,t2,t3,t4;
    protected static String shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coustomer);
        t1 =(TextView)findViewById(R.id.textView2);
        t2 =(TextView)findViewById(R.id.textView3);
        t3 =(TextView)findViewById(R.id.textView4);
        t4 =(TextView)findViewById(R.id.textView5);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop="Shop1";
                Intent intent = new Intent(Coustomer.this,Buy.class);
                startActivity(intent);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop="Shop2";

                Intent intent = new Intent(Coustomer.this,Buy.class);
                startActivity(intent);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop="Shop3";

                Intent intent = new Intent(Coustomer.this,Buy.class);
                startActivity(intent);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop="Shop4";

                Intent intent = new Intent(Coustomer.this,Buy.class);
                startActivity(intent);
            }
        });
    }
}

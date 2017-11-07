package com.example.ahmadrizaldi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_m);

        Button tambahFlight = (Button)findViewById(R.id.tambahFlight);
        Button tampilPenerbangan = (Button)findViewById(R.id.tampildatapenerbangan);


        tambahFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainM.this, InsertFlight.class);
                startActivity(i);
            }
        });

        tampilPenerbangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainM.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}

package com.example.latihanstoreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnIStorage;
    private Button btnEStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIStorage = findViewById(R.id.btn_IStorage);
        btnEStorage = findViewById(R.id.btn_EStorage);

        btnIStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnIStorage();
            }
        });
        btnEStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEStorage();
            }
        });

    }

    void btnIStorage(){
        Intent intent = new Intent(this,InternalActivity.class);
        startActivity(intent);
    }

    void btnEStorage(){
        Intent intent = new Intent(this,EksternalActivity.class);
        startActivity(intent);
    }
}
package com.example.latihanstoreg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class EksternalActivity extends AppCompatActivity {
    public static final String FILENAME = "namafileeksternal.txt";
    Button buatFile,ubahFile,bacaFile,hapusFile;
    TextView tampilTextBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eksternal);
        buatFile = findViewById(R.id.buttonBuatFile);
        ubahFile = findViewById(R.id.buttonUbahFile);
        bacaFile = findViewById(R.id.buttonBacaFile);
        hapusFile = findViewById(R.id.buttonHapusFile);
        tampilTextBaca = findViewById(R.id.textBaca);

        buatFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buatFile();
            }
        });

        ubahFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ubahFile();
            }
        });

        bacaFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bacaFile();
            }
        });

        hapusFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapusFile();
            }
        });
    }

    void buatFile(){
        String isiFile = "Coba isi data file text";
        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state)){
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(),FILENAME);
        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file,true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void ubahFile(){
        String isiFile = "Update isi data file text";
        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state)){
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(),FILENAME);
        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file,false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void bacaFile(){
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard,FILENAME);
        if (file.exists()){
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line!=null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println("Error "+e.getMessage());
            }
            tampilTextBaca.setText(text.toString());
        }
    }

    void hapusFile(){
        File file = new File(Environment.getExternalStorageDirectory(),FILENAME);
        if (file.exists()){
            file.delete();
        }
    }
}
package com.example.travelling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {

    ImageButton lawangsewu, wakatobi, tanahlot, bromo, sentani, pulauk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lawangsewu = (ImageButton) findViewById(R.id.imageButton);
        wakatobi = (ImageButton) findViewById(R.id.wakatobipic);
        tanahlot = (ImageButton) findViewById(R.id.tanahlotpic);
        bromo = (ImageButton) findViewById(R.id.bromopic);
        sentani = (ImageButton) findViewById(R.id.sentanipic);
        pulauk = (ImageButton) findViewById(R.id.pulaukpic);

        lawangsewu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,smg.class);
                startActivity(intent);
            }
        });
    }
}


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

    ImageButton lawangsewupic, wakatobipic, tanahlotpic, bromopic, sentanipic, pulaukpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lawangsewupic = (ImageButton) findViewById(R.id.lawangsewupic);
        wakatobipic = (ImageButton) findViewById(R.id.wakatobipic);
        tanahlotpic = (ImageButton) findViewById(R.id.tanahlotpic);
        bromopic = (ImageButton) findViewById(R.id.bromopic);
        sentanipic = (ImageButton) findViewById(R.id.sentanipic);
        pulaukpic = (ImageButton) findViewById(R.id.pulaukpic);


        lawangsewupic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lawangsewupic =new Intent(getApplicationContext(), smg.class);
                startActivity(lawangsewupic);
            }
        });

        wakatobipic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wakatobipic =new Intent(getApplicationContext(), sulteng.class);
                startActivity(wakatobipic);
            }
        });

        tanahlotpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tanahlotpic =new Intent(getApplicationContext(), bali.class);
                startActivity(tanahlotpic);
            }
        });

        bromopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bromopic =new Intent(getApplicationContext(), malang.class);
                startActivity(bromopic);
            }
        });

        sentanipic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sentanipic =new Intent(getApplicationContext(), papua.class);
                startActivity(sentanipic);
            }
        });

        pulaukpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pulaukpic =new Intent(getApplicationContext(), ntt.class);
                startActivity(pulaukpic);
            }
        });


    }





}


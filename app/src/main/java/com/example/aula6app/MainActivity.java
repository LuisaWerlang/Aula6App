package com.example.aula6app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1(View view) { Intent intent = new Intent(this, CampeonatoBrasileiro.class); startActivity(intent); }

    public void onClick2(View view) { Intent intent = new Intent(this, SelecionaCores.class); startActivity(intent); }
}
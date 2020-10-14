package com.example.aula6app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SelecionaCores extends AppCompatActivity {

    private Spinner spinner;
    String[] nameColors = {"Selecione uma cor", "Preto", "Gris", "Cinza", "Vermelho", "Azul", "Verde", "Amarelo", "Laranja", "Marrom", "Rosa", "Roxo"};
    String[] colors = {"#FFFFFF", "#000000", "#444444", "#888888", "#FF0000", "#0000FF", "#008000", "#FFD700", "#FFA500", "#8B4513", "#FFC0CB", "#A020F0"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleciona_cores);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = new MeuArrayAdapter(this, android.R.layout.simple_spinner_item, nameColors);
        spinner.setAdapter(adapter);
    }

    private class MeuArrayAdapter extends ArrayAdapter {

        int resources;

        public MeuArrayAdapter(Context ctx, int simple_spinner_item, String[] colors) {
            super(ctx, simple_spinner_item, colors);
            resources = simple_spinner_item;
        }

        private View CostumView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(resources, parent, false);

            TextView tv = view.findViewById(android.R.id.text1);
            tv.setText(nameColors[position]);
            tv.setTextColor(Color.WHITE);
            view.setBackgroundColor(Color.parseColor(colors[position]));

            if(position == 0) {
                tv.setTextColor(Color.BLACK);
                tv.setTextSize(20f);
            }
            return view;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return CostumView(position, convertView, parent);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return CostumView(position, convertView, parent);
        }
    }
}
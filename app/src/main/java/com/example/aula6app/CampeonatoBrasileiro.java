package com.example.aula6app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampeonatoBrasileiro extends ListActivity {

    String[] de = {"imagem", "clube", "pontos"};
    int[] para = {R.id.img, R.id.clubes, R.id.pontos};
    List<Map<String, Object>> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campeonato_brasileiro);

        lista = new ArrayList<>();

        String[] clubes = {"Palmeiras", "Flamengo", "Atlético Mineiro", "Corinthians", "Santos", "Grêmio", "Ponte Preta", "Fluminense", "Atlético Paranaense", "Chapecoense", "Botafogo", "São Paulo", "Sport", "Cruzeiro", "Vitória", "Coritiba", "Internacional", "Figueirense", "Santa Cruz", "América Mineiro"};
        int[] pontos = {43, 40, 39, 37, 36, 36, 34, 34, 33, 30, 29, 28, 27, 26, 26, 26, 24, 24, 19, 13};
        int[] img = {R.drawable.pal, R.drawable.fla, R.drawable.cam, R.drawable.cor, R.drawable.san, R.drawable.gre, R.drawable.pon, R.drawable.flu, R.drawable.cap, R.drawable.cha, R.drawable.bot, R.drawable.sao, R.drawable.spt, R.drawable.cru, R.drawable.vit, R.drawable.cfc, R.drawable.inter, R.drawable.fig, R.drawable.sta, R.drawable.ame};

        for(int i = 0; i < clubes.length; i++)
        {
            Map<String,Object> mapa = new HashMap<>();
            mapa.put("imagem", img[i]);
            mapa.put("clube", clubes[i]);
            mapa.put("pontos", pontos[i]+" pontos");
            lista.add(mapa);
        }

        SimpleAdapter adapter = new MeuAdapter(this, lista, R.layout.line_item, de, para);
        ListView listView = getListView();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Map<String,Object> selecao = lista.get(i);
                String clube = selecao.get("clube").toString();
                String pontos = selecao.get("pontos").toString();
                Toast.makeText(getApplicationContext(), clube + "\n" + pontos, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
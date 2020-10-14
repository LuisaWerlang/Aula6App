package com.example.aula6app;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MeuAdapter extends SimpleAdapter {
    public MeuAdapter(Context ctx, List<Map<String, Object>> lista, int line_item, String[] de, int[] para) {
        super(ctx, lista, line_item, de, para);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);

        TextView nomeTime = v.findViewById(R.id.clubes);
        TextView pontos = v.findViewById(R.id.pontos);

        if(position%2==0) {
            v.setBackgroundColor(Color.YELLOW);
            nomeTime.setTextColor(Color.BLACK);
            pontos.setTextColor(Color.BLACK);
        }
        else {
            v.setBackgroundColor(Color.parseColor("#007F00"));
            nomeTime.setTextColor(Color.WHITE);
            pontos.setTextColor(Color.WHITE);
        }
        return v;
    }
}

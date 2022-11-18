package com.example.marcadordebisca.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.marcadordebisca.adapter.JogadorAdapter;
import com.example.marcadordebisca.databinding.ActivityTelaInicialBinding;
import com.example.marcadordebisca.model.Jogadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TelaInicial extends AppCompatActivity {

    private ActivityTelaInicialBinding binding;
    private JogadorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaInicialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Spinner spinner = binding.numberPlayers;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                int qtdJogadores = pos+3;

                carregarRecycleView(qtdJogadores);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        binding.button.setOnClickListener(view -> {
            startGame();
        });

        binding.textBisca.setText("Bisca");
    }

    private void startGame() {
        if(adapter.getMapJogadores().isEmpty()){
            Toast.makeText(getApplicationContext(), "preencher nome dos jogadores", Toast.LENGTH_SHORT).show();
        }else {
            Map<Integer, Jogadores> mapJogadores = adapter.getMapJogadores();
            ArrayList<Jogadores> jogadores = new ArrayList<>(mapJogadores.values());

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("listaJogadores", jogadores);
            startActivity(intent);
        }
    }

    public void carregarRecycleView(int count){
        RecyclerView rv = binding.recyclerPlayers;
        //configurar Adapter
        adapter = new JogadorAdapter(count);

        //configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(false);
        rv.setAdapter(adapter);
    }


}
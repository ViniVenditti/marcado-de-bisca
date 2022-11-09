package com.example.marcadordebisca.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;


import com.example.marcadordebisca.adapter.JogadorAdapter;
import com.example.marcadordebisca.databinding.ActivityTelaInicialBinding;
import com.example.marcadordebisca.model.Jogadores;

import java.util.ArrayList;
import java.util.List;


public class TelaInicial extends AppCompatActivity {

    private ActivityTelaInicialBinding binding;
    private List<Jogadores> listaJogadores = new ArrayList<>();

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

    }

    public void carregarRecycleView(int count){
        RecyclerView rv = binding.recyclerPlayers;
        //configurar Adapter
        JogadorAdapter adapter = new JogadorAdapter(count, listaJogadores);

        //configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(false);
        rv.setAdapter(adapter);
    }


}
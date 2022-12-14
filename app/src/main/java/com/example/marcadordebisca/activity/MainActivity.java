package com.example.marcadordebisca.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marcadordebisca.adapter.Adapter;
import com.example.marcadordebisca.databinding.ActivityMainBinding;
import com.example.marcadordebisca.databinding.ActivityTelaInicialBinding;
import com.example.marcadordebisca.model.Jogadores;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView rv;
    private List<Jogadores> listaJogadores;
    private TextInputEditText editJogador;
    private Integer qtdJogadores;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle dados = getIntent().getExtras();
        ArrayList<Jogadores> listaJogadores = (ArrayList<Jogadores>) dados.getSerializable("listaJogadores");
        carregarRecycleView(listaJogadores);
    }



    public void carregarRecycleView(ArrayList<Jogadores> listaJogadores){
        rv = binding.recyclerView;
        //configurar Adapter
        adapter = new Adapter(getApplicationContext(), listaJogadores);

        //configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(false);
        rv.setAdapter(adapter);
    }

    public void zerarGame(View view){
        binding.textRodadaNum.setText("1");
    }


    public void calculaPontuacao(View view){
        if(listaJogadores.isEmpty()){

        }
        rv = binding.recyclerView;


        //Toast.makeText(getApplicationContext(), "Teste: "+ rv.getAdapter().getItemCount(), Toast.LENGTH_SHORT).show();

        Integer rodada = Integer.parseInt(binding.textRodadaNum.getText().toString());
        rodada += 1;
        binding.textRodadaNum.setText(rodada.toString());
    }

}
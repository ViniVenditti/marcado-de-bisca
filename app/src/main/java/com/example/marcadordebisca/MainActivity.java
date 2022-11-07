package com.example.marcadordebisca;

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

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Spinner spinner = binding.spinner;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                carregarJogadores(pos+3);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void carregarJogadores(int count){
        rv = binding.recyclerView;
        //configurar Adapter
        Adapter adapter = new Adapter(count);

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
        rv = binding.recyclerView;
        rv.getAdapter().getItemCount();
        for(int i = 0; i <= rv.getAdapter().getItemCount(); i++){
            String fez = rv.getChildViewHolder(view).itemView.findViewById(R.id.editFez).toString();
            String faz = rv.getChildViewHolder(view).itemView.findViewById(R.id.editFaz).toString();
        }


        //Toast.makeText(getApplicationContext(), "Teste: "+ rv.getAdapter().getItemCount(), Toast.LENGTH_SHORT).show();

        Integer rodada = Integer.parseInt(binding.textRodadaNum.getText().toString());
        rodada += 1;
        binding.textRodadaNum.setText(rodada.toString());
    }
}
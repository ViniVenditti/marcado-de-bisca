package com.example.marcadordebisca.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marcadordebisca.R;
import com.example.marcadordebisca.model.Jogadores;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;
import java.util.Objects;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private int count;
    private List<Jogadores> listJogadores;
    private boolean isOnTextChanged = false;

    Context context;

    public Adapter(Context context, int count, List<Jogadores> listJogadores){
        this.context = context;
        this.count = count;
        this.listJogadores = listJogadores;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View placar = LayoutInflater.from(parent.getContext()).inflate(R.layout.pontuacao_layout, parent, false);

        return new MyViewHolder(placar);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.editFez.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    try{
                        int pontos = Integer.parseInt(holder.textPontos.getText().toString());
                        int faz = Integer.parseInt(Objects.requireNonNull(holder.editFaz.getText()).toString());
                        int fez = Integer.parseInt(Objects.requireNonNull(holder.editFez.getText()).toString());
                        int resultado = faz == fez ? pontos + fez + 10 : pontos + fez;
                        holder.textPontos.setText(String.valueOf(resultado));
                        Toast.makeText(context, "Faz = "+ faz+ "**  fez = "+fez + " pontos: " + pontos, Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return count;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextInputEditText editJogador, editFaz, editFez;
        TextView textPontos;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            editJogador = itemView.findViewById(R.id.editJogador);
            editFaz = itemView.findViewById(R.id.editFaz);
            editFez = itemView.findViewById(R.id.editFez);
            textPontos = itemView.findViewById(R.id.textPontos);
        }
    }

}

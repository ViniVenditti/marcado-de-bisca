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

    private List<Jogadores> listJogadores;
    private boolean isOnTextChanged = false;

    Context context;

    public Adapter(Context context, List<Jogadores> listJogadores){
        this.context = context;
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
        holder.editFaz.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                listJogadores.get(holder.getAdapterPosition()).setDoing(Integer.valueOf(holder.editFaz.getText().toString()));
            }
        });

        holder.editFez.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                listJogadores.get(holder.getAdapterPosition()).setDone(Integer.valueOf(holder.editFez.getText().toString()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listJogadores.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextInputEditText editFaz, editFez;
        TextView textPlayer, textPontos;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textPlayer = itemView.findViewById(R.id.textPlayer);
            editFaz = itemView.findViewById(R.id.editFaz);
            editFez = itemView.findViewById(R.id.editFez);
            textPontos = itemView.findViewById(R.id.textPontos);
        }
    }

}

package com.example.marcadordebisca.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marcadordebisca.R;
import com.example.marcadordebisca.model.Jogadores;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class JogadorAdapter extends RecyclerView.Adapter<JogadorAdapter.MyViewHolder> {

    private int count;
    private List<Jogadores> listJogadores;

    public JogadorAdapter(int count, List<Jogadores> listJogadores){
        this.count = count;
        this.listJogadores = listJogadores;
    }

    @NonNull
    @Override
    public JogadorAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View players = LayoutInflater.from(parent.getContext()).inflate(R.layout.jogador_layout, parent, false);

        return new JogadorAdapter.MyViewHolder(players);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return count;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextInputEditText editJogador;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            editJogador = itemView.findViewById(R.id.editJogador);
        }
    }
}

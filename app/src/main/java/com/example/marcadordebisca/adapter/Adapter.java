package com.example.marcadordebisca.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marcadordebisca.R;
import com.google.android.material.textfield.TextInputEditText;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private int count;

    public Adapter(int count){
        this.count = count;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View jogadores = LayoutInflater.from(parent.getContext()).inflate(R.layout.pontuacao_layout, parent, false);

        return new MyViewHolder(jogadores);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textPontos.setText("0");
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

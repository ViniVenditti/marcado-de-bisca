package com.example.marcadordebisca.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marcadordebisca.R;
import com.example.marcadordebisca.model.Jogadores;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JogadorAdapter extends RecyclerView.Adapter<JogadorAdapter.MyViewHolder> {

    private int count;
    private Context context;
    private Map<Integer, Jogadores> mapJogadores = new HashMap<Integer, Jogadores>();

    public JogadorAdapter(int count){
        this.count = count;
    }

    @NonNull
    @Override
    public JogadorAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View players = LayoutInflater.from(parent.getContext()).inflate(R.layout.jogador_layout, parent, false);
        context = parent.getContext();
        return new JogadorAdapter.MyViewHolder(players);
    }

    public Map<Integer, Jogadores> getMapJogadores(){
        return mapJogadores;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.editJogador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                mapJogadores.put(holder.getAdapterPosition(), new Jogadores(Objects.requireNonNull(holder.editJogador.getText()).toString()));

            }
        });

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

    public void abrirDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog
                .setTitle("alerta")
                .setMessage("Mensagem do dialog")
                .setIcon(android.R.drawable.ic_btn_speak_now)
                .setCancelable(false)
                .setPositiveButton("Ok", (dialog1, which) -> {})
                .create()
                .show();
    }
}

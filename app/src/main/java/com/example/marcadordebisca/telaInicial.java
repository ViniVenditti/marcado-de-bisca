package com.example.marcadordebisca;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import com.example.marcadordebisca.databinding.ActivityTelaInicialBinding;


public class telaInicial extends AppCompatActivity {

    private ActivityTelaInicialBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaInicialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textBisca.setText("Bisca");
    }


}
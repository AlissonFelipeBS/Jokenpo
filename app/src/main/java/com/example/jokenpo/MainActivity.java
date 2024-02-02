package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario){
        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if(
                (opcaoApp == "Papel" && opcaoUsuario == "Pedra") ||
                (opcaoApp == "Pedra" && opcaoUsuario == "Tesoura") ||
                (opcaoApp == "Tesoura" && opcaoUsuario == "Papel")
        ){
            textoResultado.setText("Você perdeu!");
        }else if(
                (opcaoUsuario == "Papel" && opcaoApp == "Pedra") ||
                (opcaoUsuario == "Pedra" && opcaoApp == "Tesoura") ||
                (opcaoUsuario == "Tesoura" && opcaoApp == "Papel")
        ){
            textoResultado.setText("Você ganhou!");
        }else{
            textoResultado.setText("Empatamos!");
        }
        System.out.println("item clicado: " + opcaoApp);
    }
}
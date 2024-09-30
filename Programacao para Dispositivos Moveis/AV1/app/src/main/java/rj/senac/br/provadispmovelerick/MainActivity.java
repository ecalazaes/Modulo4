package rj.senac.br.provadispmovelerick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgDadoJogador1, imgDadoJogador2;
    private TextView tvVencedor;
    private Button btnJogarDados, btnVerPlacar;
    private int placarJogador1 = 0;
    private int placarJogador2 = 0;
    private int empates = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculando os componentes da interface
        imgDadoJogador1 = findViewById(R.id.imgDadoJogador1);
        imgDadoJogador2 = findViewById(R.id.imgDadoJogador2);
        tvVencedor = findViewById(R.id.tvVencedor);
        btnJogarDados = findViewById(R.id.btnJogarDados);
        btnVerPlacar = findViewById(R.id.btnVerPlacar);

        // Ação do botão "Jogar Dados"
        btnJogarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogarDados();
            }
        });

        // Ação do botão "Ver Placar"
        btnVerPlacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPlacar();
            }
        });
    }

    // Método para jogar os dados e atualizar placar
    private void jogarDados() {
        Random random = new Random();
        int numeroJogador1 = random.nextInt(6) + 1;
        int numeroJogador2 = random.nextInt(6) + 1;

        atualizarImagemDado(imgDadoJogador1, numeroJogador1);
        atualizarImagemDado(imgDadoJogador2, numeroJogador2);

        if (numeroJogador1 > numeroJogador2) {
            placarJogador1++;
            tvVencedor.setText("Vencedor: Jogador 1");
        } else if (numeroJogador2 > numeroJogador1) {
            placarJogador2++;
            tvVencedor.setText("Vencedor: Jogador 2");
        } else {
            empates++;
            tvVencedor.setText("Empate!");
        }
    }

    // Método para alterar a imagem do dado
    private void atualizarImagemDado(ImageView imgDado, int numero) {
        switch (numero) {
            case 1:
                imgDado.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imgDado.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imgDado.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imgDado.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imgDado.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imgDado.setImageResource(R.drawable.dice6);
                break;
        }
    }

    // Método para abrir a PlacarActivity e passar os dados
    private void abrirPlacar() {
        Intent intent = new Intent(MainActivity.this, PlacarActivity.class);
        intent.putExtra("placarJogador1", placarJogador1);
        intent.putExtra("placarJogador2", placarJogador2);
        intent.putExtra("empates", empates);
        startActivity(intent);
    }
}

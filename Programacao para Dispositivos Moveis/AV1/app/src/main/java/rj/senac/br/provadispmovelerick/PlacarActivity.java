package rj.senac.br.provadispmovelerick;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlacarActivity extends AppCompatActivity {

    private TextView tvPlacarJogador1, tvPlacarJogador2, tvEmpates;
    private Button btnRetornar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placar);

        // Vinculando os componentes da tela
        tvPlacarJogador1 = findViewById(R.id.tvPlacarJogador1);
        tvPlacarJogador2 = findViewById(R.id.tvPlacarJogador2);
        tvEmpates = findViewById(R.id.tvEmpates);
        btnRetornar = findViewById(R.id.btnRetornar);

        // Receber os valores enviados da MainActivity
        Intent intent = getIntent();
        int placarJogador1 = intent.getIntExtra("placarJogador1", 0);
        int placarJogador2 = intent.getIntExtra("placarJogador2", 0);
        int empates = intent.getIntExtra("empates", 0);

        // Exibir os valores recebidos nos TextViews
        tvPlacarJogador1.setText(String.valueOf(placarJogador1));
        tvPlacarJogador2.setText(String.valueOf(placarJogador2));
        tvEmpates.setText(String.valueOf(empates));

        // Ação do botão "Retornar"
        btnRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Fecha a PlacarActivity e volta para a MainActivity
            }
        });
    }
}

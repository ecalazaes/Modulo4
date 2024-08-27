package rj.senac.br.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        EditText num1 = findViewById(R.id.editTextNumber3);
//        EditText num2 = findViewById(R.id.editTextNumber4);
//        EditText resultado = findViewById(R.id.editTextNumber5);
//
//        Button calcularSoma = findViewById(R.id.button);
//
//        calcularSoma.setOnClickListener(view -> {
//            // Recuperar o texto dos EditTexts e convertê-los para inteiros
//            String text1 = num1.getText().toString();
//            String text2 = num2.getText().toString();
//
//            // Convertendo o texto para inteiro, com tratamento para valores nulos ou vazios
//            int number1 = text1.isEmpty() ? 0 : Integer.parseInt(text1);
//            int number2 = text2.isEmpty() ? 0 : Integer.parseInt(text2);
//
//            // Realizar a soma
//            int sum = number1 + number2;
//
//            // Exibir o resultado no EditText resultado
//            resultado.setText(String.valueOf(sum));
//        });

    }
}
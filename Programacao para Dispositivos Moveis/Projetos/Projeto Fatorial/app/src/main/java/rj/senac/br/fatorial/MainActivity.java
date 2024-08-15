package rj.senac.br.fatorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializa as views
        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        // Configura o comportamento do botão
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int num = Integer.parseInt(editText.getText().toString());
                    textView.setText(String.format(Locale.getDefault(), "%.0f", factorial(num)));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Por favor, insira um número válido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Aplica o padding para as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Função que calcula o fatorial
    private double factorial(double num) {
        if (num < 2) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}

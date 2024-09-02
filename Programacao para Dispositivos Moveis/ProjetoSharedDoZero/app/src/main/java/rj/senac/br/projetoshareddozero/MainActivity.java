package rj.senac.br.projetoshareddozero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button bsave, brecup;
    private EditText nome,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bsave = findViewById(R.id.buttonSave);
        brecup = findViewById(R.id.buttonReload);
        nome = findViewById(R.id.editTextNome);
        email = findViewById(R.id.editTextEmail);

        bsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                myEdit.putString("name", nome.getText().toString());
                myEdit.putString("email", email.getText().toString());
                myEdit.commit();
                nome.setText("");
                email.setText("");
            }
        });

        brecup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String s1 = sh.getString("name", "");
                String s2 = sh.getString("email", "");
                nome.setText(s1);
                email.setText(s2);
            }
        });
    }
}
package rj.senac.br.duasatividades2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btIr;
    EditText msgSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btIr = findViewById(R.id.btIr);
        msgSend = findViewById(R.id.msgSend);

        btIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = msgSend.getText().toString();
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("message_key", message);
                startActivity(i);
            }
        });
    }
}
package com.example.guessnumber;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    TextView Info;
    EditText Input;
    Button Button;
    Integer number;
    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Info = findViewById(R.id.info);
        Input = findViewById(R.id.input);
        Button = findViewById(R.id.button);
        int random = ThreadLocalRandom.current().nextInt(1, 100);
        onCLick();
    }
    public void onCLick (){
        Button.setOnClickListener(view -> {
         number = Integer.parseInt(Input.getText().toString());
         if (number > 100) {
       //      Info.setText(getResources());
         }
        });
    }
}
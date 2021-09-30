package com.example.guessnumber;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView Info;
    EditText Input;
    Button Button;
    Button Button_2;
    String stroke;
    int number;
    Boolean win;
    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Info = findViewById(R.id.info);
        Input = findViewById(R.id.input);
        Button = findViewById(R.id.button);
        Button_2 = findViewById(R.id.button_2);
        win = Boolean.FALSE;
        onCLick();
    }
    public void onCLick (){
        random = (int) (Math.random()*10) + 1;
        Button_2.setOnClickListener(view ->{
            finish();
            System.exit(0);
        });
        Button.setOnClickListener(view -> {
            if (win == Boolean.FALSE) {
                stroke = Input.getText().toString();
                if (stroke.equals("")) {
                    Info.setText(getResources().getText(R.string.empty));
                }
                else {
                    number = Integer.parseInt(stroke);
                    Input.setText("");
                    if (number > 10 || number < 1) {
                        Info.setText(getResources().getText(R.string.error));
                    } else if (number > random) {
                        Info.setText(getResources().getText(R.string.ahead));
                    } else if (number < random) {
                        Info.setText(getResources().getText(R.string.behind));
                    } else if (number == random) {
                        Info.setText(getResources().getText(R.string.hit));
                        win = Boolean.TRUE;
                        Button.setText(getResources().getText(R.string.play_more));
                    }
                }
            }
            else {
                win = Boolean.FALSE;
                random = (int) (Math.random()*10) + 1;
                Button.setText(getResources().getText(R.string.input_value));
                Info.setText(getResources().getString(R.string.try_to_guess));
            }
        });
    }
}
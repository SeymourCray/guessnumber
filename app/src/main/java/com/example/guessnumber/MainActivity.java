package com.example.guessnumber;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView Info;
    EditText Input;
    Button Button;
    String stroke;
    int number;
    Boolean level = Boolean.FALSE;
    int up = 10;
    Boolean win;
    int random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Info = findViewById(R.id.info);
        Input = findViewById(R.id.input);
        Button = findViewById(R.id.button);
        win = Boolean.FALSE;
        onCLick();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"Новая игра");
        menu.add(0,1,1,"Сменить уровень сложности");
        menu.add(0,2,2,"Выйти");
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint({"SetTextI18n"})
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0:
                win = Boolean.FALSE;
                if (level == Boolean.FALSE){
                    up = 10;
                    Info.setText(getResources().getString(R.string.try_to_guess_1));
                }
                else {
                    up = 100;
                   Info.setText(getResources().getString(R.string.try_to_guess_2));
                }
                random = (int) (Math.random()*up) + 1;
                break;
            case 1:
                if (level == Boolean.TRUE) {
                    up = 10;
                    level = Boolean.FALSE;
                    Info.setText(getResources().getString(R.string.try_to_guess_1));
                }
                else {
                    up = 100;
                    level = Boolean.TRUE;
                    Info.setText(getResources().getString(R.string.try_to_guess_2));
                }
                random = (int) (Math.random()*up) + 1;
                break;
            case 2:
                finish();
                System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }


    public void onCLick (){
        random = (int) (Math.random()*up) + 1;
        Button.setOnClickListener(view -> {
            if (win == Boolean.FALSE) {
                stroke = Input.getText().toString();
                if (stroke.equals("")) {
                    Info.setText(getResources().getText(R.string.empty));
                }
                else {
                    number = Integer.parseInt(stroke);
                    Input.setText("");
                    if (number > up || number < 1) {
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
                random = (int) (Math.random()*up) + 1;
                if (up == 10){
                    Info.setText(getResources().getString(R.string.try_to_guess_1));
                }
                else {
                    Info.setText(getResources().getString(R.string.try_to_guess_2));
                }
                Button.setText(getResources().getText(R.string.input_value));
            }
        });
    }
}
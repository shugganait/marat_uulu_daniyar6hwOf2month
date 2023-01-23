package com.kg.marat_uulu_daniyar6hwof2month;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText emailText = findViewById(R.id.email);
        EditText passwordText = findViewById(R.id.password);
        Button button = findViewById(R.id.btn_comeIn);
        TableLayout container = findViewById(R.id.containerTl);

        passwordText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            String email = emailText.getText().toString();
            String password = passwordText.getText().toString();
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(email.length() > 0 && password.length() > 0){
                    button.setBackgroundColor(Color.GRAY);
                }else if(email.length() == 0 && password.length() == 0){
                    button.setBackgroundColor(Color.argb(255, 255,127,80));
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailText.getText().toString().equals("admin") && passwordText.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_LONG).show();
                    container.setVisibility(View.GONE);
                    findViewById(R.id.tv_comein).setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity.this, "Не правильный логин или пароль", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
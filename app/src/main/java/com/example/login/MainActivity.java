package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;



public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    Button button;
    TextView date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        date.setText(getCurrentTime());
        time.setText(getCurrentDate());
        addListenerOnButton();

    }

    private String getCurrentTime() {
        return new SimpleDateFormat("hh:mm:ss").format(new Date());
    }

    private String getCurrentDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    public void addListenerOnButton() {
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById((R.id.password));
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailValidator(email);
                isValidPassword(String.valueOf(password));
                if (TextUtils.isEmpty(name.getText().toString())) {
                    name.setError("Required Field");
                    return;
                }
                if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Email invalid");
                    return;
                }

                if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Password should have 8 characters", Toast.LENGTH_SHORT).show();
                    password.setError("Password is Required");

                }

                if (!(TextUtils.isEmpty(name.getText().toString()) && (TextUtils.isEmpty(email.getText().toString())) && (TextUtils.isEmpty(password.getText().toString())))) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                    String person = name.getText().toString();
                    String sum = " Welcome : " + person;
                    Toast.makeText(getApplicationContext(), "     LOGIN SUCCESSFULLY...     " + "\n\n\t\t\t\t\t" + String.valueOf(sum), Toast.LENGTH_LONG).show();


                }
            }

        });

    }


    public void emailValidator(EditText email) {

        String emailToText = email.getText().toString();

        String emailPattern = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}";

        if (emailToText.matches(emailPattern)) {
            Toast.makeText(this, "Valid email !", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
        }

    }

    public static boolean isValidPassword(String password) {
        // Password must be at-least 8 characters, 1 digit and 1special character

        return password != null && password.length() >= 8 &&
                password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()].*");


    }
}







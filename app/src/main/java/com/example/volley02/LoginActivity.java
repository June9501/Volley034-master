package com.example.volley02;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;



public class LoginActivity extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);



        EditText idText = (EditText)findViewById(R.id.emailEditView);

        EditText passwordText = (EditText)findViewById(R.id.passwordEditView);



        Button loginbtn = (Button)findViewById(R.id.loginBtn);

        TextView registerbtn = (TextView)findViewById(R.id.registerbtn);


        loginbtn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);

                LoginActivity.this.startActivity(mainIntent);

            }

        });


        registerbtn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);

                LoginActivity.this.startActivity(registerIntent);

            }

        });

    }

}

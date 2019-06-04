package com.example.volley02;

import android.content.Intent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Button loginbtn = (Button)findViewById(R.id.loginBtn);

        TextView registerbtn = (TextView)findViewById(R.id.registerbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {

            EditText idText = (EditText)findViewById(R.id.emailEditView);

            EditText passwordText = (EditText)findViewById(R.id.passwordEditView);

            @Override

            public void onClick(View view) {


                String email = idText.getText().toString();
                String password = passwordText.getText().toString();
                //4. 콜백 처리부분(volley 사용을 위한 ResponseListener 구현 부분)

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    //서버로부터 여기서 데이터를 받음
                    @Override
                    public void onResponse(String true_data) {

                        try {
                            //서버로부터 받는 데이터는 JSON타입의 객체이다.
                            JSONObject jsonResponse = new JSONObject(true_data);
                            //그중 Key값이 “success”인 것을 가져온다.
                            int check = jsonResponse.getInt("true_data");

                            //회원 가입 성공시 success값이 true임

                            if (check==1) {
                                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                                //알림상자를 만들어서 보여줌//
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

                                builder.setMessage("register success!!")

                                        .setPositiveButton("ok", null)

                                        .create()

                                        .show();
                                //그리고 첫화면으로 돌아감

                                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);

                                LoginActivity.this.startActivity(mainIntent);

                            }
                            //회원 가입 실패시 success값이 false임
                            else {

                                Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
                                //알림상자를 만들어서 보여줌
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("register fail!!")
                                        .setNegativeButton("ok", null)
                                        .create()
                                        .show();

                                Intent intent = new Intent(LoginActivity.this, LoginActivity.class);

                                LoginActivity.this.startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };//responseListener 끝
                //volley 사용법

                //1. RequestObject를 생성한다. 이때 서버로부터 데이터를 받을 responseListener를 반드시 넘겨준다.

                LoginRequest loginRequest = new LoginRequest(email, password, responseListener);

                //2. RequestQueue를 생성한다.

                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);


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

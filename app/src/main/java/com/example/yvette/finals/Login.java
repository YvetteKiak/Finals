package com.example.yvette.finals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by amiel on 7/22/2016.
 */

public class Login extends AppCompatActivity {
    EditText emailTxt;
    EditText passwordTxt;
    Button btnLogin;
    TextView show, signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        emailTxt = (EditText) findViewById(R.id.emailText);
        passwordTxt = (EditText) findViewById(R.id.passwordText);
        btnLogin = (Button) findViewById(R.id.loginButton);
        signup = (TextView) findViewById(R.id.TvSignUp);


        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (Pattern.compile("^\\w+.*\\w*@[a-zA-Z_]+?\\.[0-9a-zA-Z]{2,}$").matcher(Email.getText()).matches() && Password.length() >= 8){
                AccountRepo repo = new AccountRepo(getApplicationContext());
                boolean res = false;
                res = repo.validateLogin(emailTxt.getText().toString(), passwordTxt.getText().toString());
                if (res == true) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    intent.putExtra("username", repo.getName(emailTxt.getText().toString(), passwordTxt.getText().toString()));
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "Username/Email or password is incorrect.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        signup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
            });



    }
    @Override
    protected  void onPause(){
        super.onPause();
        finish(

        );
    }


}
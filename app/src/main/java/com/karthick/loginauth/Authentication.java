package com.karthick.loginauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Authentication extends AppCompatActivity {

    private static final String KEY_UN = "username";
    private static final String KEY_PW = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        setTitle("Login Authentication");

        Bundle bundle = getIntent().getExtras();

        String un = bundle.getString(KEY_UN);
        String pw = bundle.getString(KEY_PW);

        Intent intent = new Intent();

        //GET THE STRING VALUES
        String correctUsername = getResources().getString(R.string.user_name);
        String correctPassword = getResources().getString(R.string.pass_word);
        String key = getResources().getString(R.string.message);
        String success = getResources().getString(R.string.success);
        String userNameNotFound = getResources().getString(R.string.username_not_found);
        String incorrectPassword = getResources().getString(R.string.incorrect_password);


        if (un.equalsIgnoreCase(correctUsername)) {
            if (pw.equalsIgnoreCase(correctPassword)) {
                intent.putExtra(key, success);
            } else {
                intent.putExtra(key, incorrectPassword);
            }
        } else {
            intent.putExtra(key, userNameNotFound);
        }
        setResult(201, intent);
        finish();
    }
}

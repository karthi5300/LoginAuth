package com.karthick.loginauth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.karthick.loginauth.R;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_UN = "username";
    private static final String KEY_PW = "password";

    private EditText mUsername, mPassword;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mLogin = findViewById(R.id.login);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();

                bundle.putString(KEY_UN, mUsername.getText().toString());
                bundle.putString(KEY_PW, mPassword.getText().toString());

                Intent intent = new Intent(MainActivity.this, Authentication.class);

                intent.putExtras(bundle);
                startActivityForResult(intent, 201);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String result = data.getStringExtra(getResources().getString(R.string.message));
        String success = getResources().getString(R.string.success);
        String userNameNotFound = getResources().getString(R.string.username_not_found);
        String incorrectPassword = getResources().getString(R.string.incorrect_password);

        if (requestCode == 201) {
            if (result.equalsIgnoreCase(success)) {
                mUsername.setText(result);
                mLogin.setEnabled(false);
            } else if (result.equalsIgnoreCase(userNameNotFound)) {
                mUsername.setText(result);
            } else if (result.equalsIgnoreCase(incorrectPassword)) {
                mUsername.setText(result);
            }
        }
    }
}

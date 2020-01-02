package com.example.hoquqi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class signup extends AppCompatActivity {

    private Button btnSingUp;
    private EditText edtUName, edtPasword, edtEmail, edtPhone;
    TextView txtGoToLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnSingUp = findViewById(R.id.ok_sing_up);
        edtUName = findViewById(R.id.edtunamesingup);
        edtPasword = findViewById(R.id.edtpnamesingup);
        edtEmail = findViewById(R.id.edtemailsingup);
        edtPhone = findViewById(R.id.edtphonesingup);
        txtGoToLogin = findViewById(R.id.txtgotologin);
        txtGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this,long.class));
                signup.this.finish();
            }
        });

    }
    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

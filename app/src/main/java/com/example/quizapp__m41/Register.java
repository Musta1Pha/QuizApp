package com.example.quizapp__m41;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText etName,etLogin,etPassword,etConfirm;
    Button bsign;
    TextView tvLogin;

    CheckBox showpasswd;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirm = (EditText) findViewById(R.id.etConfirm);
        bsign = (Button) findViewById(R.id.bsign);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        showpasswd = (CheckBox) findViewById(R.id.showpasswd);

        showpasswd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    etConfirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    etConfirm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        auth = FirebaseAuth.getInstance();

        bsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = etLogin.getText().toString();
                String password = etPassword.getText().toString();
                String password1 = etPassword.getText().toString();

                if(TextUtils.isEmpty(mail)) {
                    Toast.makeText(Register.this, "Please fill this password field", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this, "Please fill this password field", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password1)){
                    Toast.makeText(Register.this, "Please fill this password confirm field", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(password.length() < 6){
                    Toast.makeText(Register.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!password.equals(password1)){
                    Toast.makeText(Register.this, "The password was not confirmed correctly", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Registration réussie !", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this,Quiz1.class));
                            finish();
                        }else{
                            Toast.makeText(Register.this, "Registration echouée" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(Register.this,MainActivity.class));
            }
        });

    }
}
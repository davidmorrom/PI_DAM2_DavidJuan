package com.mycode.pi_dam2_davidjuan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText edtTxtUsuario;
    private EditText edtTxtContrasena;
    private TextView txtRegister;
    private FirebaseAuth mAuth;
    private int failedAttempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        failedAttempts = 0;

        edtTxtUsuario = findViewById(R.id.edtTxtUsuario);
        edtTxtContrasena = findViewById(R.id.edtTxtContrasena);
        txtRegister = findViewById(R.id.txtRegister);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtTxtUsuario.getText().toString();
                String password = edtTxtContrasena.getText().toString();
                loginUser(email, password);
            }
        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes abrir la actividad de registro
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("TAG", "signInWithEmail:success");
                            Toast.makeText(Login.this, "Authentication succeeded.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            intent.putExtra("email", email);
                            intent.putExtra("password", password);
                            startActivity(intent);
                        } else {
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            failedAttempts++;
                            if (failedAttempts >= 5) {
                                Toast.makeText(Login.this, "Has fallado demasiadas veces. La aplicación se cerrará.",
                                        Toast.LENGTH_SHORT).show();
                                finishAffinity();
                            } else if (failedAttempts >= 3) {
                                Toast.makeText(Login.this, "Te quedan " + (5 - failedAttempts) + " intentos hasta cerrarse la aplicación.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Login.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
}

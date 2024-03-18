package com.mycode.pi_dam2_davidjuan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private EditText edtTxtUsuario;
    private EditText edtTxtContrasena;
    private EditText edtTxtConfirmarContrasena;
    private TextView txtLogin;
    private ImageView imageView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        edtTxtUsuario = findViewById(R.id.edtTxtUsuario);
        edtTxtContrasena = findViewById(R.id.edtTxtContrasena);
        edtTxtConfirmarContrasena = findViewById(R.id.edtTxtConfirmarContrasena);
        txtLogin = findViewById(R.id.txtLogin);

        imageView = findViewById(R.id.instagramLogo);
        imageView.setImageResource(R.drawable.instagram);

        findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtTxtUsuario.getText().toString();
                String password = edtTxtContrasena.getText().toString();
                String confirmPassword = edtTxtConfirmarContrasena.getText().toString();
                if (password.equals(confirmPassword)) {
                    registerUser(email, password);
                } else {
                    Toast.makeText(Register.this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }

    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(Register.this, "Registro exitoso.", Toast.LENGTH_SHORT).show();
                        openLogin();
                    } else {
                        Toast.makeText(Register.this, "Error de registro.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void openLogin() {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }
}

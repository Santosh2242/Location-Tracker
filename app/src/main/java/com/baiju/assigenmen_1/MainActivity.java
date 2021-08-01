package com.baiju.assigenmen_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name, Email, Password;
    private Button Register;
    boolean isAllFieldsChecked = false;
    boolean CheckEmail = false;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.Name);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);

        Register = findViewById(R.id.Register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAllFieldsChecked = CheckAllFields();

                if (isAllFieldsChecked) {

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }

            }
        });

    }

    private boolean CheckAllFields() {

        if (Name.length() == 0) {
            Name.setError("This Field is Mandatory");
            return false;
        } else if (Name.length() < 4) {
            Name.setError("Name Must be 4 character");
            return false;
        }

        if (Password.length() == 0) {
            Password.setError("This Field is Mandatory");
            return false;
        } else if (Password.length() < 8) {
            Password.setError("Password Must be 8 character");
            return false;
        }
        if (Email.length() == 0) {
            Email.setError("This Field is Mandatory");
            return false;
        } else if (Email.length() < 7) {
            Email.setError("Email Must be 7 character");
            return false;
        }

        return true;
    }
}



























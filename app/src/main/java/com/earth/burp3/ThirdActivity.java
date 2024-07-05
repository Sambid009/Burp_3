package com.earth.burp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {
    EditText edName,edAddress,edEmail,edPhone;
    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_ok = findViewById(R.id.btn_ok);
        edName = findViewById(R.id.edName);
        edAddress = findViewById(R.id.edAddress);
        edEmail = findViewById(R.id.edEmail);
        edPhone = findViewById(R.id.edPhone);

        }//end of onCreate

    public void getAllValue(View view){

                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);




                String name = edName.getText().toString();

                String address = edAddress.getText().toString();

                String email = edEmail.getText().toString();

                String phone = edPhone.getText().toString();

        if (name.isEmpty()) {
            Toast.makeText(this, "Name is required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (address.isEmpty()) {
            Toast.makeText(this, "Address is required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (email.isEmpty()) {
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (phone.isEmpty()) {
            Toast.makeText(this, "Phone number is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (!phone.matches("\\d+")) {
            Toast.makeText(this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
            return;
        }




                intent.putExtra("name", "Your name is: " + name);
                intent.putExtra("address", "Your address is: " + address);
                intent.putExtra("email", "Your email is: " + email);
                intent.putExtra("phone", "Your phone is: " + phone);
                startActivity(intent);






    }//end of getAllValue

    }//end of ThirdActivity

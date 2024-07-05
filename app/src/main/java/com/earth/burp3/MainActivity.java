package com.earth.burp3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnOk, btnExplicit;

    EditText editTextName,editTextPhone;
    Spinner spinner;
    CheckBox checkBox2,checkBox3,checkBox5,checkBox6;
    RadioGroup Gender;
    RadioButton radioButton1, radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

//---------------------------------------------------------------------------
        btnOk = findViewById(R.id.btnOk);
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        spinner = findViewById(R.id.spinner);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        Gender = findViewById(R.id.Gender);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);



    }


        public void getAllValue(View view){

        //-------------------EditText--------------------------------
        String name = editTextName.getText().toString();
        String phone = editTextPhone.getText().toString();

        //-----------------RadioButton------------------------------
            String gender = "";
            if (radioButton1.isChecked()) {
                gender = radioButton1.getText().toString();
            }
            if (radioButton2.isChecked()) {
                gender = radioButton2.getText().toString();
            }
        //-----------------CheckBox---------------------------------
            String subject ="";
            if(checkBox2.isChecked()){
                subject += checkBox2.getText().toString()+"\n";
            }
            if(checkBox3.isChecked()){
                subject += checkBox3.getText().toString()+"\n";
            }
            if(checkBox5.isChecked()){
                subject += checkBox5.getText().toString()+"\n";
            }
            if(checkBox6.isChecked()){
                subject += checkBox6.getText().toString()+"\n";
            }
            //-----------------Spinner--------------------------------
            String city = spinner.getSelectedItem().toString();

            //-----------------Print All Value--------------------------------
            String res1 = name+phone+gender;
            String res2= subject+city;
            Toast.makeText(this, res1, Toast.LENGTH_LONG).show();
            Toast.makeText(this, res2, Toast.LENGTH_LONG).show();


            //--------------------btnExplicit-------------------------------
            btnExplicit = findViewById(R.id.btnNew);

            btnExplicit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);;
                    intent.putExtra("name","Message from first activity");
                    intent.putExtra("message",name);
                    startActivity(intent);
                }
            });







            }



        }


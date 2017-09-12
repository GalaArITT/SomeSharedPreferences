package com.example.oliver.somesharedpreferences;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String NAME = "NAME";
    final String CONTROL = "CONTROL";
    final String CORREO = "CORREO";

    EditText editText,editText2,editText3;
    Button btnGuardar, btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar = (Button) findViewById(R.id.button);
        btnMostrar =(Button)findViewById(R.id.button2);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView);
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                String texto = sharedPreferences.getString(NAME,null);
                String control = sharedPreferences.getString(CONTROL,null);
                String correo = sharedPreferences.getString(CORREO,null);

                if (texto == null){
                    textView.setText("Valores incompletos");
                }else{
                    textView.setText("--> "+texto+"\n"+"--> "+control+"\n"+"--> "+correo);
                }
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor= getPreferences(MODE_PRIVATE).edit();
                editor.putString(NAME,editText.getText().toString());
                editor.putString(CONTROL,editText2.getText().toString());
                editor.putString(CORREO,editText3.getText().toString());
                editor.commit();
            }
        });
    }
}
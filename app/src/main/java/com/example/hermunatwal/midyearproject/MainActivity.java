package com.example.hermunatwal.midyearproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button warm = findViewById(R.id.button);
        warm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GameActivity.class);
                EditText lives   = (EditText)findViewById(R.id.edittext);
                i.putExtra("lives", (lives.getText()+""));
                i.putExtra("weather","warm");
                startActivity(i);
            }
        });
        final Button cold = findViewById(R.id.button2);
        cold.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GameActivity.class);
                EditText lives   = (EditText)findViewById(R.id.edittext);
                i.putExtra("lives",lives.getText()+"");
                i.putExtra("weather","cold");
                startActivity(i);
            }
        });
    }
}

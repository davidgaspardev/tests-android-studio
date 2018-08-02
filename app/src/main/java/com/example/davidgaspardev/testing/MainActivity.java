package com.example.davidgaspardev.testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtWeb = (EditText) findViewById(R.id.intentForWebUri);

        Button btnWeb = (Button) findViewById(R.id.intentForWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!edtWeb.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Address is not empty", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Address is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}

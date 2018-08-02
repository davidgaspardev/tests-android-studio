package com.example.davidgaspardev.testing;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

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

                    Uri addr = Uri.parse(edtWeb.getText().toString());
                    startActivity(new Intent(Intent.ACTION_VIEW, addr));

                    Toast.makeText(MainActivity.this, "Intent Started", Toast.LENGTH_SHORT).show();

                    edtWeb.setText(null);

                }else {
                    Toast.makeText(MainActivity.this, "Address is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final EditText edtImg = (EditText) findViewById(R.id.intentForCameraName);

        Button btnCamera = (Button) findViewById(R.id.intentForCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!edtImg.getText().toString().isEmpty()) {

                    Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/" + edtImg.getText().toString() + ".jpg"));
                    startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE).putExtra(MediaStore.EXTRA_OUTPUT, uri));

                    edtImg.setText(null);

                }else{
                    Toast.makeText(MainActivity.this, "Does not have the image name", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}

package com.example.sudeepvig.filehandling;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText enterdata;
    Button write ,redirect;

    String hello = "I've made a change to master!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterdata=findViewById(R.id.enterdata);
        write=findViewById(R.id.write);
        redirect=findViewById(R.id.read);

        ///Writing to a file

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data =enterdata.getText().toString();

                try
                {
                    File sdcard= Environment.getExternalStorageDirectory();

//                    File directory=new File(sdcard.getAbsolutePath() +"/MyFolder");
//
//                    sdcard.mkdir();

                    File file=new File(sdcard,"MyFile.txt");

                    FileOutputStream fileOutputStream=new FileOutputStream(file);
                    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write(data);
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    enterdata.setText("");
                    Toast.makeText(MainActivity.this, "data", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });

        redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,second.class);
                startActivity(i);
            }
        });

    }
}


package com.example.sudeepvig.filehandling;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class second extends AppCompatActivity {

    EditText showdata;
    Button read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        showdata=findViewById(R.id.showdata);
        read=findViewById(R.id.read1);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    File sdcard= Environment.getExternalStorageDirectory();

                  //  File directory=new File(sdcard.getAbsolutePath() +"/MyFolder");

                    File file=new File(sdcard,"MyFile.txt");

                    FileInputStream fileInputStream=new FileInputStream(file);

                    InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);

                    char array[]=new char[10];
                    int chars_read=0;
                    String finalStr="";

                    while((chars_read=inputStreamReader.read(array))>0)
                    {
                        String str=new String(array);

                        finalStr+=str;
                        array=new char[10];

                    }
                    inputStreamReader.close();

                    showdata.setText(finalStr);



               } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(second.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                } catch (IOException e) {

                    e.printStackTrace();
                    Toast.makeText(second.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(second.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}

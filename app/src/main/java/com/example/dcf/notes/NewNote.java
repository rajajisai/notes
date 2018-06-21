package com.example.dcf.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewNote extends AppCompatActivity {


    EditText editText,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText) findViewById(R.id.editText2);


    }



    public void write(String content,String filename) {
        String Mytextmessage  = content;

        try {
            FileOutputStream fileOutputStream = openFileOutput(filename,MODE_PRIVATE);
            fileOutputStream.write(Mytextmessage.getBytes());
            fileOutputStream.close();
            finish();
            Toast.makeText(getApplicationContext(),"Text Saved",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(),"Dont leave any blank empty",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"IO exception",Toast.LENGTH_LONG).show();

            e.printStackTrace();
        }
    }
    public  void  save(View view){
        write(editText2.getText().toString(),editText.getText().toString());
    }

}

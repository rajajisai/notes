package com.example.dcf.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class READFILE extends AppCompatActivity {
TextView textView,t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readfile);
        String f=getIntent().getStringExtra("filename");
         t=findViewById(R.id.textView2);

        t.setMovementMethod(new ScrollingMovementMethod());

        read(textView,f);
    }
    public void read(TextView textView, String f) {
        textView=(TextView)findViewById(R.id.textView2);
        try {
            FileInputStream fileInputStream= openFileInput(f);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String lines;
            while ((lines=bufferedReader.readLine())!=null) {
                stringBuffer.append(lines+"\n");
            }

            textView.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void delete(View view){
        String f=getIntent().getStringExtra("filename");
        File file =new File(getFilesDir(),f);
        file.delete();
       final Intent intent=new Intent(this,fileview.class);
       startActivity(intent);
       finish();

    }

}

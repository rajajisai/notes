package com.example.dcf.notes;
import android.content.Intent;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void fview(View view){

        final Intent viewfile=new Intent(this,fileview.class);
        startActivity(viewfile);





    }
    public void onclick(View view){
        final Intent note=new Intent(this,NewNote.class);

        startActivity(note);
    }



        }






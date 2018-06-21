package com.example.dcf.notes;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

public class fileview extends AppCompatActivity {

  LinearLayout viewfile;


    private TextView createNewTextView(String text){
        final Intent intent=new Intent(this,READFILE.class);
        final String temp=text;
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(80,20,80,20);
        TextView textView=new TextView(this);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        textView.setAlpha((float)0.8);
        textView.setBackgroundColor(Color.parseColor("#83ff00"));
        textView.setTextColor(Color.parseColor("#4DD0E1"));
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new TextView.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent.putExtra("filename",temp);
                startActivity(intent);

            }
        });
        textView.setText(text);

          return textView;
    }

    public void copyfile(){
        viewfile.removeAllViews();
        String path=getFilesDir().toString();
        String temp;
        File f=new File(path);
        File file[]=f.listFiles();
        for(File x:file){
            temp=x.toString();
            temp=temp.replace(path+"/","");
            viewfile.addView(createNewTextView(temp));

        }




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fileview);
        viewfile=(LinearLayout)findViewById(R.id.master);
        copyfile();


    }

    @Override
    protected void onStart() {
        super.onStart();
        copyfile();;

    }

    @Override
    protected void onResume() {
        super.onResume();
        copyfile();
    }
}

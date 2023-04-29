package com.example.quizapp__m41;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz1 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button bnext;
    int score = 0;
    String RepCorrect = "Le Processeur";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        rg = (RadioGroup) findViewById(R.id.rg);
        bnext = (Button) findViewById(R.id.bnext);

        bnext.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               if(rg.getCheckedRadioButtonId() == -1){
                   Toast.makeText(getApplicationContext(), "Choisir une des responses", Toast.LENGTH_SHORT).show();
               }
               else{
                   rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                   if(rb.getText().toString().equals(RepCorrect)){
                       score += 1;
                   }
                   Intent intent=new Intent(Quiz1.this,Quiz2.class);
                   intent.putExtra("score",score);
                   startActivity(intent);

                   finish();

               }
           }
        });

    }
}
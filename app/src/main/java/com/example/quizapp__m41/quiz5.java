package com.example.quizapp__m41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class quiz5 extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Button bnext;
    int score;
    String RepCorrecte = "L'ordinateur risque d'être plus lent";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);

        rg = (RadioGroup) findViewById(R.id.rg);
        bnext = (Button) findViewById(R.id.bnext);
        Intent intent=getIntent();
        score=intent.getIntExtra("score",0) ;


        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Choisir une des responses", Toast.LENGTH_SHORT).show();
                }
                else{
                    rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                    if(rb.getText().toString().equals(RepCorrecte)){
                        score += 1;
                    }

                    Intent intent=new Intent(quiz5.this,Score.class);
                    intent.putExtra("score",score);
                    startActivity(intent);


                    finish();
                }
            }

        });
    }
}
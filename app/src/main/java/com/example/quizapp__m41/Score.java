package com.example.quizapp__m41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends AppCompatActivity {

    Button bLogout,bTry,bMaps;
    ProgressBar progressBar;
    TextView tvScore;

    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        bLogout = (Button) findViewById(R.id.bLogout);
        bTry = (Button) findViewById(R.id.bTry);
        bMaps = (Button) findViewById(R.id.bMaps);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tvScore = (TextView) findViewById(R.id.tvScore);

        Intent intent=getIntent();
        score=intent.getIntExtra("score",0) ;

        progressBar.setProgress(100*score/5);
        tvScore.setText(100*score/5+" %");

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Thanks for your participation", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Score.this,MainActivity.class));
            }
        });

        bTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Score.this,Quiz1.class));
            }
        });

        bMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Score.this,MapsActivity.class));
            }
        });


    }
}
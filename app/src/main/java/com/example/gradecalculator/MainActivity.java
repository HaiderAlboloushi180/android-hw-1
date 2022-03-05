package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // EditTexts
        EditText quizzes    = findViewById(R.id.quiz);
        EditText homeworkat = findViewById(R.id.homework);
        EditText midExams   = findViewById(R.id.midterm);
        EditText finalExams = findViewById(R.id.finals);

        // Buttons & TextView
        Button calculateScore = findViewById(R.id.calculate);
        Button resetScore = findViewById(R.id.reset);
        TextView grade = findViewById(R.id.result);

        // This is where the magic happens
        calculateScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Parsing
                double quizGrade = Double.parseDouble(quizzes.getText().toString());
                double hwsGrade  = Double.parseDouble(homeworkat.getText().toString());
                double midGrade  = Double.parseDouble(midExams.getText().toString());
                double finGrade  = Double.parseDouble(finalExams.getText().toString());

                // MAAAAAATH
                double finalResult = (((15*quizGrade)+(25*hwsGrade)+(30*midGrade)+(30*finGrade))/100);

                if (finalResult > 100) {
                    grade.setText("Bro you ain't THAT smart: " + finalResult);
                } else if (finalResult >= 93) {
                    grade.setText("A++++++++ KAFOOOOO 😎: " + finalResult);
                } else if (finalResult >= 90) {
                    grade.setText("A-, good but your parents might judge you 👏: " + finalResult);
                } else if (finalResult >= 87) {
                    grade.setText("B+, ok ok aight aight 👍: " + finalResult);
                } else if (finalResult >= 83) {
                    grade.setText("B, not bad, maaaybe study 😄: " + finalResult);
                } else if (finalResult >= 80) {
                    grade.setText("B-, dear god, at least not C 🙂: " + finalResult);
                } else if (finalResult >= 77) {
                    grade.setText("C+, omg. 😐: " + finalResult);
                } else if (finalResult >= 73) {
                    grade.setText("C, no comment. 😑: " + finalResult);
                } else if (finalResult >= 70) {
                    grade.setText("C-, BRUUUH NOOO 😭: " + finalResult);
                } else if (finalResult >= 67) {
                    grade.setText("D+, nah man, this is wrong 🤡: " + finalResult);
                } else if (finalResult >= 63) {
                    grade.setText("D, im out 🏃: " + finalResult);
                } else if (finalResult >= 60) {
                    grade.setText("D-, ...: " + finalResult);
                } else {
                    grade.setText("F!!!! No Tea/Coffee: " + finalResult);
                }
            }
        });

        // This is where the magic is reset
        resetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizzes.setText("");
                homeworkat.setText("");
                midExams.setText("");
                finalExams.setText("");
                grade.setText("");
            }
        });

    }
}
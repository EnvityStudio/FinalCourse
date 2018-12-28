package com.example.admin.finishcourse;
/**
 * @author Thuan Envity
 * @datetime 2018/12/26
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.finishcourse.lessonEight.LessonEightActivity;
import com.example.admin.finishcourse.lessonOne.Lesson1Activity;
import com.example.admin.finishcourse.lessonSeven.LessonSevenActivity;
import com.example.admin.finishcourse.lessonSix.LessonSixActivity;
import com.example.admin.finishcourse.lessonThree.LessonThreeActivity;
import com.example.admin.finishcourse.lessonTwo.LessonTwoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // define button
    private Button btnLesson1;
    private Button btnLesson2;
    private Button btnLesson3;
    private Button btnLesson4;
    private Button btnLesson5;
    private Button btnLesson6;
    private Button btnLesson7;
    private Button btnLesson8;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLesson1 = (Button) findViewById(R.id.btnLesson1);
        btnLesson2 = (Button) findViewById(R.id.btnLesson2);
        btnLesson3 = (Button) findViewById(R.id.btnLesson3);
        btnLesson4 = (Button) findViewById(R.id.btnLesson4);
        btnLesson5 = (Button) findViewById(R.id.btnLesson5);
        btnLesson6 = (Button) findViewById(R.id.btnLesson6);
        btnLesson7 = (Button) findViewById(R.id.btnLesson7);
        btnLesson8 = (Button) findViewById(R.id.btnLesson8);
        btnLesson1.setOnClickListener(this);
        btnLesson2.setOnClickListener(this);
        btnLesson3.setOnClickListener(this);
        btnLesson4.setOnClickListener(this);
        btnLesson5.setOnClickListener(this);
        btnLesson6.setOnClickListener(this);
        btnLesson7.setOnClickListener(this);
        btnLesson8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnLesson1:
                intent = new Intent(this, Lesson1Activity.class);
                startActivity(intent);
                break;
            case R.id.btnLesson2:
                intent = new Intent(this, LessonTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLesson3:
                intent = new Intent(this, LessonThreeActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLesson4:
                Toast.makeText(this, "Coming soooonnnnn!!!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnLesson5:
                Toast.makeText(this, "Coming soooonnnnn!!!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnLesson6:
                intent = new Intent(this, LessonSixActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLesson7:
                intent = new Intent(this, LessonSevenActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLesson8:
               intent = new Intent(this, LessonEightActivity.class);
               startActivity(intent);
                break;
            default:
                break;
        }

    }
}

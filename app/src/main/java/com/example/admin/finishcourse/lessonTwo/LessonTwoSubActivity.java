package com.example.admin.finishcourse.lessonTwo;

/**
 * @author Thuan Envity
 * @datetime 2018/12/26
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.admin.finishcourse.R;

public class LessonTwoSubActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);
        setTitle("Lesson 2 detail");
        textView = (TextView) findViewById(R.id.tvResultLesson2);
        // Get string from LessonTwoActivity
        Bundle bundle = getIntent().getExtras();
        String sum = bundle.getString("sum");
        textView.setText(sum);
    }
}

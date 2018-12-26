package com.example.admin.finishcourse.lessonThree;

/**
 * @author Thuan Envity
 * @datetime 2018/12/26
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.admin.finishcourse.R;

public class LessonThreeSubActivity extends AppCompatActivity {
    private static final String TAG = "LessonThreeSubActivity";
    private TextView name;
    private TextView dateOfBirth;
    private TextView address;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);
        name = (TextView) findViewById(R.id.tvName);
        dateOfBirth = (TextView) findViewById(R.id.tvDateOfBirth);
        address = (TextView) findViewById(R.id.tvAddress);

        Student student = (Student) getIntent().getSerializableExtra("student");
        Log.d(TAG, student.getName());
        name.setText(student.getName().toString());
        dateOfBirth.setText(student.getDateOfBirth().toString());
        address.setText(student.getAddress().toString());
    }
}

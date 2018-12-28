package com.example.admin.finishcourse.lessonSeven;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.admin.finishcourse.R;

public class LessonSevenSubActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvAddress;
    private TextView tvDOB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson7);
        tvName = (TextView)findViewById(R.id.tvNameLesson7);
        tvAddress = (TextView) findViewById(R.id.tvAddressLesson7);
        tvDOB = (TextView) findViewById(R.id.tvDOBLesson7);
        Student student = (Student) getIntent().getSerializableExtra("student");
        tvName.setText(student.getName());
        tvAddress.setText(student.getAddress());
        tvDOB.setText(student.getDateOfBirth());
    }
}

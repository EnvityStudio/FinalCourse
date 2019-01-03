package com.example.admin.finishcourse.lessonSix;
/**
 * @author Thuan Envity
 * @date 2018/12/27
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.finishcourse.R;

public class LessonSixSubActivity extends AppCompatActivity {
    private TextView tvName;
    private EditText edtStatus;
    private Button btnUpdate;
    private Button btnCancle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6);
        setTitle("Lesson 6 detail");
        tvName = (TextView) findViewById(R.id.tvNameLesson6);
        edtStatus = (EditText) findViewById(R.id.edtStatusLesson6);
        btnUpdate = (Button) findViewById(R.id.btnUpdateLesson6);
        btnCancle = (Button) findViewById(R.id.btnCancelLesson6);
        final Student student = (Student) getIntent().getSerializableExtra("student");
        tvName.setText(student.getName().toString());
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student.setStatus(edtStatus.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("updateStudent", student);
                setResult(RESULT_OK, intent);
                finish();
                //  onBackPressed();
            }
        });
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}

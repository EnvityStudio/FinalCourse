package com.example.admin.finishcourse.lessonThree;
/**
 * @author Thuan Envity
 * @datetime 2018/12/26
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.admin.finishcourse.R;

import java.util.ArrayList;
import java.util.List;

public class LessonThreeActivity extends AppCompatActivity {
    private static final String TAG = "LessonThreeActivity";
    private RecyclerView mRecyclerView;
    private List<Student> studentList;
    private LessonThreeRecyclerAdapter mLessonThreeRecyclerAdapter;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // add list student
        studentList = new ArrayList<>();
        Student student0 = new Student("1", "Nguyen Van A", "TP Ha Noi", "1/1/1111");
        Student student1 = new Student("2", "Nguyen Van B", "TP Ha Noi", "1/1/1111");
        Student student2 = new Student("3", "Nguyen Van C", "TP Ha Noi", "1/1/1111");
        studentList.add(student0);
        studentList.add(student1);
        studentList.add(student2);
        mLessonThreeRecyclerAdapter = new LessonThreeRecyclerAdapter(studentList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        // khởi tạo adapter

        //
        mRecyclerView.setAdapter(mLessonThreeRecyclerAdapter);
        // onclick
        mLessonThreeRecyclerAdapter.setOnItemListener(new LessonThreeRecyclerAdapter.OnItemListener() {
            @Override
            public void onItemClick(String student) {
                Intent intent = new Intent(LessonThreeActivity.this, LessonThreeSubActivity.class);
                Log.d(TAG, student);
                Student newStudent = studentList.get(Integer.parseInt(student) - 1);
                // put object
                intent.putExtra("student", newStudent);
                startActivity(intent);

            }
        });
    }
}

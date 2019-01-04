package com.example.admin.finishcourse.lessonSix;
/**
 * @author Thuan Envity
 * @date 2018/12/27
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
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class LessonSixActivity extends AppCompatActivity {
    private static final String TAG = "LessonSixActivity";
    private RecyclerView mRecyclerView;
    private List<Student> studentList;
    private LessonSixRecyclerViewAdapter mLessonSixRecyclerViewAdapter;
    private Context mContext;

    private void convertJson() {
        Log.d(TAG, "convertJson: abcdef");
        Gson gson = new Gson();
        String json = "{\n" +
                "  \"studentList\": [\n" +
                "    {\n" +
                "      \"id\":\"1\",\n" +
                "      \"name\":\"Nguyen Van C\",\n" +
                "      \"imageUrl\":\"a\",\n" +
                "      \"status\":\"Sad\"\n" +
                "    } ,\n" +
                "    {\n" +
                "      \"id\":\"2\",\n" +
                "      \"name\":\"Nguyen Van B\",\n" +
                "      \"imageUrl\":\"b\",\n" +
                "      \"status\":\"Sad\"\n" +
                "    } ,\n" +
                "    {\n" +
                "      \"id\":\"3\",\n" +
                "      \"name\":\"Nguyen Van Thuan\",\n" +
                "      \"imageUrl\":\"c\",\n" +
                "      \"status\":\"Aaaa\"\n" +
                "    }\n" +
                "\n" +
                "  ]\n" +
                "}\n";

        StudentData studentData = (StudentData) gson.fromJson(json, StudentData.class);

        studentList = studentData.getStudentList();
        Log.d(TAG, "convertJson: " + studentList.get(1).getName());
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult");
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                Student student = (Student) data.getSerializableExtra("updateStudent");
                studentList.get(Integer.parseInt(student.getId()) - 1).setStatus(student.getStatus());
                Log.d(TAG, studentList.get(Integer.parseInt(student.getId()) - 1).getName());
                Log.d(TAG, studentList.get(Integer.parseInt(student.getId()) - 1).getStatus());
                mLessonSixRecyclerViewAdapter.update(studentList);
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6_main);
        setTitle("Lesson 6");
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewLesson6);
        studentList = new ArrayList<>();
        convertJson();
        //
        mLessonSixRecyclerViewAdapter = new LessonSixRecyclerViewAdapter(this, studentList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mLessonSixRecyclerViewAdapter);
        mLessonSixRecyclerViewAdapter.setOnItemListener(new LessonSixRecyclerViewAdapter.OnItemListener() {
            @Override
            public void onItemClick(String student) {
                Log.d(TAG, student);
                Intent intent = new Intent(LessonSixActivity.this, LessonSixSubActivity.class);
                intent.putExtra("student", studentList.get(Integer.parseInt(student) - 1));
                startActivityForResult(intent, 1);
            }
        });


    }
}

package com.example.admin.finishcourse.lessonTwo;
/**
 * @author Thuan Envity
 * @datetime 2018/12/26
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.finishcourse.R;

public class LessonTwoActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LessonTwoActivity";
    private EditText edtOne;
    private EditText edtTwo;
    private Button btnSum;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_main);
        setTitle("Lesson 2");
        edtOne = (EditText) findViewById(R.id.edtOne);
        edtTwo = (EditText) findViewById(R.id.edtTwo);
        btnSum = (Button) findViewById(R.id.btnSum);
        btnSum.setOnClickListener(this);
    }

    private boolean isInteger(String integer) {
        try {
            Log.d(TAG, "isInteger: " + integer);
            Integer.parseInt(integer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: " + edtOne.getText().toString());
        String one = edtOne.getText().toString();
        String two = edtTwo.getText().toString();
        Intent intent = new Intent(this,LessonTwoSubActivity.class);
        // create the bundle
        // Sử dụng bundle để đẩy data sang một activity khác
        Bundle bundle = new Bundle();

        if(isInteger(one) && isInteger(two)){
            Integer sum = Integer.parseInt(one) + Integer.parseInt(two);
            // add data to bundle
            bundle.putString("sum",sum + "");
            // add the bundle to the intent
            intent.putExtras(bundle);
        }
        else {
            bundle.putString("sum","Dữ liệu nhập vào phải là số nguyên");
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

}

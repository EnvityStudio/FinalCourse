package com.example.admin.finishcourse.lessonOne;
/**
 * @author Thuan Envity
 * @datetime 2018/12/26
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.finishcourse.R;

public class Lesson1Activity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "Lesson1Activity";
    private EditText edtOne;
    private EditText edtTwo;
    private EditText edtThree;
    private Button btnSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_main);
        setTitle("Lesson 1");
        edtOne = (EditText) findViewById(R.id.edtOne);
        edtTwo = (EditText) findViewById(R.id.edtTwo);
        edtThree = (EditText) findViewById(R.id.edtThree);
        btnSum = (Button) findViewById(R.id.btnSum);
        btnSum.setOnClickListener(this);

    }
    private void sum(){
        try{
            Log.d(TAG, "sum: " + edtOne.getText().toString());
          String one = edtOne.getText().toString();
          String two = edtTwo.getText().toString();
          Integer numberOne = Integer.parseInt(one);
          Integer numberTwo = Integer.parseInt(two);
          Integer sum = numberOne + numberTwo;
          edtThree.setText(sum + "");
        }catch (Exception e){
            edtThree.setText("Dữ liệu nhập vào phải là số nguyên");
            e.printStackTrace();
        }
    }
    @Override
    public void onClick(View view) {
        if (view.getId()==btnSum.getId()){
            sum();
        }
    }
}

package com.example.admin.finishcourse.lessonFive;


/**
 * @author Thuan Envity
 * @datetime 2018/1/3
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.admin.finishcourse.R;

public class LessonFiveActivity extends AppCompatActivity implements View.OnClickListener {
    RectangleCustomView rectangleCustomView;
    Button imgMoveLeft;
    Button imgMoveRight;
    Button imgStop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lesson 5");
        setContentView(R.layout.activity_lesson5_main);

        rectangleCustomView = findViewById(R.id.customview);
//        rectangleControllerView.s
//        rectangleSurfaceView = findViewById(R.id.surface_view);
//        rectangleSurfaceView.setViewOk();

        imgMoveLeft = findViewById(R.id.img_left);
        imgMoveRight = findViewById(R.id.img_right);
        imgStop = findViewById(R.id.img_stop);

        imgMoveLeft.setOnClickListener(this);
        imgMoveRight.setOnClickListener(this);
        imgStop.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_left:
                rectangleCustomView.moveToLeft();
                break;
            case R.id.img_right:
                rectangleCustomView.moveToRight();
                break;
            case R.id.img_stop:
                rectangleCustomView.stop();
                break;
            default:
                break;
        }
    }
}

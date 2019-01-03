package com.example.admin.finishcourse.lessonFour;

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

public class LessonFourActivity extends AppCompatActivity implements View.OnClickListener{

    RectangleControllerView rectangleControllerView;
    Button imgMoveLeft;
    Button imgMoveRight;
    Button imgStop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lesson 4");
        setContentView(R.layout.activity_lesson4_main);
        rectangleControllerView = findViewById(R.id.rectangleController);

        imgMoveLeft = findViewById(R.id.img_left);
        imgMoveRight = findViewById(R.id.img_right);
        imgStop = findViewById(R.id.img_stop);

        imgMoveLeft.setOnClickListener(this);
        imgMoveRight.setOnClickListener(this);
        imgStop.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_left:
                rectangleControllerView.moveToLeft();
                break;
            case R.id.img_right:
                rectangleControllerView.moveToRight();
                break;
            case R.id.img_stop:
                rectangleControllerView.stop();
                break;
            default:
                break;
        }
    }
}

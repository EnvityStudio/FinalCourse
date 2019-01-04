package com.example.admin.finishcourse.lessonFour;

/**
 * @author Thuan Envity
 * @datetime 2018/1/3
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.admin.finishcourse.R;

public class RectangleControllerView extends View {

    private static final String TAG = "RectangleControllerView";
    private static final int MOVING_LEFT = -1;
    private static final int MOVING_RIGHT = 1;
    private static final int STOP = 0;

    private int action = 0;

    private Rectangle rectangle;
    private GameLoopThread gameLoopThread;

    private SurfaceHolder surfaceHolder;
    private int distance = 0;
    private int boundWidth = 0;
    private int boundHeight = 0;
    private Context context;
    SoundPool soundPool;
    int soundMove;
    int soundDie;


    public RectangleControllerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public RectangleControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        rectangle = new Rectangle(Color.RED);
        Log.d(TAG, "RectangleControllerView: ");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(4)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        }

        soundMove = soundPool.load(context, R.raw.smb_bump, 1);
        soundDie = soundPool.load(context, R.raw.smb_mariodie, 1);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.boundHeight = h;
        this.boundWidth = w;
        rectangle.setBounds(w, h);
        Log.d(TAG, "onSizeChanged: ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ");
        rectangle.draw(canvas);
        if (action == MOVING_RIGHT && distance > 0) {
            distance -= 5;
            rectangle.moveRight();
            if (rectangle.isOver()) {
                distance = 0;
                playSound(soundDie);
            }
        } else if (action == MOVING_LEFT && distance < 0) {
            distance += 5;
            rectangle.moveLeft();
            if (rectangle.isOver()) {
                distance = 0;
                playSound(soundDie);
            }
        } else if (action == STOP) {
            distance = 0;
        }

        invalidate();
    }


    public void moveToLeft() {
        playSound(soundMove);
        action = MOVING_LEFT;
        distance -= boundWidth / 2;
    }

    public void moveToRight() {
        playSound(soundMove);
        action = MOVING_RIGHT;
        distance += boundWidth / 2;
    }

    public void stop() {
        playSound(soundMove);
        action = STOP;
    }

    public void playSound(int soundId) {
        soundPool.play(soundId, 100, 100, 1, 0, 1);
    }
}

package com.example.admin.finishcourse.lessonFour;


/**
 * @author Thuan Envity
 * @datetime 2018/1/3
 */
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class GameLoopThread extends Thread {
    private static final String TAG = "GameLoopThread";
    private RectangleControllerView rectView;
    private boolean isRunning = false;

    public GameLoopThread(RectangleControllerView view) {
        this.rectView = view;
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    @Override
    public void run() {
        super.run();
        while (isRunning) {
            Canvas canvas = null;
            try {
//                canvas = rectView.getHolder().lockCanvas();
                rectView.draw(canvas);
                //lockCanvas:
                //tránh việc canvas có nhiều luồng can thiệp vào
                //synchronized: toàn bộ công việc trong này thực hiện xong thì mới thực hiện cái khác
//                synchronized (rectView.getHolder()) {
//                    if (canvas != null) {
//
//                    }
//                }
            } finally {//luôn thực hiện khối này
                if (canvas != null) {
                    //mở khóa canvas
//                    rectView.getHolder().unlockCanvasAndPost(canvas);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

package com.example.demographic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Sprite extends View {
    private int[] frame_ids = {
            R.drawable.a000,
            R.drawable.a001,
            R.drawable.a002,
            R.drawable.a003,
            R.drawable.a004,
            R.drawable.a005,
            R.drawable.a006,
            R.drawable.a007,
            R.drawable.a008,
            R.drawable.a009,
            R.drawable.a010,
            R.drawable.a011,
            R.drawable.a012,
            R.drawable.a013,
    };
    private int  index ;
    private CountDownTimer countDownTimer;
    public Sprite(Context context,
                  @Nullable AttributeSet attrs) {
        super(context, attrs);
        countDownTimer = new CountDownTimer(5000,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                update();
            }



            @Override
            public void onFinish() {
                this.start();
            }
        };
    }
    public void startAnimation(){
        countDownTimer.start();
    }
    public  void stopAnimation(){
        countDownTimer.cancel();
    }
    private void update() {
        invalidate();
        move();
    }

    private void move() {
        float x = getX()+3;
        float y = x*x;
        setX(x);
        setY(y);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bmp = BitmapFactory.decodeResource(
                getResources(),frame_ids[index++]
        );
        index = (index+1) %frame_ids.length;
        canvas.drawBitmap(bmp,0,0,null);
    }
}

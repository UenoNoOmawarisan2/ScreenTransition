package jp.ac.shohoku.s18b706.ueno.screentransition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * 一つの Activity ，一つの View で状態遷移する場合
 * Created by Ueno on 2019/10/10.
 */
public class MainView extends View{
    public final int FIRST = 1 ;  //状態を表す定数 1
    public final int SECOND = 2 ; //状態を表す定数 2

    int state ;   //状態を表す変数

    /**
     * コンストラクタ
     * @param context
     * @param attrs
     */
    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        state = FIRST;  //はじめは状態１
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super .onDraw(canvas);
        Paint p = new Paint();

        if (state == FIRST) {  //状態 1 の場合の描画
            p.setColor(Color. BLUE);
            canvas.drawARGB(255 , 255 , 255 , 255);
            canvas.drawRect(100 , 100 , 300 , 200 , p);
        } else if (state == SECOND){ //状態 2 の場合の描画
            p.setColor(Color. RED);
            canvas.drawARGB(255 , 255 , 255 , 0);
            canvas.drawRect(100 , 100 , 300 , 200 , p);
        } else {  //それ以外の場合は， Log にエラー を吐き出す
            Log. d (" error", "never come here");
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        //長方形の内部で
        if(x>100 && x < 300 && y>100 && y<200) {
            if(state == FIRST) {  //状態１だったら状態２へ
                state = SECOND;
            } else if (state == SECOND) { //状態２だったら状態１へ
                state = FIRST;
            } else { //それ以外だったらエラーを吐き出す
                Log.d("error", "never come here");
            }
        }

        invalidate();  //再描画
        return super. onTouchEvent(event);
    }
}
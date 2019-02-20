package com.example.asus_pc.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Function:
 * 做一个圆形的红色按钮
 * 中间有一个白色数字
 * 数字起始20
 * 点一下减少1
 * Created by ASUS-PC on 2019/1/24.
 */

public class TestRedButton extends View implements View.OnClickListener {

    private Paint mPaint;
    private Rect mRect;
    private int mNumber = 20;

    private int mBackgroundColor;
    private int mTextSize;

    public TestRedButton(Context context) {
        this(context,null);
    }



    public TestRedButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);

    }

    public TestRedButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }


    /**
     * init the view
     */
    private void init(Context context,AttributeSet attrs) {
        mPaint = new Paint();
        mRect = new Rect();

        this.setOnClickListener(this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TestRedButton);//从指定位置读属性值styleable

        mBackgroundColor = typedArray.getColor(R.styleable.TestRedButton_backgroundColor,Color.BLUE);//再把属性读出来,设置下默认值
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.TestRedButton_textSize,18);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画红色圆形按钮
        //设置画布为红色
        mPaint.setColor(mBackgroundColor);//把自定义的属性塞进去
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,mPaint);

        //中间有个白色数字
        mPaint.setColor(Color.WHITE);//把自定义的属性塞进去，还没做
        mPaint.setTextSize(mTextSize);//把自定义的属性塞进去

        /**
         * mRect是这个数字四周的边距
         */
        String text = String.valueOf(mNumber);
        mPaint.getTextBounds(text,0,text.length(),mRect);

        int textWidth = mRect.width();
        int textHight = mRect.height();

        canvas.drawText(text,getWidth()/2-textWidth/2,getHeight()/2+textHight/2,mPaint);



    }

    @Override
    public void onClick(View view) {
        //每点击一次减少1
       if (mNumber > 0) {
           mNumber--;
       } else{
           mNumber=20;
       }
       invalidate();//刷新界面

    }
}

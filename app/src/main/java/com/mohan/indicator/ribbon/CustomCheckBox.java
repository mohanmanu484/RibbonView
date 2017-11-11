package com.mohan.indicator.ribbon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mohang on 10/11/17.
 */

public class CustomCheckBox extends View{

    private TextPaint headerTextPaint=new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private TextPaint subTextPaint=new TextPaint(Paint.ANTI_ALIAS_FLAG);

    private TextView headerText;
    private TextView subText;



    public CustomCheckBox(Context context) {
        super(context);

    }

    public CustomCheckBox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

        headerText=new TextView(getContext());
        subText=new TextView(getContext());



    }

    public CustomCheckBox(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        headerTextPaint.measureText("Early Morning");
        subTextPaint.measureText("12 am to 8 am");

    }

    @Override
    protected void onDraw(Canvas canvas) {



    }
}

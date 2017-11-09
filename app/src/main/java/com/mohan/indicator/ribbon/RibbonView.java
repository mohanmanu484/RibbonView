package com.mohan.indicator.ribbon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.mohan.indicator.tagview.R;

/**
 * Created by mohang on 9/11/17.
 */

public class RibbonView extends AppCompatTextView {

    private Paint fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path ribbonViewPath = new Path();
    private Path strokePath = new Path();

    private int strokeWidth;
    public static final int DEFAULT_ARC_LENGTH = 10;
    public static final int DEFAULT_STROKE_LENGTH = 0;
    public static final int DEFAULT_FILL_COLOR = Color.RED;
    public static final int DEFAULT_STROKE_COLOR = Color.YELLOW;
    public static final int DEFAULT_SPACING = 20;
    private int initialPadding = strokeWidth / 2;
    private int ribbonFillColor = DEFAULT_FILL_COLOR;
    private int ribbonStrokeColor = DEFAULT_STROKE_COLOR;
    private int flagWidth;
    private int arcLength;


    public RibbonView(Context context) {
        super(context);
        init(null);
    }

    public RibbonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RibbonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        arcLength = DEFAULT_ARC_LENGTH;
        if (attributeSet != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.RibbonView, 0, 0);

            try {

                ribbonFillColor = a.getColor(R.styleable.RibbonView_ribbonFillColor, Color.RED);
                ribbonStrokeColor = a.getColor(R.styleable.RibbonView_ribbonStrokeColor, Color.YELLOW);
                strokeWidth = a.getInt(R.styleable.RibbonView_ribbonStrokeWidth, 0);
                arcLength = a.getInt(R.styleable.RibbonView_ribbonArcLength, DEFAULT_ARC_LENGTH);
                fillPaint.setColor(ribbonFillColor);
                fillPaint.setStyle(Paint.Style.FILL);
                strokePaint.setColor(ribbonStrokeColor);
                strokePaint.setStyle(Paint.Style.STROKE);
                strokePaint.setStrokeWidth(strokeWidth);
            } finally {
                a.recycle();
            }
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        flagWidth = getMeasuredWidth() / arcLength;
        initialPadding = strokeWidth / 2;
        setMeasuredDimension(getMeasuredWidth() + flagWidth + DEFAULT_SPACING, getMeasuredHeight() + DEFAULT_SPACING);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        drawTagPath(canvas, width, height);
        drawStrokePath(canvas, width, height);
        canvas.translate(flagWidth + 5, 0);
        super.onDraw(canvas);
    }

    private void drawStrokePath(Canvas canvas, int width, int height) {
        strokePath.moveTo(initialPadding, initialPadding);
        strokePath.lineTo(width - initialPadding, initialPadding);
        strokePath.lineTo(width - initialPadding, height - initialPadding);
        strokePath.lineTo(initialPadding, height - initialPadding);
        strokePath.lineTo(flagWidth + initialPadding, (height / 2) + initialPadding);
        strokePath.close();
        if (strokeWidth > 0) {
            canvas.drawPath(strokePath, strokePaint);
        }
    }

    private void drawTagPath(Canvas canvas, int width, int height) {
        ribbonViewPath.moveTo(0, 0);
        ribbonViewPath.lineTo(width, 0);
        ribbonViewPath.lineTo(width, height);
        ribbonViewPath.lineTo(0, height);
        ribbonViewPath.lineTo(flagWidth, height / 2);
        ribbonViewPath.close();
        canvas.drawPath(ribbonViewPath, fillPaint);
    }


    public void setRibbonFillColor(int ribbonFillColor) {
        this.ribbonFillColor = ribbonFillColor;
        invalidate();
    }

    public void setRibbonStrokeColor(int ribbonStrokeColor) {
        this.ribbonStrokeColor = ribbonStrokeColor;
        invalidate();
    }

    public void setArcLength(int arcLength) {
        this.arcLength = arcLength;
        invalidate();
    }
}

package com.example.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.lang.reflect.Field;

/**
 * Created by Javen on 14-1-16.
 */
public class ColorImageView extends ImageView {

    public ColorImageView(Context context) {
        super(context);
    }

    public ColorImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private Paint p = new Paint();

    private int color = -1;

    public void setColor(int color) {
        this.color = color;
        p.setColor(color);
        postInvalidate();
    }

    public Matrix getDrawableMatrix() {
        try {
            Field f = ImageView.class.getDeclaredField("mDrawMatrix");
            f.setAccessible(true);
            Matrix m = (Matrix) f.get(this);
            return m;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Matrix m = getDrawableMatrix();
        if (m != null)
            canvas.concat(m);
        Bitmap tmp = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas tmpcavnas = new Canvas(tmp);
        getDrawable().draw(tmpcavnas);
        canvas.drawBitmap(tmp.extractAlpha(), 0, 0, p);
        tmp.recycle();
    }
}

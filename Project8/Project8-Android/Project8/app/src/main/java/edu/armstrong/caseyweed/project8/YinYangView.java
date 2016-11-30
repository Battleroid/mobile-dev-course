package edu.armstrong.caseyweed.project8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by me on 11/26/2016.
 */

public class YinYangView extends View {

    float x, y;

    public YinYangView(Context context) {
        super(context);
    }

    public YinYangView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // init
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);

        // draw circle
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(x, y, 100, paint);

        // draw right black half
        paint.setStyle(Paint.Style.FILL);
        RectF b = new RectF(x - 100, y - 100, x + 100, y + 100);
        canvas.drawArc(b, 270, 180, true, paint);

        // draw left white half
        paint.setColor(Color.WHITE);
        RectF w = new RectF(x - 100, y - 100, x + 100, y + 100);
        canvas.drawArc(w, 90, 180, true, paint);

        // draw top bezier for white curve
        paint.setStyle(Paint.Style.FILL);
        RectF wr = new RectF(x - 50, y - 100, x + 50, y);
        canvas.drawArc(wr, 270, 180, true, paint);

        // draw bottom bezier for black curve
        paint.setColor(Color.BLACK);
        RectF bl = new RectF(x - 50, y, x + 50, y + 100);
        canvas.drawArc(bl, 90, 180, true, paint);

        // draw top black circle
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x, y - 50, 15, paint);

        // draw bottom white circle
        paint.setColor(Color.WHITE);
        canvas.drawCircle(x, y + 50, 15, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /* really really really primitive drag 'n drop,
         * only drag if we're inside the radius of the symbol,
         * not sure if you wanted drag and drop functionality
         * so I did it just in case
         */
        if (inside(event.getX(), event.getY())) {
            this.x = event.getX();
            this.y = event.getY();
        } else {
            return false;
        }

        invalidate();
        return true;
    }

    private boolean inside(float xl, float yl) {
        float distance = (float) Math.sqrt( Math.pow((xl - this.x), 2) + Math.pow((yl - this.y), 2) );
        return distance <= 100f;
    }

    public void move(float x, float y) {
        this.x = x;
        this.y = y;
        invalidate();
    }
}

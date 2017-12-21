package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        for (int i = 1; i < 30; ++i) {
            draw(canvas, 30);
//        }
    }

    private void draw(Canvas canvas, int degree) {
        Camera camera = new Camera();
        canvas.save();
        camera.save();
        int centerX = point1.x + bitmap.getWidth() / 2;
        int centerY = point1.y + bitmap.getHeight() / 2;
        camera.rotateX(degree);
        canvas.translate(centerX, centerY);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.translate(-centerX, -centerY);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
        paint.setColor(Color.RED);
        canvas.drawLine(0, centerY, 300, centerY, paint);

        canvas.save();
        camera.save();
        centerX = point2.x + bitmap.getWidth() / 2;
        centerY = point2.y + bitmap.getHeight() / 2;
        camera.rotateY(degree);
        canvas.translate(centerX, centerY);
        camera.applyToCanvas(canvas);
        camera.restore();
        canvas.translate(-centerX, -centerY);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
        paint.setColor(Color.BLUE);
        canvas.drawLine(centerX, centerY, centerX + 300, centerY, paint);
    }

}

package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice02ClipPathView extends View {
    Paint paint = new Paint();
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice02ClipPathView(Context context) {
        super(context);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * Region.Op.DIFFERENCE ：是A形状中不同于B的部分显示出来

         Region.Op.REPLACE：是只显示B的形状

         Region.Op.REVERSE_DIFFERENCE ：是B形状中不同于A的部分显示出来，这是没有设置时候默认的

         Region.Op.INTERSECT：是A和B交集的形状

         Region.Op.UNION：是A和B的全集

         Region.Op.XOR：是全集形状减去交集形状之后的部分
         */
        canvas.save();
        Path path1=new Path();
        path1.addCircle(point1.x+bitmap.getWidth()-80,point1.y+bitmap.getHeight()-80,bitmap.getWidth()-150, Path.Direction.CW);
        canvas.clipPath(path1, Region.Op.INTERSECT);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
        canvas.save();
        Path path2=new Path();
        path2.addCircle(point2.x+bitmap.getWidth()-80,point2.y+bitmap.getHeight()-80,bitmap.getWidth()-150, Path.Direction.CW);
        canvas.clipPath(path2, Region.Op.XOR);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}

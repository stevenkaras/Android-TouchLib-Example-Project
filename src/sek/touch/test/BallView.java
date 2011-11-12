package sek.touch.test;

import sek.touch.BaseGestureListener;
import sek.touch.GestureManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class BallView extends View {

	private float x = 100, y = 100;

	private float radius = 25;

	private Paint paint = new Paint();

	public BallView(final Context context) {
		super(context);
		GestureManager.manager.addGestureListener(new BaseGestureListener() {
			@Override
			public void onLongTap(float x, float y, long duration) {
				paint.setARGB(255, (int) (Math.random() * 180) + 40,
						(int) (Math.random() * 180) + 40, (int) (Math.random() * 180) + 40);
				postInvalidate();
			}

			@Override
			public void onDrag(float fromX, float fromY, float toX, float toY) {
				x = toX;
				y = toY;
				postInvalidate();
			}
			
			private float startRadius;
			
			@Override
			public void onTap(float x, float y) {
				Toast.makeText(context, "taptap", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onStartPinch(float scale, float centerX, float centerY) {
				startRadius = radius;
			}

			@Override
			public void onPinch(float scale, float centerX, float centerY) {
				radius = startRadius * scale;
				postInvalidate();
			}

		});
		paint.setStyle(Style.FILL_AND_STROKE);
		paint.setStrokeWidth(4);
		paint.setARGB(255, 0, 192, 48);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// delegate touch events to the touch library
		GestureManager.manager.processTouchEvent(event);
		return true;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.drawCircle(x, y, radius, paint);
	}

}

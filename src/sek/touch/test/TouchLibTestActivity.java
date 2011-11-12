package sek.touch.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

public class TouchLibTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        BallView ball = new BallView(this);
        addContentView(ball, new ViewGroup.LayoutParams(-1, -1));
    }
}
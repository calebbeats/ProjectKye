package edu.uco.jdrumm.projectkye;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceView;

public class GameActivity extends AppCompatActivity
{

    private Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        canvas = new Canvas(getApplicationContext());

        //relativeLayout.addView(canvas);
    }

    private class Canvas extends SurfaceView
    {
        public Canvas(Context context)
        {
            super(context, null);

            /*
            display = new DisplayMetrics();
            MainActivity.this.getWindowManager().getDefaultDisplay().getMetrics(display);
            // screen size, not canvas size
            displayWidth = display.widthPixels;
            displayHeight = display.heightPixels;

            x = displayWidth / 2;
            y = displayHeight / 2;

            surfaceHolder = getHolder();
            surfaceHolder.addCallback(new SurfaceHolderListener());
            */
        }
    }
}

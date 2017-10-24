package edu.uco.jdrumm.projectkye;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.RelativeLayout;

public class GameActivity extends AppCompatActivity
{

    private myCanvas myCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.draw_frame);
        myCanvas = new myCanvas(getApplicationContext());

        relativeLayout.addView(myCanvas);
    }

    private class myCanvas extends SurfaceView
    {
        private int x, y;
        private int RADIUS = 100;
        private DisplayMetrics display;
        private int displayWidth, displayHeight;
        private int canvasWidth, canvasHeight;
        private SurfaceHolder surfaceHolder;
        private Thread drawingThread;

        public myCanvas(Context context)
        {
            super(context, null);

            display = new DisplayMetrics();
            GameActivity.this.getWindowManager().getDefaultDisplay().getMetrics(display);
            // screen size, not canvas size
            displayWidth = display.widthPixels;
            displayHeight = display.heightPixels;

            x = displayWidth / 2;
            y = displayHeight / 2;

            surfaceHolder = getHolder();
            surfaceHolder.addCallback(new SurfaceHolderListener());
        }
    }

    private class SurfaceHolderListener implements SurfaceHolder.Callback
    {

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder)
        {
            myCanvas.drawingThread = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    long prevTime = System.currentTimeMillis();
                    Canvas canvas = null;

                    while(!Thread.currentThread().isInterrupted())
                    {
                        canvas = myCanvas.surfaceHolder.lockCanvas();
                        if(canvas != null)
                        {
                            long currTime = System.currentTimeMillis();
                            double elapsedTime = currTime - prevTime;

                            canvas.drawColor(Color.WHITE);

                            Paint p = new Paint();
                            p.setColor(Color.RED);
                            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.kye);
                            canvas.drawBitmap(b, myCanvas.x - b.getWidth() / 2, 0, p);

                            myCanvas.surfaceHolder.unlockCanvasAndPost(canvas);
                        }
                    }
                }
            });
            myCanvas.drawingThread.start();
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int w, int h)
        {
            // actual canvas size is avaliable at runtime rendering
            // same as the screen size if full screen with no title bar
            // style = @android:style/Theme.NoTitleBar.Fullscreen
            myCanvas.canvasWidth = w;
            myCanvas.canvasHeight = h;
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder)
        {
            if (myCanvas.drawingThread != null)
                myCanvas.drawingThread.interrupt();
        }
    }
}

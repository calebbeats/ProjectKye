package edu.uco.jdrumm.projectkye;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class GameActivity extends AppCompatActivity
{

    private myCanvas myCanvas;
    private Button lbutton, rbutton, ubutton, dbutton;

    //Inputs. True if currently pressed, false otherwise
    private boolean left, right, up, down;

    private GameBoard gameBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        lbutton = (Button) findViewById(R.id.lbutton);
        lbutton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                    left = true;
                else if(event.getAction() == MotionEvent.ACTION_UP)
                    left = false;
                return true;
            }
        });

        rbutton = (Button) findViewById(R.id.rbutton);
        rbutton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                    right = true;
                else if(event.getAction() == MotionEvent.ACTION_UP)
                    right = false;
                return true;
            }
        });

        ubutton = (Button) findViewById(R.id.ubutton);
        ubutton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                    up = true;
                else if(event.getAction() == MotionEvent.ACTION_UP)
                    up = false;
                return true;
            }
        });

        dbutton = (Button) findViewById(R.id.dbutton);
        dbutton.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                    down = true;
                else if(event.getAction() == MotionEvent.ACTION_UP)
                    down = false;
                return true;
            }
        });

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.draw_frame);
        myCanvas = new myCanvas(getApplicationContext());

        relativeLayout.addView(myCanvas);

        //Initialize Game Objects
        gameBoard = new GameBoard();
    }

    private class myCanvas extends SurfaceView
    {
        private int x, y;
        private DisplayMetrics display;
        private int displayWidth, displayHeight;
        private int canvasWidth, canvasHeight;
        private SurfaceHolder surfaceHolder;
        private Thread drawingThread, inputThread;

        public myCanvas(Context context)
        {
            super(context, null);

            display = new DisplayMetrics();
            GameActivity.this.getWindowManager().getDefaultDisplay().getMetrics(display);
            // screen size, not canvas size
            displayWidth = display.widthPixels;
            displayHeight = display.heightPixels;

            x = 0;//displayWidth / 2;
            y = 0;//displayHeight / 2;

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
                    Canvas canvas;

                    while(!Thread.currentThread().isInterrupted())
                    {
                        canvas = myCanvas.surfaceHolder.lockCanvas();
                        if(canvas != null)
                        {
                            long currTime = System.currentTimeMillis();
                            double elapsedTime = currTime - prevTime;
                            //System.out.println("Time: " + elapsedTime);

                            gameBoard.updateGameObjects();

                            if(gameBoard.levelFinished)
                            {
                                myCanvas.drawingThread.interrupt();
                                Intent i = new Intent(GameActivity.this,MainActivity.class);
                                startActivity(i);
                            }
                            canvas.drawColor(Color.WHITE);

                            Paint p = new Paint();
                            p.setColor(Color.RED);
                            //Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.kye);
                            //canvas.drawBitmap(b, myCanvas.x, myCanvas.y, p);
                            gameBoard.draw(canvas, getResources());

                            prevTime = currTime;
                            myCanvas.surfaceHolder.unlockCanvasAndPost(canvas);

                            try {
                                if(elapsedTime < 100)
                                    Thread.sleep((long)(100 - elapsedTime));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            });
            myCanvas.drawingThread.start();
            myCanvas.inputThread = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    while(!Thread.currentThread().isInterrupted())
                    {
                        if (left)
                        {
                            gameBoard.pushToInputQueue(Direction.LEFT);
                            left = false;
                        }
                        if (right)
                        {
                            gameBoard.pushToInputQueue(Direction.RIGHT);
                            right = false;
                        }
                        if (up)
                        {
                            gameBoard.pushToInputQueue(Direction.UP);
                            up = false;
                        }
                        if (down)
                        {
                            gameBoard.pushToInputQueue(Direction.DOWN);
                            down = false;
                        }
                    }
                }
            });
            myCanvas.inputThread.start();
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

            if (myCanvas.inputThread != null)
                myCanvas.inputThread.interrupt();
        }
    }
}

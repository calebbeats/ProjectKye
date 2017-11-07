package edu.uco.jdrumm.projectkye;

import android.content.Context;
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

import edu.uco.jdrumm.projectkye.Orientation.Direction;
import edu.uco.jdrumm.projectkye.Game.GameBoard;
import edu.uco.jdrumm.projectkye.Level.Level1;

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
        gameBoard = new GameBoard(0);
        Level1 lvl1 = new Level1();
        lvl1.populateBoard(gameBoard);
    }

    private class myCanvas extends SurfaceView
    {
        private DisplayMetrics display;
        private SurfaceHolder surfaceHolder;
        private Thread drawingThread, inputThread;
        private float density;
        private final int FRAMES_PER_SECOND = 10;

        public myCanvas(Context context)
        {
            super(context, null);

            display = new DisplayMetrics();
            GameActivity.this.getWindowManager().getDefaultDisplay().getMetrics(display);

            surfaceHolder = getHolder();
            surfaceHolder.addCallback(new SurfaceHolderListener());

            density = getResources().getDisplayMetrics().density;
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
                    long startTime = System.currentTimeMillis();
                    long cumTime = startTime;
                    Canvas canvas;

                    while(!Thread.currentThread().isInterrupted())
                    {
                        canvas = myCanvas.surfaceHolder.lockCanvas();
                        if(canvas != null)
                        {
                            long timePassed = System.currentTimeMillis() - cumTime;

                            try {
                                if(timePassed < 1000 / myCanvas.FRAMES_PER_SECOND)
                                    Thread.sleep(1000 / myCanvas.FRAMES_PER_SECOND - timePassed);
                                else
                                    Thread.sleep(5);
                                System.out.println(1000 / myCanvas.FRAMES_PER_SECOND  - timePassed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            cumTime += System.currentTimeMillis() - cumTime;
                            gameBoard.updateGameObjects();
                            canvas.drawColor(Color.WHITE);
                            Paint p = new Paint();
                            p.setColor(Color.RED);
                            gameBoard.draw(canvas, getResources(), myCanvas.density);
                            myCanvas.surfaceHolder.unlockCanvasAndPost(canvas);
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

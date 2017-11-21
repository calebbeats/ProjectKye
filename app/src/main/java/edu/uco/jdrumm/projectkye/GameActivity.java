package edu.uco.jdrumm.projectkye;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.RelativeLayout;

import edu.uco.jdrumm.projectkye.Game.GameBoard;
import edu.uco.jdrumm.projectkye.Level.Level;
import edu.uco.jdrumm.projectkye.Level.Level1;
import edu.uco.jdrumm.projectkye.Level.Level2;
import edu.uco.jdrumm.projectkye.Level.Level3;
import edu.uco.jdrumm.projectkye.Level.Level4;
import edu.uco.jdrumm.projectkye.Orientation.Direction;

public class GameActivity extends AppCompatActivity implements PopupDialogFragment.OnFragmentInteractionListener
{

    private myCanvas myCanvas;
    private Button lbutton, rbutton, ubutton, dbutton;

    //Inputs. True if currently pressed, false otherwise
    private boolean left, right, up, down;
    private int level;
    private GameBoard gameBoard;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle extras = getIntent().getExtras();

        if(extras != null)
        {
            level = extras.getInt("level");
        }
        /*
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
        */

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.draw_frame);
        myCanvas = new myCanvas(getApplicationContext());

        player = MediaPlayer.create(this, R.raw.game_music);
        player.setLooping(true);
        player.setVolume(70,70);
        player.start();

        relativeLayout.addView(myCanvas);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
    }

    public class myCanvas extends SurfaceView
    {
        private DisplayMetrics display;
        private SurfaceHolder surfaceHolder;
        private Thread drawingThread, inputThread;
        private int displayWidth, displayHeight;
        private float density;
        private final int FRAMES_PER_SECOND = 10;

        public myCanvas(Context context)
        {
            super(context, null);

            display = new DisplayMetrics();
            GameActivity.this.getWindowManager().getDefaultDisplay().getMetrics(display);

            displayWidth = display.widthPixels;
            displayHeight = display.heightPixels;

            surfaceHolder = getHolder();
            surfaceHolder.addCallback(new SurfaceHolderListener());

            density = getResources().getDisplayMetrics().density;



            //Initialize Game Objects
            gameBoard = new GameBoard(0, getResources(), this, density);
            Level l;
            switch(level)
            {
                case 1:
                    l = new Level1();
                    break;
                case 2:
                    l = new Level2();
                    break;
                case 3:
                    l = new Level3();
                    break;
                case 4:
                    l = new Level4();
                    break;
                default:
                    l = new Level1();
            }
            l.populateBoard(gameBoard);
        }

        @Override
        public boolean onTouchEvent(MotionEvent e)
        {
            int xpos = (int) e.getX();
            int ypos = (int) e.getY();

            switch(e.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    if(ypos < displayHeight / 3)
                        up = true;
                    else if (ypos > displayHeight * 2 / 3)
                        down = true;
                    else
                    {
                        //Middle third of the screen
                        if(xpos < displayWidth / 3)
                            left = true;
                        else if(xpos > displayWidth * 2 / 3)
                            right = true;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    up = left = down = right = false;
                    break;
            }
            //System.out.println("(" + xpos + ", " + ypos + ")");
            return true;
        }

        public void displayLevelEnd(String message, String name)
        {
            drawingThread.interrupt();
            FragmentManager fm = getFragmentManager();
            PopupDialogFragment frag = PopupDialogFragment.newInstance();
            Bundle args = new Bundle();
            args.putString("Message", message);
            args.putString("Name", name);
            frag.setArguments(args);
            frag.show(fm, "frag1");
        }

        public void startNextLevel()
        {
            gameBoard.loadNextLevel();
            drawingThread.start();
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
                    long cumTime = System.currentTimeMillis();
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
                                //System.out.println(1000 / myCanvas.FRAMES_PER_SECOND  - timePassed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            cumTime += System.currentTimeMillis() - cumTime;
                            gameBoard.updateGameObjects();
                            canvas.drawColor(Color.WHITE);
                            Paint p = new Paint();
                            p.setColor(Color.RED);
                            gameBoard.draw(canvas, getResources(), myCanvas.density, myCanvas.displayWidth, myCanvas.displayHeight);
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

    @Override
    public void onFragmentInteraction(PopupDialogFragment.ButtonPress b)
    {
        if(b == PopupDialogFragment.ButtonPress.NEXT)
        {
            myCanvas.startNextLevel();
        }
        else
        {
            Intent i = new Intent(GameActivity.this, LevelSelectActivity.class);
            startActivity(i);
        }
    }
}

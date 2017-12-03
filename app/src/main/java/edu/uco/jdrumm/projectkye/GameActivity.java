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
import edu.uco.jdrumm.projectkye.Level.*;
import edu.uco.jdrumm.projectkye.Orientation.Direction;

public class GameActivity extends AppCompatActivity implements
        PopupDialogFragment.OnFragmentInteractionListener,
        RestartDialogFragment.OnFragmentInteractionListenerRestart,
        GameWonDialogFragment.OnFragmentInteractionListenerGameWon,
        GameLossDialogFragment.OnFragmentInteractionListenerGameLoss
{

    private myCanvas myCanvas;

    //Inputs. True if currently pressed, false otherwise
    private boolean left, right, up, down, center, pressed;
    private long ltime, rtime, utime, dtime;
    private int level;
    private GameBoard gameBoard;
    MediaPlayer player;
    int volume;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle extras = getIntent().getExtras();

        if(extras != null)
        {
            level = extras.getInt("level");
            volume = extras.getInt("volume");

        }
        else
        {
         volume = 100;
        }

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.draw_frame);
        myCanvas = new myCanvas(getApplicationContext());

        player = MediaPlayer.create(this, R.raw.game_music);
        player.setLooping(true);

        System.out.println("Volume = " + volume);

        player.setVolume(volume, volume);
        player.start();

        relativeLayout.addView(myCanvas);
    }

    @Override
    protected void onDestroy()
    {
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
                case 5:
                    l = new Level5();
                    break;
                case 6:
                    l = new Level6();
                    break;
                case 7:
                    l = new Level7();
                    break;
                case 8:
                    l = new Level8();
                    break;
                case 9:
                    l = new Level9();
                    break;
                case 10:
                    l = new Level10();
                    break;
                case 11:
                    l = new Level11();
                    break;
                case 12:
                    l = new Level12();
                    break;
                case 13:
                    l = new Level13();
                    break;
                case 14:
                    l = new Level14();
                    break;
                case 15:
                    l = new Level15();
                    break;
                default:
                    l = new Level1();
            }
            l.populateBoard(gameBoard);
            gameBoard.setCurrentLevel(l);
        }

        @Override
        public boolean onTouchEvent(MotionEvent e)
        {
            int xpos = (int) e.getX();
            int ypos = (int) e.getY();

            switch(e.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    pressed = true;
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
                        else
                            center = true;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    up = left = down = right = center = pressed = false;
                    ltime = rtime = utime = dtime = 0;
                    break;
            }
            //System.out.println("(" + xpos + ", " + ypos + ")");
            return true;
        }

        public void displayLevelEnd(String message, String name)
        {
            gameBoard.pause();
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
            gameBoard.unPause();
        }

        public void promptRestart()
        {
            gameBoard.pause();
            FragmentManager fm = getFragmentManager();
            RestartDialogFragment frag = RestartDialogFragment.newInstance();
            frag.show(fm, "frag2");
        }

        public void continueLevel()
        {
            gameBoard.unPause();
        }

        public void restartLevel()
        {
            gameBoard.restartLevel();
            gameBoard.unPause();
        }

        public void displayGameEnd()
        {
            gameBoard.pause();
            FragmentManager fm = getFragmentManager();
            GameWonDialogFragment frag = GameWonDialogFragment.newInstance();
            frag.show(fm, "frag3");
        }

        public void promptLoss()
        {
            gameBoard.pause();
            FragmentManager fm = getFragmentManager();
            GameLossDialogFragment frag = GameLossDialogFragment.newInstance();
            frag.show(fm, "frag4");
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
                                int waitTime = 1000;
                                if(gameBoard.inputQueueSize() > 0 && pressed)
                                    waitTime = 250;
                                if(timePassed < waitTime / myCanvas.FRAMES_PER_SECOND)
                                    Thread.sleep(waitTime / myCanvas.FRAMES_PER_SECOND - timePassed);
                                else
                                    Thread.sleep(5);
                                //System.out.println(1000 / myCanvas.FRAMES_PER_SECOND  - timePassed);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            cumTime += System.currentTimeMillis() - cumTime;
                            gameBoard.updateGameObjects();
                            canvas.drawColor(Color.WHITE);
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
                            ltime = System.currentTimeMillis();
                            gameBoard.pushToInputQueue(Direction.LEFT);
                            left = false;
                        }
                        if (right)
                        {
                            rtime = System.currentTimeMillis();
                            gameBoard.pushToInputQueue(Direction.RIGHT);
                            right = false;
                        }
                        if (up)
                        {
                            utime = System.currentTimeMillis();
                            gameBoard.pushToInputQueue(Direction.UP);
                            up = false;
                        }
                        if (down)
                        {
                            dtime = System.currentTimeMillis();
                            gameBoard.pushToInputQueue(Direction.DOWN);
                            down = false;
                        }
                        if (center)
                        {
                            gameBoard.promptRestart();
                            center = false;
                        }
                        if(gameBoard.inputQueueSize() == 0)
                        {
                            long t = System.currentTimeMillis();
                            if (ltime != 0 && t - ltime > 500)
                                gameBoard.pushToInputQueue(Direction.LEFT);
                            if (rtime != 0 && t - rtime > 500)
                                gameBoard.pushToInputQueue(Direction.RIGHT);
                            if (utime != 0 && t - utime > 500)
                                gameBoard.pushToInputQueue(Direction.UP);
                            if (dtime != 0 && t - dtime > 500)
                                gameBoard.pushToInputQueue(Direction.DOWN);
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
    public void onFragmentInteraction(ButtonPress b)
    {
        if(b == ButtonPress.NEXT)
        {
            myCanvas.startNextLevel();
        }
        else
        {
            Intent i = new Intent(GameActivity.this, LevelSelectActivity.class);
            startActivity(i);
        }
    }


    @Override
    public void onFragmentInteractionRestart(ButtonPress b)
    {
        switch(b)
        {
            case QUIT:
                Intent i = new Intent(GameActivity.this, LevelSelectActivity.class);
                startActivity(i);
                break;
            case RESTART:
                myCanvas.restartLevel();
                break;
            default:
                myCanvas.continueLevel();
        }
    }

    @Override
    public void onFragmentInteractionGameWon()
    {
        Intent i = new Intent(GameActivity.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onFragmentInteractionGameLoss()
    {
        myCanvas.restartLevel();
    }
}

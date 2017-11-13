package edu.uco.jdrumm.projectkye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.uco.jdrumm.projectkye.Orientation.LevelSelectActivity;

public class MainActivity extends AppCompatActivity
{

    Button play, levels, options;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.ButtonPlay);
        levels = (Button) findViewById(R.id.ButtonLevels);
        options = (Button) findViewById(R.id.ButtonOptions);

        play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MainActivity.this, GameActivity.class);
                startActivity(i);
            }
        });

        levels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LevelSelectActivity.class);
                startActivity(i);
            }
        });
    }
}

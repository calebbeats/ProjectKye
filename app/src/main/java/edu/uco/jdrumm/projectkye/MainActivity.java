package edu.uco.jdrumm.projectkye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    int volume;

    Button play, levels, options;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();

        if(extras == null)
        {
            volume = 100;
        }
        else
        {
            volume =  extras.getInt("volume");
        }

        play = (Button) findViewById(R.id.ButtonPlay);
        levels = (Button) findViewById(R.id.ButtonLevels);
        options = (Button) findViewById(R.id.ButtonOptions);

        play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MainActivity.this, GameActivity.class);
                i.putExtra("volume", volume);
                startActivity(i);
            }
        });

        levels.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(MainActivity.this, LevelSelectActivity.class);
            i.putExtra("volume", volume);
            startActivity(i);
        }
    });
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, OptionsActivity.class);
                i.putExtra("volume", volume);
                startActivity(i);
            }
        });
    }
}

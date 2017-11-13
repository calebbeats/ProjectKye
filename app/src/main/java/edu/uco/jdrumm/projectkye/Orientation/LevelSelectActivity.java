package edu.uco.jdrumm.projectkye.Orientation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import edu.uco.jdrumm.projectkye.GameActivity;
import edu.uco.jdrumm.projectkye.R;

public class LevelSelectActivity extends AppCompatActivity {

    private Button btnLevel1;
    private Button btnLevel2;
    private Button btnLevel3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        btnLevel1 = (Button) findViewById(R.id.btnLevel1);
        btnLevel2 = (Button) findViewById(R.id.btnLevel2);
        btnLevel3 = (Button) findViewById(R.id.btnLevel3);

        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextLevel = new Intent(LevelSelectActivity.this, GameActivity.class);
                nextLevel.putExtra("level",1);
                startActivity(nextLevel);
            }
        });
        btnLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextLevel = new Intent(LevelSelectActivity.this, GameActivity.class);
                nextLevel.putExtra("level",2);
                startActivity(nextLevel);
            }
        });
        btnLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextLevel = new Intent(LevelSelectActivity.this, GameActivity.class);
                nextLevel.putExtra("level",3);
                startActivity(nextLevel);
            }
        });
    }
}

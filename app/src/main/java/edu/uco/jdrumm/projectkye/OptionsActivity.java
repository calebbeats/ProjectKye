package edu.uco.jdrumm.projectkye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class OptionsActivity extends AppCompatActivity {


    Button btnApply;
    SeekBar sbVolume;

    int volume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        btnApply = (Button) findViewById(R.id.btnApply);
        sbVolume = (SeekBar) findViewById(R.id.sbVolume);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            sbVolume.setProgress(extras.getInt("volume"));
        }




        sbVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                volume = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent i = new Intent(OptionsActivity.this, MainActivity.class);
                i.putExtra("volume", volume);
                startActivity(i);
            }
        });
    }
}

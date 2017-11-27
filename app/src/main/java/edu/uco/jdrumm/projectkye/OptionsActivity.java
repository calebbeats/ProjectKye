package edu.uco.jdrumm.projectkye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OptionsActivity extends AppCompatActivity {

    EditText edtVolume;
    Button btnApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        edtVolume = (EditText) findViewById(R.id.edtVolume);
        btnApply = (Button) findViewById(R.id.btnApply);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OptionsActivity.this, MainActivity.class);
                i.putExtra("volume", edtVolume.getText().toString());
                startActivity(i);
            }
        });
    }
}

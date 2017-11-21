package edu.uco.jdrumm.projectkye;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class LevelSelectActivity extends Activity
{
    ListView list;
    String[] itemname =
            {
                    "First",
                    "Second",
                    "Slider",
                    "Zoo",
                    "Diamond",
                    "Counters",
                    "Blocks",
                    "Circus",
                    "Gallery",
                    "Trapper",
                    "Pintpot",
                    "Getout",
                    "Fallin",
                    "Adoorable",
                    "RockyV"
            };

    Integer[] imgid=
            {
                    R.drawable.first,
                    R.drawable.second,
                    R.drawable.slider,
                    R.drawable.zoo,
                    R.drawable.diamond,
                    R.drawable.counters,
                    R.drawable.blocks,
                    R.drawable.circus,
                    R.drawable.gallery,
                    R.drawable.trapper,
                    R.drawable.pintpot,
                    R.drawable.getout,
                    R.drawable.fallin,
                    R.drawable.adoorable,
                    R.drawable.rockyv
            };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                Intent i = new Intent(LevelSelectActivity.this, GameActivity.class);
                i.putExtra("level", position + 1);
                startActivity(i);
            }
        });
    }
}

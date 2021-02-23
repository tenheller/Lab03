package com.hellerkristen.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
TextView tl, tr, bl, br;
int tlcount, trcount, blcount, brcount;
Context context;
CharSequence text;
Toast toast;
SharedPreferences savedData;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tl = findViewById(R.id.topleft);
        tr = findViewById(R.id.topright);
        bl = findViewById(R.id.botleft);
        br = findViewById(R.id.botright);

        tl.setOnClickListener(this);
        tr.setOnClickListener(this);
        bl.setOnClickListener(this);
        br.setOnClickListener(this);

        savedData = getSharedPreferences("Button Clicks", Context.MODE_PRIVATE);
        editor = savedData.edit();

        tlcount = savedData.getInt("tlbuttonclicks", 0);
        trcount = savedData.getInt("trbuttonclicks", 0);
        blcount = savedData.getInt("blbuttonclicks", 0);
        brcount = savedData.getInt("brbuttonclicks", 0);

        tl.setText(""+tlcount);
        tr.setText(""+trcount);
        bl.setText(""+blcount);
        br.setText(""+brcount);

    }

    @Override
    public void onClick(View v) {
        context = getApplicationContext();
        text = getString(R.string.button_was_clicked);
        int duration = Toast.LENGTH_SHORT;
        toast = Toast.makeText(context, text, duration);
        toast.show();

        int updater = 0;
        if(v.getId()==tl.getId())
        {
            tlcount++;
            updater = tlcount;
            editor.putInt("tlbuttonclicks", tlcount);
        }
        else if(v.getId()==tr.getId())
        {
            trcount++;
            updater = trcount;
            editor.putInt("trbuttonclicks", trcount);
        }
        else if(v.getId()==bl.getId())
        {
            blcount++;
            updater = blcount;
            editor.putInt("blbuttonclicks", blcount);
        }
        else if(v.getId()==br.getId())
        {
            brcount++;
            updater = brcount;
            editor.putInt("brbuttonclicks", brcount);
        }
        ((TextView)v).setText(""+updater);
        editor.apply();
    }
}
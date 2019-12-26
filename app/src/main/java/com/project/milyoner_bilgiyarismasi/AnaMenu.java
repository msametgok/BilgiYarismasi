package com.project.milyoner_bilgiyarismasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class AnaMenu extends AppCompatActivity {

    MediaPlayer mp;
    ImageView logo;
    Switch voice;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ana_menu);
        voice = (Switch) findViewById(R.id.openvoice);
        getSupportActionBar().hide();
        mp = MediaPlayer.create(this, R.raw.anaekran);
        sharedPreferences = getSharedPreferences("ses", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = sharedPreferences.edit();

        voice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    edit.putString("ses", "ok");
                    mp.start();
                    edit.commit();
                } else if (!b) {
                    edit.putString("ses", "no");
                    mp.stop();
                    edit.commit();
                }
            }
        });
        if (sharedPreferences.getString("ses", "").equals("ok")) {
            mp.start();
            voice.setChecked(true);
        } else voice.setChecked(false);

    }
    public void yeniOyun(View view) {
        mp.stop();
        startActivity(new Intent(AnaMenu.this, OyunEkran.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mp.isPlaying()) {
            mp.stop();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (mp.isPlaying()) {
            mp.stop();
        }
    }

    public void yuksekScore(View view) {
        startActivity(new Intent(AnaMenu.this, SkorListe.class));
    }

    public void quit(View view) {
        System.exit(0);
    }

}

package com.project.milyoner_bilgiyarismasi.Kütüphane;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.milyoner_bilgiyarismasi.Basari;
import com.project.milyoner_bilgiyarismasi.R;

import java.util.ArrayList;

public class SkorAdapter extends BaseAdapter { // ListView içine veri koymamız için gerekli
    Activity activity;
    LayoutInflater inflater; //xml dosyalarını çevirir.

    public SkorAdapter(Activity activity, ArrayList<Basari> scores) {
        this.activity = activity;
        this.scores = scores;
        inflater=LayoutInflater.from(activity.getApplicationContext());
    }

    ArrayList<Basari> scores;



    public int getCount() {
        return scores.size();
    } //listviewda gösterilecek satır sayısı


    public Object getItem(int i) {  //i. satırdaki nesneyi döndürüyor
        return scores.get(i);
    }


    public long getItemId(int i) { // i. satırdaki nesnenin idsi
        return i;
    }


    public View getView(int i, View view, ViewGroup viewGroup) { //rowscore.xml ini her satır için viewa çevirdik
        View v=inflater.inflate(R.layout.rowscore,null);
        TextView tvpara=(TextView)v.findViewById(R.id.para);
        TextView tvpuan=(TextView)v.findViewById(R.id.puan);
        TextView tvsure=(TextView)v.findViewById(R.id.sure);

        tvpara.setText(""+scores.get(i).getPara()+" "+activity.getString(R.string.currency));
        tvsure.setText(""+scores.get(i).getSure()+" "+activity.getString(R.string.second));
        tvpuan.setText(""+scores.get(i).getPuan()+" "+activity.getString(R.string.point));

        return v;
    }
}

package com.example.app;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
    ColorImageView civ = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        civ = (ColorImageView) findViewById(R.id.xx);
    }

    private int[] colors = {Color.RED, Color.BLACK, Color.BLUE, Color.YELLOW};
    int i = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            civ.setColor(colors[i % 4]);
            i++;
        }
        return super.onTouchEvent(event);
    }
}

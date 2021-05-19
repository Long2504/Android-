package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;


public class GameActivity extends AppCompatActivity {

    private GameView gameView;

    public void setFlags(int flags, int mask) {
        final WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags = (attrs.flags & ~mask) | (flags & mask);
        int mForcedWindowFlags = mask;
        dispatchWindowAttributesChanged(attrs);
    }

    private void dispatchWindowAttributesChanged(WindowManager.LayoutParams attrs) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Point point = new Point();
        getDisplay().getRealSize(point);

        gameView = new GameView(this, point.x, point.y);

        setContentView(gameView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }

}
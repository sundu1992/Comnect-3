package com.example.sundu.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // 0 - O and 1-X
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2}; // 2 - unplayed

    public void dropIn(View view){

        ImageView counter = (ImageView)view;

        counter.setTranslationY(-1000f);
        int Tapped = Integer.parseInt(counter.getTag().toString());

        if(gameState[Tapped]==2) {

            gameState[Tapped]=activePlayer;
            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.o);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.x);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(300);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

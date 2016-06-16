package com.example.sundu.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 - O and 1-X
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2}; // 2 - unplayed
    int [][] winningPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,4,8},{1,5,8},{2,4,6}};

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
            counter.animate().translationYBy(1000f).setDuration(30);
            for(int[] winPost : winningPosition){

                if(gameState[winPost[0]] == gameState[winPost[1]] &&
                        gameState[winPost[1]]== gameState[winPost[2]] &&
                        gameState[winPost[0]] != 2){
                    System.out.println(gameState[winPost[0]]);
                    String Winner="X";
                    if(gameState[winPost[0]]==0){
                        Winner = "O";
                    }

                    //Who won?
                    TextView msg = (TextView)findViewById(R.id.popUp);
                    msg.setText(Winner+" Won!!");
                    //when won
                    LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear);
                    linearLayout.setVisibility(View.VISIBLE);

                }
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

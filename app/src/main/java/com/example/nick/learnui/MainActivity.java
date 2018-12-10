package com.example.nick.learnui;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lib.Blocks;
import com.example.lib.Bit;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {
    public Timer timer;

    public WebView webView;

    public TextView text;

    public ImageView[][] image;

    public int count = 0;

    public EditText scoreText;

    public CharSequence ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_page);
        final EditText userID = findViewById(R.id.editText);
        Button startButton = findViewById(R.id.button4);



        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = userID.getText();
                setContentView(R.layout.activity_main);
                current = new Blocks();
                //find image
                image = new ImageView[8][11];
                image[0][0] = findViewById(R.id.image00);
                image[0][1] = findViewById(R.id.image01);
                image[0][2] = findViewById(R.id.image02);
                image[0][3] = findViewById(R.id.image03);
                image[0][4] = findViewById(R.id.image04);
                image[0][5] = findViewById(R.id.image05);
                image[0][6] = findViewById(R.id.image06);
                image[0][7] = findViewById(R.id.image07);
                image[0][8] = findViewById(R.id.image08);
                image[0][9] = findViewById(R.id.image09);
                image[0][10] = findViewById(R.id.image010);

                image[1][0] = findViewById(R.id.image10);
                image[1][1] = findViewById(R.id.image11);
                image[1][2] = findViewById(R.id.image12);
                image[1][3] = findViewById(R.id.image13);
                image[1][4] = findViewById(R.id.image14);
                image[1][5] = findViewById(R.id.image15);
                image[1][6] = findViewById(R.id.image16);
                image[1][7] = findViewById(R.id.image17);
                image[1][8] = findViewById(R.id.image18);
                image[1][9] = findViewById(R.id.image19);
                image[1][10] = findViewById(R.id.image110);

                image[2][0] = findViewById(R.id.image20);
                image[2][1] = findViewById(R.id.image21);
                image[2][2] = findViewById(R.id.image22);
                image[2][3] = findViewById(R.id.image23);
                image[2][4] = findViewById(R.id.image24);
                image[2][5] = findViewById(R.id.image25);
                image[2][6] = findViewById(R.id.image26);
                image[2][7] = findViewById(R.id.image27);
                image[2][8] = findViewById(R.id.image28);
                image[2][9] = findViewById(R.id.image29);
                image[2][10] = findViewById(R.id.image210);

                image[3][0] = findViewById(R.id.image30);
                image[3][1] = findViewById(R.id.image31);
                image[3][2] = findViewById(R.id.image32);
                image[3][3] = findViewById(R.id.image33);
                image[3][4] = findViewById(R.id.image34);
                image[3][5] = findViewById(R.id.image35);
                image[3][6] = findViewById(R.id.image36);
                image[3][7] = findViewById(R.id.image37);
                image[3][8] = findViewById(R.id.image38);
                image[3][9] = findViewById(R.id.image39);
                image[3][10] = findViewById(R.id.image310);

                image[4][0] = findViewById(R.id.image40);
                image[4][1] = findViewById(R.id.image41);
                image[4][2] = findViewById(R.id.image42);
                image[4][3] = findViewById(R.id.image43);
                image[4][4] = findViewById(R.id.image44);
                image[4][5] = findViewById(R.id.image45);
                image[4][6] = findViewById(R.id.image46);
                image[4][7] = findViewById(R.id.image47);
                image[4][8] = findViewById(R.id.image48);
                image[4][9] = findViewById(R.id.image49);
                image[4][10] = findViewById(R.id.image410);

                image[5][0] = findViewById(R.id.image50);
                image[5][1] = findViewById(R.id.image51);
                image[5][2] = findViewById(R.id.image52);
                image[5][3] = findViewById(R.id.image53);
                image[5][4] = findViewById(R.id.image54);
                image[5][5] = findViewById(R.id.image55);
                image[5][6] = findViewById(R.id.image56);
                image[5][7] = findViewById(R.id.image57);
                image[5][8] = findViewById(R.id.image58);
                image[5][9] = findViewById(R.id.image59);
                image[5][10] = findViewById(R.id.image510);

                image[6][0] = findViewById(R.id.image60);
                image[6][1] = findViewById(R.id.image61);
                image[6][2] = findViewById(R.id.image62);
                image[6][3] = findViewById(R.id.image63);
                image[6][4] = findViewById(R.id.image64);
                image[6][5] = findViewById(R.id.image65);
                image[6][6] = findViewById(R.id.image66);
                image[6][7] = findViewById(R.id.image67);
                image[6][8] = findViewById(R.id.image68);
                image[6][9] = findViewById(R.id.image69);
                image[6][10] = findViewById(R.id.image610);

                image[7][0] = findViewById(R.id.image70);
                image[7][1] = findViewById(R.id.image71);
                image[7][2] = findViewById(R.id.image72);
                image[7][3] = findViewById(R.id.image73);
                image[7][4] = findViewById(R.id.image74);
                image[7][5] = findViewById(R.id.image75);
                image[7][6] = findViewById(R.id.image76);
                image[7][7] = findViewById(R.id.image77);
                image[7][8] = findViewById(R.id.image78);
                image[7][9] = findViewById(R.id.image79);
                image[7][10] = findViewById(R.id.image710);

                scoreText = findViewById(R.id.editText2);



            }
        });

        //find image
        image = new ImageView[8][11];
        image[0][0] = this.findViewById(R.id.image00);
        image[0][1] = this.findViewById(R.id.image01);
        image[0][2] = this.findViewById(R.id.image02);
        image[0][3] = this.findViewById(R.id.image03);
        image[0][4] = this.findViewById(R.id.image04);
        image[0][5] = this.findViewById(R.id.image05);
        image[0][6] = this.findViewById(R.id.image06);
        image[0][7] = this.findViewById(R.id.image07);
        image[0][8] = this.findViewById(R.id.image08);
        image[0][9] = this.findViewById(R.id.image09);
        image[0][10] = this.findViewById(R.id.image010);

        image[1][0] = this.findViewById(R.id.image10);
        image[1][1] = this.findViewById(R.id.image11);
        image[1][2] = this.findViewById(R.id.image12);
        image[1][3] = this.findViewById(R.id.image13);
        image[1][4] = this.findViewById(R.id.image14);
        image[1][5] = this.findViewById(R.id.image15);
        image[1][6] = this.findViewById(R.id.image16);
        image[1][7] = this.findViewById(R.id.image17);
        image[1][8] = this.findViewById(R.id.image18);
        image[1][9] = this.findViewById(R.id.image19);
        image[1][10] = this.findViewById(R.id.image110);

        image[2][0] = this.findViewById(R.id.image20);
        image[2][1] = this.findViewById(R.id.image21);
        image[2][2] = this.findViewById(R.id.image22);
        image[2][3] = this.findViewById(R.id.image23);
        image[2][4] = this.findViewById(R.id.image24);
        image[2][5] = this.findViewById(R.id.image25);
        image[2][6] = this.findViewById(R.id.image26);
        image[2][7] = this.findViewById(R.id.image27);
        image[2][8] = this.findViewById(R.id.image28);
        image[2][9] = this.findViewById(R.id.image29);
        image[2][10] = this.findViewById(R.id.image210);

        image[3][0] = this.findViewById(R.id.image30);
        image[3][1] = this.findViewById(R.id.image31);
        image[3][2] = this.findViewById(R.id.image32);
        image[3][3] = this.findViewById(R.id.image33);
        image[3][4] = this.findViewById(R.id.image34);
        image[3][5] = this.findViewById(R.id.image35);
        image[3][6] = this.findViewById(R.id.image36);
        image[3][7] = this.findViewById(R.id.image37);
        image[3][8] = this.findViewById(R.id.image38);
        image[3][9] = this.findViewById(R.id.image39);
        image[3][10] = this.findViewById(R.id.image310);

        image[4][0] = this.findViewById(R.id.image40);
        image[4][1] = this.findViewById(R.id.image41);
        image[4][2] = this.findViewById(R.id.image42);
        image[4][3] = this.findViewById(R.id.image43);
        image[4][4] = this.findViewById(R.id.image44);
        image[4][5] = this.findViewById(R.id.image45);
        image[4][6] = this.findViewById(R.id.image46);
        image[4][7] = this.findViewById(R.id.image47);
        image[4][8] = this.findViewById(R.id.image48);
        image[4][9] = this.findViewById(R.id.image49);
        image[4][10] = this.findViewById(R.id.image410);

        image[5][0] = this.findViewById(R.id.image50);
        image[5][1] = this.findViewById(R.id.image51);
        image[5][2] = this.findViewById(R.id.image52);
        image[5][3] = this.findViewById(R.id.image53);
        image[5][4] = this.findViewById(R.id.image54);
        image[5][5] = this.findViewById(R.id.image55);
        image[5][6] = this.findViewById(R.id.image56);
        image[5][7] = this.findViewById(R.id.image57);
        image[5][8] = this.findViewById(R.id.image58);
        image[5][9] = this.findViewById(R.id.image59);
        image[5][10] = this.findViewById(R.id.image510);

        image[6][0] = this.findViewById(R.id.image60);
        image[6][1] = this.findViewById(R.id.image61);
        image[6][2] = this.findViewById(R.id.image62);
        image[6][3] = this.findViewById(R.id.image63);
        image[6][4] = this.findViewById(R.id.image64);
        image[6][5] = this.findViewById(R.id.image65);
        image[6][6] = this.findViewById(R.id.image66);
        image[6][7] = this.findViewById(R.id.image67);
        image[6][8] = this.findViewById(R.id.image68);
        image[6][9] = this.findViewById(R.id.image69);
        image[6][10] = this.findViewById(R.id.image610);

        image[7][0] = this.findViewById(R.id.image70);
        image[7][1] = this.findViewById(R.id.image71);
        image[7][2] = this.findViewById(R.id.image72);
        image[7][3] = this.findViewById(R.id.image73);
        image[7][4] = this.findViewById(R.id.image74);
        image[7][5] = this.findViewById(R.id.image75);
        image[7][6] = this.findViewById(R.id.image76);
        image[7][7] = this.findViewById(R.id.image77);
        image[7][8] = this.findViewById(R.id.image78);
        image[7][9] = this.findViewById(R.id.image79);
        image[7][10] = this.findViewById(R.id.image710);

        scoreText = findViewById(R.id.editText2);
    }
    //Left button onClick event.
    public void onClickLeft(android.view.View input) {
        this.current.moveAllLeft();
        this.current.moveAllDown();
        display();


    }
    //Right button onClick event.
    public void onClickRight(android.view.View input) {
        this.current.moveAllRight();
        this.current.moveAllDown();
        display();

    }
    //Rotate button onClick event.
    public void onClickRotate(android.view.View input) {
        Blocks.currentBlocks.get(Blocks.currentBlocks.size() - 1).rotate();
        display();


    }
    //Reset button onClick event.
    public void onClickReset(android.view.View input) {
        setContentView(R.layout.score_page);
        final Button restartButton = findViewById(R.id.button6);


        //APIs to store High Score Player(ID + Score)!
        Context context = getApplicationContext();
        SharedPreferences sharedPref1 = context.getSharedPreferences(getString(R.string.top_player_Score), Context.MODE_PRIVATE);
        SharedPreferences sharedPref2 = context.getSharedPreferences(getString(R.string.top_player_ID), Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor1 = sharedPref1.edit();
        final SharedPreferences.Editor editor2 = sharedPref2.edit();
        int newHighScore = Blocks.score;
        String newHighScoreID = ID.toString();



        TextView highScoreText = findViewById(R.id.editText3);

        Integer oldHighScore = sharedPref1.getInt(getString(R.string.saved_high_score_key), 0);
        Object oldHighScoreID = sharedPref2.getString("Highscore", "None");
        if (oldHighScore < newHighScore) {
            editor1.putInt(getString(R.string.saved_high_score_key), newHighScore);
            editor2.putString("Highscore", newHighScoreID);
            editor1.apply();
            editor2.apply();
            highScoreText.setText("HighScore:" + newHighScoreID + "/" + Blocks.score.toString());

        } else {
            Integer oldHighScoreObject = oldHighScore;
            highScoreText.setText("HighScore:" + oldHighScoreID + "/" + oldHighScoreObject.toString());


        }
        final Button restHighScore = findViewById(R.id.button7);
        restHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor1.putInt(getString(R.string.saved_high_score_key), 0);
                editor2.putString("Highscore", "empty");
                editor1.apply();
                editor2.apply();
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
                current = new Blocks();
                current.board = new Bit[8][11];
                current.currentBlocks = new ArrayList<>();
                current.score = 0;
                //find image
                image = new ImageView[8][11];
                image[0][0] = findViewById(R.id.image00);
                image[0][1] = findViewById(R.id.image01);
                image[0][2] = findViewById(R.id.image02);
                image[0][3] = findViewById(R.id.image03);
                image[0][4] = findViewById(R.id.image04);
                image[0][5] = findViewById(R.id.image05);
                image[0][6] = findViewById(R.id.image06);
                image[0][7] = findViewById(R.id.image07);
                image[0][8] = findViewById(R.id.image08);
                image[0][9] = findViewById(R.id.image09);
                image[0][10] = findViewById(R.id.image010);

                image[1][0] = findViewById(R.id.image10);
                image[1][1] = findViewById(R.id.image11);
                image[1][2] = findViewById(R.id.image12);
                image[1][3] = findViewById(R.id.image13);
                image[1][4] = findViewById(R.id.image14);
                image[1][5] = findViewById(R.id.image15);
                image[1][6] = findViewById(R.id.image16);
                image[1][7] = findViewById(R.id.image17);
                image[1][8] = findViewById(R.id.image18);
                image[1][9] = findViewById(R.id.image19);
                image[1][10] = findViewById(R.id.image110);

                image[2][0] = findViewById(R.id.image20);
                image[2][1] = findViewById(R.id.image21);
                image[2][2] = findViewById(R.id.image22);
                image[2][3] = findViewById(R.id.image23);
                image[2][4] = findViewById(R.id.image24);
                image[2][5] = findViewById(R.id.image25);
                image[2][6] = findViewById(R.id.image26);
                image[2][7] = findViewById(R.id.image27);
                image[2][8] = findViewById(R.id.image28);
                image[2][9] = findViewById(R.id.image29);
                image[2][10] = findViewById(R.id.image210);

                image[3][0] = findViewById(R.id.image30);
                image[3][1] = findViewById(R.id.image31);
                image[3][2] = findViewById(R.id.image32);
                image[3][3] = findViewById(R.id.image33);
                image[3][4] = findViewById(R.id.image34);
                image[3][5] = findViewById(R.id.image35);
                image[3][6] = findViewById(R.id.image36);
                image[3][7] = findViewById(R.id.image37);
                image[3][8] = findViewById(R.id.image38);
                image[3][9] = findViewById(R.id.image39);
                image[3][10] = findViewById(R.id.image310);

                image[4][0] = findViewById(R.id.image40);
                image[4][1] = findViewById(R.id.image41);
                image[4][2] = findViewById(R.id.image42);
                image[4][3] = findViewById(R.id.image43);
                image[4][4] = findViewById(R.id.image44);
                image[4][5] = findViewById(R.id.image45);
                image[4][6] = findViewById(R.id.image46);
                image[4][7] = findViewById(R.id.image47);
                image[4][8] = findViewById(R.id.image48);
                image[4][9] = findViewById(R.id.image49);
                image[4][10] = findViewById(R.id.image410);

                image[5][0] = findViewById(R.id.image50);
                image[5][1] = findViewById(R.id.image51);
                image[5][2] = findViewById(R.id.image52);
                image[5][3] = findViewById(R.id.image53);
                image[5][4] = findViewById(R.id.image54);
                image[5][5] = findViewById(R.id.image55);
                image[5][6] = findViewById(R.id.image56);
                image[5][7] = findViewById(R.id.image57);
                image[5][8] = findViewById(R.id.image58);
                image[5][9] = findViewById(R.id.image59);
                image[5][10] = findViewById(R.id.image510);

                image[6][0] = findViewById(R.id.image60);
                image[6][1] = findViewById(R.id.image61);
                image[6][2] = findViewById(R.id.image62);
                image[6][3] = findViewById(R.id.image63);
                image[6][4] = findViewById(R.id.image64);
                image[6][5] = findViewById(R.id.image65);
                image[6][6] = findViewById(R.id.image66);
                image[6][7] = findViewById(R.id.image67);
                image[6][8] = findViewById(R.id.image68);
                image[6][9] = findViewById(R.id.image69);
                image[6][10] = findViewById(R.id.image610);

                image[7][0] = findViewById(R.id.image70);
                image[7][1] = findViewById(R.id.image71);
                image[7][2] = findViewById(R.id.image72);
                image[7][3] = findViewById(R.id.image73);
                image[7][4] = findViewById(R.id.image74);
                image[7][5] = findViewById(R.id.image75);
                image[7][6] = findViewById(R.id.image76);
                image[7][7] = findViewById(R.id.image77);
                image[7][8] = findViewById(R.id.image78);
                image[7][9] = findViewById(R.id.image79);
                image[7][10] = findViewById(R.id.image710);

                scoreText = findViewById(R.id.editText2);
            }
        });


    }
    public void onClickDown(android.view.View input) {
        if (current == null) {
            current = new Blocks();
            current.createAllBlocks();
            display();
            return;

        }
        if (current.currentBlocks == null
                || current.currentBlocks.size() == 0
                || current.currentBlocks.get(current.currentBlocks.size() - 1).Stopped()) {
            current.createAllBlocks();
            display();
            return;

        }
        current.cancleLines();
        display();


    }
    Blocks current;

    public void createBlocks() {
        current = new Blocks();
    }
    public void display() {
        if (current == null) {
            return;

        }
        current.upDateBoard();
        for(int i = 0; i < current.board.length; i++) {
            for (int j = 0; j < current.board[i].length; j++) {
                if (current.board[i][j] != null) {
                    image[i][j].setImageResource(R.drawable.solid_black);

                } else {
                    image[i][j].setImageResource(R.drawable.solid_white);

                }

            }

        }
        scoreText.setText(ID + " your score:" + Blocks.score.toString());

    }

    public void atuoTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (current == null) {
                    current = new Blocks();
                    current.createAllBlocks();
                    display();
                    return;

                }
                if (current.currentBlocks == null
                        || current.currentBlocks.size() == 0
                        || current.currentBlocks.get(current.currentBlocks.size() - 1).Stopped()) {
                    current.createAllBlocks();
                    display();
                    return;

                }
                current.cancleLines();
                display();

            }
        }, 1000, 1000);

    }

}

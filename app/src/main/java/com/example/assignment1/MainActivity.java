package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mHinting;
    private TextView mGuessedNumber;
    private int numberOfTries;
    public static int attempt = 0;
    public static final int maxAttempts = 5;
    private Button validate;

    //Generates a random number upon onCreate()
    int randNumber = (int) ((Math.random() * (100 - 1)) + 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHinting = findViewById(R.id.tvHinting);
        mGuessedNumber = findViewById(R.id.tnGuessedNumber);

        //triggering the Check Your Guess button
        validate = (Button) findViewById(R.id.btCheckGuess);
        validate.setOnClickListener(this);

        newGame();
    }

        //triggers a new game if 5/5 attempts are reached otherwise continue

            public void onClick(View v) {
        attempt++;

        if(attempt == maxAttempts){
            openDetailActivity();
            newGame();

            }
        else if (v == validate){
            launchCheckNumber();
        }

    }

    //Method for the Check Your Guess Button
    private void launchCheckNumber() {

        //Reads user input
        int userGuess = Integer.parseInt(mGuessedNumber.getText().toString());

        //Cases
        for (numberOfTries = 1; numberOfTries < 6; numberOfTries++) {
            numberOfTries++;

            //Conditions to indicate hints
            if (randNumber < userGuess && numberOfTries <6) {
                mHinting.setText("Your guess was too high! Make another guess!");
                //numberOfTries++

            } if (randNumber > userGuess && numberOfTries<6){
                mHinting.setText("Your guess was too low! Make another guess!");
                //numberOfTries++

            } if (randNumber == userGuess && numberOfTries<6) {
                openDetailActivity2();
            }
        }
    }
    //Method to trigger a new game
        private void newGame () {
            int randNumber = (int) ((Math.random() * (100 - 1)) + 1);
            numberOfTries = 0;
            mGuessedNumber.setText("");

        }

        public void openDetailActivity(){
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
        }

        public void openDetailActivity2(){
        Intent intent = new Intent (this, DetailActivity2.class);
        startActivity(intent);
        }
    }





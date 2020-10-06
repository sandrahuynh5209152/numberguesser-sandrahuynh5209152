package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mHinting;
    private TextView mGuessedNumber;
    private int numberOfTries;

    //Generates a random number upon onCreate()
    int randNumber = (int) ((Math.random() * (100 - 1)) + 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHinting = findViewById(R.id.tvHinting);
        mGuessedNumber = findViewById(R.id.tnGuessedNumber);

        //triggering the Check Your Guess button
        Button button = findViewById(R.id.btCheckGuess);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.this.launchCheckNumber();
            }
        });
    }

    //Method for the Check Your Guess Button
    private void launchCheckNumber() {

        //Reads user input
        EditText inputtedNumber = (EditText) findViewById(R.id.tnGuessedNumber);
        String guessedNumber = inputtedNumber.getText().toString();
        int userGuess = Integer.parseInt(guessedNumber);

        //An attempt at creating a limit of 5 guesses - unsuccessful
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
                mHinting.setText("Congratulations!");
            }
        }
    }
    //if the loop had worked, this would be the method to trigger a new game
        private void newGame () {
            int randNumber = (int) ((Math.random() * (100 - 1)) + 1);
            mHinting.setText("New game!");
            numberOfTries = 0;
            mGuessedNumber.setText("");

        }
    }





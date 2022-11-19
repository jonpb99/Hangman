package com.example.hangman4android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int z = 0;
    String guess = "-";
    String answer = "";
    int numGuesses = 7;
    boolean gameover = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        z = chosenWord();
        answer = wordbank.words[z].toUpperCase();
        for(int i = 1; i < answer.length(); i++) {
            guess = guess.concat("-");
        }
        TextView txtEmail = findViewById(R.id.txtMessageEmail);
        android.widget.EditText edtTxtEmail = findViewById(R.id.edtTxtEmail);
        txtEmail.setText(guess);
    }

    public void onBtnClick(android.view.View view){
        /*TextView txtFirst = findViewById(R.id.txtMessageFirst);
        android.widget.EditText edtTxtFirst = findViewById(R.id.edtTxtFirst);
        txtFirst.setText("First Name: " + edtTxtFirst.getText().toString());

        TextView txtLast = findViewById(R.id.txtMessageLast);
        android.widget.EditText edtTxtLast = findViewById(R.id.edtTxtLast);
        txtLast.setText("Last Name: " + edtTxtLast.getText().toString());*/

        TextView txtEmail = findViewById(R.id.txtMessageEmail);
        android.widget.EditText edtTxtEmail = findViewById(R.id.edtTxtEmail);

        char temp;
        String guesstemp = "";
        boolean subtractNumGuess = true;
        char y = edtTxtEmail.getText().toString().toUpperCase().charAt(0);
        int trap = answer.indexOf(y); //trap checks to see if input is correct
        if(trap != -1 && gameover == false){
            subtractNumGuess = false;
            for(int j = 0; j < answer.length(); j++){
                if(guess.charAt(j) != '-'){
                    temp = guess.charAt(j);
                    guesstemp = guesstemp.concat(String.valueOf(temp));
                }
                else if(answer.charAt(j) == y){
                    guesstemp = guesstemp.concat(String.valueOf(y));
                }
                else{
                    guesstemp = guesstemp.concat("-");
                }
            }
            guess = guesstemp;
            txtEmail.setText("Answer: " + guess);
        }

        TextView num_Left = findViewById(R.id.numLeft);
        //android.widget.EditText edtnum_Left = findViewById(R.id.edtnum_Left);

        if(subtractNumGuess){
            if(numGuesses != 0){
                numGuesses--;
                //num_Left.setText(numGuesses + " Guesses Left");
            }
        }

        if(numGuesses == 0){
            num_Left.setText("Game Over, Answer was " + answer);
            gameover = true;
        }
        else if(guess.indexOf("-") == -1){
            num_Left.setText("You Win!");
            gameover = true;
        }
        else{
            num_Left.setText(numGuesses + " Guesses Left");
        }

    }
    public static int chosenWord(){
        int randomNum = (int)(Math.random() * 2466);
        String randomWord = wordbank.words[randomNum];
        while(randomWord.contains("-") || randomWord.contains(" ")){
            randomNum = (int)(Math.random() * 2466);
            randomWord = wordbank.words[randomNum];
        }
        return randomNum;
    }
}

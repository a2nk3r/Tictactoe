package com.example.tic_tac_toe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button button[] = new Button[10];
    TextView nextView, winnerView;
    boolean turn = false;
    boolean won = false;
    String squares[] = new String[9];
    int winningSquares[];// = new int[3];
    String winner = null;

    void applyGameLogic(int i){
        if(won || squares[i] != null) return;
        button[i].setText((turn ? "O" : "X"));
        button[i].setTextColor(Color.parseColor(turn ? "#009900" : "#0000CC"));
        squares[i] = turn ? "O" : "X";
        turn = !turn;
        nextView.setText("Next Move: " + (turn ? "O" : "X"));
        winner = calculateWinner(squares);
        if(winner == null) winner = " ";
        else won = true;
        winnerView.setText("Winner: " + winner);
        if(won){
            button[winningSquares[0]].setTextColor(Color.parseColor("#FF0000"));
            button[winningSquares[1]].setTextColor(Color.parseColor("#FF0000"));
            button[winningSquares[2]].setTextColor(Color.parseColor("#FF0000"));
        }
    }
    void resetGame(){
        squares = new String[9];
        for(int i = 0;i < 9;i++)
            button[i].setText(null);
        turn = false;
        won = false;
        winner = null;
        nextView.setText("Next Move: ");
        winnerView.setText("Winner: ");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button[0] = (Button) findViewById(R.id.button);
        button[1] = (Button) findViewById(R.id.button2);
        button[2] = (Button) findViewById(R.id.button3);
        button[3] = (Button) findViewById(R.id.button4);
        button[4] = (Button) findViewById(R.id.button5);
        button[5] = (Button) findViewById(R.id.button6);
        button[6] = (Button) findViewById(R.id.button7);
        button[7] = (Button) findViewById(R.id.button8);
        button[8] = (Button) findViewById(R.id.button9);
        button[9] = (Button) findViewById(R.id.resetBtn);

        nextView = (TextView) findViewById(R.id.nextView);
        winnerView = (TextView) findViewById(R.id.winnerView);



        button[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyGameLogic(0);
            }
        });
        button[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyGameLogic(1);
            }
        });
        button[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyGameLogic(2);
            }
        });
        button[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyGameLogic(3);
            }
        });
        button[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyGameLogic(4);
            }
        });
        button[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyGameLogic(5);
            }
        });
        button[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyGameLogic(6);
            }
        });
        button[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyGameLogic(7);
            }
        });
        button[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyGameLogic(8);
            }
        });


        button[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

    }

    String calculateWinner(String squares[]){
        int wins[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        for(int i = 0;i < wins.length;i++){
            int arr[] = wins[i];
            if(squares[arr[0]] != null && squares[arr[0]].equals(squares[arr[1]]) && squares[arr[0]].equals(squares[arr[2]])){
                winningSquares = arr;
                return squares[arr[0]];
            }
        }
        return null;
    }
}

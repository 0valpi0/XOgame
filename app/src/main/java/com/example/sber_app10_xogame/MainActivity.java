package com.example.sber_app10_xogame;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View cell1;
    private View cell2;
    private View cell3;
    private View cell4;
    private View cell5;
    private View cell6;
    private View cell7;
    private View cell8;
    private View cell9;

    private int counter = 0;
    private int x_counter = 0;
    private int o_counter = 0;

    private TextView cross_number;
    private TextView circle_number;

    private TicTacToeField mField = new TicTacToeField(3);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cell1 = findViewById(R.id.cell1);
        cell2 = findViewById(R.id.cell2);
        cell3 = findViewById(R.id.cell3);
        cell4 = findViewById(R.id.cell4);
        cell5 = findViewById(R.id.cell5);
        cell6 = findViewById(R.id.cell6);
        cell7 = findViewById(R.id.cell7);
        cell8 = findViewById(R.id.cell8);
        cell9 = findViewById(R.id.cell9);

        cell1.setTag("0");
        cell2.setTag("1");
        cell3.setTag("2");
        cell4.setTag("3");
        cell5.setTag("4");
        cell6.setTag("5");
        cell7.setTag("6");
        cell8.setTag("7");
        cell9.setTag("8");

        cross_number = findViewById(R.id.cross_num);
        circle_number = findViewById(R.id.circle_num);

        handleClick(cell1);
        handleClick(cell2);
        handleClick(cell3);
        handleClick(cell4);
        handleClick(cell5);
        handleClick(cell6);
        handleClick(cell7);
        handleClick(cell8);
        handleClick(cell9);
    }

    private void handleClick(View view) {
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(view.getTag().toString());
                int row = id / 3;
                int col = id % 3;
                if (mField.isEmptyCell(row, col)) {
                    if (counter % 2 == 0) {
                        view.setBackgroundResource(R.drawable.border_cross);
                        mField.setFigure(row, col, TicTacToeField.Figure.CROSS);
                    }
                    else  {
                        view.setBackgroundResource(R.drawable.border_circle);
                        mField.setFigure(row, col, TicTacToeField.Figure.CIRCLE);
                    }

                    counter++;
                }

                getFieldWinner();
            }
        });
    }

    private void getFieldWinner() {
        if (mField.getWinner() == TicTacToeField.Figure.CROSS) {
                x_counter++;
                clearAllCells();
                AlertDialogFragment fragment = AlertDialogFragment.newInstance("Крестики победили");
                getSupportFragmentManager()
                    .beginTransaction()
                    .add(fragment, null)
                    .commitAllowingStateLoss();
        }
        else if (mField.getWinner() == TicTacToeField.Figure.CIRCLE) {
                o_counter++;
                clearAllCells();
                AlertDialogFragment fragment = AlertDialogFragment.newInstance("Кружочки победили");
                getSupportFragmentManager()
                    .beginTransaction()
                    .add(fragment, null)
                    .commitAllowingStateLoss();
        }

        cross_number.setText(String.valueOf(x_counter));
        circle_number.setText(String.valueOf(o_counter));
    }

    private void clearAllCells () {
        cell1.setBackgroundResource(R.drawable.rectangle);
        cell2.setBackgroundResource(R.drawable.rectangle);
        cell3.setBackgroundResource(R.drawable.rectangle);
        cell4.setBackgroundResource(R.drawable.rectangle);
        cell5.setBackgroundResource(R.drawable.rectangle);
        cell6.setBackgroundResource(R.drawable.rectangle);
        cell7.setBackgroundResource(R.drawable.rectangle);
        cell8.setBackgroundResource(R.drawable.rectangle);
        cell9.setBackgroundResource(R.drawable.rectangle);
        mField.clear();
    }
}

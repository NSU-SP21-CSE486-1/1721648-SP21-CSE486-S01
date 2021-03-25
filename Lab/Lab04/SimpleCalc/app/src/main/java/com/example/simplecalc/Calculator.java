package com.example.simplecalc;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.text.BreakIterator;

import static android.provider.Settings.System.getString;

public class Calculator {

    private static Object NullPointerException;
    private static final String TAG =NullPointerException ;

    public enum Operator {ADD, SUB, DIV, MUL;
        public static double Div;
    }

    /**
     * Addition operation
     */
    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    /**
     * Subtract operation
     */
    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    /**
     * Divide operation
     */
    public double div(double firstOperand, double secondOperand) {
        if (secondOperand == 0 ) {
            throw new IllegalArgumentException();

        }
        return firstOperand / secondOperand;
    }

    /**
     * Multiply operation
     */
    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }
    public void onDiv(View view, BreakIterator mResultTextView){
        try{
            compute(Operator.Div);
        }
        catch(IllegalArgumentException iae)
        {
            Log log;
            log.e(TAG,"IllegalArgumentException",iae);
            mResultTextView.setText(getString(R.string.computationError));
            Toast toast=Toast.makeText(this,R.string.toastMessage,toast.LENGTH_SHORT);
            toast.show();

        }
    }

    private void compute(double div) {
    }

}

package com.ithai.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Result;

import static android.view.View.OnClickListener;

public class MainActivity extends ActionBarActivity implements OnClickListener {
    private TextView Scr; //textbox screen
    private float NumberBF; //Save screen before pressing button operation;
    private String Operations;
    private ButtonClickListener buttonClick;

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {

        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scr = (TextView) findViewById(R.id.textView);
        buttonClick = new ButtonClickListener();

        int IDList[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9, R.id.buttonDecimal, R.id.buttonEquals, R.id.buttonAdd, R.id.buttonMinus, R.id.buttonMultiply,
                R.id.buttonDivide, R.id.buttonClear};

        for (int id:IDList){
            View Background = (View) findViewById(id);
            Background.setOnClickListener(buttonClick);


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void MathSign(String str) {
        NumberBF = Float.parseFloat(Scr.getText().toString()); //This is for saving the screen
        Operations = str; ///Saving operations
        Scr.setText("0"); //To clear display
    }

    public void getKeyboard (String str) {
        String CurrentScreen = Scr.getText().toString();
        if (CurrentScreen.equals("0"))
            CurrentScreen = "";
        CurrentScreen += str;
        Scr.setText(CurrentScreen);
    }

    public void MathResult () {
        float NumberAF = Float.parseFloat(Scr.getText().toString());
        float Results = 0;

        if (Operations.equals("+")) {
            Results = NumberBF + NumberAF;
        }
        if (Operations.equals("-")) {
            Results = NumberBF - NumberAF;
        }
        if (Operations.equals("*")) {
            Results = NumberBF * NumberAF;
        }
        if (Operations.equals("/")) {
            Results = NumberBF / NumberAF;
        }

        Scr.setText(String.valueOf(Results));


    }

    //We make a news class for ButtonClickListener

        private class ButtonClickListener implements View.OnClickListener {
            public void onClick(View Background) {
                switch (Background.getId()){
                    case  R.id.buttonClear: //This is for Clearing the screen
                        Scr.setText("0");
                        NumberBF = 0;
                        Operations = "";
                        break;
                    case R.id.buttonAdd: //This is for Addition
                        MathSign("+");
                        break;

                    case R.id.buttonMinus: //This is for Subtraction
                        MathSign("-");
                        break;

                    case R.id.buttonMultiply: //This is for Multiplication
                        MathSign("*");
                        break;

                    case R.id.buttonDivide: //This is for Division
                        MathSign("/");
                        break;

                    case R.id.buttonEquals: //This is for Equals sign
                        MathResult();
                        break;

                    default:
                        String Number = ((Button) Background).getText().toString();
                        getKeyboard (Number);
                        break;

                }
            }
        }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


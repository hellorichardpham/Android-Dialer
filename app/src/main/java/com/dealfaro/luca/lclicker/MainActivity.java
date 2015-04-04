package com.dealfaro.luca.lclicker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //The same function clickButton can be used for all buttons except DEL and CALL.
    // The function gets the string labeling the button, so it will get
    // the appropriate string for each button pressed.
    // Simply use android:onClick="clickButton" for all such buttons in activity_main.xml .
    // Note that for DEL and CALL, you will instead need to write two separate functions,
    // which you can call for instance clickDel and clickCall

    public void clickButton(View v) {
        final int MAX_TEXT_LENGTH = 12;
        Button b = (Button) v;
        String t = b.getText().toString();
        //textView is the dev-given name of the textbox where the number goes.
        TextView tv = (TextView) findViewById(R.id.textView);
        int currentNumDigits = tv.getText().length();
        if(currentNumDigits < MAX_TEXT_LENGTH) {
            tv.append(t);
        }
    }

    public void clickDelete(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        try {
            String newText = tv.getText().toString();
            newText = newText.substring(0, newText.length() - 1);
            tv.setText(newText);
        } catch (Exception e) {
            //Do nothing. Exception is that the textfield is already empty
        }
    }

    public void clickCall(View v) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("");
    }

    public boolean isInteger(String s) {
        try {
            int num = Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

package com.wova.home;

import com.wova.home.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import android.widget.TextView.OnEditorActionListener;

public class Calcwatts extends Activity implements OnKeyListener {

    boolean ampssSelected = false;
    boolean voltsSelected = false;
    boolean ohmsSelected = false;
    double ampsInput;
    double voltsInput;
    double ohmsInput;
    double theAnswer;
    double finalAnswer;
    int boxesShown;
    RelativeLayout mainview;
    RelativeLayout buttonrelativeview;
    TextView textviewamps;
    TextView textviewvolts;
    TextView textviewohms;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    ImageView wattsImage;
    ImageView ampsImage;
    ImageView voltsImage;
    ImageView ohmsImage;
    ViewSwitcher viewSwitch;
    ViewSwitcher viewSwitch2;
    ViewSwitcher viewSwitch3;
    ViewSwitcher ViewSwitche4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcwatts);
        textviewamps = (TextView) findViewById(R.id.editTextAmps);
        textviewvolts = (TextView) findViewById(R.id.editTextVolts);
        textviewohms = (TextView) findViewById(R.id.editTextOhmsAnswer);
        wattsImage = (ImageView) findViewById(R.id.GreyWatts);
        ampsImage = (ImageView) findViewById(R.id.imageView_Watts_Amps);
        voltsImage = (ImageView) findViewById(R.id.imageView_Watts_Volts);
        ohmsImage = (ImageView) findViewById(R.id.imageView_Watts_Ohms);
        viewSwitch = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Volts);
        viewSwitch2 = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Amps);
        viewSwitch3 = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Grey);
        ViewSwitche4 = (ViewSwitcher) findViewById(R.id.viewSwitch_Ohms);
        button1 = (Button) findViewById(R.id.Watts_Amps_Button);
        button3 = (Button) findViewById(R.id.Watts_Volts_Button);
        button4 = (Button) findViewById(R.id.button4);
        textviewamps.setOnKeyListener(this);
        textviewvolts.setOnKeyListener(this);
        textviewohms.setOnKeyListener(this);
        mainview = (RelativeLayout) findViewById(R.id.mainViewWatts);
        buttonrelativeview = (RelativeLayout) findViewById(R.id.buttonRelativeViewwatss);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calcwatts, menu);
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        SetButtonDimensions(mainview);
    }

    public void buttonHit(View v) {
        if (v.getId() == R.id.Watts_Amps_Button) {
            ampssSelected = true;
            textviewamps.setVisibility(1);
            textviewamps.setFocusableInTouchMode(true);
            textviewamps.requestFocus();

            if (textviewamps.requestFocus()) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(textviewamps, InputMethodManager.SHOW_IMPLICIT);
            }
            //if they hit a a pie slice count it then if they go over 2 pie slices reset the whole thing
            boxesShown += 1;
        }
        if (v.getId() == R.id.Watts_Volts_Button) {
            voltsSelected = true;
            textviewvolts.setVisibility(1);
            textviewvolts.setFocusableInTouchMode(true);
            textviewvolts.requestFocus();

            if (textviewvolts.requestFocus()) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(textviewvolts, InputMethodManager.SHOW_IMPLICIT);
            }
            boxesShown += 1;
        }
        if (v.getId() == R.id.button4) {
            ohmsSelected = true;
            textviewohms.setVisibility(1);
            textviewohms.setFocusableInTouchMode(true);
            textviewohms.requestFocus();

            if (textviewohms.requestFocus()) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(textviewohms, InputMethodManager.SHOW_IMPLICIT);
            }
            boxesShown += 1;
        }
        if (boxesShown > 2 ||
                (boxesShown > 1 && ampssSelected == true && voltsSelected == false && ohmsSelected == false)
                || (boxesShown > 1 && ampssSelected == false && voltsSelected == true && ohmsSelected == false)
                || (boxesShown > 1 && ampssSelected == false && voltsSelected == false && ohmsSelected == true)) {

            textviewamps.setVisibility(v.INVISIBLE);
            textviewamps.clearFocus();
            textviewvolts.setVisibility(v.INVISIBLE);
            textviewvolts.clearFocus();
            textviewohms.setVisibility(v.INVISIBLE);
            textviewohms.clearFocus();

            if (ampssSelected == true && voltsSelected == true) {
                ViewSwitche4.showNext();
            }
            if (ampssSelected == true && ohmsSelected == true) {
                viewSwitch.showNext();
            }
            if (voltsSelected == true && ohmsSelected == true) {
                viewSwitch2.showNext();
            }

            ampssSelected = false;
            voltsSelected = false;
            ohmsSelected = false;
            button1.setClickable(true);
            button3.setClickable(true);
            button4.setClickable(true);
            ampsInput = 0;
            voltsInput = 0;
            ohmsInput = 0;
            textviewamps.setText("");
            textviewvolts.setText("");
            textviewohms.setText("");

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            boxesShown = 0;
        }
        if (ampssSelected == true && voltsSelected == true) {
            ViewSwitche4.showNext();
            button4.setClickable(false);
        }
        if (ampssSelected == true && ohmsSelected == true) {
            viewSwitch.showNext();
            button3.setClickable(false);
        }
        if (voltsSelected == true && ohmsSelected == true) {
            viewSwitch2.showNext();
            button1.setClickable(false);
        }
    }

    @Override
    public boolean onKey(View v, int arg1, KeyEvent arg2) {
        switch (arg1) {
            case KeyEvent.KEYCODE_ENTER:
                if (ampssSelected == true) {
                    if (textviewamps.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "please enter a value for watts ", Toast.LENGTH_SHORT).show();
                    } else {
                        ampsInput = Double.parseDouble(textviewamps.getText().toString());
                    }
                }
                if (voltsSelected == true) {
                    if (textviewvolts.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "please enter a value for volts ", Toast.LENGTH_SHORT).show();
                    } else {
                        voltsInput = Double.parseDouble(textviewvolts.getText().toString());
                    }
                }
                if (ohmsSelected == true) {
                    if (textviewohms.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "please enter a value for ohms ", Toast.LENGTH_SHORT).show();
                    } else {
                        ohmsInput = Double.parseDouble(textviewohms.getText().toString());
                    }
                }

                //drop the keyboard
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                ///finally if two buttons are selected and both boxes are not null; then Calculate it !!!
                if (textviewamps.getText().toString().equals("") == false && textviewvolts.getText().toString().equals("") == false) {
                    //formula is I * E
                    theAnswer = ampsInput * voltsInput;
                    calculateIt(theAnswer);
                }
                if (textviewamps.getText().toString().equals("") == false && textviewohms.getText().toString().equals("") == false) {
                    theAnswer = (ampsInput * ampsInput) * ohmsInput;
                    calculateIt(theAnswer);
                }
                if (textviewvolts.getText().toString().equals("") == false && textviewohms.getText().toString().equals("") == false) {
                    theAnswer = (voltsInput * voltsInput) / ohmsInput;
                    calculateIt(theAnswer);
                }
                return true;
        }
        return false;
    }

    private void calculateIt(double theAnswer2) {
        Intent theanswer = new Intent(this, TheAnswerWatts.class);
        theanswer.putExtra("FinalAnswer", theAnswer2);
        startActivity(theanswer);
    }

    @SuppressLint("NewApi")
    public void SetButtonDimensions(View rootView) {

        int rootWidth = (int) rootView.getWidth();
        int rootHeight = (int) rootView.getHeight();
        int topMargin;
        int leftMargin;

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(rootWidth, rootHeight);
        topMargin = (int) (buttonrelativeview.getHeight() * .21);
        viewSwitch3.setLayoutParams(lp);
        viewSwitch2.setLayoutParams(lp);
        viewSwitch.setLayoutParams(lp);
        ViewSwitche4.setLayoutParams(lp);

        RelativeLayout.LayoutParams lpButton1 = new RelativeLayout.LayoutParams((buttonrelativeview.getWidth() / 2), (int) (buttonrelativeview.getHeight() * .25));
        topMargin = (int) (buttonrelativeview.getHeight() * .25);
        leftMargin = (int) (buttonrelativeview.getWidth() * .5);
        lpButton1.setMargins(leftMargin, topMargin, 0, 0);
        button1.setLayoutParams(lpButton1);

        RelativeLayout.LayoutParams lpButton3 = new RelativeLayout.LayoutParams((buttonrelativeview.getWidth() / 2), (int) (buttonrelativeview.getHeight() * .25));
        topMargin = (int) (buttonrelativeview.getHeight() * .5);
        lpButton3.setMargins(0, topMargin, 0, 0);
        button3.setLayoutParams(lpButton3);

        RelativeLayout.LayoutParams lpButton4 = new RelativeLayout.LayoutParams((buttonrelativeview.getWidth() / 2), (int) (buttonrelativeview.getHeight() * .25));
        topMargin = (int) (buttonrelativeview.getHeight() * .5);
        leftMargin = (int) (buttonrelativeview.getWidth() * .5);
        lpButton4.setMargins(leftMargin, topMargin, 0, 0);
        button4.setLayoutParams(lpButton4);

        RelativeLayout.LayoutParams textBoxLP1 = new RelativeLayout.LayoutParams((int) (buttonrelativeview.getWidth() * .25), RelativeLayout.LayoutParams.WRAP_CONTENT);
        topMargin = (int) ((buttonrelativeview.getHeight() * .4));
        leftMargin = (int) (buttonrelativeview.getWidth() * .6);
        textBoxLP1.setMargins(leftMargin, topMargin, 0, 0);
        textviewamps.setLayoutParams(textBoxLP1);

        RelativeLayout.LayoutParams textBoxLP2 = new RelativeLayout.LayoutParams((int) (buttonrelativeview.getWidth() * .25), RelativeLayout.LayoutParams.WRAP_CONTENT);
        topMargin = (int) ((buttonrelativeview.getHeight() * .55));
        leftMargin = (int) (buttonrelativeview.getWidth() * .20);
        textBoxLP2.setMargins(leftMargin, topMargin, 0, 0);
        textviewvolts.setLayoutParams(textBoxLP2);

        RelativeLayout.LayoutParams textBoxLP3 = new RelativeLayout.LayoutParams((int) (buttonrelativeview.getWidth() * .25), RelativeLayout.LayoutParams.WRAP_CONTENT);
        topMargin = (int) ((buttonrelativeview.getHeight() * .55));
        leftMargin = (int) (buttonrelativeview.getWidth() * .6);
        textBoxLP3.setMargins(leftMargin, topMargin, 0, 0);
        textviewohms.setLayoutParams(textBoxLP3);
    }
}
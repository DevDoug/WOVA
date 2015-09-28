package com.wova.home;

import com.wova.home.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class Calcvolts extends Activity implements OnKeyListener {

    boolean wattsSelected = false;
    boolean ampsSelected = false;
    boolean ohmsSelected = false;
    double wattsInput;
    double ampsInput;
    double ohmsInput;
    double theAnswer = 0;
    int boxesShown;
    TextView textviewwatts;
    TextView textviewamps;
    TextView textviewohms;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    ImageView wattsImage;
    ImageView ampsImage;
    ImageView ohmsImage;
    ViewSwitcher viewSwitch;
    ViewSwitcher viewSwitch2;
    ViewSwitcher viewSwitch3;
    ViewSwitcher ViewSwitche4;
    RelativeLayout mainview;
    RelativeLayout buttonrelativeview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcvolts);
        textviewwatts = (TextView) findViewById(R.id.editTextWatts);
        textviewamps = (TextView) findViewById(R.id.editTextAmps);
        textviewohms = (TextView) findViewById(R.id.editTextOhmsAnswer);
        wattsImage = (ImageView) findViewById(R.id.imageViewWattsMain);
        ampsImage = (ImageView) findViewById(R.id.imageView_Watts_Volts);
        ohmsImage = (ImageView) findViewById(R.id.imageView_Watts_Ohms);
        viewSwitch = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Volts);
        viewSwitch2 = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Amps);
        viewSwitch3 = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Grey);
        ViewSwitche4 = (ViewSwitcher) findViewById(R.id.viewSwitch_Ohms);
        button1 = (Button) findViewById(R.id.Watts_Amps_Button);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        textviewamps.setOnKeyListener(this);
        textviewwatts.setOnKeyListener(this);
        textviewohms.setOnKeyListener(this);
        mainview = (RelativeLayout) findViewById(R.id.VoltsMainView);
        buttonrelativeview = (RelativeLayout) findViewById(R.id.VoltsRelativeButtonLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calcvolts, menu);
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        SetButtonDimensions(mainview);
    }

    public void buttonHit(View v) {
        if (v.getId() == R.id.button3) {
            wattsSelected = true;
            textviewwatts.setVisibility(1);
            textviewwatts.setFocusableInTouchMode(true);
            textviewwatts.requestFocus();
            if (textviewwatts.requestFocus()) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(textviewwatts, InputMethodManager.SHOW_IMPLICIT);
            }
            //if they hit a a pie slice count it then if they go over 2 pie slices reset the whole thing
            boxesShown += 1;
        }
        if (v.getId() == R.id.Watts_Amps_Button) {
            ampsSelected = true;
            textviewamps.setVisibility(1);
            textviewamps.setFocusableInTouchMode(true);
            textviewamps.requestFocus();
            if (textviewamps.requestFocus()) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(textviewamps, InputMethodManager.SHOW_IMPLICIT);
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
                (boxesShown > 1 && wattsSelected == true && ampsSelected == false && ohmsSelected == false)
                || (boxesShown > 1 && wattsSelected == false && ampsSelected == true && ohmsSelected == false)
                || (boxesShown > 1 && wattsSelected == false && ampsSelected == false && ohmsSelected == true)) {

            textviewwatts.setVisibility(v.INVISIBLE);
            textviewwatts.clearFocus();
            textviewamps.setVisibility(v.INVISIBLE);
            textviewamps.clearFocus();
            textviewohms.setVisibility(v.INVISIBLE);
            textviewohms.clearFocus();
            if (wattsSelected == true && ampsSelected == true) {
                ViewSwitche4.showNext();
            }
            if (wattsSelected == true && ohmsSelected == true) {
                viewSwitch2.showNext();
            }

            if (ampsSelected == true && ohmsSelected == true) {
                viewSwitch3.showNext();
            }

            wattsSelected = false;
            ampsSelected = false;
            ohmsSelected = false;
            button1.setClickable(true);
            button3.setClickable(true);
            button4.setClickable(true);
            wattsInput = 0;
            ampsInput = 0;
            ohmsInput = 0;
            textviewwatts.setText("");
            textviewamps.setText("");
            textviewohms.setText("");
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            boxesShown = 0;
        }


        if (wattsSelected == true && ampsSelected == true) {
            ViewSwitche4.showNext();
            button4.setClickable(false);
        }


        if (wattsSelected == true && ohmsSelected == true) {
            viewSwitch2.showNext();
            button1.setClickable(false);
        }


        if (ampsSelected == true && ohmsSelected == true) {
            viewSwitch3.showNext();
            button3.setClickable(false);
        }
    }

    @Override
    public boolean onKey(View v, int arg1, KeyEvent arg2) {
        switch (arg1) {
            case KeyEvent.KEYCODE_ENTER:
                if (wattsSelected == true) {
                    if (textviewwatts.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "please enter a value for watts ", Toast.LENGTH_SHORT).show();
                    } else {
                        wattsInput = Double.parseDouble(textviewwatts.getText().toString());
                    }
                }
                if (ampsSelected == true) {
                    if (textviewamps.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "please enter a value for amps ", Toast.LENGTH_SHORT).show();
                    } else {
                        ampsInput = Double.parseDouble(textviewamps.getText().toString());
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
                if (textviewwatts.getText().toString().equals("") == false && textviewamps.getText().toString().equals("") == false) {
                    theAnswer = wattsInput / ampsInput;
                    calculateIt(theAnswer);
                }
                if (textviewwatts.getText().toString().equals("") == false && textviewohms.getText().toString().equals("") == false) {
                    theAnswer = Math.sqrt(wattsInput * ohmsInput);
                    calculateIt(theAnswer);
                }
                if (textviewamps.getText().toString().equals("") == false && textviewohms.getText().toString().equals("") == false) {
                    theAnswer = ampsInput * ohmsInput;
                    calculateIt(theAnswer);
                }
                return true;
        }
        return false;
    }

    private void calculateIt(double theAnswer2) {
        Intent theanswer = new Intent(this, TheAnswerVolts.class);
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

        RelativeLayout.LayoutParams lpButton3 = new RelativeLayout.LayoutParams((buttonrelativeview.getWidth() / 2), (int) (buttonrelativeview.getHeight() * .25));
        topMargin = (int) (buttonrelativeview.getHeight() * .25);
        lpButton3.setMargins(0, topMargin, 0, 0);
        button3.setLayoutParams(lpButton3);

        RelativeLayout.LayoutParams lpButton1 = new RelativeLayout.LayoutParams((buttonrelativeview.getWidth() / 2), (int) (buttonrelativeview.getHeight() * .25));
        topMargin = (int) (buttonrelativeview.getHeight() * .25);
        leftMargin = (int) (buttonrelativeview.getWidth() * .5);
        lpButton1.setMargins(leftMargin, topMargin, 0, 0);
        button1.setLayoutParams(lpButton1);


        RelativeLayout.LayoutParams lpButton4 = new RelativeLayout.LayoutParams((buttonrelativeview.getWidth() / 2), (int) (buttonrelativeview.getHeight() * .25));
        topMargin = (int) (buttonrelativeview.getHeight() * .5);
        leftMargin = (int) (buttonrelativeview.getWidth() * .5);
        lpButton4.setMargins(leftMargin, topMargin, 0, 0);
        button4.setLayoutParams(lpButton4);

        RelativeLayout.LayoutParams textBoxLP1 = new RelativeLayout.LayoutParams((int) (buttonrelativeview.getWidth() * .25), RelativeLayout.LayoutParams.WRAP_CONTENT);
        topMargin = (int) ((buttonrelativeview.getHeight() * .4));
        leftMargin = (int) (buttonrelativeview.getWidth() * .20);
        textBoxLP1.setMargins(leftMargin, topMargin, 0, 0);
        textviewwatts.setLayoutParams(textBoxLP1);

        RelativeLayout.LayoutParams textBoxLP2 = new RelativeLayout.LayoutParams((int) (buttonrelativeview.getWidth() * .25), RelativeLayout.LayoutParams.WRAP_CONTENT);
        topMargin = (int) ((buttonrelativeview.getHeight() * .4));
        leftMargin = (int) (buttonrelativeview.getWidth() * .6);
        textBoxLP2.setMargins(leftMargin, topMargin, 0, 0);
        textviewamps.setLayoutParams(textBoxLP2);

        RelativeLayout.LayoutParams textBoxLP3 = new RelativeLayout.LayoutParams((int) (buttonrelativeview.getWidth() * .25), RelativeLayout.LayoutParams.WRAP_CONTENT);
        topMargin = (int) ((buttonrelativeview.getHeight() * .55));
        leftMargin = (int) (buttonrelativeview.getWidth() * .6);
        textBoxLP3.setMargins(leftMargin, topMargin, 0, 0);
        textviewohms.setLayoutParams(textBoxLP3);
    }
}
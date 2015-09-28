package com.wova.home;

import com.wova.home.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TheAnswerOhms extends Activity {

    double finalValue;
    EditText theanswertext;
    RelativeLayout mainview;
    ImageView OhmsAnswerImage;
    Button backtoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_answer_ohms);

        theanswertext = (EditText) findViewById(R.id.editTextOhmsAnswer);
        displayAnswer();
        mainview = (RelativeLayout) findViewById(R.id.ohmsAnswerMainView);
        OhmsAnswerImage = (ImageView) findViewById(R.id.imageViewOhmsAnswer);
        backtoMain = (Button) findViewById(R.id.Watts_Amps_Button);
    }

    private void displayAnswer() {
        Bundle extras = getIntent().getExtras();
        finalValue = extras.getDouble("FinalAnswer");
        String FinalValueString = String.format("%.2f", finalValue);
        theanswertext.setText(FinalValueString);
    }

    //if they hit the button start the whole app over
    public void returnButtonHit(View v) {
        Intent reset = new Intent(this, MainActivity.class);
        startActivity(reset);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.the_answer_ohms, menu);
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        SetButtonDimensions(mainview);
    }

    @SuppressLint("NewApi")
    public void SetButtonDimensions(View rootView) {
        int rootWidth = (int) rootView.getWidth();
        int rootHeight = (int) rootView.getHeight();
        int topMargin;
        int leftMargin;

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(rootWidth, rootHeight);
        topMargin = (int) (rootView.getHeight() * .21);
        OhmsAnswerImage.setLayoutParams(lp);

        RelativeLayout.LayoutParams lpButton1 = new RelativeLayout.LayoutParams((rootView.getWidth() / 2), (int) (rootView.getHeight() * .25));
        topMargin = (int) (rootView.getHeight() * .5);
        leftMargin = (int) (rootView.getWidth() * .5);
        lpButton1.setMargins(leftMargin, topMargin, 0, 0);
        backtoMain.setLayoutParams(lpButton1);

        RelativeLayout.LayoutParams textBoxLP1 = new RelativeLayout.LayoutParams((int) (rootView.getWidth() * .25), RelativeLayout.LayoutParams.WRAP_CONTENT);
        topMargin = (int) ((rootView.getHeight() * .4));
        leftMargin = (int) (rootView.getWidth() * .2);
        textBoxLP1.setMargins(leftMargin, topMargin, 0, 0);
        theanswertext.setLayoutParams(textBoxLP1);
    }
}
package com.wova.home;


import com.wova.home.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	

	RelativeLayout mainview;
	
	RelativeLayout buttonrelativeview;
	
	ImageView button1;
	
	ImageView button2;
	
	ImageView button3;
	
	ImageView button4;
	
	Button transparentButton1;
	
	Button transparentButton2;
	
	Button transparentButton3;
	
	Button transparentButton4;
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mainview = (RelativeLayout) findViewById(R.id.mainView);
		
		buttonrelativeview = (RelativeLayout) findViewById(R.id.buttonRelativeView);
		
		//set our image  buttons 
		
		button1 = (ImageView) findViewById(R.id.imageViewWattsMain);
		
		button2 = (ImageView) findViewById(R.id.imageView_Watts_Amps_Grey);
		
		button3 = (ImageView) findViewById(R.id.imageViewVoltsMain);
		
		button4 = (ImageView) findViewById(R.id.imageView_Watts_Ohms);
		
		
		
		
		//set our actual buttons 
		
		
		transparentButton1 = (Button) findViewById(R.id.Watts_Amps_Button);
		
		transparentButton2 = (Button) findViewById(R.id.button2);
		
		transparentButton3 = (Button) findViewById(R.id.button3);
		
		transparentButton4 = (Button) findViewById(R.id.button4);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		
		
	
		SetButtonDimensions(mainview);
		
	}

	public void buttonSelected(View v){
		
		if(v.getId() == R.id.Watts_Amps_Button){
			
			Intent loadcalcwatts = new Intent(this,Calcwatts.class);
			
			startActivity(loadcalcwatts);
			
		}
		
		
		
		if(v.getId() == R.id.button2){
			
			Intent loadcalcamps = new Intent(this,Calcamps.class);
			
			startActivity(loadcalcamps);
			
		}
		
		
		
		if(v.getId() == R.id.button3){
			
			Intent loadcalcvolts = new Intent(this,Calcvolts.class);
			
			startActivity(loadcalcvolts);
			
		}
		
		
		
		if(v.getId() == R.id.button4){
			
			Intent loadcalcohms = new Intent(this,CalcOhms.class);
			
			startActivity(loadcalcohms);
			
		}
		
		
		
		//get pigged 
		

		
		
	}
	
	
	//ok this function will be set to assign our buttons thier values at the start 
	//each button should get a quarter of the screen 
	
	@SuppressLint("NewApi")
	public void SetButtonDimensions(View rootView ){
		
		
		
		
		
	
		//so we need to declare our buttons then give each one a quarter of the screen
		//after this we need to set each button in its apprpriate place 
		
		
		
		//gets the root views height and width 
		
		int rootWidth = (int) rootView.getWidth();
		
		int rootHeight = (int) rootView.getHeight();
		
		int topMargin;
		
		int leftMargin;
	
		
		
		//sets params to have half the root width and half the root root height
		
		
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(rootWidth,rootHeight);
		
		//set each button to havfe 
		
		button1.setLayoutParams(lp);
		
		button2.setLayoutParams(lp);
		
		button3.setLayoutParams(lp);
		
		button4.setLayoutParams(lp);
		
		
	
		
		
		
		//ok i need a way to get the buttons to overlap the image 
		
		//if we add a margin that is equal to the starting position if the x image then the first button should be right under watts
		//then we can make everything relative to that button 
		
		
		//set another layout parameter to handle the button margins 
		
		
		
		//for button 1 
		
		RelativeLayout.LayoutParams lpButton1 = new RelativeLayout.LayoutParams( (buttonrelativeview.getWidth()/2),(int) (buttonrelativeview.getHeight()*.25));
		
		topMargin = (int) (buttonrelativeview.getHeight()*.25);
		lpButton1.setMargins(0, topMargin, 0, 0);
		transparentButton1.setLayoutParams(lpButton1);
		
		
		
		//for button 2

		RelativeLayout.LayoutParams lpButton2 = new RelativeLayout.LayoutParams( (buttonrelativeview.getWidth()/2),(int) (buttonrelativeview.getHeight()*.25));
		
		topMargin = (int) (buttonrelativeview.getHeight()*.25);
		leftMargin = (int) (buttonrelativeview.getWidth()*.5);
		lpButton2.setMargins(leftMargin, topMargin, 0, 0);
		
		transparentButton2.setLayoutParams(lpButton2);
		
		
		
		//for button 3

		RelativeLayout.LayoutParams lpButton3 = new RelativeLayout.LayoutParams( (buttonrelativeview.getWidth()/2),(int) (buttonrelativeview.getHeight()*.25));
		
		topMargin = (int) (buttonrelativeview.getHeight()*.5);
		
		lpButton3.setMargins(0, topMargin, 0, 0);
		
		transparentButton3.setLayoutParams(lpButton3);
		
		
		
		
		
		
		//for button 4

		RelativeLayout.LayoutParams lpButton4 = new RelativeLayout.LayoutParams( (buttonrelativeview.getWidth()/2),(int) (buttonrelativeview.getHeight()*.25));
		
		topMargin = (int) (buttonrelativeview.getHeight()*.5);
		
		leftMargin = (int) (buttonrelativeview.getWidth()*.5);
		
		lpButton4.setMargins(leftMargin, topMargin, 0, 0);
		
		transparentButton4.setLayoutParams(lpButton4);
		
		
		
		
		
	
	
	}
	
	
	
	
	
	}
	
	
	
	



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

public class CalcOhms extends Activity implements OnKeyListener {
	
	
	

	boolean wattsSelected = false;
	
	boolean ampsSelected = false;
	
	boolean voltsSelected = false;
	
	
	
   	double wattssInput;
	
	double ampsInput;
	
	double voltsInput; 
	
	
	double theAnswer = 0;
	
	
	
	int boxesShown;
	
	
	
	TextView textviewwatts;
	

	TextView textviewamps;
	

	TextView textviewvolts;
	
	
	
	Button button1;
	
	Button button2;
	
	Button button3;
	
	Button button4;
	
	
	ImageView wattsImage;
	
	ImageView ampsImage;
	
	ImageView voltsImage;
	
	
	ViewSwitcher viewSwitch;
	
	ViewSwitcher viewSwitch2;
	
	ViewSwitcher viewSwitch3;
	
	ViewSwitcher ViewSwitche4;
	
	
	
	
	
	RelativeLayout mainview;
	
	RelativeLayout buttonrelativeview;
	

	

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calc_ohms);
		
		
		
		textviewwatts = (TextView) findViewById(R.id.editTextWatts);
		
		textviewvolts = (TextView) findViewById(R.id.editTextVolts);
		
		textviewamps = (TextView) findViewById(R.id.editTextAmps);
		
		
		wattsImage = (ImageView) findViewById(R.id.imageViewWattsMain);
		
		voltsImage = (ImageView) findViewById(R.id.imageView_Watts_Volts);
		
		
		ampsImage = (ImageView) findViewById(R.id.imageView6);
		
		viewSwitch = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Volts);
		
		
		viewSwitch2 = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Amps);
		
		
		 viewSwitch3 = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Grey);
		 
		 ViewSwitche4 = (ViewSwitcher) findViewById(R.id.viewSwitch_Ohms);
		 
		 
		 button1 =  (Button) findViewById(R.id.Watts_Amps_Button);
		 
		 button3 = (Button) findViewById(R.id.button3);
		 
		 button4 = (Button) findViewById(R.id.button4);
		 
		 
		 
		 
		 textviewamps.setOnKeyListener(this);
		 
		 textviewvolts.setOnKeyListener(this);
		 
		 textviewwatts.setOnKeyListener(this);
		 
		 
		 
		 
		 
			mainview = (RelativeLayout) findViewById(R.id.MainViewOhms);
				
			buttonrelativeview = (RelativeLayout) findViewById(R.id.ButtonRelativeViewOhms);
			
			 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calc_ohms, menu);
		return true;
	}
	
	
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		
		SetButtonDimensions(mainview);
	
		
		
	}
	
	
	public void buttonHit(View v){
		
		if(v.getId() == R.id.Watts_Amps_Button) {
			
			
			
			ampsSelected = true;
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
		
		
		
		
		
		if(v.getId() == R.id.button3) {
			
			
			wattsSelected = true;
			textviewwatts.setVisibility(1);
			textviewwatts.setFocusableInTouchMode(true);
			textviewwatts.requestFocus();
			
			
			   if (textviewwatts.requestFocus()) {

					 InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					
			        imm.showSoftInput(textviewwatts, InputMethodManager.SHOW_IMPLICIT);
				
			}
			   
			   
			   boxesShown += 1;
			   
			   
			    
			
		}
		
		
		
		
		if(v.getId() == R.id.button4) {
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
		
			
		
		

	    if(boxesShown > 2 || (boxesShown > 1 && ampsSelected == true && voltsSelected == false && wattsSelected == false)
	    		|| (boxesShown > 1 && ampsSelected == false && voltsSelected == true && wattsSelected == false)
	    		|| (boxesShown > 1 && ampsSelected == false && voltsSelected == false && wattsSelected == true)
	    		
	    		
	    		) {
	    	
	    	 
	    	textviewamps.setVisibility(v.INVISIBLE);
	    	
	    	textviewamps.clearFocus();
	    	
	    	textviewvolts.setVisibility(v.INVISIBLE);
	    	
	    	textviewvolts.clearFocus();
	    	
	    	textviewwatts.setVisibility(v.INVISIBLE);
	    	
	    	textviewwatts.clearFocus();
	    	
	    	
	    	
	    	
				if(ampsSelected == true && voltsSelected == true ) {
					
					 viewSwitch3.showNext();
					 
					 
					 
					
				}

				
				if(ampsSelected == true && wattsSelected == true ) {
					
					//if watts and ohms show then flip volts to grayed out view 
					
					viewSwitch.showNext();
					
				}
				
				
				
				if(voltsSelected == true && wattsSelected == true ) {
					
					 viewSwitch2.showNext();
					
			
				}
				
				
				
			 	
			 	
		    	ampsSelected= false;
		    	
		    	voltsSelected = false;
		    	
		    	wattsSelected = false;
		    	
		    	
		    	
		    	button1.setClickable(true);
		    	
		    	button3.setClickable(true);
		    	
		    	button4.setClickable(true);
		    	
		    	
		    	ampsInput = 0;
		    	
		    	voltsInput = 0;
		    	
		    	wattssInput = 0;
		    	
		    	
		    	
		    	textviewamps.setText("");
		    	
		    	textviewvolts.setText("");
		    	
		    	textviewwatts.setText("");
		    	

		   	 InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		   	
		    	imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
		    	
		    	
		    	boxesShown = 0;
		    	
		    	
		    	
		    	
		    }
	    
	    
	
		
		if(ampsSelected == true && voltsSelected == true ) {
			
			viewSwitch3.showNext();
			 
			 
			 button3.setClickable(false);
			 
			
		}

		
		if(ampsSelected == true && wattsSelected == true ) {
			
			//if watts and ohms show then flip volts to grayed out view 
			
			viewSwitch.showNext();
			button4.setClickable(false);
			
			
			
			
		}
		
		
		
		if(voltsSelected == true && wattsSelected == true ) {
			
			 viewSwitch2.showNext();
			 
			 button1.setClickable(false);
			
	
		}
		
		
		
	    
	}
	
	

	@Override
	public boolean onKey(View v, int arg1, KeyEvent arg2) {
		
		
	
		    switch (arg1) {
		        case KeyEvent.KEYCODE_ENTER:
		        	
		        	
		        	
		        	// if they havnt entered a value then dont parse the string 
		        	
		       
		  
		          	
		          	if(wattsSelected == true)
		          	{
		          		
		          		if(textviewwatts.getText().toString().equals("") )
			        	{
			        		Toast.makeText(getApplicationContext(), "please enter a value for watts ", Toast.LENGTH_SHORT).show();	
			        		
			        	}else {
			        		
			        		wattssInput =  Double.parseDouble(textviewwatts.getText().toString());
			        		
   		
			        		
			        	}
		          		
		          		
		          	}
		       
		        	
		        	
		        	
   	
		          	
		          	
		          	if(voltsSelected == true)
		          	{
		          		
		          		if(textviewvolts.getText().toString().equals("") )
			        	{
			        		Toast.makeText(getApplicationContext(), "please enter a value for volts ", Toast.LENGTH_SHORT).show();	
			        		
			        	}else {
			        		
			        		voltsInput =  Double.parseDouble(textviewvolts.getText().toString());
			        		
		
			        	        		
			        	}
		          		
		          	}
		       
		        		
		          	
		          	
		          	
		          	
		          	if(ampsSelected == true)
		          	{
		          		
		          		if(textviewamps.getText().toString().equals("") )
			        	{
			        		Toast.makeText(getApplicationContext(), "please enter a value for ohms ", Toast.LENGTH_SHORT).show();	
			        		
			        	}else {
			        		
			        		ampsInput =  Double.parseDouble(textviewamps.getText().toString());
       		
			        		
			        		
			        	}
		          		
		          	}
		          	
		          	
		          	
		           	//drop the keyboard
		          	 InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		     	   	
		 	    	imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
		          
		        		
		        	///finally if two buttons are selected and both boxes are not null; then Calculate it !!! 
		          	
		          	
		          	if(textviewwatts.getText().toString().equals("") == false && textviewvolts.getText().toString().equals("") == false  )
		          	{
		          		
		          	
		          		theAnswer = (voltsInput * voltsInput)/wattssInput;
		          		
		          		calculateIt(theAnswer);
		          	}
		          	
		          	
		          	
		         	
		          	if(textviewwatts.getText().toString().equals("") == false && textviewamps.getText().toString().equals("") == false  )
		          	{
		          		
		          		theAnswer = wattssInput/(ampsInput * ampsInput);
		          		
		          		calculateIt(theAnswer);
		          	}
		          	
		          	
		         	
		          	if(textviewvolts.getText().toString().equals("") == false && textviewamps.getText().toString().equals("") == false  )
		          	{
		          		theAnswer = voltsInput/ampsInput;
		          		
		          		calculateIt(theAnswer);
		          	}
		        	
		        	
		        	
		        	
		        	
		        	
		         
		      return true;
		    }
		    return false;
		
		
		
	}

	private void calculateIt(double theAnswer2) {
			
		Intent theanswer = new Intent(this,TheAnswerOhms.class);
		
		theanswer.putExtra("FinalAnswer", theAnswer2);
		
		startActivity(theanswer);
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
				
				//sets the layout for the images in the circle 
				
				RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(rootWidth,rootHeight);
				
				topMargin = (int) (buttonrelativeview.getHeight()*.21);
				
				
				
				
				viewSwitch3.setLayoutParams(lp);
				
				
				viewSwitch2.setLayoutParams(lp);
				
				
				viewSwitch.setLayoutParams(lp);
				
				
				ViewSwitche4.setLayoutParams(lp);
				
				
				
				
				//set the layout positions for thje buttons that go on top of them 
				

				//for button 1 
				
				RelativeLayout.LayoutParams lpButton1 = new RelativeLayout.LayoutParams( (buttonrelativeview.getWidth()/2),(int) (buttonrelativeview.getHeight()*.25));
				
				topMargin = (int) (buttonrelativeview.getHeight()*.25);
				leftMargin = (int) (buttonrelativeview.getWidth()*.5);
				lpButton1.setMargins(leftMargin, topMargin, 0, 0);
				button1.setLayoutParams(lpButton1);
				
				
				
				
				
				//for button 3

				RelativeLayout.LayoutParams lpButton3 = new RelativeLayout.LayoutParams( (buttonrelativeview.getWidth()/2),(int) (buttonrelativeview.getHeight()*.25));
				
				topMargin = (int) (buttonrelativeview.getHeight()*.25);
				
				lpButton3.setMargins(0, topMargin, 0, 0);
				
				button3.setLayoutParams(lpButton3);
				
				

				
				
				
				
				//for button 4

				RelativeLayout.LayoutParams lpButton4 = new RelativeLayout.LayoutParams( (buttonrelativeview.getWidth()/2),(int) (buttonrelativeview.getHeight()*.25));
				
				topMargin = (int) (buttonrelativeview.getHeight()*.5);
				
				
				
				lpButton4.setMargins(0, topMargin, 0, 0);
				
				button4.setLayoutParams(lpButton4);
				


				
				
				
				
				

				//for the watts text box 
				
				RelativeLayout.LayoutParams textBoxLP1 = new RelativeLayout.LayoutParams( (int) (buttonrelativeview.getWidth()*.25),RelativeLayout.LayoutParams.WRAP_CONTENT);
				
				
				topMargin = (int) ((buttonrelativeview.getHeight()*.4) );   
				
				leftMargin = (int) (buttonrelativeview.getWidth()*.20);
				
				
				textBoxLP1.setMargins(leftMargin, topMargin, 0, 0);
				
				textviewwatts.setLayoutParams(textBoxLP1);
				
				
				
				
				
				//for the amps text box 
				
				RelativeLayout.LayoutParams textBoxLP2 = new RelativeLayout.LayoutParams( (int) (buttonrelativeview.getWidth()*.25),RelativeLayout.LayoutParams.WRAP_CONTENT);
				
				
				topMargin = (int) ((buttonrelativeview.getHeight()*.4) );   
				
				leftMargin = (int) (buttonrelativeview.getWidth()*.6);
				
				textBoxLP2.setMargins(leftMargin, topMargin, 0, 0);
				
				textviewamps.setLayoutParams(textBoxLP2);
				
				
				
				//for the volts text box 
				
				
				
				RelativeLayout.LayoutParams textBoxLP3 = new RelativeLayout.LayoutParams( (int) (buttonrelativeview.getWidth()*.25),RelativeLayout.LayoutParams.WRAP_CONTENT);
				
				
				topMargin = (int) ((buttonrelativeview.getHeight()*.55) );   
				
				leftMargin = (int) (buttonrelativeview.getWidth()*.20);
				
				textBoxLP3.setMargins(leftMargin, topMargin, 0, 0);
				
				textviewvolts.setLayoutParams(textBoxLP3);
				
				
				
				
	
		
	
	}
	


	
	
	
	
	

}

	
	
	
	
	
	
	
	

		

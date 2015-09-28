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

import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

public class Calcamps extends Activity implements OnKeyListener  {
	
	
	boolean wattsSelected = false;
	
	boolean voltsSelected = false;
	
	boolean ohmsSelected = false;
	
	
	
   	double wattsInput = 0;
	
   	double voltsInput = 0;
	
   	double ohmsInput = 0;
	
   	double theAnswer = 0;
	
   	int boxesShown;
	
	
	
	TextView textviewwatts;
	

	TextView textviewvolts;
	

	TextView textviewohms;
	
	
	
	Button button1;
	
	Button button2;
	
	Button button3;
	
	Button button4;
	
	
	ImageView wattsImage;
	
	ImageView voltsImage;
	
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
		setContentView(R.layout.activity_calcamps);
		
		textviewwatts = (TextView) findViewById(R.id.editTextWatts);
		
		textviewvolts = (TextView) findViewById(R.id.editTextVolts);
		
		textviewohms = (TextView) findViewById(R.id.editTextOhmsAnswer);
		
		
		wattsImage = (ImageView) findViewById(R.id.imageViewWattsMain);
		
		voltsImage = (ImageView) findViewById(R.id.imageView_Watts_Volts);
		
		
		ohmsImage = (ImageView) findViewById(R.id.imageView_Watts_Ohms);
		
		viewSwitch = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Volts);
		
		
		viewSwitch2 = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Amps);
		
		
		 viewSwitch3 = (ViewSwitcher) findViewById(R.id.viewSwitch_Watts_Grey);
		 
		 ViewSwitche4 = (ViewSwitcher) findViewById(R.id.viewSwitch_Ohms);
		 
		 
		 button1 =  (Button) findViewById(R.id.Watts_Amps_Button);
		 
		 button3 = (Button) findViewById(R.id.button3);
		 
		 button4 = (Button) findViewById(R.id.button4);
		
		
		 textviewwatts.setOnKeyListener(this);
		 
		 textviewvolts.setOnKeyListener(this);
		 
		 textviewohms.setOnKeyListener(this);
		 
		 
		 
		 
		 

		 
			mainview = (RelativeLayout) findViewById(R.id.MainViewAmps);
				
			buttonrelativeview = (RelativeLayout) findViewById(R.id.ButtonRelativeViewAmps);
			
		 
		 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calcamps, menu);
		return true;
	}
	
	
	
	
	
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		
		SetButtonDimensions(mainview);
	
		
		
	}
	
	
	


	
	public void buttonHit(View v){
		
		
		//if they only have one view selected   and they hit the same view reset the app
		
		
		
		
		
		
		if(v.getId() == R.id.Watts_Amps_Button) {
			
			
			
		
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
		
		
		if(v.getId() == R.id.button3) {
			
			
			
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
			
		 
		
		
		if(v.getId() == R.id.button4) {
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
		
		
		
		
	    if(boxesShown > 2 || (boxesShown > 1 && wattsSelected == true && voltsSelected == false && ohmsSelected == false)
	    		|| (boxesShown > 1 && wattsSelected == false && voltsSelected == true && ohmsSelected == false)
	    		|| (boxesShown > 1 && wattsSelected == false && voltsSelected == false && ohmsSelected == true)
	    		
	    		
	    		) {
	    	
	    	
	    
	    	textviewwatts.setVisibility(v.INVISIBLE);
	    	
	    	textviewwatts.clearFocus();
	    	
	    	textviewvolts.setVisibility(v.INVISIBLE);
	    	
	    	textviewvolts.clearFocus();
	    	
	    	textviewohms.setVisibility(v.INVISIBLE);
	    	
	    	textviewohms.clearFocus();
	    	
	    	
	   	
	    	
	    	
	    	
			if(wattsSelected == true && voltsSelected == true ) {
				
				 ViewSwitche4.showNext();
				 
				 
				 
				
			}

			
			if(wattsSelected == true && ohmsSelected == true ) {
				
				//if watts and ohms show then flip volts to grayed out view 
				
				viewSwitch.showNext();
				
			}
			
			
			
			if(voltsSelected == true && ohmsSelected == true ) {
				
				 viewSwitch3.showNext();
				
		
			}
			
			
			
			
			
	    	
		 	
	    	wattsSelected= false;
	    	
	    	voltsSelected = false;
	    	
	    	ohmsSelected = false;
	    	
	    	
	    	
	    	button1.setClickable(true);
	    	
	    	button3.setClickable(true);
	    	
	    	button4.setClickable(true);
	    	
	    	

	    	
	    	
	    	
	    	textviewwatts.setText("");
	    	
	    	textviewvolts.setText("");
	    	
	    	textviewohms.setText("");
	    	

	   	 InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	   	
	    	imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
	    	
	    	
	    	boxesShown = 0;
	    	
	    	
	    	
	    	
	    }
	    
			

		
		
		if(wattsSelected == true && voltsSelected == true ) {
			
			 ViewSwitche4.showNext();
			 
			 button4.setClickable(false);
			 
			 
			
		}

		
		if(wattsSelected == true && ohmsSelected == true ) {
			
			//if watts and ohms show then flip volts to grayed out view 
			
			viewSwitch.showNext();
			
			button3.setClickable(false);
			
			
			
		}
		
		
		
		if(voltsSelected == true && ohmsSelected == true ) {
			
			 viewSwitch3.showNext();
			 
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
			        		
			        		wattsInput = Double.parseDouble(textviewwatts.getText().toString());
			        		
   		
			        		
			        	}
		          		
		          		
		          	}
		       
		        	
		        	
		        	
   	
		          	
		          	
		          	if(voltsSelected == true)
		          	{
		          		
		          		if(textviewvolts.getText().toString().equals("") )
			        	{
			        		Toast.makeText(getApplicationContext(), "please enter a value for volts ", Toast.LENGTH_SHORT).show();	
			        		
			        	}else {
			        		
			        		voltsInput = Double.parseDouble(textviewvolts.getText().toString());
			        		
		
			        	        		
			        	}
		          		
		          	}
		       
		        		
		          	
		          	
		          	
		          	
		          	if(ohmsSelected == true)
		          	{
		          		
		          		if(textviewohms.getText().toString().equals("") )
			        	{
			        		Toast.makeText(getApplicationContext(), "please enter a value for ohms ", Toast.LENGTH_SHORT).show();	
			        		
			        	}else {
			        		
			        		ohmsInput = Double.parseDouble(textviewohms.getText().toString());
       		
			        		
			        		
			        	}
		          		
		          	}
		          	
		          	
		           	//drop the keyboard
		          	 InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		     	   	
		 	    	 imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
		          
		        		
		        	///finally if two buttons are selected and both boxes are not null; then Calculate it !!! 
		          	
		          	
		          	if(textviewwatts.getText().toString().equals("") == false && textviewvolts.getText().toString().equals("") == false  )
		          	{
		          		
		          		theAnswer = wattsInput/voltsInput;
		          		
		          		
		          		
		          		calculateIt(theAnswer);
		          	}
		          	
		          	
		          	
		         	
		          	if(textviewwatts.getText().toString().equals("") == false && textviewohms.getText().toString().equals("") == false  )
		          	{
		          		theAnswer =   Math.sqrt((wattsInput/ohmsInput));
		          		calculateIt(theAnswer);
		          	}
		          	
		          	
		         	
		          	if(textviewvolts.getText().toString().equals("") == false && textviewohms.getText().toString().equals("") == false  )
		          	{
		          		
		          		theAnswer = voltsInput/ohmsInput;
		          		
		          		
		          		calculateIt( theAnswer);
		          	}
		        	
		        	
		        	
		        	
		        	
		        	
		         
		      return true;
		    }
		    return false;
		
		
		
	}

	private void calculateIt(double theAnswer2) {
			
		Intent theanswer = new Intent(this,TheAnswerAmps.class);
		
		
		theanswer.putExtra("FinalAnswer", theAnswer2);
		
		startActivity(theanswer);
	}
	
	

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
				
				
				
				//for watts

				RelativeLayout.LayoutParams lpButton1 = new RelativeLayout.LayoutParams( (buttonrelativeview.getWidth()/2),(int) (buttonrelativeview.getHeight()*.25));
				
				topMargin = (int) (buttonrelativeview.getHeight()*.25);
				
				lpButton1.setMargins(0, topMargin, 0, 0);
				
				button1.setLayoutParams(lpButton1);
				
				
				
				//for volts

				RelativeLayout.LayoutParams lpButton3 = new RelativeLayout.LayoutParams( (buttonrelativeview.getWidth()/2),(int) (buttonrelativeview.getHeight()*.25));
				
				topMargin = (int) (buttonrelativeview.getHeight()*.5);
				
				
				
				lpButton3.setMargins(0, topMargin, 0, 0);
				
				button3.setLayoutParams(lpButton3);
				
				
					
				//for ohms 
				
			RelativeLayout.LayoutParams lpButton4 = new RelativeLayout.LayoutParams( (buttonrelativeview.getWidth()/2),(int) (buttonrelativeview.getHeight()*.25));
				
				topMargin = (int) (buttonrelativeview.getHeight()*.5);
				leftMargin = (int) (buttonrelativeview.getWidth()*.5);
				lpButton4.setMargins(leftMargin, topMargin, 0, 0);
				button4.setLayoutParams(lpButton4);
				
				
				
				
				
				
				
				RelativeLayout.LayoutParams textBoxLP1 = new RelativeLayout.LayoutParams( (int) (buttonrelativeview.getWidth()*.25),RelativeLayout.LayoutParams.WRAP_CONTENT);
				
				
				topMargin = (int) ((buttonrelativeview.getHeight()*.4) );   
				
				leftMargin = (int) (buttonrelativeview.getWidth()*.20);
				
				
				textBoxLP1.setMargins(leftMargin, topMargin, 0, 0);
				
				textviewwatts.setLayoutParams(textBoxLP1);
	
				
				
				
				
				
				
				
				
				//for the volts text box 
				
				
				
				RelativeLayout.LayoutParams textBoxLP3 = new RelativeLayout.LayoutParams( (int) (buttonrelativeview.getWidth()*.25),RelativeLayout.LayoutParams.WRAP_CONTENT);
				
				
				topMargin = (int) ((buttonrelativeview.getHeight()*.55) );   
				
				leftMargin = (int) (buttonrelativeview.getWidth()*.20);
				
				textBoxLP3.setMargins(leftMargin, topMargin, 0, 0);
				
				textviewvolts.setLayoutParams(textBoxLP3);
				
				
				
				
				
				
				
				
				//for the ohms text box 
				
				
				RelativeLayout.LayoutParams textBoxLP4 = new RelativeLayout.LayoutParams( (int) (buttonrelativeview.getWidth()*.25),RelativeLayout.LayoutParams.WRAP_CONTENT);
				
				
				topMargin = (int) ((buttonrelativeview.getHeight()*.55) );   
				
				leftMargin = (int) (buttonrelativeview.getWidth()*.6);
				
				textBoxLP4.setMargins(leftMargin, topMargin, 0, 0);
				
				textviewohms.setLayoutParams(textBoxLP4);
				
				
		
	
	}
	


	
	
	
	
	

}

	
	
	
	
	
	
	
	

		

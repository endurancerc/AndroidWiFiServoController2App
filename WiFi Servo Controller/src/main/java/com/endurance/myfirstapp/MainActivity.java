package com.endurance.myfirstapp;

import java.io.OutputStream;
import java.net.Socket;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private SeekBar sb1,sb2,sb3,sb4,sb5,sb6,sb7,sb8 = null;
	private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv10 = null;
	private Button cb1 = null;
	private EditText ip = null;
	private Socket socket = null;
	private OutputStream out = null;     
	private Boolean connected = false;
	private int sb1_val,sb2_val,sb3_val,sb4_val,sb5_val,sb6_val,sb7_val,sb8_val = 1;
	private byte[] arr;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		//Allows network connections
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		arr = new byte[9];
		
		ip = (EditText)findViewById(R.id.editText1);
		cb1 = (Button)findViewById(R.id.button1);
		tv10 = (TextView)findViewById(R.id.textView10);
		
		tv1 = (TextView)findViewById(R.id.TextView1);
		tv2 = (TextView)findViewById(R.id.TextView2);
		tv3 = (TextView)findViewById(R.id.TextView3);
		tv4 = (TextView)findViewById(R.id.TextView4);
		tv5 = (TextView)findViewById(R.id.TextView5);
		tv6 = (TextView)findViewById(R.id.TextView6);
		tv7 = (TextView)findViewById(R.id.TextView7);
		tv8 = (TextView)findViewById(R.id.TextView8);
		
        sb1 = (SeekBar)findViewById(R.id.seekBar1);
        sb2 = (SeekBar)findViewById(R.id.seekBar2);
        sb3 = (SeekBar)findViewById(R.id.seekBar3);
        sb4 = (SeekBar)findViewById(R.id.seekBar4);
        sb5 = (SeekBar)findViewById(R.id.seekBar5);
        sb6 = (SeekBar)findViewById(R.id.seekBar6);
        sb7 = (SeekBar)findViewById(R.id.seekBar7);
        sb8 = (SeekBar)findViewById(R.id.seekBar8);
        
        //Connect/Disconnect button handler
        cb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	if(!connected) { 								//if disconnected then connect
                	String addr = ip.getText().toString(); 
                	
    				try {
    					socket = new Socket(addr, 10001);
    					out = socket.getOutputStream();     

    					cb1.setText("Disconnect");
    					tv10.setText("Connected");
    					connected = true;
    				}
    				catch(Exception e) {
    					connected = false;
    					System.out.println(e);
    				}              		
            	}
            	else {											//if connected then disconnect
    				try { 
    					socket.close();   
    					
    					cb1.setText("Connect");
    					tv10.setText("Not Connected");
    				}
    				catch(Exception e) {
    					System.out.println(e);
    				}                	
  					
    				connected = false;    				
            	}
            		
            }
        });
        
    
        //Scroll Bar 1 handler
		sb1.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
				tv1.setText(progress+1+"");
				update();
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		});
		
		sb2.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
				tv2.setText(progress+1+"");
				update();				
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		});	
		
		sb3.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
				tv3.setText(progress+1+"");
				update();
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		});
		
		sb4.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
				tv4.setText(progress+1+"");
				update();
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		});			
		
		sb5.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
				tv5.setText(progress+1+"");
				update();
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		});
		
		sb6.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
				tv6.setText(progress+1+"");
				update();			
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		});	
		
		sb7.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
				tv7.setText(progress+1+"");
				update();
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		});
		
		sb8.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
				tv8.setText(progress+1+"");
				update();
			}
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		});				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
    public void update() {
    	if(connected) { 								
			try {
				
				sb1_val = sb1.getProgress() + 1;
				sb2_val = sb2.getProgress() + 1;
				sb3_val = sb3.getProgress() + 1;
				sb4_val = sb4.getProgress() + 1;
				sb5_val = sb5.getProgress() + 1;
				sb6_val = sb6.getProgress() + 1;
				sb7_val = sb7.getProgress() + 1;
				sb8_val = sb8.getProgress() + 1;
				
				arr[0] = 0;
				arr[1] = (byte)sb1_val;
				arr[2] = (byte)sb2_val;
				arr[3] = (byte)sb3_val;
				arr[4] = (byte)sb4_val;
				arr[5] = (byte)sb5_val;
				arr[6] = (byte)sb6_val;
				arr[7] = (byte)sb7_val;
				arr[8] = (byte)sb8_val;
				
				out.write(arr, 0, 9);
			}
			catch(Exception e) {
				connected = false;    					
				System.out.println(e);
			}              		
    	}
    }		
}

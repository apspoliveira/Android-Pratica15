package com.android.pratica15;

import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private TextView proximidade;
    @Override 
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	proximidade = (TextView) findViewById(R.id.proximidade);
	// obter um sensormanager
	mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override 
	public void onAccuracyChanged(Sensor arg0, int arg1) {

    }

    @Override 
	public void onSensorChanged(SensorEvent event) {
	if(event.values[0] == 0) {
	    // se aconteceu uma alteração no sensor,
	    // altera o layout
	    setContentView(R.layout.layout_vermelho);
	} 
	else {
	    // se o sensor não dispara volta
	    // ao layout verde
	    setContentView(R.layout.activity_main); }  
    }
    
    @Override 
	public void onResume() {
	super.onResume();
	mSensorManager.registerListener(this,mSensorManager.getDefaultSensor(
									     Sensor.TYPE_PROXIMITY),
					SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override 
	public void onStop() {
	mSensorManager.unregisterListener(this, mSensorManager.getDefaultSensor(
										Sensor.TYPE_PROXIMITY));
	super.onStop();
    }

    /*@Override 
	public boolean onCreateOptionsMenu(Menu menu) { }

    @Override 
	public boolean onOptionsItemSelected(MenuItem item) { }
    */
}
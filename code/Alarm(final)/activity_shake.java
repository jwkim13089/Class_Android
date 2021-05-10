package com.example.getready;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class activity_shake extends AppCompatActivity implements SensorEventListener {

TextView tv_hlb;
TextView tv_nsk;

SensorManager msm;
double y_ = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_shake);

tv_hlb = findViewById(R.id.tv_hlb);
tv_nsk = findViewById(R.id.tv_nsk);

Intent intent_shake = getIntent();
tv_hlb.setText(intent_shake.getStringExtra("LB"));

msm = (SensorManager)getSystemService(SENSOR_SERVICE);
Sensor a = msm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
msm.registerListener(activity_shake.this, a, SensorManager.SENSOR_DELAY_UI);
}

@Override
public void onSensorChanged(SensorEvent event) {
if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
{
double y = event.values[1];
if(y - y_ > 25 || y - y_ <-25){
tv_nsk.setText(String.valueOf(Integer.parseInt(tv_nsk.getText().toString())-1));
}
y_ = y;

System.out.println(y);

if(Integer.parseInt(tv_nsk.getText().toString()) == 0)
{
msm.unregisterListener(activity_shake.this);
Intent intent_ini = new Intent(getApplicationContext(), MainActivity.class);
intent_ini.putExtra("STOP", 1);
startActivity(intent_ini);
}
}
}

@Override
public void onAccuracyChanged(Sensor sensor, int accuracy) {

}

}
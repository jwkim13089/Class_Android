package com.example.getready;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class activity_walk extends AppCompatActivity implements SensorEventListener {

TextView tv_wlb;
TextView tv_nm;

SensorManager msm;

int step;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_walk);

tv_wlb = findViewById(R.id.tv_wlb);
tv_nm = findViewById(R.id.tv_nm);

Intent intent_walk = getIntent();
tv_wlb.setText(intent_walk.getStringExtra("LB"));

step = Integer.parseInt(tv_nm.getText().toString());

msm = (SensorManager)getSystemService(SENSOR_SERVICE);
Sensor s = msm.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
msm.registerListener(activity_walk.this, s, SensorManager.SENSOR_DELAY_UI);
}

@Override
public void onSensorChanged(SensorEvent event) {
if(event.sensor.getType() == Sensor.TYPE_STEP_DETECTOR)
{
System.out.println(event.values[0]);
if(event.values[0] == 1.0f)
{
step--;
tv_nm.setText(String.valueOf(step));
}
if(step == 0)
{
msm.unregisterListener(activity_walk.this);
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
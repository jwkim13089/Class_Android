package com.example.week11_detection;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

private static final float SHAKE_THRESHOLD = 20.0f;
private long lastTime;

TextView mtv;
Button mbtn_start;
Button mbtn_stop;

SoundPool sp;
int snd_id;

SensorManager msm;

@Override
public void onSensorChanged(SensorEvent event) {
if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
{
long currentTime = System.currentTimeMillis();
long diff = (currentTime - lastTime);
if(diff > 500)
{
double x = event.values[0];
double y = event.values[1];
double z = event.values[2];

mtv.setText("x : " + x + "\n");
mtv.append("y : " + y + "\n");
mtv.append("z : " + z + "\n");

double abs = Math.sqrt(x*x + y*y + z*z);
if(abs > SHAKE_THRESHOLD)
{
lastTime = currentTime;
Toast.makeText(this, " 낙상!!",Toast.LENGTH_LONG).show();
sp.play(snd_id,1,1,0,0,1);
}
}
}
}

@Override
public void onAccuracyChanged(Sensor sensor, int accuracy) {

}

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
snd_id = sp.load(this, R.raw.snd1,1);

msm = (SensorManager)getSystemService(SENSOR_SERVICE);

mtv = findViewById(R.id.textView);
mbtn_start = findViewById(R.id.button);
mbtn_stop = findViewById(R.id.button2);

mbtn_start.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Sensor s = msm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
msm.registerListener(MainActivity.this,s,SensorManager.SENSOR_DELAY_UI);
}
});

mbtn_stop.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
msm.unregisterListener(MainActivity.this);

}
});
}
}
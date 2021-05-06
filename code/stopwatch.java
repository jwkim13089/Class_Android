package com.example.week8_stopwatch_assign;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

TextView tv_DP;
TextView tv_TM;
Button btn_ST;
Button btn_LP;
Button btn_RS;
CheckBox cb_AR;
EditText et_AR_min;
EditText et_AR_sec;
EditText et_AR_ms;
Button btn_AR;
SoundPool sp_AR;
TextView tv_LP;

boolean tv_DP_state = false;
long mstartTime;
Handler mhandler = new Handler();
int record = 0;
boolean SW_state = false;
String alarm="0000000";
String alarm_check="0000000";
int snd_id;
boolean alarm_set = false;

class MyRunnable implements Runnable{
@Override
public void run() {
long t = SystemClock.elapsedRealtime();
long lab = t - mstartTime;

long ms, sec, min;
String ms_s, sec_s, min_s;

ms = lab % 1000;
ms_s = "" + ms;
if(ms<10)
ms_s = "00" + ms;
else if(ms<100)
ms_s = "0" + ms;

sec = lab / 1000 % 60;
sec_s = "" + sec;
if(sec<10)
sec_s = "0" + sec;

min = lab / 60000;
min_s = "" + min;
if(min<10)
min_s = "0" + min;

tv_TM.setText(min_s + " : " + sec_s+" : "+ms_s);
alarm_check = min_s+sec_s+ms_s;

if(SW_state)
{
if((Integer.parseInt(alarm) < Integer.parseInt(alarm_check)) && (alarm_set == true))
{
sp_AR.play(snd_id,1,1,0,0,1);
SW_state =false;
alarm_set = false;
}
mhandler.post(this);
}
else{tv_TM.setText("00 : 00 : 000");
}
}
}

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

tv_DP = findViewById(R.id.textView_DP);
tv_DP.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
tv_DP_state = !tv_DP_state;
if(tv_DP_state)
tv_DP.setText("20181151 김지원");
else
tv_DP.setText("Developer");
}
});

tv_TM = findViewById(R.id.textView_TM);
tv_TM.setText("00 : 00 : 000");

btn_ST = findViewById(R.id.button_ST);
btn_ST.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
SW_state = true;
mstartTime = SystemClock.elapsedRealtime();
MyRunnable runnable = new MyRunnable();
mhandler.post(runnable);
}
});

btn_LP = findViewById(R.id.button_LP);
btn_LP.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
record = record + 1;
String currentTime = tv_TM.getText().toString();
tv_LP.append(record + ". \t" + currentTime + "\n");
}
});

btn_RS = findViewById(R.id.button_RS);
btn_RS.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
SW_state = false;
tv_LP.setText("");
record = 0;alarm_set = false;
}
});

cb_AR = findViewById(R.id.checkBox_AR);
cb_AR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
if(cb_AR.isChecked()==false)
{
et_AR_min.setEnabled(false);
et_AR_sec.setEnabled(false);
et_AR_ms.setEnabled(false);
btn_AR.setEnabled(false);
}
else
{
et_AR_min.setEnabled(true);
et_AR_sec.setEnabled(true);
et_AR_ms.setEnabled(true);
btn_AR.setEnabled(true);
}
}
});

et_AR_min = findViewById(R.id.editText_AR_min);
et_AR_min.setEnabled(false);

et_AR_sec = findViewById(R.id.editText_AR_sec);
et_AR_sec.setEnabled(false);

et_AR_ms = findViewById(R.id.editText_AR_ms);
et_AR_ms.setEnabled(false);

btn_AR = findViewById(R.id.button_AR);
btn_AR.setEnabled(false);
btn_AR.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
String AR_min = et_AR_min.getText().toString();
String AR_sec = et_AR_sec.getText().toString();
String AR_ms = et_AR_ms.getText().toString();

if(AR_min.matches("") || AR_sec.matches("") || AR_ms.matches(""))
Toast.makeText(getApplicationContext(),"시간을 입력하세요.",Toast.LENGTH_SHORT).show();
else
{
if(Integer.parseInt(AR_sec)>= 60)
{
Toast.makeText(getApplicationContext(),"초는59초까지만 입력 가능합니다.",Toast.LENGTH_SHORT).show();
}
else
{
alarm = AR_min + AR_sec + AR_ms;
Toast.makeText(getApplicationContext(),"알람이 설정되었습니다.",Toast.LENGTH_SHORT).show();
alarm_set = true;
}
}

}
});
sp_AR = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
snd_id = sp_AR.load(this, R.raw.snd,1);

tv_LP = findViewById(R.id.textView_LP);
tv_LP.setText("");
}
}
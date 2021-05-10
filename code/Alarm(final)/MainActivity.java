package com.example.getready;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

//각 위젯 활성화 시키기
Switch sw_ar;Button btn_ar;
TextView tv_tm;
TimePicker tp;

String MN_text;
String HR_text;

int set;
int mhour;
int mmin;
String AMPM;
int MS;
String LB;
int stop;

//TimePicker 시간 실시간 업데이트 하기
Handler handler = new Handler();

class MyRunnable implements Runnable{
@RequiresApi(api = Build.VERSION_CODES.M)
@Override
public void run() {
SystemClock.sleep(10);

Calendar c = Calendar.getInstance();
c.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
tp.setHour(c.get(Calendar.HOUR));
tp.setMinute(c.get(Calendar.MINUTE));

mhour = c.get(Calendar.HOUR);
mmin = c.get(Calendar.MINUTE);

//음악 멈춤
if(stop == 1)
{
System.out.println("음악 중지 가능");
Intent intent_bell = new Intent(getApplicationContext(), BellService.class);
stopService(intent_bell);
stop = 0;
}

//설정한 시간과 일치할 경우 벨소리가 울리고 화면이 전환된다.
if(sw_ar.isChecked() && set == 1)
{
//System.out.println("HR_text : "+ HR_text);
//System.out.println("mhour : "+ mhour);
//System.out.println("MN_text : "+ MN_text);
//System.out.println("mmin : "+mmin);

if(Integer.parseInt(HR_text) == mhour && Integer.parseInt(MN_text) == mmin)
{
//음악 재생
Intent intent_bell = new Intent(getApplicationContext(), BellService.class);
startService(intent_bell);

System.out.println("time matching! " + HR_text + " : " + MN_text);
System.out.println("MS : "+ MS);
if(MS == 1)
{
Intent intent_basic = new Intent(getApplicationContext(), activity_basic.class);
intent_basic.putExtra("TM", HR_text + " : " + MN_text + " " + AMPM);
intent_basic.putExtra("LB", LB);
startActivity(intent_basic);
}
else if(MS == 2)
{
Intent intent_shake = new Intent(getApplicationContext(), activity_shake.class);
intent_shake.putExtra("LB", LB);
startActivity(intent_shake);
}
else if(MS == 3)
{
Intent intent_walk = new Intent(getApplicationContext(), activity_walk.class);
intent_walk.putExtra("LB", LB);
startActivity(intent_walk);
}
else if(MS == 4)
{
Intent intent_sum = new Intent(getApplicationContext(), activity_sum.class);
intent_sum.putExtra("LB", LB);
startActivity(intent_sum);
}
set = 0;
}
}
handler.post(this);
}
}

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

sw_ar = findViewById(R.id.sw1);
btn_ar = findViewById(R.id.btn_set1);
btn_ar.setEnabled(false);
tv_tm = findViewById(R.id.tv_tm1);
tp = findViewById(R.id.timePicker);

//Switch가ON일때만 설정Button이 활성화
sw_ar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
if(sw_ar.isChecked()) {btn_ar.setEnabled(true);}
else {btn_ar.setEnabled(false);}
}
});

//설정Button을 누르면 알람 옵션창으로 이동
btn_ar.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Intent intent_set = new Intent(getApplicationContext(), activity_set.class);
startActivity(intent_set);
}
});

//Intent_setting을 통해 옵션 값 받음
Intent intent_setting = getIntent();
set = intent_setting.getIntExtra("SV",0);
if(set == 1)
{
sw_ar.setChecked(true);
//옵션으로 설정한 시간을Main에 출력함
String HR = intent_setting.getStringExtra("HR");
String MN = intent_setting.getStringExtra("MN");
AMPM = intent_setting.getStringExtra("AMPM");
System.out.println("HR : " + HR);
System.out.println("MN : " + MN);
if(Integer.parseInt(HR) >= 13) { HR_text = String.valueOf(Integer.parseInt(HR)%12); }
else { HR_text = HR; }
if(Integer.parseInt(MN) >= 60) { MN_text = String.valueOf(Integer.parseInt(MN)-60); }
else { MN_text = MN; }
tv_tm.setText(HR_text + " : " + MN_text + " " + AMPM);

MS = intent_setting.getIntExtra("MS",0);
System.out.println("MS : "+ MS);

LB = intent_setting.getStringExtra("LB");
}

Intent intent_ini = getIntent();
stop = intent_ini.getIntExtra("STOP", 0);
System.out.println("STOP : "+stop);

//TimePicker 시간 실시간 업데이트 하기
MyRunnable runnable = new MyRunnable();
handler.post(runnable);
}
}
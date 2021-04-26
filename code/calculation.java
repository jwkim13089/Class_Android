package com.example.week5_cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

TextView outcome;

float mArg;
int state;
float result;

public void onBtnDel(View v)
{
String input = outcome.getText().toString();

input = input.substring(0,input.length()-1);
outcome.setText(input);

if(input.equals(""))
{
outcome.setText("0");
}

Log.v("my.msg","onBtnDel");
}

public void onBtnAC(View v)
{
outcome.setText("0");

Log.v("my.msg","onBtnAC");
}

public void onBtnOFF(View v)
{
finish();

Log.v("my.msg","onBtnOFF");
}

public void onBtnSqrt(View v)
{
String str = outcome.getText().toString();

mArg = Float.valueOf(str);

String check = Double.toString(Math.sqrt(mArg));
if(check.length() > 15)
{
outcome.setText(String.format("%.12f",Math.sqrt(mArg)));
}
else if(check.length() <= 15)
{
outcome.setText(""+Math.sqrt(mArg));
}

if(Math.sqrt(mArg)-Math.round(Math.sqrt(mArg)) == 0)
{
outcome.setText(""+Math.round(Math.sqrt(mArg)));
}

Log.v("my.msg","onBtnSqrt");
}

public void onBtnSin(View v)
{
String str = outcome.getText().toString();

mArg = Float.valueOf(str);

String check = Double.toString(Math.sin(mArg));
if(check.length() > 15)
{
outcome.setText(String.format("%.12f",Math.sin(mArg)));
}
else if(check.length() <= 15)
{
outcome.setText(""+Math.sin(mArg));
}

if(Math.sin(mArg)-Math.round(Math.sqrt(Math.sin(mArg))) == 0)
{
outcome.setText(""+Math.round(Math.sin(mArg)));
}

Log.v("my.msg","onBtnSin");
}

public void onBtnCos(View v)
{
String str = outcome.getText().toString();

mArg = Float.valueOf(str);

String check = Double.toString(Math.cos(mArg));
if(check.length() > 15)
{
outcome.setText(String.format("%.12f",Math.cos(mArg)));
}
else if(check.length() <= 15)
{
outcome.setText(""+Math.cos(mArg));
}
if(Math.cos(mArg)-Math.round(Math.sqrt(Math.cos(mArg))) == 0)
{
outcome.setText(""+Math.round(Math.cos(mArg)));
}

Log.v("my.msg","onBtnCos");
}

public void onBtnTan(View v)
{
String str = outcome.getText().toString();

mArg = Float.valueOf(str);

String check = Double.toString(Math.tan(mArg));
if(check.length() > 15)
{
outcome.setText(String.format("%.12f",Math.tan(mArg)));
}
else if(check.length() <= 15)
{
outcome.setText(""+Math.tan(mArg));
}

if(Math.tan(mArg)-Math.round(Math.sqrt(Math.tan(mArg))) == 0)
{
outcome.setText(""+Math.round(Math.tan(mArg)));
}

Log.v("my.msg","onBtnTan");
}

public void onBtnSum(View v)
{
String str = outcome.getText().toString();

//mArg = Integer.parseInt(str);
mArg = Float.valueOf(str);
outcome.setText("0");
state = 1;

Log.v("my.msg","onBtnSum");
}

public void onBtnMin(View v)
{
String str = outcome.getText().toString();

//mArg = Integer.parseInt(str);
mArg = Float.valueOf(str);
outcome.setText("0");
state = 2;

Log.v("my.msg","onBtnMin");
}

public void onBtnMul(View v)
{
String str = outcome.getText().toString();

//mArg = Integer.parseInt(str);
mArg = Float.valueOf(str);
outcome.setText("0");
state = 3;

Log.v("my.msg","onBtnMul");
}

public void onBtnDiv(View v)
{
String str = outcome.getText().toString();

//mArg = Integer.parseInt(str);
mArg = Float.valueOf(str);
outcome.setText("0");
state = 4;

Log.v("my.msg","onBtnDiv");
}

public void onBtnEql(View v)
{
String str = outcome.getText().toString();

//int current = Integer.parseInt(str);
float current = Float.valueOf(str);

// + click
if(state == 1)
{
result = mArg + current;
}

// - click
if(state == 2)
{
result = mArg - current;
}

// x clickif(state == 3)
{
result = mArg * current;
}

// / clickif(state == 4)
{
result = mArg / current;
}

if(result-Math.round(result) == 0)
{
outcome.setText(""+Math.round(result));
}
else if(result-Math.round(result) != 0
{
//            Toast.makeText(getApplicationContext(), ""+Float.toString(result).length(), Toast.LENGTH_LONG).show();
if(Float.toString(result).length() > 15)
{
outcome.setText(String.format("%.12",result));
}
else if(Float.toString(result).length() <= 15)
{
outcome.setText(""+result);
}
//            outcome.setText(""+result);
}

Log.v("my.msg","onBtnEql");
}

public void onBtn0(View v)
{
String input = outcome.getText().toString();

if(input.equals("0"))
{
return;
}
else if(input.length() >=15 )
{
input = input;
}
else
{
input = input + "0";
}

outcome.setText(input);

Log.v("my.msg","onBtn0");
}

public void onBtn1(View v)
{
String input = outcome.getText().toString();

if(input.equals("0"))
{
input = "1";
}
else if(input.length() >=15 )
{
input = input;
}
else
{
input = input + "1";
}

outcome.setText(input);

Log.v("my.msg","onBtn1");
}

public void onBtn2(View v)
{
String input = outcome.getText().toString();

if(input.equals("0"))
{
input = "2";
}

else if(input.length() >=15 )
{
input = input;
}
else
{
input = input + "2";
}

outcome.setText(input);

Log.v("my.msg","onBtn2");
}

public void onBtn3(View v)
{
String input = outcome.getText().toString();

if(input.equals("0"))
{
input = "3";
}
else if(input.length() >=15 )
{
input = input;}else{input = input + "3";
}

outcome.setText(input);

Log.v("my.msg","onBtn3");
}

public void onBtn4(View v)
{
String input = outcome.getText().toString();

if(input.equals("0"))
{
input = "4";
}

else if(input.length() >=15 )
{
input = input;
}
else
{
input = input + "4";
}

outcome.setText(input);

Log.v("my.msg","onBtn4");
}

public void onBtn5(View v)
{
String input = outcome.getText().toString();
if(input.equals("0"))
{
input = "5";
}
else if(input.length() >=15 )
{
input = input;
}
else{input = input + "5";
}

outcome.setText(input);

Log.v("my.msg","onBtn5");
}

public void onBtn6(View v)
{
String input = outcome.getText().toString();
if(input.equals("0"))
{
input = "6";
}
else if(input.length() >=15 )
{
input = input;}else{input = input + "6";
}

outcome.setText(input);
Log.v("my.msg","onBtn6");
}


public void onBtn7(View v)
{
String input = outcome.getText().toString();
if(input.equals("0"))
{
input = "7";
}
else if(input.length() >=15 )
{
input = input;
}
else{input = input + "7";
}

outcome.setText(input);

Log.v("my.msg","onBtn7");
}

public void onBtn8(View v)
{
String input = outcome.getText().toString();
if(input.equals("0")){input = "8";
}
else if(input.length() >=15 ){input = input;
}
else{input = input + "8";
}
outcome.setText(input);
Log.v("my.msg","onBtn8");
}

public void onBtn9(View v)
{
String input = outcome.getText().toString();
if(input.equals("0")){input = "9";
}
else if(input.length() >=15 )
{
input = input;
}
else
{
input = input + "9";
}

outcome.setText(input);
Log.v("my.msg","onBtn9");
}


@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

outcome = findViewById(R.id.Text_Rlt);
outcome.setText("0");
}

@Override
public boolean onTouchEvent(MotionEvent event) 
{
float x = event.getX();
float y = event.getY();
int act = event.getAction();
{
if(act == MotionEvent.ACTION_DOWN)
{
//Toast.makeText(getApplicationContext(),""+x+","+y,Toast.LENGTH_LONG).show();
if( x>=10 && x<=840 && y>=260 && y<=380 )
{
Toast.makeText(getApplicationContext(), "[김지원- 20181151]", 
Toast.LENGTH_LONG).show();
}
}
}
return super.onTouchEvent(event);
}
}
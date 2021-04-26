package com.example.week3_0403_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView text1;
TextView text2;
TextView text3;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

text1 = findViewById(R.id.textView1);
text2 = findViewById(R.id.textView2);
text3 = findViewById(R.id.textView3);
text2.setText("");
text3.setText("20181151 김지원");
}

int test(int n)
{
int x,y,z,w;
z = n%10; //1의 자리수
w = (n/10)%10; //10의 자리수
y = (n/100)%10; //100의 자리수
x = (n/1000)%10; //1000의 자리수

int sum = x*x*x*x + y*y*y*y + w*w*w*w + z*z*z*z;

if( n == sum )
{
return n;
}
return 0;
}

@Override
protected void onResume() {
super.onResume();
text1.setText(" xywz = x^4 + y^4 + w^4 + z^4 를 만족하는 수(1~10000) : ");

for(int i=1 ; i<=9999 ; i++)
{
int check = test(i);
if(check != 0)
{
text2.append(" "+check);
}
}
}

int mCnt = 1;

@Override
public boolean onTouchEvent(MotionEvent event) {

float x = event.getX();
float y = event.getY();

int act = event.getAction();
{
if(act == MotionEvent.ACTION_DOWN)
{
if( x >= y )
mCnt++;
if(mCnt % 4 == 0)
{
Toast.makeText(getApplicationContext(), "[김지원- 20181151]", 
Toast.LENGTH_LONG).show();
}
}
}
return super.onTouchEvent(event);
}
}
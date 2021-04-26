package com.example.primality;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

TextView text1, text2, text3;
int result;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

text1 = findViewById(R.id.textView1);
text2 = findViewById(R.id.textView2);
text3 = findViewById(R.id.textView3);

result = PrimalityTest(10000);

text1.setText("1~10000사이의 소수의 개수 구하기");
text2.setText("1부터10000사이의 소수는" + result + "개 입니다.");
text3.setText("학번: 20181151, 이름: 김지원");
}

public int PrimalityTest(int n)
{
int res = 1;
for(int i=3 ; i<=n ; i++){
boolean TF = true;
if(i%2!=0) {
for(int j=2 ; j*j<=i ; j++) {
if(i%j == 0) {
TF = false;
break;
}
}
if(TF) {
res = res + 1;
}
}
}
return res;
}
}
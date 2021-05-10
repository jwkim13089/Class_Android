package com.example.getready;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class activity_sum extends AppCompatActivity {

TextView tv_mlb;
TextView tv_or;
TextView tv_od;
EditText et_aw;
Button btn_mk;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_sum);

tv_mlb = findViewById(R.id.tv_mlb);
tv_or = findViewById(R.id.tv_or);
tv_od = findViewById(R.id.tv_od);
et_aw = findViewById(R.id.et_aw);
btn_mk = findViewById(R.id.btn_mk);
Intent intent_sum = getIntent();
tv_mlb.setText(intent_sum.getStringExtra("LB"));

Random rand = new Random();
int operator = rand.nextInt(500);
System.out.println("operator : "+operator);
tv_or.setText(String.valueOf(operator));

System.out.println("in");
int operand = rand.nextInt(500);
System.out.println("operand : "+operand);
tv_od.setText(String.valueOf(operand));

final   int answer = operator + operand;
System.out.println("answer : "+ answer);

btn_mk.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
if(answer ==Integer.parseInt(et_aw.getText().toString()))
{
Intent intent_ini = new Intent(getApplicationContext(), MainActivity.class);
intent_ini.putExtra("STOP", 1);
startActivity(intent_ini);
}
else
{
Toast.makeText(activity_sum.this, "오답입니다.",Toast.LENGTH_LONG).show();
}
}
});
}
}
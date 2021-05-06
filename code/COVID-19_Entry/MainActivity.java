package com.example.week9_0515_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

Button btn_PF;
Button btn_SD;
Button btn_CT;
Button btn_IF;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

btn_PF = findViewById(R.id.buttonPF);
btn_PF.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Intent intent = new Intent(getApplicationContext(), activity_profile.class);
//                startActivityForResult(intent, 2);
startActivity(intent);
}
});

btn_SD = findViewById(R.id.buttonSD);
btn_SD.setOnClickListener(new View.OnClickListener() {

Intent intent = getIntent();
int PF_check = intent.getIntExtra("profile_check",2);

@Override
public void onClick(View v) {
if(PF_check == 1)
{
Intent intent = new Intent(getApplicationContext(), activity_diag.class);
//                startActivityForResult(intent,3);
startActivity(intent);
}
else if(PF_check != 1)
{
Toast.makeText(getApplicationContext(),"개인정보를 먼저 입력하십시오.",Toast.LENGTH_LONG).show();
Intent intent = new Intent(getApplicationContext(), activity_profile.class);
startActivity(intent);
}

}
});

btn_CT = findViewById(R.id.buttonCT);
btn_CT.setOnClickListener(new View.OnClickListener() {

Intent intent = getIntent();
int DG_check = intent.getIntExtra("diagnosis_check",2);

@Override
public void onClick(View v) {
if(DG_check == 1)
{
Intent intent = new Intent(getApplicationContext(), activity_pass.class);
startActivity(intent);
}
else if(DG_check != 1)
{
Toast.makeText(getApplicationContext(),"자가진단을 먼저 통과하십시오.",Toast.LENGTH_LONG).show();
Intent intent = new Intent(getApplicationContext(), activity_diag.class);
startActivity(intent);
}

}
});

btn_IF = findViewById(R.id.buttonIF);
btn_IF.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {Intent intent = new Intent(getApplicationContext(), activity_info.class);
startActivity(intent);
}
});
}

}
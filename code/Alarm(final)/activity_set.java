package com.example.getready;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class activity_set extends AppCompatActivity {

//위젯 활성화 시키기
EditText et_hr;
EditText et_min;
Switch sw_AMPM;
TextView tv_AMPM;
RadioGroup rg_ms;
EditText et_lb;
Button btn_save;

int ms_check;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_set);

et_hr = findViewById(R.id.et_hr);
et_min = findViewById(R.id.et_min);
sw_AMPM = findViewById(R.id.sw_AMPM);
tv_AMPM = findViewById(R.id.tv_AMPM);
rg_ms = findViewById(R.id.rg_ms);
et_lb = findViewById(R.id.et_lb);
btn_save = findViewById(R.id.btn_save);

//스위치가OFF면 오전, ON이면 오후
sw_AMPM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
if(isChecked) {tv_AMPM.setText("PM"); }
else {tv_AMPM.setText("AM"); }
}
});

//Mission을 선택한거에 따라ms_check의 숫자를 할당
rg_ms.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
@Override
public void onCheckedChanged(RadioGroup group, int checkedId) {
switch (checkedId){
case R.id.rd_basic :
ms_check = 1;
break;
case R.id.rd_shake :
ms_check = 2;
break;
case R.id.rd_walk :
ms_check = 3;
break;
case R.id.rd_sum :
ms_check = 4;
break;
}
System.out.println("set MS : " + ms_check);
}
});

btn_save.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Intent intent_setting = new Intent(getApplicationContext(), MainActivity.class);
intent_setting.putExtra("HR",et_hr.getText().toString());
intent_setting.putExtra("MN",et_min.getText().toString());
intent_setting.putExtra("AMPM",tv_AMPM.getText());
intent_setting.putExtra("MS",ms_check);
intent_setting.putExtra("LB", et_lb.getText().toString());
intent_setting.putExtra("SV",1);
startActivity(intent_setting);
}
});

}
}
package com.example.week9_0515_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class activity_profile extends AppCompatActivity {

EditText et_NM;
TextView tv_DB;
DatePickerDialog DP;
Switch sw_SX;
TextView tv_SX;
EditText et_CL;
RadioGroup rg_PS;
EditText et_ID;
EditText et_PN;
CheckBox cb_AG;
Button btn_SV;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_profile);

et_NM = findViewById(R.id.editTextNM);
tv_DB = findViewById(R.id.textViewDB);
final Calendar c = Calendar.getInstance();
c.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
final int d = c.get(Calendar.DAY_OF_MONTH);
final int m = c.get(Calendar.MONTH);
final int y = c.get(Calendar.YEAR);
tv_DB.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Calendar c = Calendar.getInstance();
c.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
int d = c.get(Calendar.DAY_OF_MONTH);
int m = c.get(Calendar.MONTH);
int y = c.get(Calendar.YEAR);
DP = new DatePickerDialog(activity_profile.this, new DatePickerDialog.OnDateSetListener() {
@Override
public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
tv_DB.setText(""+year+"/"+(month+1)+"/"+dayOfMonth);
}
}, y, m, d);
DP.show();
}
});

sw_SX = findViewById(R.id.switchSX);
tv_SX = findViewById(R.id.textViewSX);
sw_SX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
boolean SX = sw_SX.isChecked();
if(SX == true)
{
tv_SX.setText(""+"Female");
}
else
{
tv_SX.setText(""+"Male");
}
}
});

et_CL = findViewById(R.id.editTextCL);

rg_PS = findViewById(R.id.RadioGroupPS);

et_ID = findViewById(R.id.editTextID);

et_PN = findViewById(R.id.editTextPN);

cb_AG = findViewById(R.id.checkBoxAG);

btn_SV = findViewById(R.id.buttonSV);
btn_SV.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
if(et_NM.getText().toString().matches("") || tv_DB.getText().toString().matches("Click!") ||et_CL.getText().toString().matches("") || et_ID.getText().toString().matches("") ||et_PN.getText().toString().matches("") || cb_AG.isChecked() == false)
{
Toast.makeText(getApplicationContext(),"정보를 모두 입력하십시오.",Toast.LENGTH_LONG).show();
}
else
{
Toast.makeText(getApplicationContext(),"정보가 저장되었습니다.",Toast.LENGTH_LONG).show();
Intent intent = new Intent(getApplicationContext(), MainActivity.class);
intent.putExtra("profile_check", 1);
startActivityForResult(intent, 1);
}

}
});
}
}
package com.example.week6_entrylog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

int year_check;
int sex_check;
int lf_check;
int rr_check;

EditText et_NM;

TextView tv_DB;
DatePickerDialog DP;

Switch sw_SX;
TextView tv_SX;

Switch sw_LF;
TextView tv_LF;

TextView tv_RR1;
EditText et_RR2;
Button btn_RR;

RadioGroup rg_PS;
EditText et_ID;
EditText et_PN;
CheckBox cb_AB;
SeekBar sb_FV;
TextView tv_FV;
CheckBox cb_AG;
Button btn_SB;

public void onBtnCK(View v)
{
String input1 = tv_RR1.getText().toString();
String input2 = et_RR2.getText().toString();

int first = Integer.parseInt(input1.substring(0,1));
int second = Integer.parseInt(input1.substring(1,2));
int third = Integer.parseInt(input1.substring(2,3));
int fourth = Integer.parseInt(input1.substring(3,4));
int fifth = Integer.parseInt(input1.substring(4,5));
int sixth = Integer.parseInt(input1.substring(5,6));
int seventh = Integer.parseInt(input1.substring(27,28));
int eighth = Integer.parseInt(input2.substring(0,1));
int ninth = Integer.parseInt(input2.substring(1,2));
int tenth = Integer.parseInt(input2.substring(2,3));
int eleventh = Integer.parseInt(input2.substring(3,4));
int twelfth = Integer.parseInt(input2.substring(4,5));
int Thirteenth = Integer.parseInt(input2.substring(5,6));

int sum = first*2 + second*3 + third*4 + fourth*5 + fifth*6 + sixth*7 + seventh*8 + eighth*9 + ninth*2 + tenth*3 + eleventh*4 + twelfth*5;
int check = (11 - (sum % 11)) % 10;

if(check==Thirteenth)
{
rr_check = 1;
Toast.makeText(getApplicationContext(),"주민등록번호가 유효합니다.(Valid)",Toast.LENGTH_LONG).show();
}
else if(check!=Thirteenth)
{
rr_check = 0;
Toast.makeText(getApplicationContext(),"주민등록번호가 유효하지 않습니다.(Invalid)",Toast.LENGTH_LONG).show();
}
}

public void onBtnSB(View v)
{
if(rr_check == 1 && cb_AG.isChecked() == true )
{
Toast.makeText(getApplicationContext(),"제출되었습니다.",Toast.LENGTH_LONG).show();
}
else if(cb_AG.isChecked() == false )
{
Toast.makeText(getApplicationContext(),"개인정보 수집동의 항목은\n"+"필수 체크 항목입니다.",Toast.LENGTH_LONG).show();
}
else if(rr_check == 0 ){Toast.makeText(getApplicationContext(),"주민등록번호가 유효하지 않습니다.\n"+"재입력해주십시오.",Toast.LENGTH_LONG).show();
}
}

@Overrideprotected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

Toast.makeText(getApplicationContext(),"20181151 김지원",Toast.LENGTH_LONG).show();

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
DP = new DatePickerDialog(MainActivity.this, new 
DatePickerDialog.OnDateSetListener() {
@Override
public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
tv_DB.setText(""+year+"/"+(month+1)+"/"+dayOfMonth);
if(year<2000 && (month+1)<10 && dayOfMonth<10)
{
tv_RR1.setText(""+(year-1900)+"0"+(month+1)+"0"+dayOfMonth+"          -          ");
}
else if(year<2000 && (month+1)<10 && dayOfMonth>=10)
{
tv_RR1.setText(""+(year-1900)+"0"+(month+1)+dayOfMonth+"          -          ");
}
else if(year<2000 && (month+1)>=10 && dayOfMonth<10)
{
tv_RR1.setText(""+(year-1900)+(month+1)+"0"+dayOfMonth+"          -          ");
}
else if(year<2000 && (month+1)>=10 && dayOfMonth>=10)
{
tv_RR1.setText(""+(year-1900)+(month+1)+dayOfMonth+"          -          ");
}
else if(year>=2000 && (month+1)<10 && dayOfMonth<10)
{
tv_RR1.setText(""+(year-2000)+"0"+(month+1)+"0"+dayOfMonth+"          -          ");
}
else if(year>=2000 && (month+1)<10 && dayOfMonth>=10)
{
tv_RR1.setText(""+(year-2000)+"0"+(month+1)+dayOfMonth+"          -          ");
}
else if(year>=2000 && (month+1)>=10 && dayOfMonth<10)
{
tv_RR1.setText(""+(year-2000)+(month+1)+"0"+dayOfMonth+"          -          ");
}
else if(year>=2000 && (month+1)>=10 && dayOfMonth>=10)
{
tv_RR1.setText(""+(year-2000)+(month+1)+dayOfMonth+"          -          ");
}

if(year<2000)
{
year_check = 0;
}
else if(year>=2000)
{
year_check = 1;
}
}
}, y, m, d);
DP.show();
}
});

sw_SX = findViewById(R.id.switchSX);
tv_SX = findViewById(R.id.textViewSX);
sw_SX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
{
@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
{
boolean SX = sw_SX.isChecked();
if(SX == true)
{
tv_SX.setText(""+"Female");
sex_check = 1;
}
else{tv_SX.setText(""+"Male");
sex_check = 0;
}
}
});

sw_LF = findViewById(R.id.switchLF);
tv_LF = findViewById(R.id.textViewLF);
sw_LF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
boolean LF = sw_LF.isChecked();
if(LF == true)
{
tv_LF.setText(""+"외국인(Foreigner)");
lf_check = 1;
}
else
{
tv_LF.setText(""+"내국인(Local)");
lf_check = 0;
}
}
});

tv_RR1 = findViewById(R.id.textViewRR1);
et_RR2 = findViewById(R.id.editTextRR2);
btn_RR = findViewById(R.id.buttonRR);
tv_RR1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
if(tv_RR1.length() == 28)
{
String str = tv_RR1.getText().toString();
tv_RR1.setText(str.substring(0,27));
}
if(lf_check == 1)
{
if(year_check==0 && sex_check==0)
{
tv_RR1.append(""+5);
}
else if(year_check==0 && sex_check==1)
{
tv_RR1.append(""+6);
}
else if(year_check==1 && sex_check==0)
{
tv_RR1.append(""+7);
}
else if(year_check==1 && sex_check==1)
{
tv_RR1.append(""+8);
}
}
else if(lf_check == 0)
{
if(year_check==0 && sex_check==0)
{
tv_RR1.append(""+1);
}
else if(year_check==0 && sex_check==1)
{
tv_RR1.append(""+2);
}
else if(year_check==1 && sex_check==0)
{
tv_RR1.append(""+3);
}
else if(year_check==1 && sex_check==1)
{
tv_RR1.append(""+4);
}
}
}
});

rg_PS = findViewById(R.id.RadioGroupPS);

et_ID = findViewById(R.id.editTextID);

et_PN = findViewById(R.id.editTextPN);

cb_AB = findViewById(R.id.checkBoxAB);

sb_FV = findViewById(R.id.seekBarFV);
tv_FV = findViewById(R.id.textViewFV);
sb_FV.setMax(50);
sb_FV.setProgress(15);
sb_FV.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
@Override
public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
tv_FV.setText(""+((progress)*0.1+35)+"ºC");
}

@Override
public void onStartTrackingTouch(SeekBar seekBar) {
}

@Override
public void onStopTrackingTouch(SeekBar seekBar) {
}
});

cb_AG = findViewById(R.id.checkBoxAG);

btn_SB = findViewById(R.id.buttonSB);

}
}
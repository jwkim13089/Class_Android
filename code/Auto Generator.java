package com.example.week7_assign_autogenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

Switch sw_NM;
Switch sw_LW;
Switch sw_UP;
CheckBox cb_SP;
SeekBar sb_LN;
TextView tv_LN;
Button btn_GN;
SoundPool sp_GN;
int snd_id;
TextView tv_GN;

String[] num = {"0","1","2","3","4","5","6","7","8","9"};
String[] eng_LW = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
String[] eng_UP = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
String[] special = {"!","@","#","$","%","^","&","*","(",")"};
String[] pass;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

sw_NM = findViewById(R.id.switch_NM);
sw_LW = findViewById(R.id.switch_LW);
sw_UP = findViewById(R.id.switch_UP);
cb_SP = findViewById(R.id.checkBox_SP);

sb_LN = findViewById(R.id.seekBar_LN);
sb_LN.setMax(10);
sb_LN.setProgress(4);
sb_LN.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
@Override
public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
tv_LN.setText(progress+"자리");
}

@Override
public void onStartTrackingTouch(SeekBar seekBar) {

}
@Override
public void onStopTrackingTouch(SeekBar seekBar) {

}
});
tv_LN = findViewById(R.id.textView_LN);

sp_GN = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
snd_id = sp_GN.load(this, R.raw.snd1,1);
btn_GN = findViewById(R.id.button_GN);
btn_GN.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
sp_GN.play(snd_id,1,1,0,0,1);
Toast.makeText(getApplicationContext(),"CC0 1.0 Universal made by DayDreamSound\n" +"https://youtu.be/kfnh9QAfDgA",Toast.LENGTH_SHORT).show();

int len = sb_LN.getProgress();

if(sw_NM.isChecked()==false && sw_LW.isChecked()==false && sw_UP.isChecked()==false && cb_SP.isChecked()==false)
{
String str = getResources().getString(R.string.str_warn);
tv_GN.setText(str);
}
else
{
if(sw_NM.isChecked()==true && sw_LW.isChecked()==false && sw_UP.isChecked()==false && cb_SP.isChecked()==false)
{
pass = new String[num.length];
System.arraycopy(num, 0,pass,0,num.length);
}
else if(sw_NM.isChecked()==false && sw_LW.isChecked()==true && sw_UP.isChecked()==false && cb_SP.isChecked()==false)
{
pass = new String[eng_LW.length];
System.arraycopy(eng_LW, 0,pass,0,eng_LW.length);
}
else if(sw_NM.isChecked()==false && sw_LW.isChecked()==false && sw_UP.isChecked()==true && cb_SP.isChecked()==false)
{
pass = new String[eng_UP.length];
System.arraycopy(eng_UP, 0,pass,0,eng_UP.length);
}
else if(sw_NM.isChecked()==false && sw_LW.isChecked()==false && sw_UP.isChecked()==false && cb_SP.isChecked()==true)
{
pass = new String[special.length];
System.arraycopy(special, 0,pass,0,special.length);
}
else if(sw_NM.isChecked()==true && sw_LW.isChecked()==true && sw_UP.isChecked()==false && cb_SP.isChecked()==false)
{
pass = new String[num.length + eng_LW.length];
System.arraycopy(num, 0,pass,0,num.length);
System.arraycopy(eng_LW,0,pass,num.length,eng_LW.length);
}
else if(sw_NM.isChecked()==true && sw_LW.isChecked()==false && sw_UP.isChecked()==true && cb_SP.isChecked()==false)
{
pass = new String[num.length + eng_UP.length];
System.arraycopy(num, 0,pass,0,num.length);
System.arraycopy(eng_UP,0,pass,num.length,eng_UP.length);
}
else if(sw_NM.isChecked()==true && sw_LW.isChecked()==false && sw_UP.isChecked()==false && cb_SP.isChecked()==true)
{
pass = new String[num.length + special.length];
System.arraycopy(num, 0,pass,0,num.length);
System.arraycopy(special,0,pass,num.length,special.length);
}
else if(sw_NM.isChecked()==false && sw_LW.isChecked()==true && sw_UP.isChecked()==true && cb_SP.isChecked()==false)
{
pass = new String[eng_LW.length + eng_UP.length];
System.arraycopy(eng_LW, 0,pass,0,eng_LW.length);
System.arraycopy(eng_UP,0,pass,eng_LW.length,eng_UP.length);
}
else if(sw_NM.isChecked()==false && sw_LW.isChecked()==true && sw_UP.isChecked()==false && cb_SP.isChecked()==true)
{
pass = new String[eng_LW.length + special.length];
System.arraycopy(eng_LW, 0,pass,0,eng_LW.length);
System.arraycopy(special,0,pass,eng_LW.length,special.length);
}
else if(sw_NM.isChecked()==false && sw_LW.isChecked()==false && sw_UP.isChecked()==true && cb_SP.isChecked()==true)
{
pass = new String[eng_UP.length + special.length];
System.arraycopy(eng_UP, 0,pass,0,eng_UP.length);
System.arraycopy(special,0,pass,eng_UP.length,special.length);
}
else if(sw_NM.isChecked()==true && sw_LW.isChecked()==true && sw_UP.isChecked()==true && cb_SP.isChecked()==false)
{
pass = new String[num.length + eng_LW.length + eng_UP.length];
System.arraycopy(num, 0,pass,0,num.length);
System.arraycopy(eng_LW,0,pass,num.length,eng_LW.length);
System.arraycopy(eng_UP,0,pass,num.length+eng_LW.length,eng_UP.length);
}
else if(sw_NM.isChecked()==true && sw_LW.isChecked()==true && sw_UP.isChecked()==false && cb_SP.isChecked()==true)
{
pass = new String[num.length + eng_LW.length + special.length];
System.arraycopy(num, 0,pass,0,num.length);
System.arraycopy(eng_LW,0,pass,num.length,eng_LW.length);
System.arraycopy(special,0,pass,num.length+eng_LW.length,special.length);
}
else if(sw_NM.isChecked()==true && sw_LW.isChecked()==false && sw_UP.isChecked()==true && cb_SP.isChecked()==true)
{
pass = new String[num.length + eng_UP.length + special.length];
System.arraycopy(num, 0,pass,0,num.length);
System.arraycopy(eng_UP,0,pass,num.length,eng_UP.length);
System.arraycopy(special,0,pass,num.length+eng_UP.length,special.length);
}
else if(sw_NM.isChecked()==false && sw_LW.isChecked()==true && sw_UP.isChecked()==true && cb_SP.isChecked()==true)
{
pass = new String[eng_LW.length + eng_UP.length + special.length];
System.arraycopy(eng_LW, 0,pass,0,eng_LW.length);
System.arraycopy(eng_UP,0,pass,eng_LW.length,eng_UP.length);
System.arraycopy(special,0,pass,eng_LW.length+eng_UP.length,special.length);
}
else if(sw_NM.isChecked()==true && sw_LW.isChecked()==true && sw_UP.isChecked()==true && cb_SP.isChecked()==true)
{
pass = new String[num.length + eng_LW.length + eng_UP.length + special.length];
System.arraycopy(num, 0,pass,0,num.length);
System.arraycopy(eng_LW,0,pass,num.length,eng_LW.length);
System.arraycopy(eng_UP,0,pass,num.length+eng_LW.length,eng_UP.length);
System.arraycopy(special,0,pass,num.length+eng_LW.length+eng_UP.length,special.length);
}
Random random = new Random();

StringBuilder builder = new StringBuilder("");
for(int i=0; i<len;i++)
{
String str = pass[random.nextInt(pass.length)];
builder.append(str);
}
tv_GN.setText(builder.toString());
}
}
});
tv_GN = findViewById(R.id.textView_GN);
}
}
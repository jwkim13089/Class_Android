package com.example.week9_0515_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class activity_diag extends AppCompatActivity {

SeekBar sb_FV;
TextView tv_FV;
CheckBox cb_SP1;
CheckBox cb_SP2;
CheckBox cb_SP3;
CheckBox cb_SP4;
CheckBox cb_SP5;
CheckBox cb_SP6;
CheckBox cb_AB;
CheckBox cb_CAB;
CheckBox cb_SC;
Button btn_SB;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_diag);

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

cb_SP1 = findViewById(R.id.checkBoxSP1);
cb_SP2 = findViewById(R.id.checkBoxSP2);
cb_SP3 = findViewById(R.id.checkBoxSP3);
cb_SP4 = findViewById(R.id.checkBoxSP4);
cb_SP5 = findViewById(R.id.checkBoxSP5);
cb_SP6 = findViewById(R.id.checkBoxSP6);
cb_AB = findViewById(R.id.checkBoxAB);
cb_CAB = findViewById(R.id.checkBoxCAB);
cb_SC = findViewById(R.id.checkBoxSC);

btn_SB = findViewById(R.id.buttonSB);
btn_SB.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {if(cb_SP1.isChecked() || cb_SP2.isChecked() || cb_SP3.isChecked() ||cb_SP4.isChecked() || cb_SP5.isChecked() || cb_SP6.isChecked() ||cb_AB.isChecked() || cb_CAB.isChecked() || cb_SC.isChecked() || sb_FV.getProgress() >= 25)
{
Toast.makeText(getApplicationContext(),"출입이 불가합니다.",Toast.LENGTH_LONG).show();
Intent intent = new Intent(getApplicationContext(),activity_info.class);
startActivityForResult(intent,5);
}

else
{
Toast.makeText(getApplicationContext(),"확인되었습니다.",Toast.LENGTH_LONG).show();

Intent intent = new Intent(getApplicationContext(), activity_pass.class);
intent.putExtra("diagnosis_check", 1);
startActivityForResult(intent, 4);

}
}
});
}
}
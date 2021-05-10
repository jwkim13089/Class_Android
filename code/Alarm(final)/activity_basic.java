package com.example.getready;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_basic extends AppCompatActivity {

TextView tv_blb;
TextView tv_time;
Button btn_pause;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_basic);

tv_blb = findViewById(R.id.tv_blb);
tv_time = findViewById(R.id.tv_time);
btn_pause = findViewById(R.id.btn_pause);

Intent intent_basic = getIntent();
tv_blb.setText(intent_basic.getStringExtra("LB"));
tv_time.setText(intent_basic.getStringExtra("TM"));

btn_pause.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Intent intent_ini = new Intent(getApplicationContext(), MainActivity.class);
intent_ini.putExtra("STOP", 1);
startActivity(intent_ini);
}
});
}
}
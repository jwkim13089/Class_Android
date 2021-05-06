package com.example.week9_0515_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class activity_pass extends AppCompatActivity {

TextView tv_DT;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_pass);

tv_DT = findViewById(R.id.textViewDT);
Calendar cal = Calendar.getInstance();
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
tv_DT.setText(format.format(Calendar.getInstance().getTime()));
}
}
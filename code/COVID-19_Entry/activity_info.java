package com.example.week9_0515_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class activity_info extends AppCompatActivity {

ImageView btn_CA;
ImageView btn_CC;
ImageView btn_CF;
ImageView btn_MK;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_info);

btn_CA = findViewById(R.id.imageViewCA);
btn_CA.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
callPhone();

}
});

btn_CC = findViewById(R.id.imageViewCC);
btn_CC.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mohw.go.kr/react/popup_200128_3.html"));
startActivity(intent);
}
});

btn_CF = findViewById(R.id.imageViewCF);
btn_CF.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://coronamap.site/"));
startActivity(intent);
}
});

btn_MK = findViewById(R.id.imageViewMK);
btn_MK.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://00mask.com/#/map"));
startActivity(intent);
}
});
}

void callPhone() {
Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1339"));

if (ActivityCompat.checkSelfPermission(activity_info.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

final String [] MYCALL = { Manifest.permission.CALL_PHONE};
ActivityCompat.requestPermissions(this, MYCALL, 1004);
// TODO: Consider calling
//    ActivityCompat#requestPermissions
// here to request the missing permissions, and then overriding
//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                                          int[] grantResults)
// to handle the case where the user grants the permission. See the documentation
// for ActivityCompat#requestPermissions for more details.
return;
}
startActivity(intent);
}
}
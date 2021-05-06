package com.example.jclient;

import androidx.appcompat.app.AppCompatActivity

;import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {f

inal static int MOUSE_REQ = 0x02;
final static int SERVER_EXIT = 0x04;

EditText met_X;
EditText met_Y;
Button mbtn_move;
Button mbtn_quit;

int mx;
int my;
ArrayList mx_list;
ArrayList my_list;

@Override
public boolean onTouchEvent(MotionEvent event) {

mx = (int)event.getX();
my = (int)event.getY();

System.out.println("onTouchevent In");

switch(event.getAction()){
case MotionEvent.ACTION_DOWN :

/*
System.out.println("x좌표: "+mx+", y좌표: " + my);

met_X.setText(""+mx);
met_Y.setText(""+my);

NetworkThread thread = new NetworkThread();
thread.start();
*/
break;

case MotionEvent.ACTION_UP :
/*
System.out.println("x좌표: "+mx+", y좌표: " + my);

mx_list.add(mx);
my_list.add(my);

met_X.setText(""+mx);
met_Y.setText(""+my);

NetworkThread thread = new NetworkThread();
thread.start();
*/
break;

case MotionEvent.ACTION_MOVE :

System.out.println("x좌표: "+mx+", y좌표: " + my);

mx_list.add(mx);
my_list.add(my);

met_X.setText(""+mx);
met_Y.setText(""+my);

}

return super.onTouchEvent(event);
}

class NetworkThread extends Thread
{
@Override
public void run() {
super.run();
//1. Socket class 생성-> ip, port
try {
System.out.println("서버 스타트");
Socket socket = new Socket("172.18.228.52", 9712);
System.out.println("연결 성공");
//2. DataInputStream(), DataOutputStream
DataInputStream dis = new DataInputStream(socket.getInputStream());
DataOutputStream dos = new 
DataOutputStream(socket.getOutputStream());

System.out.println("networkThread In");
dos.writeInt(MOUSE_REQ);
//                dos.writeInt(mx);
//                dos.writeInt(my);
dos.write(mx_list);
dos.write(my_list);

System.out.println("데이터 입력");
//3. close()
socket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}

class ServerExitThread extends Thread
{
@Override
public void run() {
super.run();
//1. Socket class 생성-> ip, port
try {
Socket socket = new Socket("172.18.228.52", 9712);

//2. DataInputStream(), DataOutputStream
DataInputStream dis = new DataInputStream(socket.getInputStream());
DataOutputStream dos = new 
DataOutputStream(socket.getOutputStream());

dos.writeInt(SERVER_EXIT);

//3. close()
socket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

met_X = findViewById(R.id.editText);
met_Y = findViewById(R.id.editText2);
mbtn_move = findViewById(R.id.button2);
mbtn_quit = findViewById(R.id.button);

mbtn_move.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
NetworkThread thread = new NetworkThread();
thread.start();
}
});

mbtn_quit.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
ServerExitThread thread = new ServerExitThread();
thread.start();
}
});

}
}
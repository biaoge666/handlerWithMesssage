package com.example.activitystudy;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String LOG="MainActivity";
    public static final int MES=1;
    private TextView textView;
    private ImageView imageView;
    public   Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
           switch (msg.what){
               case MES:
                  Real real2= (Real) msg.obj;
                  textView.setText(real2.getText());
                  imageView.setImageBitmap(real2.getBitmap());
                   Log.d(LOG,"handle");
                   break;
                   default:
                       break;
           }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG,"onCreate");
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);
        imageView=findViewById(R.id.imageView);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message=new Message();
                        Log.d(LOG,"enter");
                        Real real=new Real();
                        String data="子线程中得到的数据";
                        real.setText(data);
                        real.setBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.timg));
                        Log.d("Log",data);
                        message.obj=real;
                        message.what=MES;
                        try {
                            Log.d(LOG,"unsend");
                            Thread.sleep(3000);
                            Log.d(LOG,"send");
                            handler.sendMessage(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

    }
}

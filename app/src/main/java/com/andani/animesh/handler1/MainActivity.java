package com.andani.animesh.handler1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;


public class MainActivity extends Activity {
Thread thread;
    Handler handler;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thread=new Thread(new MyThread());
        thread.start();
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        handler=new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
              //  super.handleMessage(msg);
                progressBar.setProgress(msg.arg1);
            }
        };
    }
    class MyThread implements Runnable
    {

        @Override
        public void run()
        {


            for (int i=0;i<100;i++)
            {
                Message message=Message.obtain();
                message.arg1=i;

                handler.sendMessage(message);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

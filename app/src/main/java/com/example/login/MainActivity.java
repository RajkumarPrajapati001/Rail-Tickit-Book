package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td = new Thread(){

            public void run(){

                try {
                    sleep(2000);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(MainActivity.this , HomeScreen.class);
                    startActivity(intent);
                    finish();
                }
            }

        };td.start();
    }
}
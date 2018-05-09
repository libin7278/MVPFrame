package com.xzxj.mvpframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xzxj.frame.widget.Snacker;
import com.xzxj.frame.widget.Toaster;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Snacker.with(MainActivity.this).setMessage("警告").warning().show();

        Toaster.with(MainActivity.this).setMessage("上传成功").show();

    }
}

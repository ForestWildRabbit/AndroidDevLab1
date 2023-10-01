package com.example.firstlabapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getIntent().getExtras();

        if(arguments != null) {

            if (arguments.containsKey("color")){
                Integer color = (Integer) arguments.getInt("color");
                View layout = this.getWindow().getDecorView().findViewById(android.R.id.content);
                layout.setBackgroundColor(color);
            }

        }

        setContentView(R.layout.activity_second);
    }

}
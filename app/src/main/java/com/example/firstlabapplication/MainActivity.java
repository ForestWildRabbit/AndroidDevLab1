package com.example.firstlabapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashSet;


public class MainActivity extends Activity {
    String[] VALID_COLORS = new String[]{"red", "green", "blue"};
    Button confirmButton;
    TextView textView;
    EditText editText;

    HashSet<String> validColorsHashSet = new HashSet<String>(Arrays.asList(VALID_COLORS));

    public void confirmEditTextValues(View view){
        textView = (TextView)findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        String userInput = editText.getText().toString();
        if (validColorsHashSet.contains(userInput)){
            textView.setText(userInput);
        }
        else{
            StringBuilder errorText = new StringBuilder("Valid colors are ");
            for(String inputValue : validColorsHashSet){
                errorText.append(inputValue).append(", ");
            }
            errorText.delete(errorText.length() - 2, errorText.length());
            errorText.append(".");
            textView.setText(errorText);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }


    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Called onStart()", Toast.LENGTH_LONG).show();
        Log.d("State", "Called onStart()");
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Called onResume()", Toast.LENGTH_LONG).show();
        Log.d("State", "Called onResume()");
    }

    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Called onPause()", Toast.LENGTH_LONG).show();
        Log.d("State", "Called onPause()");
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Called onStop()", Toast.LENGTH_LONG).show();
        Log.d("State", "Called onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Called onDestroy()", Toast.LENGTH_LONG).show();
        Log.d("State", "Called onDestroy()");
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Called onRestart()", Toast.LENGTH_LONG).show();
        Log.d("State", "Called onRestart()");
    }

}


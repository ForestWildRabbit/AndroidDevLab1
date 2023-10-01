package com.example.firstlabapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class MainActivity extends Activity {
    public String APP_NAME = "First Lab";
    String[] VALID_COLORS = new String[]{"red", "green", "blue"};
    Map<String, Integer> HASHMAP_COLORS = new HashMap<String, Integer>();
    TextView textView;
    EditText editText;

    HashSet<String> validColorsHashSet = new HashSet<String>(Arrays.asList(VALID_COLORS));

    public void confirmEditTextValues(View view){
        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        String userInput = editText.getText().toString().trim();
        if (validColorsHashSet.contains(userInput)){
            textView.setText(userInput);
            Intent eIntent = new Intent(MainActivity.this, SecondActivity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                eIntent.putExtra("color", HASHMAP_COLORS.getOrDefault(userInput, Color.WHITE));
            }
            startActivity(eIntent);
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
        HASHMAP_COLORS.put("red", Color.RED);
        HASHMAP_COLORS.put("green", Color.GREEN);
        HASHMAP_COLORS.put("blue", Color.BLUE);
    }


    protected void onRestart() {
        super.onRestart();
        textView = findViewById(R.id.text_view);
        textView.setText(APP_NAME);
        editText = findViewById(R.id.edit_text);
        editText.getText().clear();
    }

}


package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class CanvasActivity extends AppCompatActivity {

    ConstraintLayout cLayout;
    TextView colorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        // NOTE: I guess a betteer way to do this would have been by sending another "extra" value
        // in with the intent that starts this activity (similar to what we did with color_selected)
        // but have it give the POSITION of that value in the string-array, etc...

        Intent startIntent = getIntent();
        String colorRecieved = startIntent.getStringExtra("color_selected");

        Resources res = getResources();
        String colorsArray[] = res.getStringArray(R.array.color_array);
        ArrayList<String> tempVals = new ArrayList<String>(Arrays.asList(colorsArray));
        int position = tempVals.indexOf(colorRecieved.toUpperCase());

        cLayout = findViewById(R.id.constraintLayout);
        colorText = findViewById(R.id.colorTextView);
        colorText.setText(colorRecieved.toUpperCase());

        Locale locale = new Locale("en");
        Configuration config = getApplicationContext().getResources().getConfiguration();
        config = new Configuration(config);
        config.setLocale(locale);
        Context localizedContext = getApplicationContext().createConfigurationContext(config);
        Resources enResources = localizedContext.getResources();

        String colorsArrayEn[] = enResources.getStringArray(R.array.color_array); // Sets the values in the string_array values file in res to this
        cLayout.setBackgroundColor(Color.parseColor(colorsArrayEn[position].toLowerCase()));
    }
}
package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class PaletteActivity extends AppCompatActivity {

    private int CODE = 11;

    // Our structures to be set in onCreate() method
    ArrayList<String> colors;
    GridView gridView;
    TextView textView;
    Locale localeEn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();

        String colorsArray[] = res.getStringArray(R.array.color_array); // Sets the values in the string_array values file in res to this
        System.out.println("COLORS ARRAY: " + Arrays.toString(colorsArray));

        colors = new ArrayList<String>(Arrays.asList(colorsArray));
        gridView = findViewById(R.id.colorGrid);
        textView = findViewById(R.id.greeting);
        textView.setText(R.string.choose_color); // Sets the greeting message/instruction message

        final BaseAdapter adapter = new ColorAdapter(this, colors);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object selectedThing = adapterView.getItemAtPosition(i);
                // textView.setText(selectedThing.toString().toLowerCase());

                Intent canvasActivityIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                canvasActivityIntent.putExtra("color_selected", (selectedThing.toString().toLowerCase()));
                startActivity(canvasActivityIntent); // this will switch to the target specified here ^^^ in our Intent creation and switch to it.
            }
        });

    }
}
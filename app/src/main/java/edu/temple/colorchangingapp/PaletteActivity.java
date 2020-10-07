package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class PaletteActivity extends AppCompatActivity {

    private int CODE = 11;

    // Our structures to be set in onCreate() method
    ArrayList<String> colors;
    GridView gridView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors = new ArrayList();
        gridView = findViewById(R.id.colorGrid);
        textView = findViewById(R.id.greeting);

        colors.add("WHITE");
        colors.add("GREY");
        colors.add("FUCHSIA");
        colors.add("RED");
        colors.add("YELLOW");
        colors.add("LIME");
        colors.add("GREEN");
        colors.add("CYAN");
        colors.add("BLUE");

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
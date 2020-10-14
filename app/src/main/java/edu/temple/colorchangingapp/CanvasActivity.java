package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    ConstraintLayout cLayout;
    TextView colorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent startIntent = getIntent();
        String colorRecieved = startIntent.getStringExtra("color_selected");

        Resources res = getResources();
        String colorsArray[] = res.getStringArray(R.array.color_array);

        cLayout = findViewById(R.id.constraintLayout);
        colorText = findViewById(R.id.colorTextView);
        colorText.setText(colorRecieved.toUpperCase());
        cLayout.setBackgroundColor(Color.parseColor(colorRecieved));
    }
}
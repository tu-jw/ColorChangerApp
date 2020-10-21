package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

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

        PaletteFragment paletteFragment = new PaletteFragment();
        //CanvasFragment canvasFragment = new CanvasFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.container_1, paletteFragment).commit(); // attaching the fragment to the activity. A fragment needs an activity to be able to function/do things





        /* Old Logic:

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

                //Intent canvasActivityIntent = new Intent(MainActivity.this, CanvasActivity.class);
                //canvasActivityIntent.putExtra("color_selected", (selectedThing.toString().toLowerCase()));
                //startActivity(canvasActivityIntent); // this will switch to the target specified here ^^^ in our Intent creation and switch to it.
            }
        });
         */

    }
}

/* NOTES:
    - When we put the fragment in, it's gonna be set up differently from the way our activity was.
    - We put a FrameLayout in our MainActivity, and that will be used as the container to hold our
      fragment to display colors, etc.

    - To actually call in the fragment we made, we do the following:
        - After the fragment is actually made (right click our edu.temple.colorchangingapp folder)
          and hit "new" > Fragment > fragment(blank)), we can reference to it by instantiating it as
          an object, i.e. FragmentClassName myFragment = new FragmentClassName();
        - We then get a reference to a fragment manager, i.e.:
              FragmentManager fm = new getSupportFragmentManager();
        - Then begin a FragmentTransaction...:
              FragmentTransaction ft = fm.beginTransaction();
        - Then we begin the process of adding a fragment to our activity. We do this with the following
          command :     ft.add(R.id.container_1, myFragment).commit(); // make sure to select the one with the "container" option! (container_1 is the id name of our FrameLayout)
 */
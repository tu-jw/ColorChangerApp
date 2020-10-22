package edu.temple.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements PaletteFragment.ColorChosenInterface {

    // Our structures to be set in onCreate() method
    PaletteFragment paletteFragment;
    CanvasFragment canvasFragment;
    String currentColorChosen;
    String[] colorArr;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        constraintLayout = findViewById(R.id.constraintLayoutID);

        colorArr = getResources().getStringArray(R.array.color_array);

        //paletteFragment = new PaletteFragment();
        paletteFragment = PaletteFragment.newInstance(colorArr);
        //canvasFragment = new CanvasFragment();
        canvasFragment = CanvasFragment.newInstance(colorArr); // finish off

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.container_1, paletteFragment); // attaching the fragment to the activity. A fragment needs an activity to be able to function/do things
        ft.add(R.id.container_2, canvasFragment).commit();

    }

    // This is the method that was implemented from the interface within our PaletteFragment
    @Override
    public void colorChosen() {
        currentColorChosen = paletteFragment.GetColorSelected(); // whenever the "colorChosen" method is invoked from within our paletteFragment, we set the current chosen color equal to whatever was chosen from the palette
        //textView.setText(currentColorChosen.toUpperCase());
        String tempEnglishColorReturned = canvasFragment.setColor(currentColorChosen).toLowerCase();
        constraintLayout.setBackgroundColor(Color.parseColor(tempEnglishColorReturned));
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
package edu.temple.colorchangingapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;


// This will be the "master" fragment
public class PaletteFragment extends Fragment {

    Context thisContext;
    View layout;

    public PaletteFragment() {
        // Required empty public constructor
    }

    // For a Fragment, this is essentially equivalent to an Activity's "onCreate". Frags have those too, but onCreateView is where we will be manipulating all of the View elements for our fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisContext = getContext();
        // Inflate the layout for this fragment
        layout =  inflater.inflate(R.layout.fragment_palette, container, false);

        String colorsArray[] = getResources().getStringArray(R.array.color_array); // Sets the values in the string_array values file in res to this ... (2) Changed "res." to "getResources()"
        System.out.println("COLORS ARRAY: " + Arrays.toString(colorsArray));

        ArrayList<String> colors = new ArrayList<String>(Arrays.asList(colorsArray));
        GridView gridView = layout.findViewById(R.id.colorGrid);

        final BaseAdapter adapter = new ColorAdapter(thisContext, colors);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object selectedThing = adapterView.getItemAtPosition(i);
                // textView.setText(selectedThing.toString().toLowerCase());
                System.out.println("\n\nColor (def): " + selectedThing.toString().toLowerCase() + "\n\n");

                //Intent canvasActivityIntent = new Intent(MainActivity.this, CanvasActivity.class);
                //canvasActivityIntent.putExtra("color_selected", (selectedThing.toString().toLowerCase()));
                //startActivity(canvasActivityIntent); // this will switch to the target specified here ^^^ in our Intent creation and switch to it.

                // CHANGE THE COLOR OF THE BACKGROUND OF THE OTHER FRAGMENT, AS WELL AS THE OTHER FRAGMENT'S TEXT TO MATCH THE NAME OF THE COLOR SELECTED
            }
        });

        return layout;
    }
}

// In fragments, there is not findViewById -- we have to look for the View that we want INSIDE OF the layout file directly
//      So, for example, if we had a TextView (with name id = textView) in our fragment_palette.xml, we would have to reference our layout first (called "layout" above),
//      and THEN we would use findViewById... ex:
//                          TextView textView = layout.findViewById(R.id.textView);
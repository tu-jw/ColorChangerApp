package edu.temple.colorchangingapp;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

// This is the "details" fragment
public class CanvasFragment extends Fragment {

    Context thisContext;
    TextView textView;
    View layout;
    String realColorArray[];
    private final static String pKey = "paramV";

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            realColorArray = bundle.getStringArray(pKey);
        }
        System.out.println("CanvasFragment color array: " + Arrays.toString(realColorArray));
    }

    public static CanvasFragment newInstance(String[] paramV){
        CanvasFragment cFragment = new CanvasFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray(pKey, paramV);
        cFragment.setArguments(bundle);
        return cFragment;
    }

    // For a Fragment, this is essentially equivalent to an Activity's "onCreate". Frags have those too, but onCreateView is where we will be manipulating all of the View elements for our fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisContext = getContext();
        layout = inflater.inflate(R.layout.fragment_canvas, container, false);
        textView = layout.findViewById(R.id.greeting); // sets the textView equal to our greeting text
        textView.setText("Colour:");

        // Receive the color selected from the adapter in the other fragment (palette fragment) and set the text = that... Also set the background color = that. Handle French

        // Inflate the layout for this fragment
        return layout;
    }

    public String setColor(String color){
        // this will be called by the parent. it changes the color value specified here.
        // it must make sure to call back to the parent to return the literal color value for parseColor (which would just be the lowercase English value)
        String toReturn;
        ArrayList<String> tempVals = new ArrayList<>(Arrays.asList(realColorArray));
        int position = tempVals.indexOf(color.toUpperCase());

        textView.setText(color.toUpperCase());

        Locale locale = new Locale("en");
        Configuration config = thisContext.getResources().getConfiguration();
        config = new Configuration(config);
        config.setLocale(locale);
        Context localizedContext = thisContext.createConfigurationContext(config); // a bit different from prev assignment's use of this. May cause issues?
        Resources enResources = localizedContext.getResources();

        String colorsArrayEn[] = enResources.getStringArray(R.array.color_array);
        toReturn = colorsArrayEn[position].toLowerCase(); // sends back the PARSEABLE version (lowercase & English)

        return toReturn;
    }

}
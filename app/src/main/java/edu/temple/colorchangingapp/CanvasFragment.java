package edu.temple.colorchangingapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// This is the "details" fragment
public class CanvasFragment extends Fragment {

    Context thisContext;
    TextView textView;
    View layout;

    public CanvasFragment() {
        // Required empty public constructor
    }

    // For a Fragment, this is essentially equivalent to an Activity's "onCreate". Frags have those too, but onCreateView is where we will be manipulating all of the View elements for our fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thisContext = getContext();
        layout = inflater.inflate(R.layout.fragment_canvas, container, false);
        textView = layout.findViewById(R.id.greeting); // sets the textView equal to our greeting text
        textView.setText("Choose a color!");

        // Receive the color selected from the adapter in the other fragment (palette fragment) and set the text = that... Also set the background color = that. Handle French

        // Inflate the layout for this fragment
        return layout;
    }
}
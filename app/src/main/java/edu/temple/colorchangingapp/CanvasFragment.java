package edu.temple.colorchangingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// This is the "details" fragment
public class CanvasFragment extends Fragment {


    public CanvasFragment() {
        // Required empty public constructor
    }

    // For a Fragment, this is essentially equivalent to an Activity's "onCreate". Frags have those too, but onCreateView is where we will be manipulating all of the View elements for our fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_canvas, container, false);
    }
}
package edu.temple.colorchangingapp;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class ColorAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    Locale locale;

    public ColorAdapter(Context context, ArrayList<String> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        textView.setText(getItem(position).toString());

        /*locale = new Locale("en");
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale); */

        textView.setBackgroundColor(Color.parseColor(getItem(position).toString().toLowerCase()));
        return textView;
    }
}

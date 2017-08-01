package com.thesnowgoose.androidlayoutexamples;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = (LinearLayout) findViewById(R.id.background);
    }

    public void onClicked(View view) {
        String text = view.getId() == R.id.view1 ? "Green" : "Orange";

        if (view.getId() == R.id.view1) {
            background.setBackgroundColor(
                    ResourcesCompat.getColor(getResources(), android.R.color.holo_green_light, null));
        } else if (view.getId() == R.id.view2) {
            background.setBackgroundColor(
                    ResourcesCompat.getColor(getResources(), android.R.color.holo_orange_dark, null));
        }
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}

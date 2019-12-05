package com.android.application;


import android.os.Bundle;
import android.app.Activity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    protected int count = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We use a LinearLayout object as the root view object.
        LinearLayout rootView = new LinearLayout(this);
        // Set root view properties such as background color, gravity and orientation.
        //rootView.setBackgroundColor(Color.GREEN);
        // Display child view in center both horizontal and vertical.
        rootView.setGravity(Gravity.CENTER);
        // Align child view in horizontal direction.
        rootView.setOrientation(LinearLayout.HORIZONTAL);
        // Create a LinearLayout parames object.
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(10,10, 10,10);
        // Use LinearLayout object as root view
        setContentView(rootView, layoutParams);

        final TextView text = new TextView(this);
        text.setId(R.id.id_label);
        rootView.addView(text);
        // Create a button.
        final Button button = new Button(this);
        // Set submit button id from resource file.
        button.setId(R.id.id_button);
        // Set button text by string resource id.
        button.setText(getString(R.string.button_str));
        // Show button text by original character case.
        button.setAllCaps(false);
        // Add button to the root view.
        rootView.addView(button);

        // When this button is clicked.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(String.format(getString(R.string.label_str), incrementAndGet()));
            }
        });
    }

    public int incrementAndGet() {
        this.count++;
        return this.count;
    }
}
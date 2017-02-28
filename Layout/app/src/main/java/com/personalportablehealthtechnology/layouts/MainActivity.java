package com.personalportablehealthtechnology.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter;
    Button add;
    Button subtract;
    TextView display;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int count = 0;
        add = (Button) findViewById(R.id.plus_button);
        subtract = (Button) findViewById(R.id.minus_button);
        display = (TextView) findViewById(R.id.title);


        add.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter++;
                display.setText("The score is: " + counter);

            }
        });


        subtract.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                counter--;
                display.setText("The score is: " + counter);
            }
        });

    }

}

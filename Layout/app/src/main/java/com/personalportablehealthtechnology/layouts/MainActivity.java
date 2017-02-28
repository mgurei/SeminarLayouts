package com.personalportablehealthtechnology.layouts;

import android.app.Dialog;
import android.content.Context;
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
    final Context context = this;

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


                if(counter == 10) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dialog_demo);
                    dialog.setTitle(R.string.dialog_title);

                    dialog.setContentView(R.layout.dialog_demo);
                    Button agreeButton = (Button) dialog.findViewById(R.id.dialog_ok);
                    Button cancelButton = (Button) dialog.findViewById(R.id.dialog_cancel);

                    agreeButton.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View k) {
                            counter = 0;
                            display.setText("The score is: " + counter);
                            dialog.dismiss();
                        }
                    });

                    cancelButton.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View k) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
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

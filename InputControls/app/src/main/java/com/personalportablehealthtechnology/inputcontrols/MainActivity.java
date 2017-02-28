package com.personalportablehealthtechnology.inputcontrols;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button end;
    EditText name;
    EditText surname;
    AutoCompleteTextView country;
    EditText pswd;
    String[] countries;
    public Context context = this;
    CheckBox color1;
    CheckBox color2;
    CheckBox color3;

    String Name;
    String Surname;
    String Country;
    String Password;
    String[] Color = {"", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.edit_name);
        surname = (EditText) findViewById(R.id.edit_surname);
        pswd = (EditText) findViewById(R.id.edit_password);

        handleCountry();

        color1 = (CheckBox) findViewById(R.id.checkbox_color1);
        color2 = (CheckBox) findViewById(R.id.checkbox_color2);
        color3 = (CheckBox) findViewById(R.id.checkbox_color3);

        color1.setOnClickListener(new View.OnClickListener(){
            //@Override
            public void onClick(View v) {
                if (color1.isChecked())
                    Color[0] = "red";
                else
                    Color[0] = "";
            }
        });
        color2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (((CheckBox) v).isChecked()) {
                    Color[1] = "blue";
                } else
                    Color[1] = "";
            }
        });

        color3.setOnClickListener(new View.OnClickListener(){
           // @Override
            public void onClick(View v) {
                if (color1.isChecked())
                    Color[2] = "yellow";
                else
                    Color[2] = "";
            }
        });

        end = (Button) findViewById(R.id.end);
        end.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Name = name.getText().toString();
                Surname = surname.getText().toString();
                Country = country.getText().toString();
                Password = pswd.getText().toString();

                if (Name.matches("")) {
                    Toast.makeText(context, R.string.generic_error, Toast.LENGTH_SHORT).show();
                } else if (Surname.matches("")) {
                    Toast.makeText(context, R.string.generic_error, Toast.LENGTH_SHORT).show();
                } else if (Country.matches("")) {
                    Toast.makeText(context, R.string.generic_error, Toast.LENGTH_SHORT).show();
                } else if (Password.matches("")) {
                    Toast.makeText(context, R.string.generic_error, Toast.LENGTH_SHORT).show();
                } else if (Color[0].matches("")) {
                    if (Color[1].matches("")){
                        if (Color[2].matches("")){
                            Toast.makeText(context, R.string.generic_error, Toast.LENGTH_LONG).show();
                        }
                        else {
                            String s = (String) "The input is: " + Name + " " + Surname + " living in "
                                    + Country + " password is " + Password + "and color is " + Color[2];
                            Toast.makeText(context, s, Toast.LENGTH_LONG).show();
                        }
                    } else {
                        String s = (String) "The input is: " + Name + " " + Surname + " living in "
                                + Country + " password is " + Password + "and color is" + Color[1];
                        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
                    }
                }else {
                    String s = (String) "The input is: " + Name + " " + Surname + " living in "
                            + Country + " password is " + Password + " and color is" + Color[0];
                    Toast.makeText(context, s, Toast.LENGTH_LONG).show();
                }
            }

        });
    }


    public void handleCountry(){

        country = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);

        countries = getResources().getStringArray(R.array.countries_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,countries);
        country.setAdapter(adapter);
        country.setThreshold(1);

        country.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(country.getWindowToken(), 0);
            }
        });

    }


}


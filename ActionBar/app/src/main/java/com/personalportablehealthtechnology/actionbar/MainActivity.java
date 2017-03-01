package com.personalportablehealthtechnology.actionbar;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search1);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);

        switch (menuItem.getItemId()) {

            case R.id.action_go_to_child:
                Intent i = new Intent(getApplicationContext(),second_activity.class);
                startActivity(i);
                setContentView(R.layout.child_activity);

                return true;
            case R.id.action_search1:
                Toast.makeText(context, R.string.press_search, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search2:
                Toast.makeText(context, R.string.press_search, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search3:
                Toast.makeText(context, R.string.press_search, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search4:
                Toast.makeText(context, R.string.press_search, Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_settings:
                Toast.makeText(context, R.string.press_settings, Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}

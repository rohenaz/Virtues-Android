package com.listfist.virtue;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private AppPreferences _appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("junk", "Let there be light...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, VirtueSurvey.class);
                    MainActivity.this.startActivity(intent);

                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

        _appPrefs = new AppPreferences(getApplicationContext());
        final String activeVirtue = _appPrefs.getActiveVirtue();
        Log.d("junk", "Active virtue is " + activeVirtue);
        TextView yourVirtue = (TextView) findViewById(R.id.yourVirtue);
        TextView goal = (TextView) findViewById(R.id.goalTxt);
        String goaltxt;
        switch(activeVirtue) {
            case "1":
                yourVirtue.setText(getResources().getString(R.string.v1_title));
                goaltxt = goal.getText().toString();
                goal.setText(goaltxt.replaceAll("\\bTemperance\\b", getResources().getString(R.string.v1_title)));
                goaltxt = goal.getText().toString();
                goal.setText(goaltxt.replaceAll("\\bfirst\\b", "second"));
                break;
            case "2":
                yourVirtue.setText(getResources().getString(R.string.v2_title));
                goaltxt = goal.getText().toString();
                goal.setText(goaltxt.replaceAll("\\bTemperance\\b", getResources().getString(R.string.v2_title)));
                goaltxt = goal.getText().toString();
                goal.setText(goaltxt.replaceAll("\\bfirst\\b", "second"));
                break;
            case "3":
                yourVirtue.setText(getResources().getString(R.string.v3_title));
                goaltxt = goal.getText().toString();
                goal.setText(goaltxt.replaceAll("\\bTemperance\\b", getResources().getString(R.string.v3_title)));
                goaltxt = goal.getText().toString();
                goal.setText(goaltxt.replaceAll("\\bfirst\\b", "second"));
                break;
            default:
                break;
        }

    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d("junk", "Resuming...");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("junk", "Create options menu...");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("junk", "Menu Item Selected...");
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            MainActivity.this.startActivity(intent);
            return true;
        }
        if (id == R.id.action_progress) {
            Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
            MainActivity.this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static int getHour(String time) {

        if(time!="") {
            String[] pieces = time.split(":");

            return (Integer.parseInt(pieces[0]));
        }
        else {
            return 0;
        }
    }

    public static int getMinute(String time) {
            if(time!=null) {
                String[] pieces = time.split(":");

                return (Integer.parseInt(pieces[1]));
            }
            else {
                return 0;
            }
        }

}


package javainside.com.daggertest.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import javainside.com.daggertest.DaggerTestApp;
import javainside.com.daggertest.R;
import javainside.com.daggertest.di.IDaggerTestComponent;
import javainside.com.daggertest.model.ImageModel;
import javainside.com.daggertest.model.Speaker;

public class MainActivity extends AppCompatActivity {


    Speaker speaker;

    @Inject
    ImageModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        IDaggerTestComponent component = DaggerTestApp.component(this);
        component.inject(this);

        speaker = component.speaker();
        ImageView view = (ImageView) findViewById(R.id.image);
        model.downloadTask(view);

        TextView text = (TextView) findViewById(R.id.text);
        text.setText(speaker.getName() + "\n" + speaker.getSpeech());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

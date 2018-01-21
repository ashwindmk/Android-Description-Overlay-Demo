package com.ashwin.example.descriptionoverlaydemo;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ashwin.descriptionoverlay.DescriptionOverlayConfig;
import com.ashwin.descriptionoverlay.DescriptionOverlaySequence;
import com.ashwin.descriptionoverlay.shapes.CircleShape;

public class MainActivity extends AppCompatActivity {

    private View mInfoView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                mInfoView = findViewById(R.id.info);
                showDescription();
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                Toast.makeText(getApplicationContext(), "Info Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.help:
                Toast.makeText(getApplicationContext(), "Help Selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showDescription() {
        DescriptionOverlayConfig descriptionConfig = new DescriptionOverlayConfig();
        descriptionConfig.setDelay(200);
        descriptionConfig.setShape(new CircleShape());
        descriptionConfig.setMaskColor(Color.parseColor("#888888"));

        DescriptionOverlaySequence descriptionSequence = new DescriptionOverlaySequence(this);
        descriptionSequence.setConfig(descriptionConfig);
        descriptionSequence.addSequenceItem(mInfoView, "Info", "This will give you more information", "GOT IT");
        descriptionSequence.addSequenceItem(mTextView, "Text", "This is a simple text", "DONE");
        descriptionSequence.start();
    }
}

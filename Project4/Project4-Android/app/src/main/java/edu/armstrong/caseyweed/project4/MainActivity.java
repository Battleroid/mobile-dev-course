package edu.armstrong.caseyweed.project4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Project 4 - Choose");
    }

    public void startRotate(View v) {
        Intent i = new Intent(this, RotateActivity.class);
        startActivity(i);
    }

    public void startScale(View v) {
        Intent i = new Intent(this, ScaleActivity.class);
        startActivity(i);
    }
}

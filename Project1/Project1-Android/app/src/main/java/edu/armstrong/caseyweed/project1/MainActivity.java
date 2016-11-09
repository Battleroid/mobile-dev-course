package edu.armstrong.caseyweed.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int seq = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numField = (TextView) findViewById(R.id.numField);
        numField.setText("1");
    }

    public void onNext(View v) {
        ((TextView) findViewById(R.id.numField)).setText("" + fib(++seq));
    }

    public void onReset(View v) {
        seq = 2;
        ((TextView) findViewById(R.id.numField)).setText("1");
    }

    private int fib(int n) {
        if (n < 2) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}

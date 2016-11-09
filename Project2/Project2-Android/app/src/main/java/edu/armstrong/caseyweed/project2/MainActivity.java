package edu.armstrong.caseyweed.project2;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView randValue;
    RC4 r = new RC4(new int[] {1, 3, 5});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randValue = (TextView) findViewById(R.id.randValue);
        randValue.setTypeface(Typeface.MONOSPACE);
        randValue.setText("" + r.next());
    }

    public void generate(View v) {
        randValue.setText("" + r.next());
    }
}

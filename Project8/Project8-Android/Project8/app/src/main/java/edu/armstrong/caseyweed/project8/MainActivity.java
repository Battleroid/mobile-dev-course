package edu.armstrong.caseyweed.project8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    YinYangView yyv1;
    YinYangView yyv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init
        yyv1 = (YinYangView) findViewById(R.id.yyv1);
        yyv2 = (YinYangView) findViewById(R.id.yyv2);

        // just move them so they're initially visible
        yyv1.move(200, 200);
        yyv2.move(500, 200);
    }

}

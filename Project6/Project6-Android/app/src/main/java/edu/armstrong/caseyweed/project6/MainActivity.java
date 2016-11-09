package edu.armstrong.caseyweed.project6;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView numTv;
    EditText numInput;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numTv = (TextView) findViewById(R.id.numTv);
        numTv.setMovementMethod(new ScrollingMovementMethod());
        numInput = (EditText) findViewById(R.id.numInput);
    }

    public void startSearch(View v) {
        int limit = Integer.parseInt(String.valueOf(numInput.getText()));
        if (limit <= 2) {
            Toast.makeText(this, "Limit too low!", Toast.LENGTH_SHORT).show();
            return;
        }

        numTv.setText("Twins:");
        startTwinPrimeSearch(limit);
    }

    private void startTwinPrimeSearch(final int limit) {
        TwinPrimes task = new TwinPrimes();
        task.execute(limit);
    }

    private boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        return count == 2;
    }

    class TwinPrimes extends AsyncTask<Integer, Void, String> {

        @Override
        protected String doInBackground(Integer... n) {
            System.out.println("Started background task");
            String result = "";
            int total = 0;

            for (int i = 1; i <= (n[0] - 2); i++) {
                if (isPrime(i) && isPrime(i + 2)) {
                    result += " [" + i + ", " + (i + 2) + "]";
                    total++;
                }
            }

            result += " Total: " + total;
            return result;
        }

        protected void onPostExecute(String result) {
            numTv.append(result);
        }
    }
}

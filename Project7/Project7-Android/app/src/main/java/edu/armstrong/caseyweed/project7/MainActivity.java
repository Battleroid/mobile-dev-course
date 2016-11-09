package edu.armstrong.caseyweed.project7;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    // Controls
    EditText cityTxt;
    TextView descTxt;
    TextView humidityTxt;
    TextView windTxt;
    TextView tempTxt;

    // API
    final static String API_KEY = "0a1a045b3802454c4d7f8feb00ba74f7";
    final static String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&APPID=%s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityTxt = (EditText) findViewById(R.id.cityTxt);
        descTxt = (TextView) findViewById(R.id.descTxt);
        humidityTxt = (TextView) findViewById(R.id.humidityTxt);
        windTxt = (TextView) findViewById(R.id.windTxt);
        tempTxt = (TextView) findViewById(R.id.temperatureTxt);
    }

    public void getWeather(View v) {
        WeatherTask task = new WeatherTask();
        task.execute(String.format(API_URL, cityTxt.getText(), API_KEY));
    }

    class WeatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            return fetchURL(params[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject json = new JSONObject(result);

                String description = json.getJSONArray("weather").getJSONObject(0).getString("description");
                int humidity = json.getJSONObject("main").getInt("humidity");
                Double temperature = json.getJSONObject("main").getDouble("temp");
                Double wind = json.getJSONObject("wind").getDouble("speed");

                descTxt.setText(description.substring(0, 1).toUpperCase() + description.substring(1));
                humidityTxt.setText(humidity + "%");
                tempTxt.setText("" + temperature);
                windTxt.setText("" + wind);
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Problem fetching weather!", Toast.LENGTH_SHORT).show();
                clear();
            }
        }
    }

    private void clear() {
        descTxt.setText("");
        humidityTxt.setText("");
        tempTxt.setText("");
        windTxt.setText("");
    }

    private static String fetchURL(String loc) {
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(loc);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}

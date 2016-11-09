package edu.armstrong.caseyweed.project3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView spinnerImageView;
    RotateAnimation rotAnim;
    static boolean spinning = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create animation
        rotAnim = new RotateAnimation(0, 359, RotateAnimation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotAnim.setInterpolator(new LinearInterpolator());
        rotAnim.setDuration(1000); // in milliseconds
        rotAnim.setRepeatCount(Animation.INFINITE);

        // add animation and adjust size
        spinnerImageView = (ImageView) findViewById(R.id.spinnerImageView);
        spinnerImageView.setImageDrawable(getDrawable(R.drawable.spinning_thing));
        spinnerImageView.setMinimumHeight(500);
        spinnerImageView.setMinimumWidth(500);

        // start
        spinnerImageView.startAnimation(rotAnim);
    }

    public void toggleSpin(View v) {
        if (spinning) {
            spinning = false;
            spinnerImageView.clearAnimation();
        } else {
            spinning = true;
            spinnerImageView.startAnimation(rotAnim);
        }
    }
}

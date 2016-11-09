package edu.armstrong.caseyweed.project4;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class RotateActivity extends AppCompatActivity {

    ImageView iv;
    Switch rotToggle;
    ObjectAnimator oa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        setTitle("Rotate");

        iv = (ImageView) findViewById(R.id.targetRotate);
        rotToggle = (Switch) findViewById(R.id.rotateToggle);
        oa = new ObjectAnimator().ofFloat(iv, "rotation", 360f);
        oa.setDuration(1000);
        oa.setRepeatCount(ObjectAnimator.INFINITE);
        oa.setRepeatMode(ObjectAnimator.RESTART);
        oa.setInterpolator(new LinearInterpolator());

        rotToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    oa.start();
                } else {
                    oa.cancel();
                }
            }
        });
    }

}

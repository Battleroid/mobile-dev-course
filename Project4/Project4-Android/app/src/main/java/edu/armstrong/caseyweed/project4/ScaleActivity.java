package edu.armstrong.caseyweed.project4;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class ScaleActivity extends AppCompatActivity {

    ImageView iv;
    Switch scaleToggle;
    ObjectAnimator oaScaleX;
    ObjectAnimator oaScaleY;
    AnimatorSet animScaleXY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        setTitle("Scale");

        iv = (ImageView) findViewById(R.id.targetScale);
        scaleToggle = (Switch) findViewById(R.id.scaleToggle);

        // anim
        oaScaleX = new ObjectAnimator().ofFloat(iv, "scaleX", 2f);
        oaScaleY = new ObjectAnimator().ofFloat(iv, "scaleY", 2f);

        oaScaleX.setDuration(1000);
        oaScaleX.setRepeatCount(ObjectAnimator.INFINITE);
        oaScaleX.setRepeatMode(ObjectAnimator.REVERSE);
        oaScaleX.setInterpolator(new LinearInterpolator());

        oaScaleY.setDuration(1000);
        oaScaleY.setRepeatCount(ObjectAnimator.INFINITE);
        oaScaleY.setRepeatMode(ObjectAnimator.REVERSE);
        oaScaleY.setInterpolator(new LinearInterpolator());

        animScaleXY = new AnimatorSet();
        animScaleXY.playTogether(oaScaleX, oaScaleY);

        scaleToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    animScaleXY.start();
                } else {
                    animScaleXY.cancel();
                }
            }
        });

    }
}

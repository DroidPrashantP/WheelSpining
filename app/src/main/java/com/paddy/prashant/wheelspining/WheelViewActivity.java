package com.paddy.prashant.wheelspining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

public class WheelViewActivity extends AppCompatActivity {

    private WheelMenu wheelMenu;
    private TextView selectedPositionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_view);


        wheelMenu = (WheelMenu) findViewById(R.id.wheelMenu);

        wheelMenu.setDivCount(12);
        wheelMenu.setWheelImage(R.drawable.wheel);

        selectedPositionText = (TextView) findViewById(R.id.selected_position_text);
        selectedPositionText.setText("selected: " + (wheelMenu.getSelectedPosition() + 1));

        wheelMenu.setWheelChangeListener(new WheelMenu.WheelChangeListener() {
            @Override
            public void onSelectionChange(int selectedPosition) {
                selectedPositionText.setText("selected: " + (selectedPosition + 1));
            }
        });

        RotateAnimation rAnim = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rAnim.setDuration(1000);
        wheelMenu.startAnimation(rAnim);
    }

}

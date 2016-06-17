package com.eugeneek.smilebar_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.eugeneek.smilebar.SmileBar;

public class MainActivity extends AppCompatActivity implements SmileBar.OnRatingSliderChangeListener {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        final SmileBar smileBar = (SmileBar) findViewById(R.id.starBar);
        smileBar.setOnRatingSliderChangeListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "Rating before is " + smileBar.getRating();
                if (smileBar.getRating() >= 5)
                    smileBar.setRating(0);
                else
                    smileBar.setRating(smileBar.getRating() + 1);
                s += " and after is " + smileBar.getRating();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onPendingRating(int rating) {
        Log.i("onPendingRating", "" + rating);
        btn.setText("" + rating);
    }

    @Override
    public void onFinalRating(int rating) {
        Log.i("onFinalRating", "" + rating);
        btn.setText("" + rating);
    }

    @Override
    public void onCancelRating() {
        Log.i("onCancelRating", "cancel");
    }
}

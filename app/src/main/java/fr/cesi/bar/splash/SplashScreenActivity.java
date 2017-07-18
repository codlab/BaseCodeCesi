package fr.cesi.bar.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import fr.cesi.basecode.R;
import fr.cesi.bar.map.MapsActivity;


public class SplashScreenActivity extends AppCompatActivity {

    private Handler _handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        _handler = new Handler();
        _handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startNextActivity();
            }
        },3000);
    }
    private void startNextActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

        finish();
    }
}

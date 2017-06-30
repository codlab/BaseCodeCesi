package fr.cesi.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.cesi.basecode.R;

public class StartActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View menu_activity) {
                startNextActivity();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void startNextActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);

        finish();
    }


}






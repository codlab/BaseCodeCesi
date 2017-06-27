package fr.cesi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import fr.cesi.basecode.R;


public class MenuActivity2 extends AppCompatActivity {


    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activity3);


        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View Question) {
                startNextActivity();
            }
        });

        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View Question) {
                startNextActivity();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void startNextActivity() {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);

        finish();
    }
};



package fr.cesi.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.cesi.basecode.R;



public class MenuActivity extends AppCompatActivity {


    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activity2);


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

    }
};



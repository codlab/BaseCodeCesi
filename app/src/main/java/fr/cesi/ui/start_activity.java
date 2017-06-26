package fr.cesi.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.basecode.example.R;
import fr.cesi.basecode.example.timer.ChoiceTimerFragment;

public class start_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);
    }
}

    @Override
    protected void onResume() {
        super.onResume();

        IPopableFragment current_stack_head = _stack_controller.head();
        if(current_stack_head == null) {
            ChoiceTimerFragment fragment = ChoiceTimerFragment.newInstance();
            _stack_controller.push(fragment);
        }

    }


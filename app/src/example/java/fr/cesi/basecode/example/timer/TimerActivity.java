package fr.cesi.basecode.example.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import fr.cesi.base.controllers.fragment.IActivityListener;
import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.base.controllers.fragment.StackController;
import fr.cesi.basecode.R;

public class TimerActivity extends AppCompatActivity
implements IActivityListener {

    private FrameLayout _main_content;
    private StackController _stack_controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        _main_content = (FrameLayout) findViewById(R.id.main_container);
        _stack_controller = new StackController(this, _main_content);
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

    @Override
    public void onFragmentSet() {
        //si j'ai besoin de gestion de callback ici!
    }

    public void appelTimerFragment(int duration, int duration_pause, int number_repetition) {
        TimerFragment fragment = TimerFragment.newInstance(duration, duration_pause, number_repetition);
        _stack_controller.push(fragment);
    }
}

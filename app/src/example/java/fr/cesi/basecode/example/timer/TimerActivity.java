package fr.cesi.basecode.example.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cesi.base.controllers.fragment.AbstractPopableActivity;
import fr.cesi.base.controllers.fragment.IActivityListener;
import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.base.controllers.fragment.StackController;
import fr.cesi.basecode.R;

public class TimerActivity extends AbstractPopableActivity
        implements IActivityListener {

    @BindView(R.id.toolbar)
    Toolbar _toolbar;

    @BindView(R.id.main_container)
    FrameLayout _main_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        ButterKnife.bind(this);

        setSupportActionBar(_toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IPopableFragment current_stack_head = getStackController().head();
        if (current_stack_head == null) {
            ChoiceTimerFragment fragment = ChoiceTimerFragment.newInstance();
            getStackController().push(fragment);
        }

    }

    @Override
    protected StackController createStackController() {
        return new StackController(this, _main_content);
    }

    public void appelTimerFragment(int duration, int duration_pause, int number_repetition) {
        TimerFragment fragment = TimerFragment.newInstance(duration, duration_pause, number_repetition);
        getStackController().push(fragment);
    }
}

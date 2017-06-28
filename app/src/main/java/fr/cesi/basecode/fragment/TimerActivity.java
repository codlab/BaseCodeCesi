package fr.cesi.basecode.fragment;

import android.os.Bundle;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cesi.base.controllers.fragment.AbstractPopableActivity;
import fr.cesi.base.controllers.fragment.IActivityListener;
import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.base.controllers.fragment.StackController;
import fr.cesi.basecode.R;
import fr.cesi.basecode.fragment.choice;
import fr.cesi.basecode.fragment.working;

public class TimerActivity extends AbstractPopableActivity
        implements IActivityListener {


    @BindView(R.id.main_container)
    FrameLayout _main_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        IPopableFragment current_stack_head = getStackController().head();
        if (current_stack_head == null) {
            choice fragment = choice.newInstance();
            getStackController().push(fragment);
        }

    }

    @Override
    protected StackController createStackController() {
        return new StackController(this, _main_content);
    }

    public void appelworking(int duration, int duration_pause, int number_repetition) {
        working fragment = working.newInstance(duration, duration_pause, number_repetition);
        getStackController().push(fragment);
    }
}


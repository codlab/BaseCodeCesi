package fr.cesi.basecode.example.timer;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.basecode.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChoiceTimerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChoiceTimerFragment extends Fragment implements IPopableFragment {

    @BindView(R.id.button_choice_timer_choose_duration)
    Button _button_duration;

    @BindView(R.id.button_choice_timer_choose_pause)
    Button _button_pause_duration;

    @BindView(R.id.button_choice_timer_choose_repetition)
    Button _button_repetition;

    @BindView(R.id.button_choice_timer_choose_start)
    Button _button_start;

    @OnClick(R.id.button_choice_timer_choose_start)
    public void onStartClicked() {
        TimerActivity activity = (TimerActivity) getActivity();

        activity.appelTimerFragment(_duration,
                _duration_pause,
                _number_repetition);
    }

    private int _duration = 0;
    private int _duration_pause = 0;
    private int _number_repetition = 0;

    public ChoiceTimerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ChoiceTimerFragment.
     */
    public static ChoiceTimerFragment newInstance() {
        ChoiceTimerFragment fragment = new ChoiceTimerFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choice_timer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
    }

    @Override
    public boolean hasParent() {
        return false;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}

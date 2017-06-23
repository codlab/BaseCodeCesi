package fr.cesi.basecode.example.timer;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.basecode.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChoiceTimerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChoiceTimerFragment extends Fragment implements IPopableFragment {

    private Button _button_duration;

    private Button _button_pause_duration;

    private Button _button_repetition;

    private Button _button_start;

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

        _button_duration = (Button) view.findViewById(R.id.button_choice_timer_choose_duration);
        _button_pause_duration = (Button) view.findViewById(R.id.button_choice_timer_choose_pause);
        _button_repetition = (Button) view.findViewById(R.id.button_choice_timer_choose_repetition);
        _button_start = (Button) view.findViewById(R.id.button_choice_timer_choose_start);

        _button_duration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        _button_pause_duration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        _button_repetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        _button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
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

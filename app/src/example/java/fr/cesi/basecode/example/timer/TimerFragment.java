package fr.cesi.basecode.example.timer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.basecode.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimerFragment extends Fragment implements IPopableFragment {
    private static final String ARG_DURATION = "duration";
    private static final String ARG_DURATION_PAUSE = "duration_pause";
    private static final String ARG_NUMBER_REPETITION = "number_repetition";

    private int _duration;
    private int _duration_pause;
    private int _number_repetition;


    public TimerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TimerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimerFragment newInstance(int duration, int duration_pause, int number_repetition) {
        TimerFragment fragment = new TimerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_DURATION, duration);
        args.putInt(ARG_DURATION_PAUSE, duration_pause);
        args.putInt(ARG_NUMBER_REPETITION, number_repetition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            _duration = getArguments().getInt(ARG_DURATION);
            _duration_pause = getArguments().getInt(ARG_DURATION_PAUSE);
            _number_repetition = getArguments().getInt(ARG_NUMBER_REPETITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }

    @Override
    public boolean hasParent() {
        return true;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}

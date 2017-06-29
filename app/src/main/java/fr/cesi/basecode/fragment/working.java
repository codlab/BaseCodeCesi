package fr.cesi.basecode.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;

import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.basecode.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link working#newInstance} factory method to
 * create an instance of this fragment.
 */
public class working extends Fragment implements IPopableFragment {
    private static final String ARG_DURATION = "getDuration";
    private static final String ARG_DURATION_PAUSE = "getPause";
    private static final String ARG_NUMBER_REPETITION = "getRepetition";

    private Handler _handler;
    private int _duration;
    private int _duration_pause;
    private int _repetition;

    private DonutProgress _working_progress;
    private DonutProgress _pause_progress;

    private ImageView _stop_image;
    private ImageView _start_image;

    private TextView _counter;
    private TextView _repetitions;
    private int _duration_seconds;
    private int _duration_pause_seconds;


    public working() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TimerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static working newInstance(int getDuration, int getPause, int getRepetition) {
        working fragment = new working();
        Bundle args = new Bundle();
        args.putInt(ARG_DURATION, getDuration);
        args.putInt(ARG_DURATION_PAUSE, getPause);
        args.putInt(ARG_NUMBER_REPETITION, getRepetition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            _duration = getArguments().getInt(ARG_DURATION);
            _duration_pause = getArguments().getInt(ARG_DURATION_PAUSE);
            _repetition = getArguments().getInt(ARG_NUMBER_REPETITION);
            Log.d("test", "onCreate: " + _repetition + "!");

            _duration_seconds = _duration;
            _duration_pause_seconds = _duration_pause;
        }

        _duration *= 1000;
        _duration_pause *= 1000;


        _handler = new Handler();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_working, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View main_button = view.findViewById(R.id.main_btn);

        _counter = (TextView) view.findViewById(R.id.counter);
        _repetitions = (TextView) view.findViewById(R.id.repetition);

        _start_image = (ImageView) view.findViewById(R.id.start_btn);
        _stop_image = (ImageView) view.findViewById(R.id.stop_btn);

        _pause_progress = (DonutProgress) view.findViewById(R.id.pause_progress);
        _working_progress = (DonutProgress) view.findViewById(R.id.working_progress);

        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_started == false) {
                    _started = true;
                    _paused = false;
                    init();
                } else {
                    if (!_paused) {
                        _paused = true;
                    } else {
                        _paused = false;
                        postStartLoop();
                    }
                }
            }
        });
    }

    @Override
    public boolean hasParent() {
        return true;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    /*************************************************************************************
     *
     *
     *************************************************************************************/
    private static final String TYPE_DURATION = "TYPE_DURATION";
    private static final String TYPE_DURATION_PAUSE = "TYPE_DURATION_PAUSE";

    private double remaining_duration = 0;
    private int remaining_repetition = 0;
    private String _current_type;

    private boolean _started = false;
    private boolean _paused = false;


    private void init() {
        remaining_repetition = _repetition;
        remaining_duration = _duration;
        _current_type = TYPE_DURATION;
        postStartLoop();
    }

    private void refreshUI() {
        //mettre le fonctionnement
        int remaining_seconds = (int) (remaining_duration / 1000);

        _counter.setText("" + remaining_seconds);
        _repetitions.setText((_repetition - remaining_repetition) + "/" + _repetition);

        if (TYPE_DURATION.equals(_current_type)) {
            _start_image.setVisibility(View.VISIBLE);
            _working_progress.setVisibility(View.VISIBLE);

            _stop_image.setVisibility(View.GONE);
            _pause_progress.setVisibility(View.GONE);

            _working_progress.setMax(_duration);
            _working_progress.setProgress((float) (_duration - remaining_duration));
        } else {
            _start_image.setVisibility(View.GONE);
            _working_progress.setVisibility(View.GONE);

            _stop_image.setVisibility(View.VISIBLE);
            _pause_progress.setVisibility(View.VISIBLE);

            _pause_progress.setMax(_duration_pause);
            _pause_progress.setProgress((float) (_duration_pause - remaining_duration));
        }
    }

    private void startLoop() {
        if (remaining_repetition >= 0 && _started) {
            refreshUI();
            remaining_duration -= 50;//ms

            if (remaining_duration <= 0) {
                if (TYPE_DURATION.equals(_current_type)) {
                    if (remaining_repetition > 1) {
                        remaining_repetition--;
                        _current_type = TYPE_DURATION_PAUSE;
                        remaining_duration = _duration_pause;
                    } else{
                        _started = false;
                    }
                } else { //_current_type == TYPE_DURATION_PAUSE
                    _current_type = TYPE_DURATION;
                    remaining_duration = _duration;
                }
            }

            postStartLoop();
        } else {
            _started = false;
            //FINISH
        }
    }

    private void postStartLoop() {
        if (!_paused) {
            _handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startLoop();
                }
            }, 50);
        }
    }
}


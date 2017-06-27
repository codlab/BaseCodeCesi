package fr.cesi.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.cesi.basecode.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ASK = "ask";
    private static final String ARG_IMG = "img";
    private static final String ARG_BTN1 = "btn1";
    private static final String ARG_BTN2 = "btn2";
    private static final String ARG_BTN3 = "btn3";
    private static final String ARG_BTN4 = "btn4";
    // TODO: Rename and change types of parameters
    private String ask;
    private String img;
    private String btn1;
    private String btn2;
    private String btn3;
    private String btn4;


    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance(String text, int image, String bouton1, String bouton2, String bouton3, String bouton4 ) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ASK, ask);
        args.putString(ARG_IMG, img);
        args.putString(ARG_BTN1, btn1);
        args.putString(ARG_BTN2, btn2);
        args.putString(ARG_BTN3, btn3);
        args.putString(ARG_BTN4, btn4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ask = getArguments().getString(ARG_ASK);
            img = getArguments().getString(ARG_IMG);
            btn1 = getArguments().getString(ARG_BTN1);
            btn2 = getArguments().getString(ARG_BTN2);
            btn3 = getArguments().getString(ARG_BTN3);
            btn4 = getArguments().getString(ARG_BTN4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_fragment, container, false);
    }

}


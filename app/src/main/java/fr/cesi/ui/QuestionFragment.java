package fr.cesi.ui;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.basecode.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment implements IPopableFragment {

    private QuestionActivity.Question question;


    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     */
    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance(QuestionActivity.Question question) {
        QuestionFragment fragment = new QuestionFragment();
        fragment.setArguments(question.toBundle());
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = new QuestionActivity.Question(getArguments());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView vue = (ImageView) view.findViewById(R.id.poule);
        TextView text = (TextView) view.findViewById(R.id.text);
        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);
        Button button4 = (Button) view.findViewById(R.id.button4);

        vue.setImageResource(question.imgQuestion);
        text.setText(question.textQuestion);
        button1.setText(question.btn1);
        button2.setText(question.btn2);
        button3.setText(question.btn3);
        button4.setText(question.btn4);

        //button1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(question.btn1);
            }
        });

        //button2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(question.btn2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(question.btn3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(question.btn4);
            }
        });
    }

    private void checkAnswer(String given_answer) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);

        if(question.reponseQuestion.equals(given_answer)) {
            // text si gagné
            builder.setTitle(getString(R.string.result_title1));
            builder.setMessage(getString(R.string.result_success));
        } else {
            // texte si perdu
            builder.setTitle(getString(R.string.result_title2));
            builder.setMessage(getString(R.string.result_failed));
        }

        DialogInterface.OnClickListener on_click =  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //ICI > METTRE DANS LE CALLBACK DE LA POPUP
                ((QuestionActivity) getActivity()).showNextQuestion();
            }
        };

        builder.setPositiveButton("Confirm",
                on_click);
        builder.setNegativeButton(android.R.string.cancel, on_click);

        builder.show();


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


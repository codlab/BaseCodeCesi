package fr.cesi.ui;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import fr.cesi.base.controllers.fragment.AbstractPopableActivity;
import fr.cesi.base.controllers.fragment.IActivityListener;
import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.base.controllers.fragment.StackController;
import fr.cesi.basecode.R;

public class QuestionActivity extends AbstractPopableActivity
        implements IActivityListener {

    private List<Question> _questions;
    private FrameLayout _question_container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        _question_container = (FrameLayout) findViewById(R.id.contenu_questions);

        initQuestions();
    }

    @Override
    protected void onResume() {
        super.onResume();

        IPopableFragment current_stack_head = getStackController().head();
        if (current_stack_head == null) {
            showNextQuestion();
        }
    }

    public void showNextQuestion() {
        Question question = getNextQuestionAndRemoveHead();
        if(question != null) {
            QuestionFragment fragment = QuestionFragment.newInstance(question);
            getStackController().push(fragment);
        } else {
            //show finish ! ... fragment
        }
    }

    private void initQuestions() {
        _questions = new ArrayList<>();
        _questions.add(new Question("Salut", R.drawable.poule,
                "chat", "chien", "croco", "canard", "croco"));
        //.......
    }

    @Nullable
    private Question getNextQuestionAndRemoveHead() {
        if(_questions.size() > 0) {
            Question question = _questions.get(0);
            _questions.remove(0);
            return question;
        }

        return null;
    }


    public static class Question {

        public String textQuestion;
        public int imgQuestion;
        public String btn1;
        public String btn2;
        public String btn3;
        public String btn4;
        public String reponseQuestion;

        public Question(){

        }

        public Question(String text, int img, String btn1, String btn2, String btn3, String btn4, String ans) {
            textQuestion = text;
            imgQuestion = img;
            this.btn1 = btn1;
            this.btn2 = btn2;
            this.btn3 = btn3;
            this.btn4 = btn4;
            this.reponseQuestion = ans;
        }

        public Question(Bundle bundle) {
           this(bundle.getString("text"),
                   bundle.getInt("image"),
                   bundle.getString("btn1"),
                   bundle.getString("btn2"),
                   bundle.getString("btn3"),
                   bundle.getString("btn4"),
                   bundle.getString("answer"));
        }

        public Bundle toBundle() {
            Bundle args = new Bundle();
            args.putString("text", textQuestion);
            args.putInt("image", imgQuestion);
            args.putString("btn1", btn1);
            args.putString("btn2", btn2);
            args.putString("btn3", btn3);
            args.putString("btn4", btn4);
            args.putString("answer", reponseQuestion);

            return args;
        }
    }


    @Override
    protected StackController createStackController() {

        return new StackController(this, _question_container);
    }

}

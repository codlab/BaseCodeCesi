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
            finish();
        }
    }

    private void initQuestions() {
        _questions = new ArrayList<>();
        _questions.add(new Question("Si cet animal a de la laine et des cornes, alors c'est un bélier. Cet animal est-il un bélier?", R.drawable.mouton,
                "oui", "non", "", "", "non"));
        _questions.add(new Question("Marguerite la vache est mariée avec Hugo le taureau. Hugo a perdu Marguerite et la cherche désespérément! Il sait qu'elle a des taches marron. Est-ce que c'est celle-ci?", R.drawable.vache,
                "oui", "non", "", "", "non"));
        _questions.add(new Question("Si la poule a 3 poussins, son ami sera un chien, si la poule a 4 poussins, son ami sera un chat, si la poule a 5 poussins son ami sera le taureau. Si c’est un autre nombre de poussins son ami sera la vache. Peux tu me dire quel est l’ami de la poule ?", R.drawable.poule,
                "chat", "chien", "taureau", "vache", "taureau"));
        _questions.add(new Question("Si il fait beau, le canard nage, si il pleut, le canard peche, si il fait nuit le canard dort, et si il neige le canard se cache. Que fait le canard ?", R.drawable.pluie,
                "il nage", "il pêche", "il dort", "il se cache", "il pêche"));
        _questions.add(new Question("Si le corbeau a un fromage : pour faire tomber un fromage du bec de corbeau le renard doit tirer le levier 3 fois. Combien de foisle renard doit-il tirer sur le levier pour récupérer les fromages ?", R.drawable.corbeau,
                "2", "3", "4", "6", "6"));
        _questions.add(new Question("2 tour de moulin suffisent à moudre assez de blé pour nourrir une poule. Pour le nombre de poule que tu vois, combien de tours de moulin faut-il ?", R.drawable.poules,
                "2", "4", "5", "6", "4"));
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

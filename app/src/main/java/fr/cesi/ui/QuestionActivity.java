package fr.cesi.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fr.cesi.base.controllers.fragment.AbstractPopableActivity;
import fr.cesi.base.controllers.fragment.IActivityListener;
import fr.cesi.base.controllers.fragment.IPopableFragment;
import fr.cesi.base.controllers.fragment.StackController;
import fr.cesi.basecode.R;

public class QuestionActivity extends AbstractPopableActivity
        implements IActivityListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IPopableFragment current_stack_head = getStackController().head();
        if (current_stack_head == null) {
            QuestionFragment fragment = QuestionFragment.newInstance("Salut", R.drawable.poule,
                    "chat", "chien", "croco", "canard" );
            getStackController().push(fragment);
        }

    }

    @Override
    protected StackController createStackController() {
        return null;
    }

}

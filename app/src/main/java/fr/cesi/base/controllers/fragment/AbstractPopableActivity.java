package fr.cesi.base.controllers.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public abstract class AbstractPopableActivity extends AppCompatActivity implements IActivityListener {

    private final static String TAG = "AbstractPopableActivity";
    private StackController _stack_controller;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        _stack_controller = createStackController();
    }

    @Override
    protected void onResume() {
        super.onResume();

        onFragmentSet();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected abstract StackController createStackController();

    protected StackController getStackController() {
        return _stack_controller;
    }

    @Override
    public void onBackPressed() {
        if (!_stack_controller.managedOnBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentSet() {
        IPopableFragment head = getStackController().head();
        ActionbarActionEnum type = ActionbarActionEnum.NO_ICON;
        if (head != null && head.hasParent()) {
            type = ActionbarActionEnum.BACK;
        }

        setActionbarAction(type);
    }

    protected void setActionbarAction(ActionbarActionEnum action) {

        Log.d(TAG, "setActionbarAction: " + action);
        ActionBar actionbar = getSupportActionBar();

        if (actionbar != null) {
            switch (action) {
                case BACK:
                    actionbar.setDisplayHomeAsUpEnabled(true);
                    actionbar.setHomeButtonEnabled(true);
                    actionbar.setHomeAsUpIndicator(0);
                    break;
                /*case MENU:
                    actionbar.setDisplayHomeAsUpEnabled(true);
                    actionbar.setHomeButtonEnabled(true);
                    break;*/
                default:
                    actionbar.setDisplayHomeAsUpEnabled(false);
                    actionbar.setHomeButtonEnabled(false);
                    actionbar.setHomeAsUpIndicator(0);
            }
        }
    }
}

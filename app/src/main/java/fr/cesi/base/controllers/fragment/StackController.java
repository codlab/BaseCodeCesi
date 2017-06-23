package fr.cesi.base.controllers.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import fr.cesi.basecode.BuildConfig;

public class StackController {

    private IActivityListener mParent;
    private View mContainer;
    private List<IPopableFragment> mFragments;

    private StackController() {

    }

    public StackController(@NonNull IActivityListener parent, @NonNull View container) {
        this();
        mFragments = new ArrayList<>();
        mContainer = container;
        mParent = parent;
    }

    public void remove(int count) {
        for (int i = 0; i < count; i++)
            if (mFragments.size() > 0)
                mFragments.remove(mFragments.size() - 1);
    }

    public boolean pop() {
        return pop(true);
    }

    private boolean pop(boolean keep_one) {
        if (mFragments.size() > (keep_one ? 1 : 0)) {
            remove(1);
            setFragment();

            return true;
        }
        return false;
    }

    public void flush() {
        while (pop(false)) {
            if (BuildConfig.DEBUG) Log.d("StackController", "popping");
        }
    }

    public void push(@NonNull IPopableFragment new_fragment) {
        mFragments.add(new_fragment);
        setFragment();
    }

    private void setFragment() {
        if (head() != null) {
            mParent.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(mContainer.getId(), (Fragment) head())
                    .commit();

            mParent.onFragmentSet();
        }
    }

    @Nullable
    public IPopableFragment head() {
        if (mFragments.size() > 0)
            return mFragments.get(mFragments.size() - 1);
        return null;
    }

    public boolean managedOnBackPressed() {
        IPopableFragment popable_head = head();
        if (popable_head != null && popable_head.onBackPressed()) {
            return true;
        }

        if (pop()) return true;
        return false;
    }
}

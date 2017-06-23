package fr.cesi.base.controllers.fragment;

import android.support.v4.app.FragmentManager;

public interface IActivityListener {

    /**
     * Simply return the support manager
     * @return
     */
    FragmentManager getSupportFragmentManager();

    /**
     * possible callback to manage fragments when modification appeared
     */
    void onFragmentSet();
}

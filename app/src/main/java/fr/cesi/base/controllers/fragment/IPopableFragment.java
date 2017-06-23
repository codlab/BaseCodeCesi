package fr.cesi.base.controllers.fragment;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Created by kevinleperf on 13/09/2016.
 */
public interface IPopableFragment {

    /**
     * Does the fragment has parent?
     * @return
     */
    boolean hasParent();

    /**
     * onBackPressed
     * @return
     */
    boolean onBackPressed();

    /* IParentStackConfigurator getConfigurator(); */
}
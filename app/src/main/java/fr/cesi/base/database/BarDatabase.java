package fr.cesi.base.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by zora on 28/06/2017.
 */

@Database(name = BarDatabase.NAME, version = BarDatabase.VERSION)
public class BarDatabase {

    public final static String NAME = "BarDatabase";

    public final static int VERSION = 1;
}

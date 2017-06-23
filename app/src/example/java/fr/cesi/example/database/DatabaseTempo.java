package fr.cesi.example.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by kevinleperf on 16/06/2017.
 */

@Database(name = DatabaseTempo.NAME, version = DatabaseTempo.VERSION)
public class DatabaseTempo {

    public final static String NAME = "DatabaseTempo";

    public final static int VERSION = 1;
}

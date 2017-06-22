package fr.cesi.example.database.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fr.cesi.example.database.DatabaseTempo;

@Table(name = "TempoModel", database = DatabaseTempo.class)
public class TempoModel extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    public long _id;

    @Column
    public int _duration_active;

    @Column
    public int _duration_pause;

    @Column
    public int _number_repetition;


    public TempoModel() {
        super();

        _duration_active = 0;
        _duration_pause = 0;
        _number_repetition = 0;
    }

    public TempoModel(int duration_active, int duration_pause, int number_repetition) {
        this();

        _duration_active = duration_active;
        _duration_pause = duration_pause;
        _number_repetition = number_repetition;
    }

    public int getActiveDuration() {
        return _duration_active;
    }

    public int getPauseDuration() {
        return _duration_pause;
    }

    public int getNumberRepetition() {
        return _number_repetition;
    }

}


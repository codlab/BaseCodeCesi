package ui.maps.database.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fr.cesi.example.database.DatabaseTempo;

@Table(name = "CommerceModel", database = DatabaseCommerce.class)
public class CommerceModel extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    public long _id_commerce;

    @Column
    public int _longitude;

    @Column
    public int _lattitude;

    @Column
    public int _lundi_ouverture;

    @Column
    public int _lundi_fermeture;

    @Column
    public int _mardi_ouverture;

    @Column
    public int _mardi_fermeture;

    @Column
    public int _mercredi_ouverture;

    @Column
    public int _mercredi_fermeture;

    @Column
    public int _jeudi_ouverture;

    @Column
    public int _jeudi_fermeture;

    @Column
    public int _vendredi_ouverture;

    @Column
    public int _vendredi_fermeture;

    @Column
    public int _samedi_ouverture;

    @Column
    public int _samedi_fermeture;

    @Column
    public int _dimanche_ouverture;

    @Column
    public int _dimanche_fermeture;

    public CommerceModel() {
        super();

        _id_commerce = 0;
        _longitude = 0;
        _lattitude = 0;
        _lundi_ouverture = 0;
        _lundi_fermeture = 0;
        _mardi_ouverture = 0;
        _mardi_fermeture = 0;
        _mercredi_ouverture = 0;
        _mercredi_fermeture = 0;
        _jeudi_ouverture = 0;
        _jeudi_fermeture = 0;
        _vendredi_ouverture = 0;
        _vendredi_fermeture = 0;
        _samedi_ouverture = 0;
        _samedi_fermeture = 0;
        _dimanche_ouverture = 0;
        _dimanche_fermeture = 0;
    }

    public CommerceModel(int duration_active, int duration_pause, int number_repetition) {
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


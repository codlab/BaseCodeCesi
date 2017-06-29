package ui.maps.database.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import ui.maps.database.DatabaseCommerce;


@Table(name = "CommerceModel", database = DatabaseCommerce.class)
public class CommerceModel extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    public long _id_commerce;

    @Column
    public String _nom;

    @Column
    public double _longitude;

    @Column
    public double _lattitude;

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

        _nom = "";
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

    public CommerceModel(String nom, double latitude, double longitude, int lundi_ouverture, int lundi_fermeture, int mardi_ouverture, int mardi_fermeture, int mercredi_ouverture, int mercredi_fermeture, int jeudi_ouverture, int jeudi_fermeture, int vendredi_ouverture, int vendredi_fermeture, int samedi_ouverture, int samedi_fermeture, int dimanche_ouverture, int dimanche_fermeture) {
        this();
        _nom = nom;
        _lattitude = latitude;
        _longitude = longitude;
        _lundi_ouverture = lundi_ouverture;
        _lundi_fermeture = lundi_fermeture;
        _mardi_ouverture = mardi_ouverture;
        _mardi_fermeture = mardi_fermeture;
        _mercredi_ouverture = mercredi_ouverture;
        _mercredi_fermeture = mercredi_fermeture;
        _jeudi_ouverture = jeudi_ouverture;
        _jeudi_fermeture = jeudi_fermeture;
        _vendredi_ouverture = vendredi_ouverture;
        _vendredi_fermeture = vendredi_fermeture;
        _samedi_ouverture = samedi_ouverture;
        _samedi_fermeture = samedi_fermeture;
        _dimanche_ouverture = dimanche_ouverture;
        _dimanche_fermeture = dimanche_fermeture;
    }
}


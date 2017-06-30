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
    public String _lundi_ouverture;

    @Column
    public String _lundi_fermeture;

    @Column
    public String _mardi_ouverture;

    @Column
    public String _mardi_fermeture;

    @Column
    public String _mercredi_ouverture;

    @Column
    public String _mercredi_fermeture;

    @Column
    public String _jeudi_ouverture;

    @Column
    public String _jeudi_fermeture;

    @Column
    public String _vendredi_ouverture;

    @Column
    public String _vendredi_fermeture;

    @Column
    public String _samedi_ouverture;

    @Column
    public String _samedi_fermeture;

    @Column
    public String _dimanche_ouverture;

    @Column
    public String _dimanche_fermeture;

    public CommerceModel() {
        super();

        _nom = "";
        _id_commerce = 0;
        _longitude = 0;
        _lattitude = 0;
        _lundi_ouverture = "";
        _lundi_fermeture = "";
        _mardi_ouverture = "";
        _mardi_fermeture = "";
        _mercredi_ouverture = "";
        _mercredi_fermeture = "";
        _jeudi_ouverture = "";
        _jeudi_fermeture = "";
        _vendredi_ouverture = "";
        _vendredi_fermeture = "";
        _samedi_ouverture = "";
        _samedi_fermeture = "";
        _dimanche_ouverture = "";
        _dimanche_fermeture = "";
    }

    public CommerceModel(String nom, double latitude, double longitude, String lundi_ouverture, String lundi_fermeture, String mardi_ouverture, String mardi_fermeture, String mercredi_ouverture, String mercredi_fermeture, String jeudi_ouverture, String jeudi_fermeture, String vendredi_ouverture, String vendredi_fermeture, String samedi_ouverture, String samedi_fermeture, String dimanche_ouverture, String dimanche_fermeture) {
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


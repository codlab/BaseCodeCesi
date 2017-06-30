package ui.maps.database.controllers;

import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fr.cesi.base.database.AbstractModelController;
import ui.maps.database.models.CommerceModel;


public class CommerceController extends AbstractModelController<CommerceModel> {

    @Override
    protected Property getColumnId() {
        return null;//TempoModel_Table._id;
    }

    @Override
    protected Class<? extends BaseModel> getTableClass() {
        return CommerceModel.class;
    }

    public CommerceModel createCommerce(String nom, double latitude, double longitude, String lundi_ouverture, String lundi_fermeture, String mardi_ouverture, String mardi_fermeture, String mercredi_ouverture, String mercredi_fermeture, String jeudi_ouverture, String jeudi_fermeture, String vendredi_ouverture, String vendredi_fermeture, String samedi_ouverture, String samedi_fermeture, String dimanche_ouverture, String dimanche_fermeture) {
        CommerceModel instance = new CommerceModel(nom, latitude,
        longitude,
        lundi_ouverture,
        lundi_fermeture,
        mardi_ouverture,
        mardi_fermeture,
        mercredi_ouverture,
        mercredi_fermeture,
        jeudi_ouverture,
        jeudi_fermeture,
        vendredi_ouverture,
        vendredi_fermeture,
        samedi_ouverture,
        samedi_fermeture,
        dimanche_ouverture,
        dimanche_fermeture);

        instance.save();

        return instance;
    }

    private static final CommerceController _sInstance = new CommerceController();

    public static CommerceController getInstance() {
        return _sInstance;
    }
}
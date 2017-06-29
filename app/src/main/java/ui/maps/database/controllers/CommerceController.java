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

    public CommerceModel createCommerce(String nom, double latitude, double longitude, int lundi_ouverture, int lundi_fermeture, int mardi_ouverture, int mardi_fermeture, int mercredi_ouverture, int mercredi_fermeture, int jeudi_ouverture, int jeudi_fermeture, int vendredi_ouverture, int vendredi_fermeture, int samedi_ouverture, int samedi_fermeture, int dimanche_ouverture, int dimanche_fermeture) {
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
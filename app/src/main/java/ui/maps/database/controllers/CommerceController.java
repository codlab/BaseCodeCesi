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

    public CommerceModel createTempo(int duration_active, int duration_pause, int number_repetition) {
        CommerceModel instance = new CommerceModel(duration_active,
                duration_pause,
                number_repetition);

        instance.save();

        return instance;
    }
}
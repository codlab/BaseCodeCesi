package fr.cesi.example.database.controllers;

import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fr.cesi.base.database.AbstractModelController;
import fr.cesi.example.database.models.TempoModel;
import fr.cesi.example.database.models.TempoModel_Table;


public class TempoModelController extends AbstractModelController<TempoModel> {

    @Override
    protected Property getColumnId() {
        return TempoModel_Table._id;
    }

    @Override
    protected Class<? extends BaseModel> getTableClass() {
        return TempoModel.class;
    }

    public TempoModel createTempo(int duration_active, int duration_pause, int number_repetition) {
        TempoModel instance = new TempoModel(duration_active,
                duration_pause,
                number_repetition);

        instance.save();

        return instance;
    }
}

package fr.cesi.example.database.controllers;

import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fr.cesi.base.database.AbstractModelController;
import fr.cesi.example.database.models.TempoModel;
import fr.cesi.example.database.models.TempoModel_Table;


public class BarController extends AbstractModelController<bar> {

    @Override
    protected Property getColumnId() {
        return null;
    }

    @Override
    protected Class<? extends BaseModel> getTableClass() {
        return TempoModel.class;
    }

    public bar createTempo(String bar_name, double latitude, double longitude int price_min int price_max) {
        TempoModel instance = new TempoModel(latitude,
                longitude,
                price_min
                price_max
        );

        instance.save();

        return instance;
    }
}

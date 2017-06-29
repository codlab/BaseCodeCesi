package fr.cesi.base.database;

import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.BaseModel;


public class BarController extends AbstractModelController<Bar> {

    private static final BarController sInstance = new BarController();

    public static BarController getInstance() {
        return sInstance;
    }

    @Override
    protected Property getColumnId() {
        return null;
    }

    @Override
    protected Class<? extends BaseModel> getTableClass() {
        return Bar.class;
    }

    public Bar createBar(String bar_name, double longitude, double latitude, String price_min,
                         String price_max) {
        Bar instance = new Bar(
                bar_name,
                longitude,
                latitude,
                price_min,
                price_max);

        instance.save();

        return instance;
    }
}

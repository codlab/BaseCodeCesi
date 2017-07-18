package fr.cesi.base.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import fr.cesi.base.database.BarDatabase;

@Table(name = "Bar", database = BarDatabase.class)
public class Bar extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    public long _id;

    @Column
    public String _bar_name;

    @Column
    public double _latitude;

    @Column
    public double _longitude;

    @Column
    public String _price_min;

    @Column
    public String _price_max;





    public Bar() {
        super();
    }

    public Bar(String bar_name, double latitude, double longitude, String price_min,  String price_max) {
        this();

        _bar_name = bar_name;
        _latitude = latitude;
        _longitude = longitude;
        _price_min = price_min;
        _price_max = price_max;
    }
    public String get_bar_name() {
        return _bar_name;
    }
    public String get_price_min() {
        return _price_min;
    }

    public String get_price_max() {
        return _price_max;
    }

    public double get_longitude(){ return _longitude; }

    public double get_latitude(){ return _latitude; }
}


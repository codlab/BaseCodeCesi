package fr.cesi.base;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.cesi.basecode.R;
import ui.maps.database.controllers.CommerceController;

public class FormulaireActivity extends AppCompatActivity {
    private final static String LONGITUDE = "LONGITUDE";
    private final static String LATITUDE = "LATITUDE";


    @BindView(R.id.nom)
    EditText _nom;

    @BindView(R.id.lundi_open)
    EditText _lundi_open;

    @BindView(R.id.lundi_close)
    EditText _lundi_close;

    @BindView(R.id.mardi_open)
    EditText _mardi_open;

    @BindView(R.id.mardi_close)
    EditText _mardi_close;

    @BindView(R.id.mercredi_open)
    EditText _mercredi_open;

    @BindView(R.id.mercredi_close)
    EditText _mercredi_close;

    @BindView(R.id.jeudi_open)
    EditText _jeudi_open;

    @BindView(R.id.jeudi_close)
    EditText _jeudi_close;

    @BindView(R.id.vendredi_open)
    EditText _vendredi_open;

    @BindView(R.id.vendredi_close)
    EditText _vendredi_close;

    @BindView(R.id.samedi_open)
    EditText _samedi_open;

    @BindView(R.id.samedi_close)
    EditText _samedi_close;

    @BindView(R.id.dimanche_open)
    EditText _dimanche_open;

    @BindView(R.id.dimanche_close)
    EditText _dimanche_close;

    public static void startFormulaireActivity(Activity parent, LatLng latLng) {
        Intent intent = new Intent(parent, FormulaireActivity.class);

        intent.putExtra(LONGITUDE, latLng.longitude);
        intent.putExtra(LATITUDE, latLng.latitude);

        parent.startActivity(intent);
    }

    @OnClick(R.id.create)
    public void onCreate() {
        double latitude = getIntent().getDoubleExtra(LATITUDE, 0);
        double longitude = getIntent().getDoubleExtra(LONGITUDE, 0);

        String nom = _nom.getText().toString();

        String lundi_open = _lundi_open.getText().toString();
        String lundi_close = _lundi_close.getText().toString();
        String mardi_open = _mardi_open.getText().toString();
        String mardi_close = _mardi_close.getText().toString();
        String mercredi_open = _mercredi_open.getText().toString();
        String mercredi_close = _mercredi_close.getText().toString();
        String jeudi_open = _jeudi_open.getText().toString();
        String jeudi_close = _jeudi_close.getText().toString();
        String vendredi_open = _vendredi_open.getText().toString();
        String vendredi_close = _vendredi_close.getText().toString();
        String samedi_open = _samedi_open.getText().toString();
        String samedi_close = _samedi_close.getText().toString();
        String dimanche_open = _dimanche_open.getText().toString();
        String dimanche_close = _dimanche_close.getText().toString();

        CommerceController.getInstance().createCommerce(nom,
                latitude,
                longitude,
                lundi_open,
                lundi_close,
                mardi_open,
                mardi_close,
                mercredi_open,
                mercredi_close,
                jeudi_open,
                jeudi_close,
                vendredi_open,
                vendredi_close,
                samedi_open,
                samedi_close,
                dimanche_open,
                dimanche_close);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);

        ButterKnife.bind(this);
    }
}
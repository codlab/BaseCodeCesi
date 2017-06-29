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

public class FormulaireActivity extends AppCompatActivity {
    private final static String LONGITUDE = "LONGITUDE";
    private final static String LATITUDE = "LATITUDE";

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

        String dimanche_open = _dimanche_open.getText().toString();
        String dimanche_close = _dimanche_close.getText().toString();

        //Commerce commerce = CommerceController.getInstance().createCommerce(.....);
        //finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);

        ButterKnife.bind(this);
    }
}
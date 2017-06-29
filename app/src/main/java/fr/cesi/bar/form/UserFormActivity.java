package fr.cesi.bar.form;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.cesi.base.database.BarController;
import fr.cesi.basecode.R;

public class UserFormActivity extends AppCompatActivity {

    public static void startUserFormActivity(Activity parent, LatLng latlng) {
        Intent intent = new Intent(parent, UserFormActivity.class);
        intent.putExtra("lat", latlng.latitude);
        intent.putExtra("long", latlng.longitude);
        parent.startActivity(intent);
    }

    @BindView(R.id.nom)
    EditText _nom;

    @BindView(R.id.prixmin)
    EditText _prixmin;

    @BindView(R.id.prixmax)
    EditText _prixmax;

    @OnClick(R.id.button)
    public void onValidate() {
        double latitude = getIntent().getDoubleExtra("lat", 0);
        double longitude = getIntent().getDoubleExtra("long", 0);

        BarController.getInstance().createBar(_nom.getText().toString(),
                latitude,
                longitude,
                _prixmin.getText().toString(),
                _prixmax.getText().toString()
                );
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ubarform);

        ButterKnife.bind(this);
    }

}

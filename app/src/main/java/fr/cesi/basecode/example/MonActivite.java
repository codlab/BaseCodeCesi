package fr.cesi.basecode.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import fr.cesi.basecode.R;

/**

 */

public class MonActivite extends AppCompatActivity {

    static final LatLng PARIS = new LatLng(48.858093, 2.294694);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mon_activite);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                //ajoute un marker sur Paris
                googleMap.addMarker(new MarkerOptions().title("Paris").position(PARIS));

                //centre la google map sur Paris (avec animation de zoom)
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PARIS, 15));
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

            }
        });
    }

}

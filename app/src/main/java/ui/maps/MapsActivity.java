package ui.maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.cesi.base.FormulaireActivity;
import fr.cesi.basecode.R;
import ui.maps.database.controllers.CommerceController;
import ui.maps.database.models.CommerceModel;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private BottomSheetLayout mBottomSheetLayout;
    private View mBottomSheet;
    private List<CommerceModel> _my_markers;
    private HashMap<Marker, CommerceModel> _markers_to_models = new HashMap<>();

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        FlowManager.init(this);

        _my_markers = new ArrayList<>();

        mBottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomsheet);


        mBottomSheet = LayoutInflater.from(this)
                .inflate(R.layout.info_commerce, mBottomSheetLayout, false);
    }

    @Override
    protected void onResume() {
        super.onResume();

        int access_fine_location = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int access_coarce_location = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);

        if(access_coarce_location != PackageManager.PERMISSION_GRANTED ||
                access_fine_location != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    1337); //here, request callback int to 1337 - used when manage response from call
        } else {
            //here we can manage maps start
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

            init();
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        init();
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMyLocationEnabled(true);



        //click
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                FormulaireActivity.startFormulaireActivity(MapsActivity.this,
                        latLng);
            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                showInformation(marker);
                //deleteMarker(marker);

                // Return false to indicate that we have not consumed the event and that we wish
                // for the default behavior to occur (which is for the camera to move such that the
                // marker is centered and for the marker's info window to open, if it has one).
                return true;
            }
        });

    }

    private void showInformation(Marker marker) {

        CommerceModel model = _markers_to_models.get(marker);

        if(model != null) {
            TextView name = (TextView) mBottomSheet.findViewById(R.id.commerce);
            TextView lundi_ouverture = (TextView) mBottomSheet.findViewById(R.id.lundi_ouverture);
            TextView lundi_fermeture = (TextView) mBottomSheet.findViewById(R.id.lundi_fermeture);
            TextView mardi_ouverture = (TextView) mBottomSheet.findViewById(R.id.mardi_ouverture);
            TextView mardi_fermeture = (TextView) mBottomSheet.findViewById(R.id.mardi_fermeture);
            TextView mercredi_ouverture = (TextView) mBottomSheet.findViewById(R.id.mercredi_ouverture);
            TextView mercredi_fermeture = (TextView) mBottomSheet.findViewById(R.id.mercredi_fermeture);
            TextView jeudi_ouverture = (TextView) mBottomSheet.findViewById(R.id.jeudi_ouverture);
            TextView jeudi_fermeture = (TextView) mBottomSheet.findViewById(R.id.jeudi_fermeture);
            TextView vendredi_ouverture = (TextView) mBottomSheet.findViewById(R.id.vendredi_ouverture);
            TextView vendredi_fermeture = (TextView) mBottomSheet.findViewById(R.id.vendredi_fermeture);
            TextView samedi_ouverture = (TextView) mBottomSheet.findViewById(R.id.samedi_ouverture);
            TextView samedi_fermeture = (TextView) mBottomSheet.findViewById(R.id.samedi_fermeture);
            TextView dimanche_ouverture = (TextView) mBottomSheet.findViewById(R.id.dimanche_ouverture);
            TextView dimanche_fermeture = (TextView) mBottomSheet.findViewById(R.id.dimanche_fermeture);

            name.setText(model._nom);
            lundi_ouverture.setText(model._lundi_ouverture);
            lundi_fermeture.setText(model._lundi_fermeture);
            mardi_ouverture.setText(model._mardi_ouverture);
            mardi_fermeture.setText(model._mardi_fermeture);
            mercredi_ouverture.setText(model._mercredi_ouverture);
            mercredi_fermeture.setText(model._mercredi_fermeture);
            jeudi_ouverture.setText(model._jeudi_ouverture);
            jeudi_fermeture.setText(model._jeudi_fermeture);
            vendredi_ouverture.setText(model._vendredi_ouverture);
            vendredi_fermeture.setText(model._vendredi_fermeture);
            samedi_ouverture.setText(model._samedi_ouverture);
            samedi_fermeture.setText(model._samedi_fermeture);
            dimanche_ouverture.setText(model._dimanche_ouverture);
            dimanche_fermeture.setText(model._dimanche_fermeture);
            mBottomSheetLayout.showWithSheetView(mBottomSheet);
        }
    }

    private void deleteMarker(Marker marker) {
        marker.remove();
        _my_markers.remove(marker);
    }

    private void init() {
        if(mMap != null) {
            mMap.clear();
            _markers_to_models.clear();

            _my_markers = CommerceController.getInstance().listAll();


            for (CommerceModel model : _my_markers) {
                LatLng NEW = new LatLng(model._lattitude, model._longitude);
                Marker marker = mMap.addMarker(new MarkerOptions().position(NEW).title(model._nom));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(NEW));

                _markers_to_models.put(marker, model);
            }
        }
    }
}
